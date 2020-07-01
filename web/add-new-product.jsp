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
        <form >
            <div class="form-group">
                <label for="productName">Product Name</label>
                <input type="text" name="product_name" class="form-control" id="productName"  placeholder="Product Name">
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <input type="number" name="price" class="form-control" id="price"  placeholder="Price">
            </div>

            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="number" name="quantity" class="form-control" id="quantity"  placeholder="Quantity">
            </div>

            <div class="form-group">
                <label for="color">Color</label>
                <input type="text" name="color" class="form-control" id="color"  placeholder="Color">
            </div>

            <select class="custom-select" name="category">
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </section>



</section>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<c:import url="views/foot.jsp"/>
</body>
</html>