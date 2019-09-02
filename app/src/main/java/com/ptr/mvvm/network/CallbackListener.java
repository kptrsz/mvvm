package com.ptr.mvvm.network;

import okhttp3.ResponseBody;

public interface CallbackListener<T> {
    void success(T result, int responseCode);
    void error(ResponseBody rawError, int responseCode);
    void fail(int responseCode);
}
