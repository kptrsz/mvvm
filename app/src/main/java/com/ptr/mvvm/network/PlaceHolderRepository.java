package com.ptr.mvvm.network;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.ptr.mvvm.network.model.Post;

import java.util.List;

import okhttp3.ResponseBody;

public class PlaceHolderRepository {
    public static final String TAG = PlaceHolderRepository.class.getSimpleName();
    public PlaceHolderRepository() {

    }

    public MutableLiveData<List<Post>> getPosts() {
        final MutableLiveData<List<Post>> posts = new MutableLiveData<>();

        ApiClient.INSTANCE.getPosts(new CallbackListener<List<Post>>() {
            @Override
            public void success(List<Post> result, int responseCode) {
                posts.setValue(result);
            }

            @Override
            public void error(ResponseBody rawError, int responseCode) {
                Log.e(TAG, "Error: " + rawError.toString());
            }

            @Override
            public void fail(int responseCode) {
                Log.e(TAG, "Fail: " + responseCode);
            }
        });
        return posts;
    }
}
