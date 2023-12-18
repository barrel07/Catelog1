package com.example.catalog1;

public class Category_Method {

    String user_id,user_name;

    public Category_Method(String user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public String getUser_id() {return user_id;}

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}

