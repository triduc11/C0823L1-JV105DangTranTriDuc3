package com.chanh.demo_jstl.repository.impl;

import com.chanh.demo_jstl.dto.StudentDto;
import com.chanh.demo_jstl.model.Student;
import com.chanh.demo_jstl.repository.ConnectDB;
import com.chanh.demo_jstl.repository.IStudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String GET_All ="select * from student;";
    private final String GET_All_DTO ="SELECT s.*, c.name as class_name FROM student s join class c on s.class_id=c.id;";
    private final String INSERT ="insert into student(name,gender,point,class_id) values (?,?,?,?);";
    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        // kết nối DB
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
              int id =  resultSet.getInt("id");
              String name = resultSet.getString("name");
              boolean gender = resultSet.getBoolean("gender");
              float point = resultSet.getFloat("point");
              int classId = resultSet.getInt("class_id");
              Student student = new Student(id,name,gender,point,classId);
              studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return studentList;
    }

    @Override
    public List<StudentDto> getAll() {

        List<StudentDto> studentList = new ArrayList<>();
        // kết nối DB
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_All_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =  resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float point = resultSet.getFloat("point");
                String className = resultSet.getString("class_name");
                StudentDto student = new StudentDto(id,name,gender,point,className);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setBoolean(2,student.isGender());
            preparedStatement.setFloat(3,student.getPoint());
            preparedStatement.setInt(4,student.getClassId());
            int effectRow=preparedStatement.executeUpdate();
            return effectRow ==1;
        } catch (SQLException e) {
            return false;
        }
    }
}
