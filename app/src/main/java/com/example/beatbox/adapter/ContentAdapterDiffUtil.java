package com.example.beatbox.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.beatbox.model.HomeMessageResponse;

public class ContentAdapterDiffUtil extends DiffUtil.ItemCallback<HomeMessageResponse.DataBean.DatasBean> {
    @Override
    public boolean areItemsTheSame(@NonNull HomeMessageResponse.DataBean.DatasBean oldItem, @NonNull HomeMessageResponse.DataBean.DatasBean newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull HomeMessageResponse.DataBean.DatasBean oldItem, @NonNull HomeMessageResponse.DataBean.DatasBean newItem) {
        return oldItem.getTitle().equals(newItem.getTitle()) && oldItem.getAuthor().equals(newItem.getAuthor()) && oldItem.getNiceDate().equals(newItem.getNiceDate());
    }
}
