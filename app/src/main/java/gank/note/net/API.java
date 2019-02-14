package gank.note.net;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

import gank.note.common.Constants;
import gank.note.net.base.BaseApi;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 海獭生活接口
 */
public class API extends BaseApi {
    private GankApi gankApi;
    private static API api;

    /**
     * 获取单利
     *
     * @return
     */
    public static API get() {
        if (null == api) {
            api = new API();
        }
        return api;
    }

    /**
     * 海獭生活app接口
     *
     * @param context
     * @return
     */
    public GankApi GankApi(Context context) {
        if (null == gankApi) {
            //实例化gson
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();
            OkHttpClient.Builder builder = new OkHttpClient()
                    .newBuilder();
            gankApi = create(builder.build(),
                    GsonConverterFactory.create(gson), RxJava2CallAdapterFactory.create(), Constants.BASE_URL, GankApi.class);
        }
        return gankApi;
    }
}