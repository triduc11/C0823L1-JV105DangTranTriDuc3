package duc.com.demo_product.repository.impl;

import duc.com.demo_product.dto.ProductDto;
import duc.com.demo_product.model.Product;
import duc.com.demo_product.repository.ConnectDB;
import duc.com.demo_product.repository.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String GET_All = "select * from thong_tin_sp;";
    private final String GET_ALL_DTO = "select thong_tin_sp.id,thong_tin_sp.ten_san_pham,thong_tin_sp.don_gia,thong_tin_sp.so_luong,bang_kich_thuoc.loai_kich_thuoc from thong_tin_sp join bang_kich_thuoc on thong_tin_sp.kich_thuoc=bang_kich_thuoc.ma_kich_thuoc order by thong_tin_sp.id asc;";
    private final String INSERT = "insert into thong_tin_sp(ten_san_pham,don_gia,so_luong,kich_thuoc) values (?,?,?,?);";
    private final String SEARCH = "select thong_tin_sp.id,thong_tin_sp.ten_san_pham,thong_tin_sp.don_gia,thong_tin_sp.so_luong,bang_kich_thuoc.loai_kich_thuoc from thong_tin_sp join bang_kich_thuoc on thong_tin_sp.kich_thuoc=bang_kich_thuoc.ma_kich_thuoc where thong_tin_sp.ten_san_pham like concat('%',?,'%') and bang_kich_thuoc.loai_kich_thuoc like concat('%',?,'%') order by thong_tin_sp.id asc;";
    private final String UPDATE = "update thong_tin_sp set ten_san_pham=?, don_gia=?,so_luong=?,kich_thuoc=? where id=?;";
    private final String FIND_BY_ID="select * from thong_tin_sp where id=?;";

    @Override
    public boolean add(Product product) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setInt(4, product.getSize());
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
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_All);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("don_gia");
                int amount = resultSet.getInt("so_luong");
                int size = resultSet.getInt("kich_thuoc");
                Product product = new Product(id, name, price, amount, size);
                productList.add(product);
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
        return productList;
    }

    public List<ProductDto> getAllDTO() {
        List<ProductDto> productDtoList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("don_gia");
                int amount = resultSet.getInt("so_luong");
                String size = resultSet.getString("loai_kich_thuoc");
                ProductDto productDto = new ProductDto(id, name, price, amount, size);
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
    public boolean update(Product product) {
        int updateId= product.getId();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setInt(4, product.getSize());
            preparedStatement.setInt(5, updateId);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow==1;
        } catch (SQLException e) {
            return false;
        }finally {
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
        Product product =null;
        Connection connection =ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("don_gia");
                int amount = resultSet.getInt("so_luong");
                int size = Integer.parseInt(resultSet.getString("kich_thuoc"));
                product = new Product(id, name, price, amount, size);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public List<ProductDto> search(String searchName, String searchSize) {
        List<ProductDto> productDtoList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, searchName);
            preparedStatement.setString(2, searchSize);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ten_san_pham");
                float price = resultSet.getFloat("don_gia");
                int amount = resultSet.getInt("so_luong");
                String size = resultSet.getString("loai_kich_thuoc");
                ProductDto productDto = new ProductDto(id, name, price, amount, size);
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
