<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Cotizaci&oacute;n</h3>
	<div class="buttons pull-right">
	<!-- Saco el botón nuevo xq siempre tengo todas las cotizaciónes en el listado
 		<a href="#" class="nuevo btn btn-primary btn-icon glyphicons circle_plus"><i></i> Nuevo</a>
	 -->

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
						<th>Moneda</th>
						<th>Utima Actualizaci&oacute;n</th>
						<th>Cotizaci&oacute;n</th>
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
			<form:form commandName="Cotizacion" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

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
																		<label class="control-label">Moneda</label>
																		<div class="controls">
																				<form:select class='selectpicker span12'  path ='moneda.id' multiple="false">
																					<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
																				</form:select>
																		</div>
																	</div>
						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Fecha</label>
							<div class="controls"><input size="span12" type="text" name ="fecha" id="datetimepicker1" class="datepicker"></div>
						</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Cotizaci&oacute;n</label>
								<div class="controls"><input class="span12" id="cotizacion" name="cotizacion" type="number" min="0" step="0"></div>
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
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Guardar</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove contCancelNew"><i></i>Cancelar</button>
				</div>
				<!-- // Form actions END -->

			</div>
		</div>
		<!-- // Widget END -->

			</form:form>	
	<!-- // Form END -->

</div>
</div>

		