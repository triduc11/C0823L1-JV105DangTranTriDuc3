package triduc.com.final_exam.service.impl;

import triduc.com.final_exam.dto.ProductDto;
import triduc.com.final_exam.model.Product;
import triduc.com.final_exam.repository.IProductRepository;
import triduc.com.final_exam.repository.impl.ProductRepository;
import triduc.com.final_exam.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository =new ProductRepository();
    @Override
    public boolean add(Product entity) {
        return productRepository.add(entity);
    }

    @Override
    public boolean update(Product entity) {
        return productRepository.update(entity);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductDto> getAllDTO() {
        return productRepository.getAllDTO();
    }

    @Override
    public List<ProductDto> search(String searchName) {
        return productRepository.search(searchName);
    }
}
