package duc.com.demo_product.service.impl;

import duc.com.demo_product.model.ProductSize;
import duc.com.demo_product.repository.IProductSizeRepository;
import duc.com.demo_product.repository.impl.ProductSizeRepository;
import duc.com.demo_product.service.IProductSizeService;

import java.util.List;

public class ProductSizeService implements IProductSizeService {
    private IProductSizeRepository productSizeRepository =new ProductSizeRepository();
    @Override
    public List<ProductSize> findAll() {
        return productSizeRepository.findAll();
    }
}
