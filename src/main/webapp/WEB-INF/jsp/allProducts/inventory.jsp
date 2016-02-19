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

        <form:form method="POST" commandName="mainView">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Main View" name="MainView" />
                    </td>
                </tr>
            </table>
         </form:form>

        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <h3>ID: ${product.id}</h3>
                    <p>Name: ${product.name}</p>
                    <p>Net Price: ${product.netPrice}</p>
                    <p>Tax: ${product.tax}</p>
                    <p>On Stock: ${product.items}</p>
                </c:forEach>
            </div>
        </section>
    </body>
</html>