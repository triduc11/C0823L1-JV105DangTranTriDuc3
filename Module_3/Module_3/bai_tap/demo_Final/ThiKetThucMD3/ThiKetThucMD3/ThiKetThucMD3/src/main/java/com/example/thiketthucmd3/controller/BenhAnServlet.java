package com.example.thiketthucmd3.controller;

import com.example.thiketthucmd3.dto.BenhAnDto;
import com.example.thiketthucmd3.service.BenhAnService;
import com.example.thiketthucmd3.service.IBenhAnService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BenhAnServlet", value = "/BenhAnServlet")
public class BenhAnServlet extends HttpServlet {
           private IBenhAnService benhAnService = new BenhAnService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "edit":
                showFormEdit(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        BenhAnDto benhAnDto = benhAnService.selectBenhAn(id);
        request.setAttribute("list" ,benhAnDto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAnDto> list = benhAnService.showList();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "edit":
                updateBenhAn(request,response);
                break;
            case "delete":
                deleteBenhAn(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void updateBenhAn(HttpServletRequest request, HttpServletResponse response) {

         int id = Integer.parseInt(request.getParameter("id"));
         String maBenhAn = request.getParameter("maBA");
         String maBenhNhan = request.getParameter("maBN");
         Date ngayNhapVien = Date.valueOf(request.getParameter("ngayNhapVien"));
         Date ngayRaVien = Date.valueOf(request.getParameter("ngayRaVien"));
         String lyDoNhapVien = request.getParameter("lyDo");
         String tenBenhNhan = request.getParameter("tenBN");
         BenhAnDto benhAnDto = new BenhAnDto(id,maBenhAn,maBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,tenBenhNhan);
         benhAnService.updateBenhAn(benhAnDto);
        try {
            response.sendRedirect("/BenhAnServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        benhAnService.deleteBenhAn(id);
        try {
            response.sendRedirect("/BenhAnServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
