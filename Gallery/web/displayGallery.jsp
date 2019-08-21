<%@ page import="lt.bit.photoGallery.Image" %><%--
  Created by IntelliJ IDEA.
  User: Vytautas
  Date: 8/19/2019
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" integrity="sha256-HAaDW5o2+LelybUhfuk0Zh2Vdk8Y2W2UeKmbaXhalfA=" crossorigin="anonymous" />

    <title>Gallery</title>

</head>
<%
    Integer loggedIn = (Integer)session.getAttribute("login");
    if(loggedIn != null){
        if(loggedIn !=0){
%>
<div class="container my-3"><a href="Logout" type="button" class="btn btn-danger">Logout</a></div>
<%
        }
    }

%>
<body>
<div class="container align-items-center">
    <a href="index.jsp"><button type="button" class="btn btn-success my-5">Home</button></a>
</div>
<div class="container-fluid">
    <div class="row">
        <c:forEach items="${images}" var="image">
            <div class="col-sm-4 align-items-center">
                <a href="${image.getUrl()}"  class="d-block my-4" >
                    <img src="${image.getUrl()}" class="img-fluid">
                </a>
                <p class="my-2">${image.getDescription()}</p>
                <a class="btn btn-danger my-2" href="http://localhost:8080/Gallery_Web_exploded/Remove?delete=${images.indexOf(image)}">DELETE</a>

            </div>
        </c:forEach>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.js" integrity="sha256-jGAkJO3hvqIDc4nIY1sfh/FPbV+UK+1N+xJJg6zzr7A=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>


</body>
</html>
