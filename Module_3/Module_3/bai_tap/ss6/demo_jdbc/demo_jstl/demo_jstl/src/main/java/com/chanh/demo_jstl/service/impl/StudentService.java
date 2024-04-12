package com.chanh.demo_jstl.service.impl;

import com.chanh.demo_jstl.dto.StudentDto;
import com.chanh.demo_jstl.model.Student;
import com.chanh.demo_jstl.repository.IStudentRepository;
import com.chanh.demo_jstl.repository.impl.StudentRepository;
import com.chanh.demo_jstl.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentDto> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }
}
