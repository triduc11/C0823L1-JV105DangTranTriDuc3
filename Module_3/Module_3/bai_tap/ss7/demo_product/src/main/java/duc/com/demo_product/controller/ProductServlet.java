package duc.com.demo_product.controller;

import duc.com.demo_product.dto.ProductDto;
import duc.com.demo_product.model.Product;
import duc.com.demo_product.service.IProductService;
import duc.com.demo_product.service.IProductSizeService;
import duc.com.demo_product.service.impl.ProductService;
import duc.com.demo_product.service.impl.ProductSizeService;

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
    private IProductService productService = new ProductService();

    private IProductSizeService productSizeService = new ProductSizeService();

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

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int updateId = Integer.parseInt(req.getParameter("updateId"));
        Product product = productService.findById(updateId);
        req.setAttribute("product", product);
        req.setAttribute("productSizeList", productSizeService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productSizeList", productSizeService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/list.jsp");
        req.setAttribute("productSizeList", productSizeService.findAll());
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
        }
    }

    private void saveUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        int size = Integer.parseInt(req.getParameter("size"));
        Product product = new Product(id, name, price, amount, size);
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
        int size = Integer.parseInt(req.getParameter("size"));
        Product product = new Product(name, price, amount, size);
        boolean check = productService.add(product);
        String mess = "Không thành công";
        if (check) {
            mess = "Thành công";
        }
        resp.sendRedirect("/product?mess=" + mess);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchName");
        String searchSize = req.getParameter("searchSize");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/product/list.jsp");
        req.setAttribute("productDtoList", productSizeService.findAll());
        List<ProductDto> productDtoList = productService.search(searchName, searchSize);
        req.setAttribute("productDtoList", productDtoList);
        req.setAttribute("searchName", searchName);
        requestDispatcher.forward(req, resp);
    }
}
