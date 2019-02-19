package gank.note.mvp.presenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import gank.note.model.GankCategoriesModel;
import gank.note.model.base.GankDataModel;
import gank.note.mvp.contract.MainContract;
import gank.note.net.API;
import gank.note.net.ResponseModel;
import gank.note.view.weight.LoadingDialog;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * 主页
 */
public class MainPresenter implements MainContract.Presenter {
    private Context context;
    private MainContract.View view;
    //错误信息
    private String wasdisconnected;

    public MainPresenter(Context context, MainContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void categories() {
        API.get().GankApi(context).categories().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<ResponseModel<List<GankCategoriesModel>>>() {
            @Override
            public void onSubscribe(Disposable d) {
                LoadingDialog.showProgressDialog(context, "加载中…………", false);
            }

            @Override
            public void onNext(ResponseModel<List<GankCategoriesModel>> listResponseModel) {
                LoadingDialog.dismissProgressDialog();
                if (listResponseModel.isError() == false) {

                }
            }

            @Override
            public void onError(Throwable e) {
                wasdisconnected = e.toString();
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onComplete() {
                LoadingDialog.dismissProgressDialog();
            }
        });
    }

    @Override
    public void category(String category) {

    }

    /**
     * 获取数据内容
     *
     * @param type  数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param total 请求个数： 数字，大于0
     * @param page  第几页：数字，大于0
     * @return
     */
    @Override
    public void getData(String type, int total, int page) {
        API.get().GankApi(context).getData(type, total, page).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<ResponseModel<List<GankDataModel>>>() {
            @Override
            public void onSubscribe(Disposable d) {
//                LoadingDialog.showProgressDialog(context, "加载中…………", false);
            }

            @Override
            public void onNext(ResponseModel<List<GankDataModel>> listResponseModel) {
//                LoadingDialog.dismissProgressDialog();
                if (listResponseModel.isError() == false) {
                    view.showInformation(listResponseModel.getResults());
                }
            }

            @Override
            public void onError(Throwable e) {
                wasdisconnected = e.toString();
                handler.sendEmptyMessage(0);
            }

            @Override
            public void onComplete() {
//                LoadingDialog.dismissProgressDialog();
            }
        });
    }

    /**
     * 展示报错信息
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
//                    LoadingDialog.dismissProgressDialog();
                    view.showDialog(wasdisconnected, new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            if (which == DialogAction.POSITIVE) {
                            } else if (which == DialogAction.NEGATIVE) {

                            }
                        }
                    });
                    break;
                default:
                    break;
            }
        }
    };
}