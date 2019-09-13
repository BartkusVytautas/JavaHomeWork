<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/13/2019
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>BMI table</title>
    <script src="https://kit.fontawesome.com/09d1a309d1.js"></script>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Raleway:300,400,600);
        body{
            font-size: .9rem;
            font-weight: 400;
            line-height: 1.6;
            color: #212529;
            text-align: left;
            background-color: #f5f8fa !important;
            font-family: Raleway, sans-serif !important;
        }
        a i {
            color: brown !important;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card my-5">
        <div class="card-body">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <form:form action="modify" modelAttribute="kmimod" method="POST">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Height</th>
                                <th>Weight</th>
                                <th>KMI</th>
                                <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="kmi">
                                <tr>
                                    <c:if test="${ mod1 == null || mod1 != kmi.getId()}">
                                    <td>${kmi.getHeight()}</td>
                                    <td>${kmi.getWeight()}</td>
                                    <td>${kmi.getKmi()} <a class="mx-2" href="delete?id=${kmi.getId()}"><i class="fas fa-trash"></i></a></td>
                                     <td><a class="btn btn-primary" href="kmitable?mod1=${kmi.getId()}">Modify</a></td>
                                    </c:if>
                                    <c:if test="${mod1 !=null && mod1 == kmi.getId()}">
                                        <div class="form-group">
                                            <form:hidden path = "id" value="${kmi.getId()}" />
                                            <td><form:input path="height" class="form-control" value="${kmi.getHeight()}" /></td>
                                            <td><form:input path="weight" class="form-control" value="${kmi.getWeight()}" /></td>
                                            <td>${kmi.getKmi()} </td>
                                            <td><button type="submit" class="btn btn-success"><i class="fas fa-check"></i></button></td>
                                        </div>

                                    </c:if>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                   </form:form>
                    <a class="btn btn-warning my-3" href="home">Calculate new BMI</a>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>