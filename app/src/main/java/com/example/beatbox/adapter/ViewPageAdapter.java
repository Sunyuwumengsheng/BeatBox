package com.example.beatbox.adapter;

import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.beatbox.view.fragment.home.HomeFragment;
import com.example.beatbox.view.fragment.project.ProjectFragment;
import com.example.beatbox.view.fragment.square.SquareFragment;
import com.example.beatbox.view.fragment.system.SystemFragment;

/**
 * @author 11733
 */
public class ViewPageAdapter extends FragmentStateAdapter {

    private SparseArray<Fragment> sparseArray = new SparseArray<>();
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        sparseArray.put(0,new HomeFragment());
        sparseArray.put(1,new ProjectFragment());
        sparseArray.put(2,new SquareFragment());
        sparseArray.put(3,new SystemFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return sparseArray.get(position);
    }

    @Override
    public int getItemCount() {
        return sparseArray.size();
    }
}
