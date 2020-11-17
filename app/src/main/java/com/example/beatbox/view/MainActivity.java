package com.example.beatbox.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beatbox.R;
import com.example.beatbox.StyApplication;
import com.example.beatbox.databinding.ActivityMainBinding;
import com.example.beatbox.viewmodel.UserViewModel;
import com.example.beatbox.viewmodel.factory.UserViewModelFactory;

/**
 * @author STY
 */
public class MainActivity extends BaseActivity<UserViewModel,ActivityMainBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected void processLogic() {

        binding.btn.setOnClickListener(v->
        {
            if (mViewModel != null){
                mViewModel.login();
            }

        });
    }

    @Override
    protected void createViewModel() {
        mViewModel = new ViewModelProvider(this,UserViewModelFactory.getInstance(getApplication())).get(UserViewModel.class);
    }


}
