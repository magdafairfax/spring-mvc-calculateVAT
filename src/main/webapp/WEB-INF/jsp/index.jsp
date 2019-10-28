<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate VAT</title>
    <link href="/css/vatstyle.css/" rel="stylesheet" type="text/css">
</head>
<body>

<form  method="post" action="calculateVat">

    <table>
    <tr>
    <td>Your gross :</td>
    <td><input type="text" name="gross"/></td>
    </tr>
    <tr>
    <td>Vat rate in percentage :</td>
    <td><input type="text" name="vatRate"/></td>
    </tr>
    <th><input type="submit" value="Submit" name="find"/></th>
    <th><input type="reset" value="Reset" name="reset" /></th>
    </table>
    <h2>The calculated vat is: ${vat}</h2>
</form>

</body>
    </html>