package com.example.beatbox.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.beatbox.R;
import com.example.beatbox.databinding.ActivityLoginBinding;
import com.example.beatbox.viewmodel.UserViewModel;
import com.example.beatbox.viewmodel.factory.UserViewModelFactory;

/**
 * @author STY 登录注册
 */
public class LoginAndRegisterActivity extends BaseActivity<UserViewModel, ActivityLoginBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void createViewModel() {
        mViewModel =  mViewModel = new ViewModelProvider(this,UserViewModelFactory.getInstance(getApplication())).get(UserViewModel.class);
    }
}