package com.moktamel.room_databaes;

public class User {
    private int UserID;
    private String UserName;

    public User() {
    }

    public User(int userID, String userName) {
        UserID = userID;
        UserName = userName;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}

