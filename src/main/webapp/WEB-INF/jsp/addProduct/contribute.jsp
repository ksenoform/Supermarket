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

        <form:form method="POST" commandName="mainView">
            <input type="submit" value="Main View" name="MainView" />
         </form:form>

        <form:form method="POST" commandName="productForm" action="../addProduct/contribute">
        <table>
        <tr>
            <td><label for="id">Id: </label></td>
            <td><form:input path="id" id="id"/></td>
            <td><form:errors path="id" cssclass="error"/></td>
        </tr>
        <tr>
            <td><label for="name">name: </label></td>
            <td><form:input path="name" id="name"/></td>
            <td><form:errors path="name" cssclass="error"/></td>
        </tr>
        <tr>
            <td><label for="netPrice">net Price: </label></td>
            <td><form:input path="netPrice" id="netPrice"/></td>
            <td><form:errors path="netPrice" cssclass="error"/></td>
        </tr>
        <tr>
            <td><label for="tax">tax: </label></td>
            <td><form:input path="tax" id="tax"/></td>
            <td><form:errors path="tax" cssclass="error"/></td>
        </tr>
        </table>

        <input type="submit" value="Submit" name="Submit"/>
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