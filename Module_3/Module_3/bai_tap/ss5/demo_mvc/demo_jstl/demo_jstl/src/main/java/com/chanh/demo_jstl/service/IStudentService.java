package com.chanh.demo_jstl.service;

import com.chanh.demo_jstl.model.Student;

import java.util.List;

public interface IStudentService  {
    List<Student> findAll();
    boolean add(Student student);
}
