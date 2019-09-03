<%--
  Created by IntelliJ IDEA.
  User: Vytautas
  Date: 8/31/2019
  Time: 9:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>EGrade</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <h1 class="my-5">Students info</h1>
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${students}" var="student">
                                <tr>
                                    <td>#</td>
                                    <td>${student.getName()}</td>
                                    <td>${student.getSurname()}</td>
                                    <td><a href="Delete?delete=${student.getId()}" class="btn btn-danger">Delete</a><a href="ModifyStudent?studentid=${student.getId()}" class="btn btn-info mx-2">View info/Modify</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${canAdd == null}">
                        <a href="Addstudent" class="btn btn-success my-3">Add new student</a>
                    </c:if>
                    <c:if test="${canAdd != null}">
                        <form method="post" action="Addstudent">
                            <div class="form-group">
                                <label for="name">Student name: </label>
                                <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp">
                            </div>
                            <div class="form-group">
                                <label for="surname">Surname: </label>
                                <input type="text" name="surname" class="form-control" id="surname">
                            </div>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Subject name</th>
                            <th>Description</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${subjects}" var="subject">
                            <tr>
                                <td>#</td>
                                <td>${subject.getName()}</td>
                                <td>${subject.getDescription()}</td>
                                <td><a href="Delete?deletesub=${subject.getId()}" class="btn btn-danger">Delete</a><a href="Addgrade" class="btn btn-info mx-3">Modify</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${canAddSubj == null}">
                        <a href="Addsubject" class="btn btn-success my-3">Add new subject</a>
                        <a href="Addgrade" class="btn btn-info mx-3">Add grades</a>
                    </c:if>
                    <c:if test="${canAddSubj != null}">
                        <form method="post" action="Addsubject">
                            <div class="form-group">
                                <label for="sname">Subject name: </label>
                                <input type="text" name="name" class="form-control" id="sname" aria-describedby="emailHelp">
                            </div>
                            <div class="form-group">
                                <label for="description">Description: </label>
                                <input type="text" name="description" class="form-control" id="description">
                            </div>
                            <button type="submit" class="btn btn-primary">Add</button>
                        </form>
                    </c:if>

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
</html>>