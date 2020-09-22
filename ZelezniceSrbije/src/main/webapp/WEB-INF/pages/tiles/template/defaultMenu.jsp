<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div></div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a class="navbar-brand" href="<c:url value="/polazak"/>">RED VOZNJE</a>
    <a class="navbar-brand" href="<c:url value="/polazak/nalog"/>">MOJ NALOG</a>
    <a class="navbar-brand" href="<c:url value="/polazak/rezervacije"/>">MOJE REZERVACIJE</a>
    <ul class="navbar-nav mr-auto d-flex justify-content-end">

    </ul>
    <form action="${pageContext.request.contextPath}/klijent/logout" method="GET">
        <button id="logout" type="submit" class="logoutbtn">Odjavi se</button>
    </form>
</nav>
<b>Ulogovan:</b>
<b><p>${sessionScope.loginUser.ime} ${sessionScope.loginUser.prezime}</p> </b>

</div>