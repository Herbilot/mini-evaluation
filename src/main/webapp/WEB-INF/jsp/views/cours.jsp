
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 26/10/2024
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Cours</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Liste des cours</h5>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th>Matière</th>
                            <th>Professeur</th>
                            <th>Classe</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${coursList}" var="cours">
                            <tr>
                                <td>${cours.matiere}</td>
                                <td>${cours.professeur}</td>
                                <td>${cours.classe}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Ajout d'un cours</h5>
                    <form action="cours" method="post">
                        <div class="mb-3">
                            <label for="matiereInput" class="form-label">Matiere</label>
                            <input type="text" name="matiere" class="form-control" id="matiereInput">
                        </div>
                        <div class="mb-3">
                            <label for="inputProfesseur" class="form-label">Professeur</label>
                            <input type="text" name="professeur" class="form-control" id="inputProfesseur">
                        </div>
                        <div class="mb-3">
                            <label for="inputClasse" class="form-label">Classe</label>
                            <input type="text" name="classe" class="form-control" id="inputClasse">
                        </div>
                        <button type="submit" class="btn btn-primary">Ajouter</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
