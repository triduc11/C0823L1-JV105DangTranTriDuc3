package com.chanh.demo_jstl.dto;

public class StudentDto {
    private int id;
    private String name;
    private boolean gender;
    private float point;
    private String className;

    public StudentDto() {
    }

    public StudentDto(int id, String name, boolean gender, float point, String className) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.point = point;
        this.className = className;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
