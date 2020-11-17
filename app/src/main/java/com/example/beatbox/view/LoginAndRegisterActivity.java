package com.example.beatbox.view;


import android.util.Log;

import androidx.lifecycle.ViewModelProvider;

import com.example.beatbox.R;
import com.example.beatbox.databinding.ActivityLoginBinding;
import com.example.beatbox.model.UserRequest;
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
        binding.loginBtn.setOnClickListener(v->{
            mViewModel.login();
        });
    }

    @Override
    protected void createViewModel() {
        mViewModel = new ViewModelProvider(this,UserViewModelFactory.getInstance(getApplication())).get(UserViewModel.class);
        binding.setUserViewModel(mViewModel);
    }
}