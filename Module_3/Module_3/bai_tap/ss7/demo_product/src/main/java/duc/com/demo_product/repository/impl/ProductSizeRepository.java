package duc.com.demo_product.repository.impl;

import duc.com.demo_product.model.ProductSize;
import duc.com.demo_product.repository.ConnectDB;
import duc.com.demo_product.repository.IProductSizeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductSizeRepository implements IProductSizeRepository {
    private final String GET_ALL="select * from bang_kich_thuoc";
    @Override
    public List<ProductSize> findAll() {
        List<ProductSize> productSizeList=new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id =resultSet.getInt("ma_kich_thuoc");
                String size=resultSet.getString("loai_kich_thuoc");
                ProductSize productSize =new ProductSize(id,size);
                productSizeList.add(productSize);
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
        return productSizeList;
    }
}
