package gank.note.view.weight;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import gank.note.R;

/**
 * 标题栏视图
 */
public class TitleView extends FrameLayout {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.textview_title)
    TextView textViewTitle;

    public TitleView(@NonNull Context context) {
        this(context, null);
    }

    public TitleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    /**
     * 初始化方法
     */
    private void initView() {
        View contentView = LayoutInflater.from(getContext())
                .inflate(R.layout.view_title, this, false);
        ButterKnife.bind(this, contentView);
        addView(contentView);
    }

    /**
     * 设置为标题栏
     *
     * @param activity
     * @return
     */
    public TitleView setSupportActionBar(@NonNull AppCompatActivity activity) {
        if (null != toolbar) {
            activity.setSupportActionBar(toolbar);
        }
        return this;
    }

    /**
     * 设置标题
     *
     * @param id
     * @return
     */
    public TitleView setTitle(@StringRes int id) {
        return setTitle(getResources().getString(id));
    }

    /**
     * 设置标题
     *
     * @param title
     * @return
     */
    public TitleView setTitle(@NonNull String title) {
        if (null != textViewTitle) {
            textViewTitle.setText(title);
        }
        return this;
    }

    /**
     * 设置左侧按钮
     *
     * @param id
     * @param listener
     * @return
     */
    public TitleView setLeftButton(@DrawableRes int id, OnClickListener listener) {
        if (null != toolbar) {
            toolbar.setNavigationIcon(id);
            toolbar.setNavigationOnClickListener(listener);
        }
        return this;
    }
}