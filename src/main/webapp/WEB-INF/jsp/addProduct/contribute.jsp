<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

        <title>Contribute</title>
    </head>
    <body>
        <h1>${showContribute}</h1>
        <form:form method="POST" commandName="productForm" action="../addProduct/contribute">
           <table>
            <tr>
                <td><form:label path="id">Id</form:label></td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td><form:label path="netPrice">Net Price</form:label></td>
                <td><form:input path="netPrice" /></td>
            </tr>
            <tr>
                <td><form:label path="tax">Tax</form:label></td>
                <td><form:input path="tax" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>
        </form:form>

        <table>
            ${product_id}
            ${product_name}
            ${product_netPrice}
            ${product_tax}
            ${product_totalPrice}
        </table>

    </body>
</html>