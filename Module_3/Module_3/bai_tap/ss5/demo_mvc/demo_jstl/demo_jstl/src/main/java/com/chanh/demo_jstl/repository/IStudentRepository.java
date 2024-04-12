package com.chanh.demo_jstl.repository;

import com.chanh.demo_jstl.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    boolean add(Student student);
}
