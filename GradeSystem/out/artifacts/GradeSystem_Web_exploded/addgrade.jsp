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
<a href="Logout" class="btn btn-danger my-4 mx-4">Logout</a>
<div class="container my-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${form1 == null}">
                <h1 class="my-5">Add a grade</h1>
                <form method="post" action="Addgrade">
                    <div class="form-group">
                        <select class="form-control my-4" id="student" name="student">
                            <option  selected="selected">Choose a student</option>
                            <c:forEach items="${studentss}" var="student">
                                <option value="${student.getId()}">${student.getName()} ${student.getSurname()}</option>
                            </c:forEach>
                        </select>
                        <select class="form-control" id="subject" name="subject">
                            <option  selected="selected">Choose a subject</option>
                            <c:forEach items="${subjectss}" var="subject">
                                <option value="${subject.getId()}">${subject.getName()}</option>
                            </c:forEach>
                        </select>
                        <button type="submit" class="btn btn-success my-4">Choose</button>
                    </div>
                </form>
            </c:if>
            <c:if test="${form2 != null}">
                <h3 class="my-4">Add or modify a grade for <i><b>${gradee.getStudent().getName()} ${gradee.getStudent().getSurname()}</b></i></h3>
                <h3 class="my-5">Subject: <i><b>${gradee.getSubject().getName()}</b></i></h3>
                <form action="Addgrade" method="post">
                    <div class="form-group">
                        <label for="gradeValue">Current grade: </label>
                        <c:if test="${gradee.getGrade() < 1}">
                            <input id="gradeValue" class="form-control" type="text" placeholder="Not graded yet" name="gradeValue">
                        </c:if>
                        <c:if test="${gradee.getGrade() > 0}">
                        <input id="gradeValue" class="form-control" type="text" value="${gradee.getGrade()}" name="gradeValue">
                        </c:if>
                        <button name="addchange" value="${gradee.getId()}" type="submit" class="btn btn-info my-3">Submit</button>
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
