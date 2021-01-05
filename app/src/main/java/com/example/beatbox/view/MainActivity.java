package com.example.beatbox.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.MarginPageTransformer;

import android.os.Build;
import android.transition.Fade;
import android.view.Window;

import com.example.baselibrary.BaseActivity;
import com.example.beatbox.R;
import com.example.beatbox.adapter.ViewPageAdapter;
import com.example.beatbox.databinding.ActivityMainBinding;
import com.example.beatbox.view.fragment.home.HomeFragment;
import com.example.beatbox.view.fragment.project.ProjectFragment;
import com.example.beatbox.view.fragment.square.SquareFragment;
import com.example.beatbox.view.fragment.system.SystemFragment;
import com.example.beatbox.viewmodel.UserViewModel;
import com.example.beatbox.viewmodel.factory.UserViewModelFactory;

import java.util.ArrayList;
import java.util.List;

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
        initView();

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

    private void initView(){
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(),this.getLifecycle());
        binding.viewPage.setPageTransformer(new MarginPageTransformer((int) getResources().getDimension(R.dimen.dp_10)));
        binding.viewPage.setAdapter(viewPageAdapter);
    }



}
