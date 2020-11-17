package com.example.beatbox.viewmodel;

import android.app.Application;
import android.os.Parcel;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.example.beatbox.api.HttpUtil;
import com.example.beatbox.callbacks.HttpCallback;
import com.example.beatbox.model.UserRequest;
import com.example.beatbox.model.UserResponse;
import com.example.beatbox.repository.UserRepository;
import com.example.beatbox.view.BaseViewModel;

import java.util.Objects;


/**
 * @author STY
 */
public class UserViewModel extends BaseViewModel {

    private final UserRepository userRepository;

    private final static String TAG = "UserViewModel";

    private ObservableField<UserRequest> loginObservableField;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(HttpUtil.getInstance().getApi());
        UserRequest request = new UserRequest();
        loginObservableField = new ObservableField<>();
        loginObservableField.set(request);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public void login() {
        String userId = Objects.requireNonNull(loginObservableField.get(),"UserMode对象为空").username;
        String password = Objects.requireNonNull(loginObservableField.get(),"UserMode对象为空").username;
        userRepository.login(userId,
                password, new HttpCallback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse) {

//                Log.d(TAG, userResponse.getData().getId() + "");
            }

            @Override
            public void failure(Throwable e) {
                Log.d(TAG, e.getMessage());
            }
        });
    }

//    public void register() {
//        UserRequest request = new UserRequest();
//        request.setUsername("sanyu");
//        request.setPassword("Zxy5201314");
//        request.setRePassword("Zxy5201314");
//        userRepository.register(request, new HttpCallback<UserResponse>() {
//            @Override
//            public void success(UserResponse userResponse) {
//                Log.d(TAG, userResponse.getData().getId() + "");
//            }
//
//            @Override
//            public void failure(Throwable e) {
//
//            }
//        });
//    }

    public String getUseName(){
        return loginObservableField.get().username;
    }

    public void setUseName(String userName){
        loginObservableField.get().username = userName;
    }
    public String getPassword(){
        return loginObservableField.get().username;
    }

    public void setPassword(String password){
        loginObservableField.get().password = password;
    }

}
