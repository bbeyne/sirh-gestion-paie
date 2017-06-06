<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/paie/mvc/employes/lister">Employe</a>
<a href="/paie/mvc/bulletins/lister">Bulletin</a>

<form class="form-horizontal" method="post">
	
	<fieldset>
	<legend>Ajouter un employé</legend>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Matricule</label>
			<div class="col-md-4">
				<input id="matricule" name="matricule" type="text" placeholder=""
					class="form-control input-md">

			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Entreprise</label>
			<div class="col-md-4">
				<select id="entreprise" name="entreprise"
					class="form-control">
					<c:forEach var="entrep" items="${entreprise}">
						<option value="${entrep.id}">${entrep.denomination}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Profil</label>
			<div class="col-md-4">
				<select id="profil" name="profil"
					class="form-control">
					<c:forEach var="profil" items="${profils}">
						<option value="${profil.id}">${profil.code}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Grade</label>
			<div class="col-md-4">
				<select id="grade" name="grade"
					class="form-control">
					<c:forEach var="grade" items="${grades}">
						<option value="${grade.id}">${grade.code}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="singlebutton"></label>
			<div class="col-md-4">
				<button id="singlebutton" name="singlebutton"
					class="btn btn-default">Ajouter</button>
			</div>
		</div>

	</fieldset>
</form>
