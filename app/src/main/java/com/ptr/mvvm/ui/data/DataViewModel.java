package com.ptr.mvvm.ui.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ptr.mvvm.db.PostRepository;
import com.ptr.mvvm.network.model.Post;

import java.util.List;

public class DataViewModel extends AndroidViewModel {

    private LiveData<List<Post>> posts;

    public DataViewModel(Application application) {
        super(application);
        PostRepository repository = new PostRepository(application);
        posts = repository.getPosts();
    }

    LiveData<List<Post>> getPosts(){
        return posts;
    }
}