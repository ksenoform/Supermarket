<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

        <title>Inventory</title>
    </head>
    <body>
        <h1>${showInventory}</h1>
        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <h3>ID: ${product.key.id}</h3>
                    <p>Name: ${product.key.name}</p>
                    <p>Net Price: ${product.key.netPrice}</p>
                    <p>Tax: ${product.key.tax}</p>
                    <p>On Stock: ${product.value}</p>
                </c:forEach>
            </div>
        </section>
    </body>
</html>