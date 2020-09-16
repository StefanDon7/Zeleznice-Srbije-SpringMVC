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
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert mb-2">${message}</div>
    </c:if>
    <body>
        <h1>Dobro dosli!</h1>
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

            <div>
                <p>Pocetna Stanica</p>
                <select name="Pocetna Stanica" size="1" style="width:196px; padding:5px;" >
                </select>
            </div>
            <div>
                <p>Krajnja Stanica</p>
                <select name="Krajnja Stanica" size="1" style="width:196px; padding:5px;" >
                    </div>
                </select>

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
