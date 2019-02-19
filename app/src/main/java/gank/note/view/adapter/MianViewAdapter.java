package gank.note.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jtechlib2.adapter.RecyclerAdapter;
import com.jtechlib2.view.RecyclerHolder;
import gank.note.R;
import gank.note.model.base.GankDataModel;
import gank.note.util.ImageUtils;

public class MianViewAdapter extends RecyclerAdapter<GankDataModel> {

    private OnMianViewAdapterListener listener;

    public MianViewAdapter(Context context) {
        super(context);
    }

    /**
     * 设置监听
     *
     * @param listener 监听
     * @return
     */
    public MianViewAdapter setListener(OnMianViewAdapterListener listener) {
        this.listener = listener;
        return this;
    }

    @Override
    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return layoutInflater.inflate(R.layout.gank_weal_entry, viewGroup, false);
    }

    @Override
    protected void convert(RecyclerHolder holder, GankDataModel model, int position) {
        //设置名字
        holder.setText(R.id.tv_weal_title, model.getDesc());
        ImageUtils.showImageAsPath(getContext(), model.getUrl(), holder.getImageView(R.id.iv_weal));
        holder.getView(R.id.card_weal).setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(model, position);
            }
        });
    }

    /**
     * 首页监听
     */
    public interface OnMianViewAdapterListener {
        /**
         * 设置监听
         *
         * @param model    当前数据
         * @param position 下标
         */
        void onItemClick(GankDataModel model, int position);
    }
}
