<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>

<jsp:include page="/WEB-INF/include/header.jsp"/>
<jsp:include page="/WEB-INF/include/menu.jsp" />

<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Ingredients</td>
        <td>Discount</td>
        <td>Weight</td>
        <td>Cooking Time</td>
        <td>Delivery</td>
    </tr>
    <c:forEach items="${foodList}" var="food">
        <tr>
            <td><c:out value="${food.id}"/></td>
            <td><c:out value="${food.name}"/></td>
            <td><c:out value="${food.price}"/></td>
            <td><c:out value="${food.ingredients}"/></td>
            <td><c:out value="${food.discount}"/></td>
            <td><c:out value="${food.weight}"/></td>
            <td><c:out value="${food.cookingTime}"/></td>
            <td><c:out value="${food.delivery}"/></td>
        </tr>
        <td>
            <a:auth path="/removeFood">
                <a href="${pageContext.request.contextPath}/removeFood?id=${food.id}">Delete</a>
            </a:auth>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/updateFood">Update</a>
        </td>
    </c:forEach>
</table>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
