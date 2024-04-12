package com.chanh.demo_jstl.repository;

import com.chanh.demo_jstl.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"chanh1",true,3.5f,1));
        studentList.add(new Student(2,"Nhân Chánh",true,10.0f,1));
        studentList.add(new Student(3,"Nghiêm",true,3.5f,1));
        studentList.add(new Student(4,"Hậu",false,8.5f,1));
        studentList.add(new Student(5,"Huy",true,6.5f,1));
        studentList.add(new Student(6,"Đức",false,5,1));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }
}
