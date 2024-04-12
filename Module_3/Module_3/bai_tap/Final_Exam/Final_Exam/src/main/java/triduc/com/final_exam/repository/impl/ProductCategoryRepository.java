package triduc.com.final_exam.repository.impl;

import triduc.com.final_exam.model.ProductCategory;
import triduc.com.final_exam.repository.ConnectDB;
import triduc.com.final_exam.repository.IProductCategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryRepository implements IProductCategoryRepository {
    private final String GET_ALL="select * from bang_danh_muc;";

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> productCategoryList=new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt("ma_danh_muc");
                String category=resultSet.getString("danh_muc");
                ProductCategory productSize =new ProductCategory(id,category);
                productCategoryList.add(productSize);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productCategoryList;
    }
}

