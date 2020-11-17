package com.example.beatbox.mmkv;

import com.tencent.mmkv.MMKV;

/**
 * @author STY
 */
public class MmkvSinger {

    private static MmkvSinger instance;

    private MMKV mkn;

    private MmkvSinger(){
        mkn = MMKV.mmkvWithID("user");
    }

    public MMKV getMkn() {
        return mkn;
    }

    public static MmkvSinger getInstance(){
        if (instance == null){
            instance = new MmkvSinger();
        }
        return instance;
    }

    public void setMkn(MMKV mkn) {
        this.mkn = mkn;
    }
}
