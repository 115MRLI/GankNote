package gank.note.manager;

import android.app.Activity;

import gank.note.view.activity.MainActivity;
import gank.note.util.ActivityGo;


/**
 * 页面跳转管理
 */
public class ActivityGoManager {
    /**
     * 跳转到首页
     *
     * @param activity
     */
    public static void goMainPage(Activity activity) {
        ActivityGo.build(activity, MainActivity.class).go();
    }


}