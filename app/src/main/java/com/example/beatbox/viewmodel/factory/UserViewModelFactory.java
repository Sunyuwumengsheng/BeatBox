package com.example.beatbox.viewmodel.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.example.beatbox.model.UserRequest;
import com.example.beatbox.viewmodel.UserViewModel;

import java.lang.reflect.InvocationTargetException;

/**
 * @author STY UserViewModel的自定义工厂类
 */
public class UserViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private static UserViewModelFactory sInstace;

    @NonNull
    public static UserViewModelFactory getInstance(@NonNull Application application){
        if (sInstace == null){
            sInstace = new UserViewModelFactory(application);
        }
        return sInstace;
    };

    private Application application;

    public UserViewModelFactory(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        return (T) new UserViewModel(application);
    }
}
