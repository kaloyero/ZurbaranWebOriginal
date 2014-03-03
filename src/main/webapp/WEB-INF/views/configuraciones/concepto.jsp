<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Concepto</h3>
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
			<table id="configurationTable"
				class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Id</th>
						<th>Moneda</th>
						<th>Fecha</th>
						<th>Cotizacion</th>
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
<div class="modal hide fade" id="modal-simple">
	<div class="innerLR">


		<form:form commandName="Concepto" class="form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Complete los datos</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">

					<div class="row-fluid">

						<!-- Column -->
						<div class="span6">

							<div class="control-group">
								<label class="control-label">Administracion</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='administracion' multiple="false">
											 <form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
										</form:select>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
									<input class="span12" id="nombre" name="nombre"
										type="text">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Codigo</label>
								<div class="controls">
									<input class="span12" id="codigo" name="codigo"
										type="text">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">
									<textarea id="descripcion" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; width: 179px; height: 102px;">Des
												</textarea>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Estado</label>
								<div class="controls">
									<select class="selectpicker span12">
										<option>Activo</option>
										<option>No Activo</option>
									</select>
								</div>
							</div>
	
							<!-- // Group END -->

						</div>
						<!-- // Column END -->

						<!-- Column -->
						<div class="span6">

							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='cuenta' multiple="false">
										<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='cuenta' multiple="false">
										<form:options items="${tipoEntidades}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Entidad</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='cuenta' multiple="false">
										<form:options items="${entidades}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='moneda' multiple="false">
										<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>

				


							<!-- // Group END -->

						</div>
						<!-- // Column END -->

					</div>


					<hr class="separator">

					<!-- Row -->


					<!-- // Row END -->

					<hr class="separator">

					<!-- Form actions -->
					<div class="form-actions">
						<button type="submit"
							class="save btn btn-icon btn-primary glyphicons circle_ok">
							<i></i>Save
						</button>
						<button type="button"
							class="btn btn-icon btn-default glyphicons circle_remove">
							<i></i>Cancel
						</button>
					</div>
					<!-- // Form actions END -->

				</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>

