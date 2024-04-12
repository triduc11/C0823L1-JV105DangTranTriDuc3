package controller;

import model.BenhAn;
import service.IBenhAnService;
import service.IBenhNhanService;
import service.impl.BenhAnService;
import service.impl.BenhNhanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "BenhAnServlet", value = "/benhAn")
public class BenhAnServlet extends HttpServlet {
    private IBenhAnService benhAnService = new BenhAnService();
    private IBenhNhanService benhNhanService = new BenhNhanService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(req, resp);
                break;
            case "delete":
                break;
            case "search":
                search(req, resp);
                break;
            case "update":
                showUpdateForm(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchMaBenhAn = req.getParameter("searchMaBenhAn");
        String searchTenBenhNhan = req.getParameter("searchTenBenhNhan");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/benhAn/list.jsp");
        req.setAttribute("benhAnDtoList", benhNhanService.findAll());
        req.setAttribute("benhAnDtoList", benhAnService.search(searchMaBenhAn, searchTenBenhNhan));
        req.setAttribute("searchMaBenhAn", searchMaBenhAn);
        requestDispatcher.forward(req, resp);
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int updateId = Integer.parseInt(req.getParameter("updateId"));
        req.setAttribute("benhAn", benhAnService.findById(updateId));
        req.setAttribute("tenBenhNhan", benhNhanService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/benhAn/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tenBenhNhan", benhNhanService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/benhAn/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/benhAn/list.jsp");
        req.setAttribute("tenBenhNhan", benhNhanService.findAll());
        req.setAttribute("benhAnDtoList", benhAnService.getAll());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                saveAddForm(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                saveUpdateForm(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void saveUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String maBenhAn = req.getParameter("maBenhAn");
        String maBenhNhan = req.getParameter("maBenhNhan");
        Date ngayNhapVien = Date.valueOf(req.getParameter("ngayNhapVien"));
        Date ngayRaVien = Date.valueOf(req.getParameter("ngayRaVien"));
        String lyDoNhapVien = req.getParameter("lyDoNhapVien");
        BenhAn benhAn = new BenhAn(id, maBenhAn, maBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        boolean check = benhAnService.update(benhAn);
        String mess = "Không thành công";
        ;
        if (check) {
            mess = "Thành công";
        }
        resp.sendRedirect("/benhAn?mess=" + mess);
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean check = benhAnService.delete(deleteId);
        String mess = "NOT";
        if (check) {
            mess = "OK";
        }
        resp.sendRedirect("/benhAn?deleteMessage=" + mess);
    }

    private void saveAddForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String maBenhAn = req.getParameter("maBenhAn");
        String maBenhNhan = req.getParameter("maBenhNhan");
        Date ngayNhapVien = Date.valueOf(req.getParameter("ngayNhapVien"));
        Date ngayRaVien = Date.valueOf(req.getParameter("ngayRaVien"));
        String lyDoNhapVien = req.getParameter("lyDoNhapVien");
        BenhAn benhAn = new BenhAn(maBenhAn, maBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        boolean check = benhAnService.add(benhAn);
        String mess = "Không thành công";
        ;
        if (check) {
            mess = "Thành công";
        }
        resp.sendRedirect("/benhAn?mess=" + mess);
    }
}
