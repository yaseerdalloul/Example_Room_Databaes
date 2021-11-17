package com.moktamel.room_databaes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = Post.class, version = 1)
@TypeConverters(Converters.class)
public abstract class PostDatabase extends RoomDatabase {

    public static PostDatabase instance;

    public abstract PostDao postDao();

    public static synchronized PostDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context, PostDatabase.class, "posts_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
