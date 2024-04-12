package repository;

import dto.ProductDto;
import model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final static String GET_ALL = "SELECT * FROM product";
    private final static String GET_ALL_DTO = "select product.id, product.name, price,description, manufactor.name as manufactor\n" +
            "from product \n" +
            "join manufactor on manufactor.id = product.manufactor;";
    private final static String DELETE_BY_ID = "DELETE FROM product WHERE id = ?";
    private final static String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
//    private final static String SEARCH = "SELECT * FROM product WHERE name = ? AND  manufactor = ?";

    private final static String SAVE = "INSERT INTO product(name,price,description,manufactor) VALUE (?,?,?,?)";
    private final static String UPDATE = "UPDATE product SET name=? ,price= ?,description= ?, manufactor =? WHERE id =?";
    private final static String SEARCH_DTO = "SELECT product.id, product.name, price,description, manufactor.name AS manufactor\n" +
            "FROM product\n" +
            "JOIN manufactor ON manufactor.id = product.manufactor\n" +
            "WHERE product.name like concat('%',?,'%') and manufactor.id = ?;";
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String desc = resultSet.getString("description");
                int manufactor = resultSet.getInt("manufactor");
                productList.add(new Product(id,name,price,desc,manufactor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public List<ProductDto> findAllDto() {
        List<ProductDto> productList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(GET_ALL_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String desc = resultSet.getString("description");
                String manufactor = resultSet.getString("manufactor");
                productList.add(new ProductDto(id, name,price,desc,manufactor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product foundProduct = null;
        Connection conn = null;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String desc = resultSet.getString("description");
                int manufactor = resultSet.getInt("manufactor");
                foundProduct = new Product(id,name,price,desc,manufactor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foundProduct;
    }
    @Override
    public Product findByName(String name) {

        return null;
    }

    @Override
    public boolean add(Product newProduct) {
        Connection conn = null;
        int rowEffected = 0;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(SAVE);
//            preparedStatement.setInt(1, newProduct.getId());
            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setFloat(2, newProduct.getPrice());
            preparedStatement.setString(3, newProduct.getDescription());
            preparedStatement.setInt(4, newProduct.getManufactor());
            rowEffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowEffected>0;
    }
    @Override
    public boolean deleteById(int id) {
        Connection conn = null;
        int rowEffected = 0;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            rowEffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rowEffected>0;
    }

    @Override
    public boolean update(Product product) {
        int updateId = product.getId();
        Connection conn = null;
        int rowEffected = 0;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getManufactor());
            preparedStatement.setInt(5, updateId);
            rowEffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return rowEffected>0;

    }

    @Override
    public List<ProductDto> search(String name, int manufactor) {
        List<ProductDto> foundProducts = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConnectDB.getConnectDB();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(SEARCH_DTO);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, manufactor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int foundId = resultSet.getInt("id");
                String foundnName = resultSet.getString("name");
                float foundPrice = resultSet.getFloat("price");
                String foundDesc = resultSet.getString("description");
                String foundManufactor = resultSet.getString("manufactor");
                foundProducts.add(new ProductDto(foundId,foundnName,foundPrice,foundDesc,foundManufactor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foundProducts;
    }
}
