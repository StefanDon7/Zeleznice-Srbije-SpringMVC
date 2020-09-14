<%-- 
    Document   : home
    Created on : Sep 10, 2020, 6:10:58 PM
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <h1>LOGIN PAGE</h1>
        THIS IS LOGIN PAGE
         <form action="${pageContext.request.contextPath}/klijent/find" method="post">
            <div class="container">   
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Unesi email" name="email" id="email" required>
             
                <label for="lozinka"><b>Lozinka</b></label>
                <input type="password" placeholder="Unesi lozinku" name="lozinka" id="lozinka" required>
                
                <button id="find" type="submit" class="loginbtn">Uloguj se</button>
            </div>
        </form>
        <div>
            <a href="<c:url value="/klijent"/>">Register</a>       
        </div>
   
    </body>
</html>
