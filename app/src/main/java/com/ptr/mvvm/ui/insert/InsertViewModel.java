package com.ptr.mvvm.ui.insert;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.ptr.mvvm.db.PostRepository;
import com.ptr.mvvm.network.model.Post;

public class InsertViewModel extends AndroidViewModel {

    private PostRepository repository;

    public InsertViewModel(Application application) {
        super(application);
        repository = new PostRepository(application);
    }

    void insert(Post post)
    {
        repository.insert(post);
    }

}