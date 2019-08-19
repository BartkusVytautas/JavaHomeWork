<%--
  Created by IntelliJ IDEA.
  User: Vytautas
  Date: 8/19/2019
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" integrity="sha256-HAaDW5o2+LelybUhfuk0Zh2Vdk8Y2W2UeKmbaXhalfA=" crossorigin="anonymous" />
    <title>Welcome!</title>
</head>
<body>
    <div class="container-fluid my-5">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <form method="post" action="Add">
                            <div class="form-group">
                                <label for="input1">Enter URL of the image to add:</label>
                                <input type="url"
                                       class="form-control" name="url" id="input1" aria-describedby="helpId" placeholder="http://..." required>
                                <label for="input2">Description:</label>
                                <input type="text"
                                       class="form-control" name="description" id="input2" aria-describedby="helpId" placeholder="Description here" required>
                                <button name="add" type="submit" class="btn btn-success my-3">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <table class="table">
                    <thead>
                        <tr>
                            <th>URL example:</th>
                        </tr>
                    </thead>
                    <tr>
                        <td>https://unsplash.it/600.jpg?image=251</td>
                    </tr>
                    <tr>
                        <td>https://unsplash.it/600.jpg?image=252</td>
                    </tr>
                    <tr>
                        <td>https://unsplash.it/600.jpg?image=253</td>
                    </tr>
                    <tr>
                        <td>https://unsplash.it/600.jpg?image=254</td>
                    </tr>

                </table>
            </div>
        </div>
    </div>






<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.js" integrity="sha256-jGAkJO3hvqIDc4nIY1sfh/FPbV+UK+1N+xJJg6zzr7A=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</body>
</html>
