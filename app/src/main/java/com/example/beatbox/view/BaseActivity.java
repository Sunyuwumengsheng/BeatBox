package com.example.beatbox.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author STY activity 父类
 */
public abstract class BaseActivity<VM extends BaseViewModel
        ,VDB extends ViewDataBinding> extends AppCompatActivity {
    /**
     *获取当前activity布局文件,并初始化dataBinding
     * @return int
     */
    protected abstract int getContentViewId();

    /**
     * 业务逻辑处理
     */
    protected abstract void processLogic();

    protected VM mViewModel;

    protected VDB binding;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        binding = DataBindingUtil.setContentView(this,getContentViewId());
        binding.setLifecycleOwner(this);
        createViewModel();
        processLogic();
    }

    protected abstract void createViewModel();


}
