package gank.note.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.DisplayMetrics;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jtechlib2.view.JRecyclerView;
import com.jtechlib2.view.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import gank.note.R;
import gank.note.common.Constants;
import gank.note.manager.ActivityGoManager;
import gank.note.model.base.GankDataModel;
import gank.note.mvp.contract.MainContract;
import gank.note.mvp.presenter.MainPresenter;
import gank.note.util.ActivityGo;
import gank.note.util.ToastUtils;
import gank.note.view.adapter.MianViewAdapter;
import gank.note.view.component.ShowImagesDialog;

/**
 * 主页
 */
public class MainActivity extends BaseActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    //弹窗
    private MaterialDialog.Builder mBuilder;
    private MaterialDialog mMaterialDialog;

    //主页页面
    @BindView(R.id.recycler_main)
    JRecyclerView recyclerMain;
    //刷新
    @BindView(R.id.refreshlayout)
    RefreshLayout refreshLayout;

    //福利界面
    private MianViewAdapter mianViewAdapter;

    //当前页码

    private int page = 1;

    //图片集合
    private ArrayList<String> urls = new ArrayList<>();

    @Override
    protected void initVariables(Bundle bundle) {
        presenter = new MainPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        getDeviceDensity();

        recyclerMain.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mianViewAdapter = new MianViewAdapter(getActivity());
        recyclerMain.setAdapter(mianViewAdapter);
        //刷新
        refreshLayout.startRefreshing();
        refreshLayout.setOnRefreshListener(() -> {
            page = 1;
            presenter.getData("福利", 10, page);
        });
        //加载更多
        recyclerMain.setLoadMore(true);
        recyclerMain.setOnLoadListener(() -> {
            page = page + 1;
            presenter.getData("福利", 10, page);
        });
        //点击事件
        mianViewAdapter.setListener((model, position) -> {
//           ActivityGoManager.goGankPic(getActivity(),urls);
            new ShowImagesDialog(getActivity(), urls,position).show();

        });

    }

    @Override
    protected void loadData() {
        //检查必备权限
//        PermissionManager.checkMust(getActivity(), allGranted -> {
//        });
    }

    @Override
    public void showDialog(String content, MaterialDialog.SingleButtonCallback callback) {
        if (!this.isFinishing()) {
            mBuilder = new MaterialDialog.Builder(this);
            mBuilder.title(R.string.reminder_str);
            mBuilder.titleColor(Color.parseColor("#000000"));
            mBuilder.content(content);
            mBuilder.contentColor(Color.parseColor("#000000"));
            mBuilder.positiveText(R.string.sure);
            mBuilder.titleGravity(GravityEnum.CENTER);
            mBuilder.buttonsGravity(GravityEnum.START);
            mBuilder.negativeText(R.string.abolish_str);
            mBuilder.cancelable(false);
            mMaterialDialog = mBuilder.build();
            mMaterialDialog.show();
            mBuilder.onAny(callback);
        }
    }

    @Override
    public void showInformation(List<GankDataModel> gankDataModels) {
        if (page == 1) {
            refreshLayout.refreshingComplete();
            mianViewAdapter.setDatas(gankDataModels, false);
            urls.clear();
            for (GankDataModel gankDataModel : gankDataModels) {
                urls.add(gankDataModel.getUrl());
            }
        } else {
            //加载更多
            recyclerMain.setLoadCompleteState();
            mianViewAdapter.setDatas(gankDataModels, true);
            for (GankDataModel gankDataModel : gankDataModels) {
                urls.add(gankDataModel.getUrl());
            }
        }
    }

    /**
     * 获取当前设备的屏幕密度等基本参数
     */
    protected void getDeviceDensity() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Constants.EXACT_SCREEN_HEIGHT = metrics.heightPixels;
        Constants.EXACT_SCREEN_WIDTH = metrics.widthPixels;
    }
}
