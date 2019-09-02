package com.ptr.mvvm.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ptr.mvvm.network.model.Post;

import java.util.List;

public class PostRepository {
    private final PostDao postDao;
    private LiveData<List<Post>> posts;

    public PostRepository(Application application) {
        MvvmDatabase db = MvvmDatabase.getDatabase(application);
        postDao = db.postDao();
        posts = postDao.getPosts();
    }

    public LiveData<List<Post>> getPosts() {
        return posts;
    }

    public void insert(Post posts) {
        new insertAsyncTask(postDao).execute(posts);
    }

    private static class insertAsyncTask extends AsyncTask<Post, Void, Void> {

        private PostDao dao;

        insertAsyncTask(PostDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(final Post... params) {
            dao.insertPost(params[0]);
            return null;
        }
    }

}

