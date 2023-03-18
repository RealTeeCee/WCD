<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyen huu tri
  Date: 12/02/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
  <title>Update Employee</title>
</head>
<body>
<h3>Update Employee</h3>
<form action="<c:url value="/update"/> " method="post" >
  <p>
    ${error}
  </p>
  <p>
    <input name="id" type="text" value="${product.id}" placeholder="Product Id">
  </p>
  <p>
    <input name="productName" type="text" value="${product.productName}" placeholder="Product Name">
  </p>
  <p>
    <input name="price" type="number" value="${product.price}" placeholder="Address">
  </p>
  <p>
    <input name="quantity" type="number" value="${product.quantity}" placeholder="Age">
  </p>
  <p>
    <input type="submit" value="Update">
  </p>
</form>
</body>
</html>