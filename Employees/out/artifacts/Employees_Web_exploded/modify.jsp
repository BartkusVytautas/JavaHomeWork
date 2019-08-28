<%--
  Created by IntelliJ IDEA.
  User: Vytautas
  Date: 8/27/2019
  Time: 11:17 PM
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

    <title>Add</title>
    <style>
        label{
            margin: 20px;
        }
    </style>
</head>
<body>
<div class="container my-5">
    <h1 class="my-3">Employee info</h1>
    <div class="card">
        <div class="card-body">
            <form method="post" action="Modify">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text"
                           class="form-control" name="name" id="name" aria-describedby="helpId" pattern="^[A-Za-z]+$" value="${emp.getName()}"  required>
                    <label for="surname">Surname:</label>
                    <input type="text"
                           class="form-control" name="surname" id="surname" aria-describedby="helpId" pattern="^[A-Za-z]+$" value="${emp.getSurname()}"  required>
                    <label for="gender">Gender:</label>
                    <select class="form-control" id="gender" name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                    <label for="phone">Phone:</label>
                    <input type="text"
                           class="form-control" name="phone" id="phone" aria-describedby="helpId" pattern="^[+]\d{11}$" value="${emp.getPhone()}" required>
                    <label for="birthday">Birthday:</label>
                    <input type="date"
                           class="form-control" name="birthday" id="birthday" aria-describedby="helpId" min="1970-01-01" max="2002-01-01" value="${emp.getBirthday()}"  required>
                    <label for="education">Education:</label>
                    <input type="text"
                           class="form-control" name="education" id="education" aria-describedby="helpId" pattern="^[A-Za-z]+$" value="${emp.getEducation()}"  required>
                    <label for="salary">Salary:</label>
                    <input type="number"
                           class="form-control" name="salary" id="salary" aria-describedby="helpId" pattern="^[0-9]+$" value="${emp.getSalary()}" required>
                    <input type="submit" class="btn btn-success my-3" value="Save changes">

                </div>
            </form>
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