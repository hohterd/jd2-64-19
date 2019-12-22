<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>

<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/menu.jsp" />

<html>
<head>
    <style type="text/css">
        .field {
            clear: both;
            text-align: right;
            line-height: 25px;
        }

        .submit {
            clear: both;
            text-align: left;
            line-height: 25px;
        }

        label {
            float: left;
            padding-right: 10px;
        }

        .main {
            float: left
        }
    </style>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/foodCreate">
    <div class="main">

        <div class="field">
            <label for="menu">Category:</label>
                <select id="menu" name="menuId">
                    <c:forEach var="menu" items="${menu}">
                        <option value="${menu.id}"
                                <c:if test="${menuSelected == menu.id}">selected='selected'</c:if> >${menu.name}</option>
                    </c:forEach>
                </select>
        </div>

        <div class="field">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"/>
        </div>

        <div class="field">
            <label for="price">Price:</label>
            <input type="text" id="price" name="price"/>
        </div>

        <div class="field">
            <label for="ingredients">Ingredients:</label>
            <input type="text" id="ingredients" name="ingredients"/>
        </div>

        <div class="field">
            <label for="weight">Weight:</label>
            <input type="text" id="weight" name="weight"/>
        </div>

        <div class="field">
            <label for="discount">Discount:</label>
            <input type="text" id="discount" name="discount"/>
        </div>

        <div class="field">
            <label for="cookingTime">Cooking Time:</label>
            <input type="text" id="cookingTime" name="cookingTime"/>
        </div>

        <div class="field">
            <label for="delivery">Delivery:</label>
            <input type="checkbox" id="delivery" name="delivery" value="true"/>
        </div>

        <div class="submit">
            <input type="submit">
        </div>

    </div>
</form>
</body>
</html>

<jsp:include page="/WEB-INF/include/footer.jsp"/>


