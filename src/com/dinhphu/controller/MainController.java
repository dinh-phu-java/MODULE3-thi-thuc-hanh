package com.dinhphu.controller;

import com.dinhphu.model.Product;
import com.dinhphu.services.IProductServices;
import com.dinhphu.services.ProductServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MainController",urlPatterns="/home")
public class MainController extends HttpServlet {
    private IProductServices productServices=new ProductServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action=request.getParameter("action");
        String url="";

        if (action==null){
            action="views";
        }
        switch (action){
            case "add-new-product":
                url="/add-new-product.jsp";
                showAddProduct(request,response);
                break;
            default:
                url="/home.jsp";
                showAllProduct(request,response);
                break;
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    private void showAddProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Product> productList=new ArrayList<>(productServices.selectAllProduct());
        request.setAttribute("productList",productList);
    }
}
