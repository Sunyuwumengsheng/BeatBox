package com.example.beatbox.viewmodel;

import android.app.Application;
import android.os.Parcel;
import android.util.Log;

import androidx.annotation.NonNull;
import com.example.beatbox.api.HttpUtil;
import com.example.beatbox.callbacks.HttpCallback;
import com.example.beatbox.model.UserRequest;
import com.example.beatbox.model.UserResponse;
import com.example.beatbox.repository.UserRepository;
import com.example.beatbox.view.BaseViewModel;


/**
 * @author STY
 */
public class UserViewModel extends BaseViewModel {

    private UserRepository userRepository;

    private final static String TAG = "UserViewModel";

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(HttpUtil.getInstance().getApi());
    }



    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void login(){

        UserRequest request = new UserRequest();
        request.setUsername("sanyu");
        request.setPassword("Zxy5201314");
        userRepository.login(request, new HttpCallback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse) {

                Log.d(TAG, userResponse.getData().getId()+"");
            }

            @Override
            public void failure(Throwable e) {
                Log.d(TAG, e.getMessage());
            }
        });
    }

    public void register(){
        UserRequest request = new UserRequest();
        request.setUsername("sanyu");
        request.setPassword("Zxy5201314");
        request.setRePassword("Zxy5201314");
        userRepository.register(request, new HttpCallback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse) {
                Log.d(TAG, userResponse.getData().getId()+"");
            }

            @Override
            public void failure(Throwable e) {

            }
        });
    }

}
