<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="/paie/mvc/employes/lister">Employe</a>
<a href="/paie/mvc/bulletins/lister">Bulletin</a>

<form class="form-horizontal" method="post">
	
	<fieldset>
	<legend>Créer un bulletin</legend>
		
		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Periode</label>
			<div class="col-md-4">
				<select id="periode" name="periode"
					class="form-control">
					<c:forEach var="periode" items="${periodes}">
						<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Matricule</label>
			<div class="col-md-4">
				<select id="employe" name="employe"
					class="form-control">
					<c:forEach var="employe" items="${employes}">
						<option value="${employe.id}">${employe.matricule}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Prime exceptionnelle</label>
			<div class="col-md-4">
				<input id="prime" name="prime" type="text" placeholder=""
					class="form-control input-md">

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