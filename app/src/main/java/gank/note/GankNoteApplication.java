package gank.note;

import android.app.Application;


/**
 * application
 */
public class GankNoteApplication extends Application {
    //除非特殊情况，否则尽量少用
    private static GankNoteApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    /**
     * 获取application实例
     *
     * @return
     */
    public static GankNoteApplication get() {
        return application;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}