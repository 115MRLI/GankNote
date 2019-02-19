package gank.note.manager;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import gank.note.view.activity.GankPicActivity;
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

    /**
     * 跳转图片展示页
     *
     * @param activity
     */
    public static void goGankPic(Activity activity, ArrayList<String> urls) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("urls",urls);
        ActivityGo.build(activity, GankPicActivity.class).addBundle(bundle).go();
    }
}