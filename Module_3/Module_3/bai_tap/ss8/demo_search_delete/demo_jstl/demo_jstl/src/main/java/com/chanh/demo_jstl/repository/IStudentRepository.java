package com.chanh.demo_jstl.repository;

import com.chanh.demo_jstl.dto.StudentDto;
import com.chanh.demo_jstl.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    List<StudentDto> getAll();
    List<StudentDto> search(String name, String className);
    boolean add(Student student);
    boolean delete(int id);
}
