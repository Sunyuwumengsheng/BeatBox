package com.example.beatbox.view.fragment.home;

import android.app.Application;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baselibrary.BaseViewModel;
import com.example.beatbox.api.HttpUtil;
import com.example.beatbox.callbacks.HttpCallback;
import com.example.beatbox.model.BannerResponse;
import com.example.beatbox.model.HomeMessageResponse;
import com.example.beatbox.repository.HomeFragRepository;
import com.youth.banner.Banner;

import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/**
 * @author STY
 */
public class HomeViewModel extends BaseViewModel {

    private int pageId = 0;

    private SparseArray<List<HomeMessageResponse.DataBean.DatasBean>> datasBeanArray;

    private final HomeFragRepository repository;

    private MutableLiveData<List<BannerResponse.DataBean>> dataBeLiveData;

    public MutableLiveData<List<BannerResponse.DataBean>> getDataBeLiveData() {
        if (dataBeLiveData == null) {
            dataBeLiveData = new MutableLiveData<>();
        }
        return dataBeLiveData;
    }

    private MutableLiveData<SparseArray<List<HomeMessageResponse.DataBean.DatasBean>>> arrayMutableLiveData;

    public MutableLiveData<SparseArray<List<HomeMessageResponse.DataBean.DatasBean>>> getArrayMutableLiveData() {
        if (arrayMutableLiveData == null) {
            arrayMutableLiveData = new MutableLiveData<>();
        }

        return arrayMutableLiveData;
    }

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new HomeFragRepository(HttpUtil.getInstance().getApi());
        datasBeanArray = new SparseArray<>();
    }

    public void initBanner() {
        repository.getBanner(new HttpCallback<BannerResponse>() {
            @Override
            public void success(BannerResponse bannerResponse) {
                dataBeLiveData.postValue(bannerResponse.getData());

            }

            @Override
            public void failure(Throwable e) {

            }

            @Override
            public void error(BannerResponse bannerResponse) {

            }
        });
    }

    public void initHomeMessage() {
        getHomeMessage();
    }

    public void addHomeMessage() {
        getHomeMessage();

    }

    private void getHomeMessage() {
        repository.getMessage(pageId, new HttpCallback<HomeMessageResponse>() {
            @Override
            public void success(HomeMessageResponse homeMessageResponse) {

                if (pageId == 0) {
                    datasBeanArray.put(0, homeMessageResponse.getData().getDatas());
                    datasBeanArray.put(1, null);
                } else {
                    datasBeanArray.put(0, null);
                    datasBeanArray.put(1, homeMessageResponse.getData().getDatas());
                }
                arrayMutableLiveData.postValue(datasBeanArray);
                if (pageId<homeMessageResponse.getData().getPageCount()){
                    pageId++;
                }
            }

            @Override
            public void failure(Throwable e) {

            }

            @Override
            public void error(HomeMessageResponse homeMessageResponse) {

            }
        });
    }
}