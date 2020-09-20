<%-- 
    Document   : home
    Created on : Sep 14, 2020, 8:50:21 PM
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <form action="${pageContext.request.contextPath}/polazak/find" method="post">
            <div>
                <p>Pocetna Stanica</p>
                <select name="PocetnaStanica" size="1" style="width:250px; padding:5px;" >

                    <c:forEach items="${stanice}" var="stanica">
                        <option value="${stanica.stanicaID}">${stanica.nazivStanice}</option>
                    </c:forEach>

                </select>
            </div>
            <div>
                <p>Krajnja Stanica</p>
                <select name="KrajnjaStanica" size="1" style="width:250px; padding:5px;" >
                    <c:forEach items="${stanice}" var="stanica">
                        <option  value="${stanica.stanicaID}">${stanica.nazivStanice}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <p>Za datum</p>
                <select name="Datum" size="1" style="width:125px; padding:5px;" >
                    <c:forEach items="${datumi}" var="datum">
                        <option  <td><fmt:formatDate pattern="dd-MM-yyyy" value="${datum}" /></td></option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <p>Pretrazi polaske</p>
                <button id="find" type="submit" class="pretragabtn">Pretraga</button>
            </div>
        </form>
        <table>
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th  scope="col">Pocetna Stanica</th>
                    <th  scope="col">Krajnja Stanica</th>
                    <th  scope="col">Datum polaska</th>
                    <th  scope="col">Vreme polaska</th>
                    <th  scope="col">Datum dolaska</th>
                    <th  scope="col">Vreme dolaska</th>
                    <th scope="col">Tip linije</th>
                    <th scope="col">Napomena</th>
                    <th scope="col">Lista Medjustanica</th>
                    <th scope="col">Rezervisi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach  items="${polasciZaDanasnjiDatum}" var="polazak" varStatus="loop">
                    <tr>
                        <td>${loop.index+1}</td>
                        <td>${polazak.linija.stanicaPocetna}</td>
                        <td>${polazak.linija.stanicaPocetna}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${polazak.datumPolaska}" /></td>
                        <td><fmt:formatDate pattern="HH:mm" value="${polazak.datumPolaska}" /></td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy" value="${polazak.datumDolaska}" /></td>
                        <td><fmt:formatDate pattern="HH:mm" value="${polazak.datumDolaska}" /></td>
                        <td>${polazak.linija.tipLinije}</td>
                        <td>${polazak.napomena}</td>
                        <td>
                            <a href="#">ListaMedjustanica</a>
                        </td>
                        <td>
                            <a href="#">Rezervisi polazak</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
