package com.example.beatbox.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beatbox.model.BannerResponse;
import com.squareup.picasso.Picasso;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.List;

/**
 * banner适配器
 * @author STY
 */
public class BannerImageAdapter extends BannerAdapter<BannerResponse.DataBean, BannerImageAdapter.BannerImageHolder> {
    public BannerImageAdapter(List<BannerResponse.DataBean> datas) {
        super(datas);
    }

    @Override
    public BannerImageAdapter.BannerImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView view = new ImageView(parent.getContext());
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerImageHolder(view);
    }

    @Override
    public void onBindView(BannerImageAdapter.BannerImageHolder holder, BannerResponse.DataBean data, int position, int size) {
        Picasso.get().load(data.getImagePath()).into(holder.view);

    }

    public static class BannerImageHolder extends RecyclerView.ViewHolder {
        ImageView view;
        public BannerImageHolder(@NonNull ImageView itemView) {
            super(itemView);
            view = itemView;
        }
    }
}
