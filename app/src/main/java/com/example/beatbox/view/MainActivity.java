package com.example.beatbox.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
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

    }

    @Override
    protected void createViewModel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Fade());
            getWindow().setExitTransition(new Fade());
        }
        mViewModel = new ViewModelProvider(this,UserViewModelFactory.getInstance(getApplication())).get(UserViewModel.class);
    }

    @Override
    protected void isStartTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
    }


}
