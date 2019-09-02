package com.ptr.mvvm.network;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCallback<T> implements Callback<T> {

    private static final String logTag = "ApiCallback";

    private final CallbackListener<T> callbackListener;

    public ApiCallback(CallbackListener<T> callbackListener) {
        this.callbackListener = callbackListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.d(logTag, "Call: " + call .toString() + "\nResponse: " + response.toString());

        int responseCode = response.code();

        if (responseCode < 200) {
            // 1xx Informational
            callbackListener.fail(responseCode);
        } else if (responseCode < 300) {
            // 2xx Success
            callbackListener.success(response.body(), responseCode);
        } else if (responseCode < 400) {
            // 3xx Redirection
            callbackListener.fail(responseCode);
        } else if (responseCode < 500) {
            // 4xx Client Error
            callbackListener.error(response.errorBody(), responseCode);
        } else {
            // 5xx Server Error
            callbackListener.fail(responseCode);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d(logTag, "Rest failure!\nCall: " + call .toString(), t);
        t.printStackTrace();
        callbackListener.fail(-1);
    }
}
