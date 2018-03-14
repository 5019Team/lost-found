package com.nineteen.lostfound.controller.viewobject;

import com.nineteen.lostfound.dao.harmony.entity.Address;

/**
 * Created by mengxu on 2018/1/3.
 */
public class UserInfo {
    private String userId;

    private Address address;

    private String username;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
