package com.example.beatbox.view.fragment.home;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.example.baselibrary.BaseFragment;
import com.example.beatbox.R;
import com.example.beatbox.adapter.BannerImageAdapter;
import com.example.beatbox.adapter.ContentAdapter;
import com.example.beatbox.adapter.ContentAdapterDiffUtil;
import com.example.beatbox.adapter.ContentItemDecoration;
import com.example.beatbox.databinding.HomeFragmentBinding;
import com.example.beatbox.model.BannerResponse;
import com.example.beatbox.model.HomeMessageResponse;
import com.google.android.material.appbar.AppBarLayout;

import java.util.List;
import java.util.Objects;


/**
 * @author STY
 */
public class HomeFragment extends BaseFragment<HomeViewModel, HomeFragmentBinding> {

    private ContentAdapter contentAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void processLogic() {
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(Objects.requireNonNull(getActivity())
                .getApplication())).get(HomeViewModel.class);
        initSwipeRef();
        initRecycler();
        initBanner();
        homeMessageListen();
    }

    /**
     * 动态获取banner数据
     */
    private void initBanner() {
        binding.homeBanner.setIntercept(true);
        final Observer<List<BannerResponse.DataBean>> observerDataBe = dataBeans -> {
            if (dataBeans != null) {
                BannerImageAdapter adapter = new BannerImageAdapter(dataBeans);
                binding.homeBanner.setAdapter(adapter).addBannerLifecycleObserver(this).setBannerRound(20.0f).start();
            }
        };
        mViewModel.getDataBeLiveData().observe(this, observerDataBe);
    }

    /**
     * 初始话Swipe
     */
    private void initSwipeRef() {
        binding.swipeRefresh.setOnRefreshListener(() -> {
            new Handler(Looper.getMainLooper()).postDelayed(() ->
                    binding.swipeRefresh.setRefreshing(false),
                    2000);
            mViewModel.initHomeMessage();
        });
        binding.appBarHome.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                binding.swipeRefresh.setEnabled(verticalOffset == 0);
            }
        });
    }

    /**
     * 初始化Recycler
     */
    private void initRecycler() {
        contentAdapter = new ContentAdapter(R.layout.home_recycler_item, null);
        contentAdapter.setDiffCallback(new ContentAdapterDiffUtil());
        contentAdapter.getLoadMoreModule().setPreLoadNumber(1);
        contentAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> mViewModel.addHomeMessage());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        binding.homeRecycler.setLayoutManager(manager);
        binding.homeRecycler.setAdapter(contentAdapter);
        binding.homeRecycler.addItemDecoration(new ContentItemDecoration());
    }

    /**
     * 首页内容动态绑定
     */
    private void homeMessageListen(){
        final Observer<SparseArray<List<HomeMessageResponse.DataBean.DatasBean>>> sparseArrayObserver
                = listSparseArray -> {
                    if (listSparseArray.get(0) == null){
                        contentAdapter.setDiffNewData(listSparseArray.get(1));
                    }else {
                        contentAdapter.setDiffNewData(listSparseArray.get(0));
                    }
                };
        mViewModel.getArrayMutableLiveData().observe(this,sparseArrayObserver);
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.initBanner();
        mViewModel.initHomeMessage();
    }
}