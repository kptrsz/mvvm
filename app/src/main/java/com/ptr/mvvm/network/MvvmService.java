package com.ptr.mvvm.network;

import com.ptr.mvvm.network.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MvvmService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{post_id}")
    Call<Post> getPost(@Path("post_id") Integer postId);
}
