<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 1/6/2020
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">Back to Home!</a>
<div align="center">
    <c:forEach var="images" items="${images}">
        <h3><c:out value="${images.title}"/></h3>
        <h4><c:out value="${images.text}"/></h4>
        <img src="data:image:/jpg;base64,${images.base64Image}" width="240" height="300"/>
    </c:forEach>

</div>

</body>
</html>
