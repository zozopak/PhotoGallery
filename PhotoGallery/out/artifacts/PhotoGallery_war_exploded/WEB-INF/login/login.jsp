<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 1/3/2020
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="admin.do">
    <h1>Log as Admin</h1>
    Username:<input type="text" name="username"/>
    Password:<input type="text" name="password"/>
    Role:<input type="text" name="role"/>
    <input type="submit" value="click">


</form>
<form method="post" action="user.do">
    <h1>Log as User</h1>
    Username:<input type="text" name="username"/>
    Password:<input type="text" name="password"/>
    Role:<input type="text" name="role"/>
    <input type="submit" value="click"/>
</form>
</body>
</html>
