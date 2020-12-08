package com.example.beatbox.callbacks;

/**
 * @author STY
 */
public interface HttpCallback<T> {
    /**
     *
     * @param t
     * @@description 网络成功回调
     * @return t
     */
    void success(T t);
    /**
     *
     * @param e
     * @description 网络失败回调
     * @return e
     */
    void failure(Throwable e);

    /**
     * @param t
     */
    void error(T t);


}
