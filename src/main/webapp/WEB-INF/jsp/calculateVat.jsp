<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate VAT</title>
    <style><%@include file="/css/vatstyle.css"%></style>
</head>

<body>
<h1>Calculate vat from gross and rate.</h1>
Gross and vat rate has to be numerical. The vat rate will be given in percentge (ie. 19 means 19%).
<form  method="post" action="calculateVat" id="container">
    <table>
    <tr>
    <td>Your gross :</td>
    <td><input type="text" pattern="^[0-9]+(\.[0-9]+)?$" name="gross"/></td>
    </tr>
    <tr>
    <td>Vat rate in percentage :</td>
    <td><input type="text" pattern="^[0-9]+(\.[0-9]+)?$" name="vatRate"/></td>
    </tr>
    <th><input type="submit" value="Submit" name="find"/></th>
    <th><input type="reset" value="Reset" name="reset" /></th>
    </table>
    <br>
    <h2>The calculated vat is: ${vat}</h2>
    <div class="errorblock">${errMessage}</div>
</form>

</body>
</html>