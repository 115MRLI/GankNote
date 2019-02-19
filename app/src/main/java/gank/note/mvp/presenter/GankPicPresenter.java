package gank.note.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import gank.note.mvp.contract.GankPicContract;

/**
 * 展示图片界面
 */
public class GankPicPresenter implements GankPicContract.Presenter {
    private Context context;
    private GankPicContract.View view;

    public GankPicPresenter(Context context, GankPicContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }
}