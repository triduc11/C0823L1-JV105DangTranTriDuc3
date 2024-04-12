package com.chanh.demo_jstl.model;

public class CodeClass {
    private int id;
    private  String name;

    public CodeClass() {
    }

    public CodeClass(int id, String name) {
        this.id = id;
        this.name = name;
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
}
