<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Dish</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/updateFood">
    <label> Id: <input type="number" name="id"/> </label>
    <br>
    <label> Name: <input type="text" name="name"/> </label>
    <br>
    <label> Price: <input type="number" name="price"/> </label>
    <br>
    <label> Ingredients: <input type="text" name="ingredients"/> </label>
    <br>
    <label> Discount: <input type="number" name="discount"/> </label>
    <br>
    <label> Weight: <input type="number" name="weight"/> </label>
    <br>
    <label> Cooking Time: <input type="number" name="cookingTime"/> </label>
    <br>
    <label> Delivery: <input type="checkbox" name="delivery" value="true"/> </label>
    <br>
    <input type="submit">
</form>
</body>
</html>
