<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<%@include file="/WEB-INF/include/header.jsp"%>
<%@include file="/WEB-INF/include/menu.jsp" %>

<h3>Login Page</h3>
<p style="color: red;">${errorString}</p>


<form method="post" action="${pageContext.request.contextPath}/login">
    <table border="0">
        <tr>
            <td><fmt:message key="login.page.user.name"/></td>
            <td><input type="text" name="userName" value="${user.userName}"/></td>
        </tr>
        <tr>
            <td><fmt:message key="login.page.user.password"/></td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<fmt:message key="login.page.submit"/>"/>
                <a href="${pageContext.request.contextPath}/">Cancel</a>
            </td>
        </tr>
    </table>
</form>

<p style="color:black;">Admin User: admin password: qwerty</p>
<p style="color:black;">Simple User: user password: 12345</p>

<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>