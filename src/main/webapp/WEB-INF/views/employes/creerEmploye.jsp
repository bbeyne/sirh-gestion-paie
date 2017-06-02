
<a href="/paie/mvc/employes/lister">Employe</a>
<a href="/paie/mvc/bulletins/lister">Bulletin</a>
<center>
	<h1>Ajouter un employé</h1>
</center>

<form class="form-horizontal">
	<fieldset>
		<!-- Text input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="textinput">Matricule</label>
			<div class="col-md-4">
				<input id="textinput" name="textinput" type="text" placeholder=""
					class="form-control input-md">

			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Entreprise</label>
			<div class="col-md-4">
				<select id="selectmultiple" name="selectmultiple"
					class="form-control" multiple="multiple">
					<option>${Entreprise.findOne(0).getDenomination()}</option>
				</select>
			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Profil</label>
			<div class="col-md-4">
				<select id="selectmultiple" name="selectmultiple"
					class="form-control" multiple="multiple">
				</select>
			</div>
		</div>

		<!-- Select Multiple -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectmultiple">Grade</label>
			<div class="col-md-4">
				<select id="selectmultiple" name="selectmultiple"
					class="form-control" multiple="multiple">
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
