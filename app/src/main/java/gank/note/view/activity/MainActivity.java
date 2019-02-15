package gank.note.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import butterknife.BindView;
import gank.note.R;
import gank.note.manager.ActivityGoManager;
import gank.note.manager.PermissionManager;
import gank.note.model.base.GankDataModel;
import gank.note.mvp.contract.MainContract;
import gank.note.mvp.presenter.MainPresenter;
import gank.note.view.adapter.MianViewAdapter;

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
    RecyclerView recyclerMain;

    //福利界面
    private MianViewAdapter mianViewAdapter;

    @Override
    protected void initVariables(Bundle bundle) {
        presenter = new MainPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        recyclerMain.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mianViewAdapter = new MianViewAdapter(getActivity());
        recyclerMain.setAdapter(mianViewAdapter);
        presenter.getData("福利",10,1);
    }

    @Override
    protected void loadData() {
        //检查必备权限
        PermissionManager.checkMust(getActivity(), allGranted -> {
        });
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
        mianViewAdapter.setDatas(gankDataModels);

    }
}
