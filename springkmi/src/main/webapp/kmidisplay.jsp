<%--
  Created by IntelliJ IDEA.
  User: Vytautas
  Date: 9/12/2019
  Time: 9:48 PM
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

    <title>BMI</title>
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
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card my-5">
                <div class="card-body">
                    <h1 class="my-3">Your BMI is: <b><i>${kmi.KMIcalculation()}</i></b></h1>
                </div>
            </div>
            <c:if test="${kmi.KMIcalculation() < 18.5}">
                <div class="card">
                    <div class="card-body" style="background-color: #ffddbb !important">
                        <p>
                            <b>BMI of less than 18.5</b><br>
                            A BMI of less than 18.5 indicates that you are underweight, so you may need to put on some weight.
                            You are recommended to ask your doctor or a dietitian for advice.
                        </p>
                    </div>
                </div>
            </c:if>
            <c:if test="${kmi.KMIcalculation() >= 18.5 && kmi.KMIcalculation() < 25.0}">
                <div class="card">
                    <div class="card-body" style="background-color: #ccffcc !important">
                        <p>
                            <b>BMI of 18.5–24.9</b><br>
                            A BMI of 18.5–24.9 indicates that you are at a healthy weight for your height.
                            By maintaining a healthy weight, you lower your risk of developing serious health problems.
                        </p>
                    </div>
                </div>
            </c:if>
            <c:if test="${kmi.KMIcalculation() >= 25.0 && kmi.KMIcalculation() < 30.0}">
                <div class="card">
                    <div class="card-body" style="background-color: #ffddbb !important">
                        <p>
                            <b>BMI of 25–29.9</b><br>
                            A BMI of 25–29.9 indicates that you are slightly overweight. You may be advised to lose some weight for health reasons.
                            You are recommended to talk to your doctor or a dietitian for advice.
                        </p>
                    </div>
                </div>
            </c:if>
            <c:if test="${kmi.KMIcalculation() > 30.0}">
                <div class="card">
                    <div class="card-body" style="background-color: #ffaaaa !important">
                        <p>
                            <b>BMI of over 30</b><br>
                            A BMI of over 30 indicates that you are heavily overweight. Your health may be at risk if you do not lose weight.
                            You are recommended to talk to your doctor or a dietitian for advice.
                        </p>
                    </div>
                </div>
            </c:if>
            <a class="btn btn-success my-4" href="home">Calculate again</a><a href="kmitable" class="btn btn-info mx-2">View BMI's</a>
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
