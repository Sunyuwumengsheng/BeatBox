package com.example.beatbox;

import android.app.Application;


import com.example.beatbox.api.Api;
import com.example.beatbox.api.HttpUtil;
import com.example.ktdslibrary.DsDataStore;
import com.tencent.mmkv.MMKV;
//import com.example.beatbox.db.AppDatabase;

/**
 * @author STY
 */
public class StyApplication extends Application {

    private static Api api;
    @Override
    public void onCreate() {
        super.onCreate();
        api = HttpUtil.getInstance().getApi();
        MMKV.initialize(this);
    }

    public static Api getApi() {
        return api;
    }

}
