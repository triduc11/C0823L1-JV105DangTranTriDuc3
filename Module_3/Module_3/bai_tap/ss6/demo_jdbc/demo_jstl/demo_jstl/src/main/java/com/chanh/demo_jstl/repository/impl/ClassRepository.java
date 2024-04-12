package com.chanh.demo_jstl.repository.impl;

import com.chanh.demo_jstl.model.CodeClass;
import com.chanh.demo_jstl.model.Student;
import com.chanh.demo_jstl.repository.ConnectDB;
import com.chanh.demo_jstl.repository.IClassRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository implements IClassRepository {
    private final  String GET_All ="select  * from class";
    @Override
    public List<CodeClass> findAll() {
        List<CodeClass> classList = new ArrayList<>();
        // kết nối DB
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =  resultSet.getInt("id");
                String name = resultSet.getString("name");
                CodeClass codeClass = new CodeClass(id,name);
                classList.add(codeClass);
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
        return classList;
    }
}
