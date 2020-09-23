<%-- 
    Document   : home
    Created on : Sep 10, 2020, 6:10:58 PM
    Author     : Stefan
--%>
<style>
    .dopuna{
        height: 300px;
    }
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>

    <p class="p"> ${message}</p>
    <body class="body">
        <div class="container">
            <h1 class="h1">Uloguj se</h1>
            <form action="${pageContext.request.contextPath}/klijent/find" method="post">
                <div class="container"> 
                    <div>
                        <label for="email"><b>Email</b></label>
                    </div>
                    <div>
                        <input type="text" placeholder="Unesi email" name="email" id="email" required>
                    </div>
                    <div>
                        <label for="lozinka"><b>Lozinka</b></label>
                    </div>
                    <div>
                        <input type="password" placeholder="Unesi lozinku" name="lozinka" id="lozinka" required>
                    </div>
                    <p></p>
                    <div>
                        <button id="find" type="submit" class="loginbtn">Uloguj se</button>
                    </div>
                </div>
            </form>
            <div>
                <p class="p">Nemas nalog?</p>
                <a class="p" href="<c:url value="/klijent"/>">Registruj se.</a>       
            </div>
            <div>
                <p></p>
            </div>
        </div>
               <p class="dopuna"></p>
    </body>
</html>
