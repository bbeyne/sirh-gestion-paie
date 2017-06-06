<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/paie/mvc/employes/lister">Employe</a>
<a href="/paie/mvc/bulletins/lister">Bulletin</a>
<center>
<h1>Liste des Employes</h1>
</center>
 <a href="/paie/mvc/employes/creer" align="right">Ajouter un employe</a>
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