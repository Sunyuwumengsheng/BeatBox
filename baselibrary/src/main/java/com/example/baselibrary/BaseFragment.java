package com.example.baselibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * Fragment的基类
 * @author STY
 */
public abstract class BaseFragment<VM extends BaseViewModel
        ,VDB extends ViewDataBinding> extends Fragment {

    protected VM mViewModel;

    protected VDB binding;



    /**
     * 获取布局ID
     * @return int
     */
    protected abstract int getLayoutId();

    /**
     * 业务逻辑处理
     */
    protected abstract void processLogic();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        processLogic();
    }
}
