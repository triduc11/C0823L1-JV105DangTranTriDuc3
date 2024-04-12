package duc.com.demo_product.service;

import java.util.List;

public interface IService<T> {
    boolean add (T entity) ;
    List<T> getAll();
    T update(T entity);
    boolean delete (int id);
    T findById(int id);
}
