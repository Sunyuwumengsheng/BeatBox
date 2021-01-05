package com.example.beatbox.adapter;

import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.example.beatbox.databinding.HomeRecyclerItemBinding;
import com.example.beatbox.model.HomeMessageResponse;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

/**
 * @author STY
 */
public class ContentAdapter extends BaseQuickAdapter<HomeMessageResponse.DataBean.DatasBean, ContentAdapter.ContentViewHolder> implements LoadMoreModule {
    public ContentAdapter(int layoutResId, @Nullable List<HomeMessageResponse.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull ContentAdapter.ContentViewHolder contentViewHolder, HomeMessageResponse.DataBean.DatasBean datasBean) {
        HomeRecyclerItemBinding binding = DataBindingUtil.getBinding(contentViewHolder.itemView);
        Objects.requireNonNull(binding).setData(datasBean);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull ContentViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    public static class ContentViewHolder extends BaseDataBindingHolder<HomeRecyclerItemBinding> {
        public ContentViewHolder(@NotNull View view) {
            super(view);
        }
    }
}

