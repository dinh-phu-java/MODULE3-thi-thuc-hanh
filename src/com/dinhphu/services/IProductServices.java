package com.dinhphu.services;

import com.dinhphu.model.Category;
import com.dinhphu.model.Product;

import java.util.List;

public interface IProductServices {
    public List<Product> selectAllProduct();
    public List<Category> selectAllCategory();
    public void addProduct(Product product);
    public void updateProduct(Product product,int product_id);
    public void deleteProduct(int product_id);
    public Product selectProductById(int product_id);
}
