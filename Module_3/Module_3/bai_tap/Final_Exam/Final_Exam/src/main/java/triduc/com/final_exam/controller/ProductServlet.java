package triduc.com.final_exam.controller;

import triduc.com.final_exam.dto.ProductDto;
import triduc.com.final_exam.model.Product;
import triduc.com.final_exam.service.IProductCategoryService;
import triduc.com.final_exam.service.IProductService;
import triduc.com.final_exam.service.impl.ProductCategoryService;
import triduc.com.final_exam.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    IProductCategoryService productCategoryService = new ProductCategoryService();
    IProductService productService = new ProductService();

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
        String searchName = req.getParameter("searchName");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/list.jsp");
        List<ProductDto> productDtoList = productService.search(searchName);
        req.setAttribute("productDtoList", productDtoList);
        req.setAttribute("searchName", searchName);
        requestDispatcher.forward(req, resp);
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int updateId = Integer.parseInt(req.getParameter("updateId"));
        Product product = productService.findById(updateId);
        req.setAttribute("product", product);
        req.setAttribute("productCategoryList", productCategoryService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productCategoryList", productCategoryService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/list.jsp");
        req.setAttribute("productCategoryList", productCategoryService.findAll());
        List<ProductDto> productDtoList = productService.getAllDTO();
        req.setAttribute("productDtoList", productDtoList);
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
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int category = Integer.parseInt(req.getParameter("category"));
        Product product = new Product(id, name, price, amount, color, description, category);
        boolean check = productService.update(product);
        String mess = "Không thành công";
        if (check) {
            mess = "Thành công";
        }
        resp.sendRedirect("/product?mess=" + mess);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean check = productService.delete(deleteId);
        String mess = "NOT";
        if (check) {
            mess = "OK";
        }
        resp.sendRedirect("/product?deleteMessage=" + mess);
    }

    private void saveAddForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int category = Integer.parseInt(req.getParameter("category"));
        Product product = new Product(name, price, amount, color, description, category);
        boolean check = productService.add(product);
        String mess = "Không thành công";
        if (check) {
            mess = "Thành công";
        }
        resp.sendRedirect("/product?mess=" + mess);
    }
}
