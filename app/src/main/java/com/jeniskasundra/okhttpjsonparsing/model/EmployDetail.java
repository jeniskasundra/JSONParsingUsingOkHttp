package com.jeniskasundra.okhttpjsonparsing.model;

/**
 * Created by Jenis Kasundra on 2/2/2018.
 */

public class EmployDetail {


    private String id, name, gender, address, email, mobile, picture;


    public EmployDetail(String id, String name, String gender, String address, String picture, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.picture = picture;
        this.mobile = mobile;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
