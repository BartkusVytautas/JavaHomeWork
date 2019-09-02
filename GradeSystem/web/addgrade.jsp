<%--
  Created by IntelliJ IDEA.
  User: Vytautas
  Date: 9/2/2019
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>Add a grade</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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

    </style>
</head>
<body>
<div class="container my-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${form1 == null}">
            <form method="post" action="Addgrade">
                <div class="form-group">
                <select class="form-control" id="student" name="student">
                    <option  selected="selected">Choose a student</option>
                    <c:forEach items="${studentss}" var="student">
                        <option value="${student.getId()}">${student.getName()} ${student.getSurname()}</option>
                    </c:forEach>
                </select>
                    <button type="submit" class="btn btn-success my-3">Choose</button>
                </div>
            </form>
            </c:if>
            <c:if test="${form2 != null}">
                <form method="post" action="Addgrade">
                    <div class="form-group">
                        <select class="form-control" id="subject" name="subject">
                            <option  selected="selected">Choose a subject</option>
                            <c:forEach items="${gradess}" var="grade">
                                <option value="${grade.value.getId()}">${grade.value.getSubject().getName()}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-success my-3">Choose</button>
                    </div>
                </form>
            </c:if>
            <c:if test="${form3 != null}">
                <h1>${Addgrade.student.getName()} ${Addgrade.student.getSurname()}</h1>
                <h3>${Addgrade.subject.getName()}</h3>
            <form method="post" action="Updategrade">
                <div class="form-group">
                    <input class="form-control" type="text" name="gradevalue" value="${gradeValue}" required>
                    <button name="gradeid" value="${Addgrade.grade.getId()}" type="submit" class="btn btn-info my-2">Change the grade</button>
                </div>
            </form>
            </c:if>
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
