<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

        <title>Warehous</title>
    </head>
    <body>
        <h1>${toShow}</h1>
         <form:form method="POST" commandName="showProducts">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="All Products" name="AllProducts" />
                    </td>
                    <td colspan="3">
                        <input type="submit" value="Add Products" name="AddProducts" />
                    </td>
                </tr>
            </table>
         </form:form>
    </body>
</html>