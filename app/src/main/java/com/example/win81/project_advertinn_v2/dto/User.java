package com.example.win81.project_advertinn_v2.dto;

import java.io.Serializable;

/**
 * Created by Win 8.1 on 07/12/2017.
 */

public class User implements Serializable{
    public static int autoIncrement=1;
    int userId =0;
    String name =null;
    String email=null,password=null,mobileNumber=null;

    public User() {
    }

    public User(int userId, String name, String email, String password, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        String str="Email : "+getEmail()+"\n Password: "+getPassword()+"\n Mobile :"+getMobileNumber()+"\n Name :"+getName();
        return str;
    }
}
