<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="icon" type="image/png"
    href="http://www.salaire-brut-en-net.fr/wp-content/uploads/favicon2.png" />
<title>SGP - App</title>
</head>
<body>
<a href="/paie/mvc/employes/lister">Employe</a>
<a href="/paie/mvc/bulletins/lister">Bulletin</a>

<h1 align="center">Liste des Employes</h1>

 <a href="/paie/mvc/employes/creer">Ajouter un employe</a>
 <table class="table table-bordered">
 <thead>
 <tr><th>Date/Heure de création</th><th>Matricule</th><th>Grade</th></tr> </thead>
 <tbody>
 	<c:forEach var="remun" items="${remunerations}">
 	<tr>
 		<td>${remun.dateform()}</td><td>${remun.matricule}</td><td>${remun.grade.code}</td>
 	</tr>
 	</c:forEach>
 </tbody>
 </Table>
 </body>