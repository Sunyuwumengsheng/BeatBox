package com.example.beatbox.view;

import android.content.Intent;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.beatbox.R;
import com.example.beatbox.databinding.ActivityRegisterBinding;
import com.example.beatbox.viewmodel.UserViewModel;
import com.example.beatbox.viewmodel.factory.UserViewModelFactory;

public class RegisterActivity extends BaseActivity<UserViewModel, ActivityRegisterBinding>{
    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void processLogic() {
        binding.registerBtn.setOnClickListener(v -> mViewModel.register());
        registerData();
    }

    public void registerData(){

        final Observer<Integer> registerObs = integer -> {
            switch (integer){
                case 0:
                    toLogin();
                    break;
                case 1:
                    showShortToast(RegisterActivity.this,"密码或账号错误");
                    break;
                case 2:
                    showShortToast(RegisterActivity.this,"网络错误");
                    break;
                default:
                    break;

            }
        };
        mViewModel.getRegisterData().observe(this,registerObs);

    }

    public void toLogin(){
        onBackPressed();
    }
    @Override
    protected void createViewModel() {
        mViewModel = new ViewModelProvider(this, UserViewModelFactory.getInstance(getApplication())).get(UserViewModel.class);
        binding.setUserViewModel(mViewModel);
    }

    @Override
    protected void isStartTransitions() {

    }
}
