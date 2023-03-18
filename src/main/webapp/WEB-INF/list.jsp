<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Document</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            max-width: 800px;
            margin: auto;
        }

        th, td {
            text-align: center;
            padding: 10px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        input[type="text"], input[type="password"], input[type="submit"] {
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>

<div style="position: relative;left: 251px;top: 13px;margin-bottom: 3%;">
    <h2>Hello ${sessionScope.user.username} <a href="<c:url value="/logout"/>">Logout</a> </h2>
    <h2>Last search Key: ${cookie.get("lastSearchStr").value}</h2>
    <h3>Product List</h3>

    <p>
        <a href="<c:url value="/insert"/>">Create Employee</a>
    </p>
    <div>
        <form action="<c:url value="/search"/>" method="post">
            <p>
                <%--            <input type="text" placeholder="Search by name" name="searchStr" value="${cookie.get("lastSearchStr").value}">--%>
                <input type="text" placeholder="Search by name" name="searchStr" value="${lastSearchStr}">
            </p>
            <p>
                <input type="submit" value="Search">
            </p>
        </form>
    </div>
</div>

    <form action="delete" method="post">
        <table>
            <thead>
            <tr>
                <th>Delete</th>
                <th>ProductName</th>
                <th>Price</th>
                <th>Quantity</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td><input type="checkbox" name="ids" value="${product.id}"></td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td><a href="<c:url value="/update?id=${product.id}"/>">Update</a></td>
                    <td><a href="<c:url value="/delete?id=${product.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div style="position: relative;left: 251px;top: 13px;margin-bottom: 3%;">
            <input type="submit" value="Delete">
        </div>
    </form>

</body>
</html>
