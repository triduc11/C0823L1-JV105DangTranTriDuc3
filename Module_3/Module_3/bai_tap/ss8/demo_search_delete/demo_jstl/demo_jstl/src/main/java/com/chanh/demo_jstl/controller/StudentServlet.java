package com.chanh.demo_jstl.controller;

import com.chanh.demo_jstl.dto.StudentDto;
import com.chanh.demo_jstl.model.Student;
import com.chanh.demo_jstl.service.IClassService;
import com.chanh.demo_jstl.service.IStudentService;
import com.chanh.demo_jstl.service.impl.ClassService;
import com.chanh.demo_jstl.service.impl.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
   private IStudentService studentService = new StudentService();
   private IClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action ="";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                break;
            case "delete":
                break;
            case "search":
                search(req,resp);
                break;
            default:
                showList(req,resp);

        }

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchName");
        String className = req.getParameter("className");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/student/list.jsp");
        req.setAttribute("classList", classService.findAll());
        List<StudentDto> studentList = studentService.search(searchName,className);
        req.setAttribute("studentList",studentList);
        req.setAttribute("searchName",searchName);
        requestDispatcher.forward(req,resp);

    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("classList", classService.findAll());
        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("view/student/add.jsp");
        requestDispatcher1.forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/student/list.jsp");
        req.setAttribute("classList", classService.findAll());
        List<StudentDto> studentList = studentService.getAll();
        req.setAttribute("studentList",studentList);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action ="";
        }
        switch (action){
            case "add":
                save(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            default:
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean check = studentService.delete(deleteId);
        String mess = "NOT";
        if (check){
            mess = "OK";
        }
        resp.sendRedirect("/student?deleteMessage="+mess);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        float point = Float.parseFloat(req.getParameter("point"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name,gender,point,classId);
        boolean check = studentService.add(student);
        String mess = "Not Ok";
        if (check){
            mess ="OK";
        }
        resp.sendRedirect("/student?mess="+mess);
    }
}
