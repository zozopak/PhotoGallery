<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 1/3/2020
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome Admin!!!!</h1>
Select a Photo to upload:<br/>
<form method="post" enctype="multipart/form-data" action="upload.do">
    <table border="0">
        <tr>

            <td> <input type="file" name="file" size="50" /></td>
        </tr>

        <tr>
        <td>Title: </td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td> Description: </td>
            <td> <textarea name="text" cols="50" rows="5"></textarea></td>

        </tr>

        <tr>
            <td>Store Image: </td>
            <td><input type="submit" value="Save"/></td>


        </tr>
    </table>
</form>
</body>
</html>
