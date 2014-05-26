<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Cuenta</h3>
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
						<th>Administracion</th>
						<th>Nombre</th>
						<th>Codigo</th>
						<th>Tipo Entidad</th>
						<th>Saldo</th>
						<th>Estado</th>
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


				<form:form commandName="Cuenta" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			

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
						<div class="span10">
							<div class="control-group">
								<label class="control-label">Administracion</label>
								<div class="controls">
									<form:select class='contAdministracionCombo selectpicker span10'  path ='administracion.id' multiple="false">
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
									<input class="span10" id="nombre" name="nombre"
										type="text" maxlength="50">
								</div>
							</div>
								<div class="control-group">
								<label class="control-label" for="firstname">Codigo</label>
								<div class="controls">
									<input class="span5" id="codigo" name="codigo"
										type="text" maxlength="20">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">
									<textarea id="descripcion" maxlength="100" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; width: 273px; height: 100px;resize:none"></textarea>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<form:select class='selectpicker span8'  path ='tipoEntidad.id' multiple="false">
																					<form:options items="${tipoEntidades}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>


							<div class="control-group">
								<label class="control-label">Monedas</label>
								<div class="controls" style="width: 100%;">
						<div class="widget-body uniformjs span6" style="margin-left: 12px;">
											<form:select path="idsMonedas" multiple ="multiple" items="${monedas}" itemValue="id" itemLabel="nombre" />

											</div>
											<div class="widget-body uniformjs span3" style="width: 40%;">
												<label >Saldo</label>
												<label class="checkbox"> <input name="saldo" type="radio"
													class="checkbox" value="D" /> Deudor
												</label> <label class="checkbox"> <input type="radio" name="saldo"
													class="checkbox" value="A" checked="checked" /> Acreedor
												</label>
											</div>
											
								</div>
							</div>
							

							<div class="control-group">
												<label class="control-label">Estado</label>
												<div class="controls">
																		<select id="estado" name="estado" class="selectpicker span12">
																			<option value="T">Activo</option>
																			<option value="F">No Activo</option>
																		</select>
																	</div>
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

