<%-- 
    Document   : home
    Created on : Sep 14, 2020, 8:50:21 PM
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <table>
            <thead>
                <tr>
                    <th>Pocetna Stanica</th>
                    <th>Krajnja Stanica</th>
                    <th>Datum polaska</th>
                    <th>Datum dolaska</th>
                    <th>Tip linije</th>
                    <th>Rezervisi</th>
                </tr>
            </thead>
            <tbody>
  <!--
            <c:forEach var="polazak" items="${applicationScope.polasci}">
                    <tr>
                        <td>${polazak.linija.stanicaPocetna}</td>
                        <td>${polazak.linija.stanicaPocetna}</td>
                        <td>${polazak.datumPolaska}</td>
                        <td>${polazak.datumDolaska}</td>
                         <td>${polazak.datumDolaska}</td>
                        <td>
                             <a href="#">Rezervisi</a>
                        </td>
                    </tr>
                </c:forEach>
-->
            </tbody>
        </table>
    </body>
</html>