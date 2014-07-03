<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Periodos</h3>
	<div class="buttons pull-right">
		<a href="#" class="nuevo btn btn-primary btn-icon glyphicons circle_plus"><i></i> Nuevo</a>
	</div>
	<div class="clearfix"></div>
</div>
<div class="innerLR">

	<!-- Widget -->
	<div class="widget">

		<!-- Widget heading -->
		<div class="widget-head">
			<h4 class="heading">Listado</h4>
		</div>
		<!-- // Widget heading END -->

		<div class="widget-body">

			<!-- Table -->
			<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Id</th>
						<th>Administracion</th>
						<th>Fecha Inicial</th>
						<th>Fecha Fin</th>
						<th>Acciones</th>
						
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>

					<!-- // Table row END -->

				</tbody>
				<!-- // Table body END -->

			</table>
			<!-- // Table END -->

		</div>
	</div>
	<!-- // Widget END -->


	<!-- Widget -->




</div>
<div class="contNew modal hide fade" id="modal-simple">
		<div class="innerLR">

	<!-- Form -->
			<form:form commandName="periodo" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

		<!-- Widget -->
		<div class="widget">

			<!-- Widget heading -->
			<div class="widget-head">
				<h4 class="heading">Complete los datos</h4>
			</div>
			<!-- // Widget heading END -->

			<div class="widget-body">

				<!-- Row -->
				<div class="row-fluid">

					<!-- Column -->
					<div class="span6">
							<div class="control-group">
																		<label class="control-label">Administracion</label>
																		<div class="controls">
																				<form:select class='selectpicker span12 contAdministracionCombo'  path ='administracion.id' multiple="false">
																					<option></option>
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
																				</form:select>
																		</div>
																	</div>
						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Fecha Inicio</label>
							<div class="controls"><input size="span12" type="text" name ="fechaIni" id="fechaIniText" class="datepicker" disabled></div>
							<input size="span12" type="hidden" name ="fechaIni" id="fechaIni" class="datepicker">
							
						</div>

						<div class="control-group">
							<label class="control-label" for="firstname">Fecha Cierre</label>
							<div class="controls"><input size="span12" type="text" name ="fechaFin" id="fechaFin" class="datepicker" ></div>
						</div>



						<!-- // Group END -->

						<!-- Group -->

						<!-- // Group END -->

					</div>
					<!-- // Column END -->

					<!-- Column -->

					<!-- // Column END -->

				</div>
				<!-- // Row END -->

				<hr class="separator">

				<!-- Row -->


				<!-- // Row END -->

				<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Save</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove contCancelNew"><i></i>Cancel</button>
				</div>
				<!-- // Form actions END -->

			</div>
		</div>
		<!-- // Widget END -->

			</form:form>	
	<!-- // Form END -->

</div>
</div>

		