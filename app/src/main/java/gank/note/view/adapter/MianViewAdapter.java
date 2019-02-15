package gank.note.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jtechlib2.adapter.RecyclerAdapter;
import com.jtechlib2.view.RecyclerHolder;

import java.util.List;

import gank.note.R;
import gank.note.model.base.GankDataModel;
import gank.note.util.ImageUtils;

public class MianViewAdapter extends RecyclerAdapter<GankDataModel> {


    public MianViewAdapter(Context context) {
        super(context);
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
    }

}
