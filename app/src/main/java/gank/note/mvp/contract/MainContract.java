package gank.note.mvp.contract;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

import gank.note.model.base.GankDataModel;

/**
 * 主页
 */
public interface MainContract {
    interface Presenter extends BaseContract.Presenter {
        /**
         * 获取闲读的主分类
         */
        void categories();

        /**
         * 获取闲读的子分类
         */
        void category(String category);

        /**
         * 获取数据内容
         *
         * @param type  数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
         * @param total 请求个数： 数字，大于0
         * @param page  第几页：数字，大于0
         * @return
         */
        void getData(String type, int total, int page);
    }

    interface View extends BaseContract.View {
        /**
         * 展示弹窗
         *
         * @param content
         * @param callback
         */
        void showDialog(String content, MaterialDialog.SingleButtonCallback callback);


        void showInformation(List<GankDataModel> gankDataModels);
    }
}