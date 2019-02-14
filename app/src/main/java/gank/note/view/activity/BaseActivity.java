package gank.note.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import gank.note.manager.ActivityManager;
import gank.note.util.Bus;
import gank.note.util.Utils;

/**
 * activity基类
 * Created by wuxubaiyang on 16/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //注册activity
        ActivityManager.get().add(this);
        super.onCreate(savedInstanceState);
        //设置全屏样式
        Utils.setNavigationBarStatusBar(this, true);
        //赋值TAG
        TAG = this.getClass().getSimpleName();
        //初始化变量(用户传递进来的参数)
        if (null != getIntent()) {
            initVariables(getIntent().getExtras());
        } else {
            initVariables(null);
        }
        //基类中注册消息总线
        Bus.getOnWithBase(this);
        //初始化视图
        initViews(savedInstanceState);
        //加载数据
        loadData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //设置全屏样式
        Utils.setNavigationBarStatusBar(this, true);
    }

    /**
     * 初始化变量
     *
     * @param bundle bundle
     */
    protected abstract void initVariables(Bundle bundle);

    /**
     * 初始化视图
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 请求数据
     */
    protected abstract void loadData();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //绑定注解
        ButterKnife.bind(this);
    }

    /**
     * 获取activity对象
     *
     * @return 当前activity对象
     */
    public BaseActivity getActivity() {
        return this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //移除activity
        ActivityManager.get().remove(this);
        //基类中反注册
        Bus.getOffWithBase(this);
    }
}