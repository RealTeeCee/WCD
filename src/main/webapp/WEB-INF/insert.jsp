<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 08/02/2023
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Product</title>
</head>
<body>
<h3>Insert Product</h3>
<form action="<c:url value="/insert"/> " method="post" >
    <p>
        ${error}
    </p>

    <p>
        <input name="id" type="text" placeholder="Product Id">
    </p>
    <p>
        <input name="name" type="text" placeholder="Product Name">
    </p>
    <p>
        <input name="price" type="number" placeholder="Price">
    </p>
    <p>
        <input name="quantity" type="number" placeholder="Quantity">
    </p>
    <p>
        <input type="submit" value="Insert">
    </p>
</form>

</body>
</html>
