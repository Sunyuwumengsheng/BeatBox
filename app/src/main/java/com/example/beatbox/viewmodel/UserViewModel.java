package com.example.beatbox.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.example.beatbox.api.HttpUtil;
import com.example.beatbox.callbacks.HttpCallback;
import com.example.beatbox.model.UserRequest;
import com.example.beatbox.model.UserResponse;
import com.example.beatbox.repository.UserRepository;
import com.example.baselibrary.BaseViewModel;

import java.util.Objects;


/**
 * @author STY
 */
public class UserViewModel extends BaseViewModel {

    private final UserRepository userRepository;

    private final static String TAG = "UserViewModel";

    private final ObservableField<UserRequest> loginObservableField;

    private MutableLiveData<Integer> loginData;
    private MutableLiveData<Integer> registerData;
    public MutableLiveData<Integer> getLoginData() {
        if (loginData == null){
            loginData = new MutableLiveData<>();
        }
        return loginData;
    }

    public MutableLiveData<Integer> getRegisterData() {
        if (registerData == null){
            registerData = new MutableLiveData<>();
        }
        return registerData;
    }

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
        String userId = Objects.requireNonNull(loginObservableField.get(), "UserMode对象为空").username;
        String password = Objects.requireNonNull(loginObservableField.get(), "UserMode对象为空").password;
        userRepository.login(userId,
                password, new HttpCallback<UserResponse>() {
                    @Override
                    public void success(UserResponse userResponse) {
                        loginData.postValue(0);

                    }

                    @Override
                    public void failure(Throwable e) {
                        Log.d(TAG, e.getMessage());
                        loginData.postValue(1);
                    }

                    @Override
                    public void error(UserResponse userResponse) {
                        loginData.postValue(2);
                    }
                });
    }

    public void register() {
        UserRequest request = new UserRequest();
        userRepository.register(request, new HttpCallback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse) {
                registerData.postValue(0);
            }

            @Override
            public void failure(Throwable e) {
                registerData.postValue(1);

            }

            @Override
            public void error(UserResponse userResponse) {
                registerData.postValue(2);
            }
        });
    }

    public String getUseName() {
        return loginObservableField.get().username;
    }

    public void setUseName(String userName) {
        loginObservableField.get().username = userName;
    }

    public String getPassword() {
        return loginObservableField.get().username;
    }

    public void setPassword(String password) {
        loginObservableField.get().password = password;
    }

    public void setRePassword(String rePassword) {
        loginObservableField.get().rePassword = rePassword;
    }
    public String getRePassword() {
        return loginObservableField.get().rePassword;
    }

}
