package com.ptr.mvvm.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ptr.mvvm.network.model.Post;

import java.util.List;

@Dao
public interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPost(Post post);

    @Query("SELECT * From Post")
    LiveData<List<Post>> getPosts();
}
