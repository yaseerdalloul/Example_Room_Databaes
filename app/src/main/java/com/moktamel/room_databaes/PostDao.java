package com.moktamel.room_databaes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
interface PostDao {
    @Insert
    Completable insertPost(Post post);

    @Query("select * from Post_table")
    Observable<List<Post>> getPost();
}
