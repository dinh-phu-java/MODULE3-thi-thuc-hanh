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
            case "edit-product":
                editRealProduct(request, response);
                break;

            default:
                url="/home";
                break;
        }

    }

    private void editRealProduct(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session=request.getSession();
        int product_id = Integer.parseInt(String.valueOf(session.getAttribute("edit-product-id"))) ;
        String product_name=request.getParameter("product_name");
        double   price=Double.parseDouble(request.getParameter("price")) ;
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String category=request.getParameter("category");

        Product editProduct=new Product(product_name,price,quantity,color,category);
        productServices.updateProduct(editProduct,product_id);

        String message="Edit Product Completed!";
        request.setAttribute("message",message);
        String url="/home.jsp";
        ArrayList<Product> productList=new ArrayList<>(productServices.selectAllProduct());
        session.setAttribute("productList",productList);

        try {
            getServletContext().getRequestDispatcher(url).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        session.setAttribute("productList",productList);

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
            case "edit-product":
                 url="/edit-product.jsp";
                editProduct(request,response);
                break;
            default:
                url="/home";
                break;
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        int product_id=Integer.parseInt(request.getParameter("product-id")) ;
        Product editProduct=productServices.selectProductById(product_id);
        request.setAttribute("editProduct",editProduct);

        ArrayList<Category> categories=new ArrayList<>(productServices.selectAllCategory());
        session.setAttribute("categories",categories);
        session.setAttribute("edit-product-id",product_id);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int product_id=Integer.parseInt(request.getParameter("product-id")) ;
        HttpSession session=request.getSession();
        productServices.deleteProduct(product_id);
        String url="/home.jsp";
        String message="Delete Product Completed!";
        request.setAttribute("message",message);
        ArrayList<Product> productList=new ArrayList<>(productServices.selectAllProduct());
        session.setAttribute("productList",productList);

        try {
            getServletContext().getRequestDispatcher(url).forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
