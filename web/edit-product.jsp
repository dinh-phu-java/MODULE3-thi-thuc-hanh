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

<section id="main-section" class="container-fluid">
    <section class="row">
        <div class="col-sm-8">
            <form action="product-controller" method="post">
                <input type="hidden" name="action" value="edit-product">
                <input type="hidden" name="product-id" value="${editProduct.product_id}">
                <div class="form-group">
                    <label for="productName">Product Name</label>
                    <input type="text" name="product_name" class="form-control" id="productName"
                           placeholder="Product Name" value="${editProduct.product_name}">
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" name="price" class="form-control" id="price" placeholder="Price" value="${editProduct.price}">
                </div>

                <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <input type="text" name="quantity" class="form-control" id="quantity" placeholder="Quantity" value="${editProduct.quantity}">
                </div>

                <div class="form-group">
                    <label for="color">Color</label>
                    <input type="text" name="color" class="form-control" id="color" placeholder="Color" value="${editProduct.color}">
                </div>

                <select class="custom-select" name="category">
                    <c:forEach items="${categories}" var="category">
                        <c:if test = "${category.category_name==editProduct.category}">
                            <option value="${category.category_id}"  selected>${category.category_name}</option>
                        </c:if>
                        <c:if test = "${category.category_name!=editProduct.category}">
                            <option value="${category.category_id}"  >${category.category_name}</option>
                        </c:if>
                    </c:forEach>
                </select>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </section>


</section>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<c:import url="views/foot.jsp"/>
</body>
</html>