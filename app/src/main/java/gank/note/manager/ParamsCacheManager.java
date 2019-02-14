package gank.note.manager;

import android.content.Context;

import gank.note.common.Constants;
import gank.note.manager.base.ACache;
import gank.note.manager.base.BaseCacheManager;


/**
 * 常用参数缓存管理
 */
public class ParamsCacheManager extends BaseCacheManager {
    private final static String KEY_FOODS_INFO_CACHE = "keyFoodsInfoCache";
    private final static int FOODS_INFO_CACHE_TIME = ACache.TIME_HOUR * 2;

    private static ParamsCacheManager manager;

    private ParamsCacheManager(Context context) {
        super(context);
    }

    /**
     * 获取单利
     *
     * @param context
     * @return
     */
    public static ParamsCacheManager get(Context context) {
        if (null == manager) {
            manager = new ParamsCacheManager(context);
        }
        return manager;
    }

    /**
     * 获取缓存目录名
     *
     * @return
     */
    @Override
    public String getCacheName() {
        return Constants.CACHE_PATH;
    }


}