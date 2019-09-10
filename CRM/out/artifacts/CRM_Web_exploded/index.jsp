<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/4/2019
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="lt.bit.CRM.Servlets.Add" %>
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
    <script src="https://kit.fontawesome.com/09d1a309d1.js"></script>

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
            border-color: #343a40 !important;
        }

        .card {
            background-color: #71ffeb !important;
        }

        table{

        }

    </style>
</head>
<body>

<div class="container-fluid my-5">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-7">
                    <h1 class="my-4">Companies info:</h1>
                    <form action="Add" method="post">
                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th>Company name</th>
                            <th>Address</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Vat-code</th>
                            <th>Email</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${companies}" var="company">
                            <tr>
                                <c:if test="${mod1 == null || company.getId() != mod1}">
                                <td>${company.getCompany_name()}</td>
                                <td>${company.getAddress()}</td>
                                <td>${company.getName()}</td>
                                <td>${company.getPhone()}</td>
                                <td>${company.getVat_code()}</td>
                                <td>${company.getEmail()}</td>
                                <td><a href="Delete?delete=${company.getId()}&company=1" class="btn btn-danger d-block">Delete</a><a href="Modify?modify=${company.getId()}&table=1" class="btn btn-info d-block my-2">Modify</a></td>
                                </c:if>
                                <c:if test="${mod1 != null}">
                                    <c:if test="${company.getId() == mod1}">
                                        <div class="form-group">
                                            <td><input class="form-control" id="compname" type="text" name="compname2" value="${company.getCompany_name()}"></td>
                                            <td><input class="form-control" id="address" type="text" name="address2" value="${company.getAddress()}"></td>
                                            <td><input class="form-control" id="name" type="text" name="name2" value="${company.getName()}"></td>
                                            <td><input class="form-control" id="phone" type="text" name="phone2" value="${company.getPhone()}"></td>
                                            <td><input class="form-control" id="vat" type="text" name="vat2" value="${company.getVat_code()}"></td>
                                            <td><input class="form-control" id="email" type="text" name="email2" value="${company.getEmail()}"></td>
                                            <td><button type="submit" id="company" class="btn btn-success" name="companymod" value="${company.getId()}">Save</button></td>
                                        </div>
                                    </c:if>
                                </c:if>
                                
                            </tr>
                        </c:forEach>
                        <c:if test="${table1 != null}">
                            <tr>
                                <div class="form-group">
                                    <td><input class="form-control" type="text" name="compname"></td>
                                    <td><input class="form-control" type="text" name="address"></td>
                                    <td><input class="form-control" type="text" name="name"></td>
                                    <td><input class="form-control" type="text" name="phone"></td>
                                    <td><input class="form-control" type="text" name="vat"></td>
                                    <td><input class="form-control" type="text" name="email"></td>
                                    <td><button type="submit" class="btn btn-success" name="company">Add</button></td>
                                </div>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    </form>
                    <c:if test="${table1 == null}"><a href="Add?add=1" class="btn btn-success my-3">Add new</a></c:if>

                </div>
                <div class="col-md-5">
                    <h1 class="my-4">Contact info:</h1>
                    <form method="post" action="Add">
                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th>Costumer name</th>
                            <th>Talked about: </th>
                            <th>Date</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${contacts}" var="contact">
                                <tr>
                                    <c:if test="${mod3 == null || contact.getId() != mod3}">
                                    <td>${contact.getCostumer().getName()} ${contact.getCostumer().getSurname()}</td>
                                    <td>
                                        <c:forEach items="${contact.getCostumer().getItems()}" var="item">
                                            ${item.getName()} <a href="Delete?deleteitem=${item.getId()}&costumerid=${contact.getCostumer().getId()}"><i style="color: crimson" class="fas fa-times-circle"></i></a><br>
                                        </c:forEach>
                                    </td>
                                    <td>${contact.getDate()}</td>
                                    <td><a href="Delete?delete=${contact.getId()}&contact=1" class="btn btn-danger d-block">Delete</a><a href="Modify?modify=${contact.getId()}&table=3" class="btn btn-info d-block my-2">Modify</a></td>
                                    </c:if>
                                    <c:if test="${mod3 != null}">
                                        <c:if test="${contact.getId() == mod3}">
                                            <div class="form-group">
                                                <td>
                                                    <select class="form-control" name="costumerid">

                                                        <c:forEach items="${costumers}" var="costumer">
                                                            <c:if test="${contact.getCostumer().getId() == costumer.getId()}">
                                                            <option selected value="${costumer.getId()}">${costumer.getName()} ${costumer.getSurname()}</option>
                                                            </c:if>
                                                            <c:if test="${contact.getCostumer().getId() != costumer.getId()}">
                                                                <option value="${costumer.getId()}">${costumer.getName()} ${costumer.getSurname()}</option>
                                                            </c:if>

                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td>
                                                    <c:forEach items="${items}" var="item">
                                                        <c:if test="${contact.getCostumer().getItems().contains(item)}">
                                                            <div class="d-block">
                                                                <label class="d-inline" for="item${item.getId()}">${item.getName()}</label>
                                                                <input class="d-inline" id="item${item.getId()}" class="form-control" type="checkbox" checked name="itemadd2" value="${item.getId()}">
                                                            </div>
                                                        </c:if>
                                                        <c:if test="${!contact.getCostumer().getItems().contains(item)}">
                                                            <div class="d-block">
                                                                <label class="d-inline" for="item${item.getId()}">${item.getName()}</label>
                                                                <input class="d-inline" id="item${item.getId()}" class="form-control" type="checkbox" name="itemadd2" value="${item.getId()}">
                                                            </div>
                                                        </c:if>

                                                    </c:forEach>
                                                </td>
                                                <td>${contact.getDate()}</td>
                                                <td><button type="submit" id="contact" class="btn btn-success" name="contactmod" value="${contact.getId()}">Save</button></td>
                                            </div>
                                        </c:if>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            <c:if test="${table2 != null}">
                                <tr>
                                    <div class="form-group">
                                        <td>
                                            <select class="form-control" name="costumerid">
                                                <option>Select a costumer:</option>
                                                <c:forEach items="${costumers}" var="costumer">
                                                    <option value="${costumer.getId()}">${costumer.getName()} ${costumer.getSurname()}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td>
                                           <c:forEach items="${items}" var="item">
                                               <div class="d-block">
                                               <label class="d-inline" for="item${item.getId()}">${item.getName()}</label>
                                               <input class="d-inline" id="item${item.getId()}" class="form-control" type="checkbox" name="itemadd" value="${item.getId()}">
                                               </div>
                                           </c:forEach>
                                        </td>
                                        <td>#</td>
                                        <td><button type="submit" class="btn btn-success" name="contact">Add</button></td>
                                    </div>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                    </form>
                    <c:if test="${table2 == null}"><a href="Add?add=2" class="btn btn-success my-3">Add new</a></c:if>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md-8">
                    <h1 class="my-4">Costumers info:</h1>
                    <form action="Add" method="post">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Position</th>
                            <th>Company name</th>
                            <th>Options</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${costumers}" var="costumer">
                            <tr>
                                <c:if test="${mod2 == null || costumer.getId() != mod2}">
                                <td>${costumer.getName()}</td>
                                <td>${costumer.getSurname()}</td>
                                <td>${costumer.getAddress()}</td>
                                <td>${costumer.getEmail()}</td>
                                <td>${costumer.getPhone()}</td>
                                <td>${costumer.getPosition()}</td>
                                <td>${costumer.getCompany().getCompany_name()}</td>
                                <td><a href="Delete?delete=${costumer.getId()}&costumer=1" class="btn btn-danger d-block">Delete</a><a href="Modify?modify=${costumer.getId()}&table=2" class="btn btn-info d-block my-2">Modify</a></td>
                                </c:if>
                                <c:if test="${mod2 != null}">
                                    <c:if test="${costumer.getId() == mod2}">
                                        <div class="form-group">
                                            <td><input class="form-control" id="costname2" type="text" name="costname2" value="${costumer.getName()}"></td>
                                            <td><input class="form-control" id="costsurname2" type="text" name="costsurname2" value="${costumer.getSurname()}"></td>
                                            <td><input class="form-control" id="costaddress2" type="text" name="costaddress2" value="${costumer.getAddress()}"></td>
                                            <td><input class="form-control" id="costemail2" type="text" name="costemail2" value="${costumer.getEmail()}"></td>
                                            <td><input class="form-control" id="costphone2" type="text" name="costphone2" value="${costumer.getPhone()}"></td>
                                            <td><input class="form-control" id="costposition2" type="text" name="costposition2" value="${costumer.getPosition()}"></td>
                                            <td>
                                                <select class="form-control" name="companyid2">
                                                    <c:forEach items="${companies}" var="company">
                                                        <c:if test="${costumer.getCompany().getId() == company.getId()}">
                                                        <option selected value="${company.getId()}">${company.getCompany_name()}</option>
                                                        </c:if>
                                                        <c:if test="${costumer.getCompany().getId() != company.getId()}">
                                                            <option value="${company.getId()}">${company.getCompany_name()}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><button type="submit" id="costumer" class="btn btn-success" name="costumermod" value="${costumer.getId()}">Save</button></td>
                                        </div>
                                    </c:if>
                                </c:if>
                            </tr>
                        </c:forEach>
                        <c:if test="${table3 != null}">
                            <tr>
                                <div class="form-group">
                                    <td><input class="form-control" type="text" name="costname"></td>
                                    <td><input class="form-control" type="text" name="surname"></td>
                                    <td><input class="form-control" type="text" name="costaddress"></td>
                                    <td><input class="form-control" type="text" name="costemail"></td>
                                    <td><input class="form-control" type="text" name="costphone"></td>
                                    <td><input class="form-control" type="text" name="position"></td>
                                    <td>
                                        <select class="form-control" name="companyid">
                                            <option>Select a company:</option>
                                            <c:forEach items="${companies}" var="company">
                                                <option value="${company.getId()}">${company.getCompany_name()}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td><button type="submit" class="btn btn-success" name="costumer">Add</button></td>
                                </div>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                </form>
                    <c:if test="${table3 == null}"><a href="Add?add=3" class="btn btn-success my-3">Add new</a></c:if>

                </div>

        <div class="col-md-4">
            <form action="Add" method="post">
                <h1 class="my-4">Items info:</h1>
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Item name</th>
                            <th>Item price</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${items}" var="item">
                        <tr>
                            <c:if test="${mod4 == null || item.getId() != mod4}">
                                <td>${item.getName()}</td>
                                <td>${item.getPrice()}</td>
                                <td><a href="Delete?delete${item.getId()}&item=1" class="btn btn-danger d-block">Delete</a><a href="Modify?modify=${item.getId()}&table=4" class="btn btn-info d-block my-2">Modify</a></td>
                            </c:if>
                            <c:if test="${mod4 != null}">
                                <c:if test="${item.getId() == mod4}">
                                    <div class="form-group">
                                        <td><input class="form-control" id="itemname2" type="text" name="itemname2" value="${item.getName()}"></td>
                                        <td><input class="form-control" id="itemprice2" type="text" name="itemprice2" value="${item.getPrice()}"></td>
                                        <td><button type="submit" id="item" class="btn btn-success" name="itemmod" value="${item.getId()}">Save</button></td>
                                    </div>
                                </c:if>
                            </c:if>
                        </tr>
                    </c:forEach>
                    <c:if test="${table4 != null}">
                        <tr>
                            <div class="form-group">
                                <td><input class="form-control" type="text" name="itemname"></td>
                                <td><input class="form-control" type="text" name="itemprice"></td>
                                <td><button type="submit" class="btn btn-success" name="item">Add</button></td>
                            </div>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </form>
            <c:if test="${table4 == null}"><a href="Add?add=4" class="btn btn-success my-3">Add new</a></c:if>
            </div>
            </div>
        </div>
    </div>
</div>

<!-- Button trigger modal -->
<%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">--%>
<%--    Launch demo modal--%>
<%--</button>--%>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Ooops</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <c:forEach items="${errors}" var="error">
                    ${error}<br>
                </c:forEach>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
<c:if test="${Add.modal == 1}">
<script>
    $(document).ready(function(){
        $('#exampleModalCenter').modal('show');
    });
</script>
</c:if>
</body>
</html>