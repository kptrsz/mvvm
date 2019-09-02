package com.ptr.mvvm.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ptr.mvvm.network.model.Post;

import static com.ptr.mvvm.utils.Constants.DB_NAME;

@Database(entities = {Post.class},
        version = 1)
public abstract class MvvmDatabase extends RoomDatabase {
    public abstract PostDao postDao();

    private static volatile MvvmDatabase INSTANCE;

    static MvvmDatabase getDatabase(final Context context) {
        if (INSTANCE == null)
            synchronized (MvvmDatabase.class) {
                if (INSTANCE == null)
                    createDatabase(context);
            }
        return INSTANCE;
    }

    private static void createDatabase(Context context) {
        INSTANCE = Room.databaseBuilder(
                context.getApplicationContext(),
                MvvmDatabase.class,
                DB_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }
}
