package com.dinhphu.services;

import com.dinhphu.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServices implements IProductServices{

    private final String selectAllProductQuery="select p.product_id,p.product_name,p.price,p.quantity,p.color,c.category_name from products p inner join categories c on p.category=c.category_id";
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


}
