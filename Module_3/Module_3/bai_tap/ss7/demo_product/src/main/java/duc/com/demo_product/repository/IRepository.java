package duc.com.demo_product.repository;

import duc.com.demo_product.model.ProductSize;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<T> {
    boolean add (T entity) ;
    List<T> getAll();
    T update(T entity);
    boolean delete (int id);
    T findById(int id);
    
}
