package gank.note.net;


import java.util.List;

import gank.note.model.GankCategoriesModel;
import gank.note.model.GankMenuModel;
import gank.note.model.base.GankDataModel;
import retrofit2.http.GET;
import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * 海獭生活接口
 */
public interface GankApi {
    /**
     * 获取闲读的主分类
     */
    @GET("api/xiandu/categories")
    Observable<ResponseModel<List<GankCategoriesModel>>> categories();

    /**
     * 获取闲读的子分类
     *
     * @param category 分类
     * @return
     */
    @GET("api/xiandu/category/{category}")
    Observable<ResponseModel<List<GankMenuModel>>> category(@Path("category") String category);

    /**
     * 获取数据内容
     *
     * @param type  数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param total 请求个数： 数字，大于0
     * @param page  第几页：数字，大于0
     * @return
     */
    @GET("api/data/{type}/{total}/{page}")
    Observable<ResponseModel<List<GankDataModel>>> getData(@Path("type") String type, @Path("total") int total, @Path("page") int page);
}