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

<h1 align="center">Liste des Bulletins</h1>

<a href="/paie/mvc/bulletins/creer" style="align:'right'">Creer un nouveau bulletin</a>
 <table class="table table-bordered">
 <thead>
 <tr><th>Date/Heure de création</th><th>Periode</th><th>Matricule</th><th>Salaire Brut</th><th>Net imposable</th><th>Net à payer</th><th> Visualiser</th></tr> </thead>
 <tbody>
 	<c:forEach var="bulletin" items="${bulletins}">
 	<tr>
 		<td>${bulletin.dateform()}</td><td>${bulletin.periode.dateDebut}  ${bulletin.periode.dateFin}</td><td>${bulletin.remunerationEmploye.matricule}</td><td>${remun.get(bulletin.id-1).salaireBrut}</td><td>${remun.get(bulletin.id-1).netImposable}</td><td>${remun.get(bulletin.id-1).netAPayer}</td><td>lien</td> 
 	</tr>
 	</c:forEach>
 </tbody>
 </Table>
 </body>