package com.thelearningtogether.myapplication.models;

public class User {


    private String avatarUrl;
    private String displayName;
    private String username;

    public User(){

    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getUsername() {
        return username;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
