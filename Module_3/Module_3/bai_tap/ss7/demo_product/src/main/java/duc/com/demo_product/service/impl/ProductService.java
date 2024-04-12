package duc.com.demo_product.service.impl;

import duc.com.demo_product.dto.ProductDto;
import duc.com.demo_product.model.Product;
import duc.com.demo_product.repository.IProductRepository;
import duc.com.demo_product.repository.impl.ProductRepository;
import duc.com.demo_product.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public boolean add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
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
    public List<ProductDto> search(String name, String size) {
        return productRepository.search(name,size);
    }

    public List<ProductDto> getAllDTO() {
        return productRepository.getAllDTO();

    }
}
