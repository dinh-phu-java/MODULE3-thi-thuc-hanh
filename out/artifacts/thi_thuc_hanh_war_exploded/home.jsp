<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinh Phu
  Date: 7/1/2020
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <c:import url="views/head.jsp"/>
</head>
<body>
<%--<a href="/product-controller?action=add-new-product" class="btn btn-primary float-left">+ Add New Product</a>--%>
<h4>${message}</h4>
<section id="main-section" class="container-fluid">
    <section class="row">
        <div class="col-sm-6">
            <a href="/product-controller?action=add-new-product" class="btn btn-primary float-left">+ Add New Product</a>
        </div>
        <div class="col-sm-6">
            <form action="" class="float-right">
                <input type="email" class="form-control" style="display:inline-block; width:400px;"  placeholder="Search">
                <button class="btn btn-primary " style="display:inline-block;">Search</button>
            </form>
        </div>
    </section>

    <section clas="row">
        <div class="col-sm-12">
            <table class="table table-striped table-bordered table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Color</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productList}" var="product">
                    <tr>
                        <th scope="row">${product.product_id}</th>
                        <td >${product.product_name}</td>
                        <td >${product.price}</td>
                        <td >${product.quantity}</td>
                        <td >${product.color}</td>
                        <td>${product.category}</td>
                        <td > <a href="" class="btn btn-primary">Edit</a>  | <a href="/product-controller?action=delete-product&product-id=${product.product_id}" class="btn btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>

</section>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<c:import url="views/foot.jsp"/>
</body>
</html>