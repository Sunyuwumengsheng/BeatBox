package com.example.beatbox.view;


import android.content.Intent;
import android.os.Build;
import android.transition.Explode;
import android.view.Window;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.beatbox.R;
import com.example.beatbox.databinding.ActivityLoginBinding;
import com.example.beatbox.viewmodel.UserViewModel;
import com.example.beatbox.viewmodel.factory.UserViewModelFactory;

/**
 * @author STY 登录
 */
public class LoginActivity extends BaseActivity<UserViewModel, ActivityLoginBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void processLogic() {
        binding.loginBtn.setOnClickListener(v -> mViewModel.login());
        loginData();
    }

    @Override
    protected void createViewModel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }
        mViewModel = new ViewModelProvider(this,UserViewModelFactory.getInstance(getApplication())).get(UserViewModel.class);
        binding.setUserViewModel(mViewModel);
    }

    @Override
    protected void isStartTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }

    }

    public void loginData(){
        final Observer<Integer> loginObs = integer -> {
            switch (integer){
                case 0:
                    toMain();
                    break;
                case 1:
                    showShortToast(LoginActivity.this,"网络错误");
                    break;
                case 2:
                    showShortToast(LoginActivity.this,"密码或账号错误");
                    break;
                default:
                    break;

            }
        };
        mViewModel.getLoginData().observe(this,loginObs);
    }
    public void toMain(){
        Intent registerIntent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(registerIntent);
        finish();
    }
    public void toRegister(){
        Intent registerIntent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(registerIntent);
    }
}