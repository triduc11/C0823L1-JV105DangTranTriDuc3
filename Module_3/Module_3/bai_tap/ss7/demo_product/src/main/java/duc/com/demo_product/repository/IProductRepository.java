package duc.com.demo_product.repository;

import duc.com.demo_product.dto.ProductDto;
import duc.com.demo_product.model.Product;

import java.util.List;

public interface IProductRepository {
    boolean add (Product entity) ;
    List<Product> getAll();
    boolean update(Product entity);
    boolean delete (int id);
    Product findById(int id);
    List<ProductDto> search (String name,String size);
    List<ProductDto> getAllDTO ();
}
