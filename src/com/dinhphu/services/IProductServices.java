package com.dinhphu.services;

import com.dinhphu.model.Category;
import com.dinhphu.model.Product;

import java.util.List;

public interface IProductServices {
    public List<Product> selectAllProduct();
    public List<Category> selectAllCategory();
    public void addProduct(Product product);
    public void deleteProduct(int product_id);
}
