package com.example.administrator.gson;

/**
 * Created by Administrator on 2017/3/5 0005.
 */

public class Student {
    int id;
    String name;
    int age;
    public Student( int id,String name,int age){
        id=this.id;
        name=this.name;
        age=this.age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
