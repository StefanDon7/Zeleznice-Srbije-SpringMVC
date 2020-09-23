<%-- 
    Document   : home
    Created on : Sep 12, 2020, 5:08:35 PM
    Author     : Stefan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
            <form action="${pageContext.request.contextPath}/klijent/save" method="post">
                <div class="container">

                    <h1>Registruj se</h1>
                    <p>Popuni sledеca polja kako bi se registrovao.</p>
                    <p>Sva polja su obavezna.</p>
                    <hr>
                    <div>
                        <label for="email"><b>Email</b></label>
                        <div>
                            <input type="text" placeholder="Unesi email" name="email" id="email" required>
                        </div>
                    </div>

                    <div>
                        <label for="korisnickoIme"><b>Korisnicko ime</b></label>
                        <div>
                        <input type="text" placeholder="Unesi korisničko Ime" name="korisnickoIme" id="korisnickoIme" required>
                        </div>
                    </div>
                    <div>
                        <label for="Ime"><b>Ime</b></label>
                        <div>
                        <input type="text" placeholder="Unesi ime" name="ime" id="ime" required>
                        </div>
                    </div>
                    <div>
                        <label for="prezime"><b>Prezime</b></label>
                        <div>
                        <input type="text" placeholder="Unesi prezime" name="prezime" id="prezime" required>
                        </div>
                    </div>
                    <div>
                        <label for="lozinka"><b>Lozinka</b></label>
                        <div>
                        <input type="password" placeholder="Unesi lozinku" name="lozinka" id="lozinka" required>
                        </div>
                    </div>
                    <div>
                        <label for="ponovoLozinka"><b>Ponovi Lozinku</b></label>
                        <div>
                        <input type="password" placeholder="Ponovi lozinku" name="ponovoLozinka" id="ponovoLozinka" required>
                        </div>
                        </hr>
                    </div>
                    <p></p>
                    <!--<p>Da bi kreirao nalog potvrdi p <a href="#">Terms & Privacy</a>.</p> -->
                    <div>
                    <button id="save" type="submit" class="registerbtn">Registruj se</button>
                    </div>
                </div>

                <div class="container signin">
                    <p>Vec imas nalog? <a href="<c:url value="/home"/>">Uloguj se.</a>    </p>
                </div>
            </form>
        </div>
    </body>
</html>
