package com.dinhphu.services;

import com.dinhphu.model.Category;
import com.dinhphu.model.Product;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServices implements IProductServices{

    private final String selectAllProductQuery="select p.product_id,p.product_name,p.price,p.quantity,p.color,c.category_name from products p inner join categories c on p.category=c.category_id order by p.product_id asc";
    @Override
    public List<Product> selectAllProduct() {
        ArrayList<Product> list=new ArrayList<>();
        Connection connection=DatabaseConnection.getConnection();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(selectAllProductQuery);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int product_id=rs.getInt(1);
                String product_name=rs.getString(2);
                double price =rs.getDouble(3);
                int quantity =rs.getInt(4);
                String color= rs.getString(5);
                String category=rs.getString(6);
                Product product=new Product(product_id,product_name,price,quantity,color,category);
                list.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    private final String selectAllCategories="select * from categories";
    @Override
    public List<Category> selectAllCategory() {
        Connection connection=DatabaseConnection.getConnection();
        ArrayList<Category> list=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(selectAllCategories);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int category_id=rs.getInt(1);
                String category_name=rs.getString(2);
                Category category=new Category(category_id,category_name);
                list.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    private final String addProduct="insert into products(product_name, price, quantity, color, category) values (?,?,?,?,?)";
    @Override
    public void addProduct(Product product) {
        Connection connection=DatabaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(addProduct);
            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setInt(5,Integer.parseInt(product.getCategory()));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private final String deleteProductQuery="delete from  products where product_id=?";
    @Override
    public void deleteProduct(int product_id) {
        Connection connection=DatabaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(deleteProductQuery);
            preparedStatement.setInt(1,product_id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        ProductServices productServices=new ProductServices();
//        Product product=new Product("abc",242,12,"red","1");
//        productServices.addProduct(product);
//    }


}
