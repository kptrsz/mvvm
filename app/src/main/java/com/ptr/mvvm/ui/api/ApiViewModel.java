package com.ptr.mvvm.ui.api;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ptr.mvvm.network.PlaceHolderRepository;
import com.ptr.mvvm.network.model.Post;

import java.util.List;

public class ApiViewModel extends AndroidViewModel {

    private PlaceHolderRepository repository;

    public ApiViewModel(Application application) {
        super(application);
        this.repository = new PlaceHolderRepository();
    }

    public LiveData<List<Post>> getPosts() {
        return repository.getPosts();
    }
}