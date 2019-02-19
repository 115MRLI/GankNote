package gank.note.view.activity;

import android.os.Bundle;

import java.util.List;

import gank.note.R;
import gank.note.mvp.contract.GankPicContract;
import gank.note.mvp.presenter.GankPicPresenter;
import gank.note.view.component.ShowImagesDialog;

/**
 * 展示图片界面
 */
public class GankPicActivity extends BaseActivity implements GankPicContract.View {
    private GankPicContract.Presenter presenter;


    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new GankPicPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_gank_pic);
        List<String> urls = getIntent().getExtras().getStringArrayList("urls");
//        new ShowImagesDialog(getActivity(), urls).show();
    }

    @Override
    protected void loadData() {
    }
}