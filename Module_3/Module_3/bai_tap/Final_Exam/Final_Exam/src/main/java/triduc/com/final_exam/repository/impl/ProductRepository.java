package triduc.com.final_exam.repository.impl;

import triduc.com.final_exam.dto.ProductDto;
import triduc.com.final_exam.model.Product;
import triduc.com.final_exam.repository.ConnectDB;
import triduc.com.final_exam.repository.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String GET_ALL_DTO = "select thong_tin_san_pham.id ,thong_tin_san_pham.ten_san_pham,thong_tin_san_pham.gia ,thong_tin_san_pham.so_luong,thong_tin_san_pham.mau_sac,bang_danh_muc.danh_muc from thong_tin_san_pham\n" +
            "join bang_danh_muc on bang_danh_muc.ma_danh_muc=thong_tin_san_pham.ma_danh_muc ;";
    private final String INSERT = "insert into thong_tin_san_pham(ten_san_pham,gia,so_luong,mau_sac,mo_ta,ma_danh_muc) values (?,?,?,?,?,?);";
    private final String UPDATE = "update thong_tin_san_pham set ten_san_pham=?,gia=?,so_luong=?,mau_sac=?,mo_ta=?,ma_danh_muc=? where id=? ;";
    private final String FIND_BY_ID = "select * from thong_tin_san_pham where id=?;";

    private final String SEARCH = "select thong_tin_san_pham.id ,thong_tin_san_pham.ten_san_pham,thong_tin_san_pham.gia ,thong_tin_san_pham.so_luong,thong_tin_san_pham.mau_sac,bang_danh_muc.danh_muc from thong_tin_san_pham\n" +
            "join bang_danh_muc on bang_danh_muc.ma_danh_muc=thong_tin_san_pham.ma_danh_muc \n" +
            "where thong_tin_san_pham.ten_san_pham like concat('%',?,'%') ;";

    @Override
    public boolean add(Product product) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean update(Product product) {
        int updateId = product.getId();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategory());
            preparedStatement.setInt(7, updateId);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_by_id(?);");
            callableStatement.setInt(1, id);
            int effectRow = callableStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("gia");
                int amount = resultSet.getInt("so_luong");
                String color = resultSet.getString("mau_sac");
                String description = resultSet.getString("mo_ta");
                int category = resultSet.getInt("ma_danh_muc");
                product = new Product(id, name, price, amount, color, description, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return product;
    }

    @Override
    public List<ProductDto> getAllDTO() {

        List<ProductDto> productDtoList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("gia");
                int amount = resultSet.getInt("so_luong");
                String color = resultSet.getString("mau_sac");
                String category = resultSet.getString("danh_muc");
                ProductDto productDto = new ProductDto(id, name, price, amount, color, category);
                productDtoList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> search(String searchName) {
        List<ProductDto> productDtoList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("gia");
                int amount = resultSet.getInt("so_luong");
                String color = resultSet.getString("mau_sac");
                String category = resultSet.getString("danh_muc");
                ProductDto productDto = new ProductDto(id, name, price, amount, color, category);
                productDtoList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productDtoList;
    }
}

