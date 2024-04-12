package triduc.com.final_exam.service;

import triduc.com.final_exam.dto.ProductDto;
import triduc.com.final_exam.model.Product;

import java.util.List;

public interface IProductService {
    boolean add (Product entity) ;
    boolean update(Product entity);
    boolean delete (int id);
    Product findById(int id);
    List<ProductDto> getAllDTO ();
    List<ProductDto> search (String searchName);
}
