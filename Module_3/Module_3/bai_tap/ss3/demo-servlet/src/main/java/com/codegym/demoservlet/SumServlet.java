package com.codegym.demoservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", value = {"/sum","/cong"})
public class SumServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("init chay 1 lan khi khởi tạo");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number1 = Integer.parseInt(req.getParameter("n1"));
        int number2 = Integer.parseInt(req.getParameter("n2"));
        int sum = number1+ number2;
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>Hello sum</h1>");
        printWriter.println("<h1>Tổng :"+sum+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int number1 = Integer.parseInt(req.getParameter("n1"));
        int number2 = Integer.parseInt(req.getParameter("n2"));
        int sum = number1+ number2;
        req.setAttribute("tong", sum);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Result.jsp");
        requestDispatcher.forward(req,resp);

    }

    @Override
    public void destroy() {
        System.out.println("destroy chay 1 lan truoc khi mat");
    }
}
