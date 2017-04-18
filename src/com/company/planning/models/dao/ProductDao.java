package com.company.planning.models.dao;

import com.company.planning.models.pojo.Product;
import com.company.planning.models.pojo.User;

import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public interface ProductDao {
    public List<Product> getAll();
    public Product get(int id);
    public boolean update(Product product);
    public boolean delete(Product product);
}
