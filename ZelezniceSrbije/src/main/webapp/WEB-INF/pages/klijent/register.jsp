<%-- 
    Document   : home
    Created on : Sep 12, 2020, 5:08:35 PM
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div>
            <c:if test="${not empty message}">
                 <h3 style="color: red;">${message}</h3>
            </c:if>
            <form action="${pageContext.request.contextPath}/klijent/save" method="post">
                <div class="container">

                    <h1>Registruj se</h1>
                    <p>Popuni sledеća polja kako bi se registrovao.</p>
                    <p>Sva polja su obavezna.</p>
                    <hr>
                    <div>
                        <label for="email"><b>Email</b></label>
                        <input type="text" placeholder="Unesi email" name="email" id="email" required>
                    </div>
                    <div>
                        <label for="korisnickoIme"><b>Korisničko ime</b></label>
                        <input type="text" placeholder="Unesi korisničko Ime" name="korisnickoIme" id="korisnickoIme" required>
                    </div>
                    <div>
                        <label for="Ime"><b>Ime</b></label>
                        <input type="text" placeholder="Unesi ime" name="ime" id="ime" required>
                    </div>
                    <div>
                        <label for="prezime"><b>Prezime</b></label>
                        <input type="text" placeholder="Unesi prezime" name="prezime" id="prezime" required>
                    </div>
                    <div>
                        <label for="lozinka"><b>Lozinka</b></label>
                        <input type="password" placeholder="Unesi lozinku" name="lozinka" id="lozinka" required>
                    </div>
                    <div>
                        <label for="ponovoLozinka"><b>Ponovi Lozinku</b></label>
                        <input type="password" placeholder="Ponovi lozinku" name="ponovoLozinka" id="ponovoLozinka" required>
                        <hr>
                    </div>

                    <!--<p>Da bi kreirao nalog potvrdi p <a href="#">Terms & Privacy</a>.</p> -->
                    <button id="save" type="submit" class="registerbtn">Registruj se</button>
                </div>

                <div class="container signin">
                    <p>Već imaš nalog? <a href="<c:url value="/home"/>">Uloguj se.</a>    </p>
                </div>
            </form>
        </div>
    </body>
</html>
