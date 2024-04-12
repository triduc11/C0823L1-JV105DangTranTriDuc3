package triduc.com.final_exam.service.impl;

import triduc.com.final_exam.model.ProductCategory;
import triduc.com.final_exam.repository.IProductCategoryRepository;
import triduc.com.final_exam.repository.impl.ProductCategoryRepository;
import triduc.com.final_exam.service.IProductCategoryService;

import java.util.List;

public class ProductCategoryService implements IProductCategoryService {
    IProductCategoryRepository productCategoryRepository=new ProductCategoryRepository();
    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }
}
