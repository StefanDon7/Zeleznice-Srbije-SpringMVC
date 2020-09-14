<%-- 
    Document   : home
    Created on : Sep 12, 2020, 5:08:35 PM
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
        <form action="${pageContext.request.contextPath}/klijent/save" method="post">
            <div class="container">
                <h1>Registruj se</h1>
                <p>Popuni sledеća polja kako bi se registrovao.</p>
                <p>Sva polja su obavezna.</p>
                <hr>
                
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Unesi email" name="email" id="email" required>

                <label for="korisnickoIme"><b>Korisničko ime</b></label>
                <input type="text" placeholder="Unesi korisničko Ime" name="korisnickoIme" id="korisnickoIme" required>

                <label for="Ime"><b>Ime</b></label>
                <input type="text" placeholder="Unesi ime" name="ime" id="ime" required>

                <label for="prezime"><b>Prezime</b></label>
                <input type="text" placeholder="Unesi prezime" name="prezime" id="prezime" required>

                <label for="lozinka"><b>Lozinka</b></label>
                <input type="password" placeholder="Unesi lozinku" name="lozinka" id="lozinka" required>

                <label for="ponovoLozinka"><b>Ponovi Lozinku</b></label>
                <input type="password" placeholder="Ponovi lozinku" name="ponovoLozinka" id="ponovoLozinka" required>
                <hr>

                <!--<p>Da bi kreirao nalog potvrdi p <a href="#">Terms & Privacy</a>.</p> -->
                <button id="save" type="submit" class="registerbtn">Registruj se</button>
            </div>

            <div class="container signin">
                <p>Već imaš nalog? <a href="login.html">Uloguj se</a>.</p>
            </div>
        </form>
        <h1>REGISTER PAGE</h1>
        THIS IS REGISTER PAGE
        <div>
            <a href="<c:url value="/home"/>">Back to Login</a>       
        </div>
    </body>
</html>
