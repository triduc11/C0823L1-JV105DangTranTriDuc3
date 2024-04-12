package duc.com.demo_product.service;

import duc.com.demo_product.dto.ProductDto;
import duc.com.demo_product.model.Product;

import java.util.List;

public interface IProductService  {
    boolean add (Product entity) ;
    List<Product> getAll();
    boolean update(Product product);
    boolean delete (int id);
    Product findById(int id);
    List<ProductDto> search (String searchName,String searchSize);
    List<ProductDto> getAllDTO ();
}
