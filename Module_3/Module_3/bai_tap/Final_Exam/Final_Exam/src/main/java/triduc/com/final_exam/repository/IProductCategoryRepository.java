package triduc.com.final_exam.repository;

import triduc.com.final_exam.model.ProductCategory;

import java.util.List;

public interface IProductCategoryRepository {
    List<ProductCategory> findAll();
}
