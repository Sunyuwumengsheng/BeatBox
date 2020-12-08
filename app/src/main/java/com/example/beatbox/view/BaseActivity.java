package com.example.beatbox.view;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

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

    /**
     * 创建viewMode
     */
    protected abstract void createViewModel();

    /**
     * Toast提示
     * @param ctx
     * @param msg
     */
    public void showLoginToast(Context ctx,String msg){
        Toast.makeText(ctx,msg,Toast.LENGTH_LONG).show();
    }
    public void showShortToast(Context ctx,String msg){
        Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();
    }

    /**
     * 是否开启动画
     */
    protected abstract void isStartTransitions();

    protected VM mViewModel;

    protected VDB binding;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isStartTransitions();
        setContentView(getContentViewId());
        binding = DataBindingUtil.setContentView(this,getContentViewId());
        binding.setLifecycleOwner(this);
        createViewModel();
        processLogic();
    }




}
