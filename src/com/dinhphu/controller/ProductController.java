package com.dinhphu.controller;

import com.dinhphu.model.Category;
import com.dinhphu.model.Product;
import com.dinhphu.services.IProductServices;
import com.dinhphu.services.ProductServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductController",urlPatterns = "/product-controller")
public class ProductController extends HttpServlet {
    private IProductServices productServices=new ProductServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        String url="";
        if (action==null){
            action="views";
        }
        switch (action) {
            case "add-product":
                addProduct(request, response);
                break;
            default:
                url="/home";
                break;
        }

    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        String product_name=request.getParameter("product_name");
        double   price=Double.parseDouble(request.getParameter("price")) ;
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String category=request.getParameter("category");

        Product addProduct=new Product(product_name,price,quantity,color,category);

        productServices.addProduct(addProduct);
        String message="Add Product Completed!";
        request.setAttribute("message",message);
        String url="/home.jsp";
         ArrayList<Product> productList=new ArrayList<>(productServices.selectAllProduct());
        request.setAttribute("productList",productList);

        try {
            getServletContext().getRequestDispatcher(url).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        String url="";

        if (action==null){
            action="views";
        }
        switch (action) {
            case "add-new-product":
                url = "/add-new-product.jsp";
                showAddProduct(request, response);
                break;
            case "delete-product":
                deleteProduct(request,response);
                break;
            default:
                url="/home";
                break;
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        
    }

    private void showAddProduct(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        ArrayList<Category> categories=new ArrayList<>(productServices.selectAllCategory());
        session.setAttribute("categories",categories);
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) {

        ArrayList<Product> productList=new ArrayList<>(productServices.selectAllProduct());
        request.setAttribute("productList",productList);
    }
}
