<%-- 
    Document   : rezervacije
    Created on : Sep 20, 2020, 7:47:42 PM
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
      <body class="body">
        <h1>REZERVACIJE</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th  scope="col">Polazak</th>
                    <th  scope="col">Pocetna</th>
                    <th  scope="col">Datum polaska</th>
                    <th  scope="col">Datum dolaska</th>
                    <th scope="col">Otkazi rezervaciju</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach  items="${rezervacije}" var="rezervacija" varStatus="loop">
                    <tr> 

                        <td>${loop.index+1}</td>
                        <td>${rezervacija.polazak.linija.stanicaPocetna.nazivStanice}</td>
                        <td>${rezervacija.polazak.linija.stanicaKrajnja.nazivStanice}</td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${rezervacija.polazak.datumPolaska}" /></td>
                        <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${rezervacija.polazak.datumDolaska}" /></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/polazak/otkaziRezervaciju" method="POST">
                                <input type="hidden" name="polazakId" value="${rezervacija.polazak.polazakID}" />
                                <button id="otkazi" type="submit" class="otkazibtn">Otkazi rezervaciju</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
