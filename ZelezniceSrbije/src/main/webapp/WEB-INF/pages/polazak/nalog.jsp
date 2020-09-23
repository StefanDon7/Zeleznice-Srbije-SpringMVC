<%-- 
    Document   : nalog
    Created on : Sep 20, 2020, 7:47:56 PM
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
           <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.4.1/css/bootstrap.min.css">
    </head>
      <body class="body">
        <div>
            <c:if test="${not empty message}">
                <h3 style="color: red;">${message}</h3>
            </c:if>

     
                <div class="container">
                    <hr>
                    <div>
                        <label for="email"><b>Email</b></label>
                        <div>
                            <p>${sessionScope.loginUser.email}</p>
                        </div>
                    </div>
                    <div>
                        <label for="Ime"><b>Ime</b></label>
                        <div>
                            <p>${sessionScope.loginUser.ime}</p>
                        </div>
                    </div>
                    <div>
                        <label for="Prezime"><b>Prezime</b></label>
                        <div>
                            <p>${sessionScope.loginUser.prezime}</p>
                        </div>
                    </div>
                    <div>
                        <label for="KorisnickoIme"><b>Korisnicko ime</b></label>
                        <div>
                            <div>
                                <p>${sessionScope.loginUser.korisnickoIme}</p>
                            </div>
                        </div>
                    </div>
                </div>
           
        </div>
    </body>
</html>
