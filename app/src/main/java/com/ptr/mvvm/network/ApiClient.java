package com.ptr.mvvm.network;

import com.ptr.mvvm.network.model.Post;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ptr.mvvm.utils.Constants.BASE_URL;

public enum ApiClient {
    INSTANCE;

    private MvvmService apiInterface;

    ApiClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
//                .addInterceptor(new MyInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create(MvvmService.class);
    }

//    class MyInterceptor implements Interceptor {
//        @Override
//        public okhttp3.Response intercept(Chain chain) throws IOException {
//            Request originalRequest = chain.request();
//            Request.Builder myRequestBuilder = originalRequest.newBuilder();
//            return chain.proceed(myRequestBuilder.build());
//        }
//    }

    public void getPosts(final CallbackListener<List<Post>> callbackListener) {
        apiInterface.getPosts().enqueue(new ApiCallback<>(callbackListener));
    }


}
