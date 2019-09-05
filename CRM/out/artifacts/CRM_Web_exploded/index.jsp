<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/4/2019
  Time: 2:42 PM
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

    <title>CRM</title>
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
        td, th {
            font-size: 10px !important;
        }

    </style>
</head>
<body>

<div class="container-fluid my-5">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="my-4">Companies info:</h1>
                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th>Company name</th>
                            <th>Address</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Vat-code</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${companies}" var="company">
                            <tr>
                                <td>${company.getCompany_name()}</td>
                                <td>${company.getAddress()}</td>
                                <td>${company.getName()}</td>
                                <td>${company.getPhone()}</td>
                                <td>${company.getVat_code()}</td>
                                <td><a href="" class="btn btn-danger">Delete</a><a href="" class="btn btn-info py-2">Modify</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
                <div class="col-md-6">
                    <h1 class="my-4">Costumers info:</h1>
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Position</th>
                            <th>Company id</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${costumers}" var="costumer">
                            <tr>
                                <td>${costumer.getName()}</td>
                                <td>${costumer.getSurname()}</td>
                                <td>${costumer.getAddress()}</td>
                                <td>${costumer.getEmail()}</td>
                                <td>${costumer.getPhone()}</td>
                                <td>${costumer.getPosition()}</td>
                                <td>${costumer.getCompany_id()}</td>
                                <td><a href="" class="btn btn-danger">Delete</a><a href="" class="btn btn-info py-2">Modify</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container fluid">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h1 class="my-4">Contact info:</h1>
                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th>Costumer id</th>
                            <th>Conversation summary</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
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