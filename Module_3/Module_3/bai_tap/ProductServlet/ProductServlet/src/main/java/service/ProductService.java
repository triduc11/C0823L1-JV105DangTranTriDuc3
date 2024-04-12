package service;

import dto.ProductDto;
import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    @Override
    public List<ProductDto> findAllDto() {
        return productRepository.findAllDto();
    }

    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDto> search(String name, int manufactor) {
        return productRepository.search(name, manufactor);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public boolean add(Product newProduct) {
        return productRepository.add(newProduct);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepository.deleteById(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }
}
