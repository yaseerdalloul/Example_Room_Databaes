package com.moktamel.room_databaes;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Post_table")
public class Post {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private User user;
    private String Title;
//    @Ignore >> هاد لو تريد العمود هاد ما بدخل في قاعده البيانات
    private String Body;

    public Post() {
    }

    public Post( User user, String title, String body) {

        this.user = user;
        Title = title;
        Body = body;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }
}
