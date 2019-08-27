<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/27/2019
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title></title>
</head>
<body>

<div class="container py-5">
    <h1 class="my-2">Employees</h1>
 <table class="table">
    <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>gender</th>
            <th>phone</th>
            <th>birthday</th>
            <th>education</th>
            <th>salary</th>
        </tr>
    </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.getNumber()}</td>
                    <td>${employee.getName()}</td>
                    <td>${employee.getSurname()}</td>
                    <td>${employee.getGender()}</td>
                    <td>${employee.getPhone()}</td>
                    <td>${employee.getBirthday()}</td>
                    <td>${employee.getEducation()}</td>
                    <td>${employee.getSalary()}</td>
                    <td><a href="Delete?delete=${employee.getId()}" class="btn btn-danger">Delete</a></td>
                    <td><a href="Modify?modify=${employee.getId()}" class="btn btn-info">Modify</a></td>
                </tr>
            </c:forEach>
        </tbody>
</table>
    <a href="Add" class="btn btn-success my-3">Add</a>
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