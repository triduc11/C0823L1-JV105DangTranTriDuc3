package com.chanh.demo_jstl;

import com.chanh.demo_jstl.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view//list.jsp");
        req.setAttribute("studentList",studentList);
        requestDispatcher.forward(req,resp);
    }
}
