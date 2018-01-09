package com.mvc.cn.entity;

/**
 * Created by liKun on 2018/1/8 0008.
 */
public class Company {
    private String name;
    private User user;
    private int age;

    public Company() {
    }

    public Company(String name, User user, int age) {
        this.name = name;
        this.user = user;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", user=" + user +
                ", age=" + age +
                '}';
    }
}
