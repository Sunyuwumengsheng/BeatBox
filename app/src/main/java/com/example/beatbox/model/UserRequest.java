package com.example.beatbox.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author STY
 * 用户相关实体类
 */
public class UserRequest  {

    private String username;

    private String password;

    private String rePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
