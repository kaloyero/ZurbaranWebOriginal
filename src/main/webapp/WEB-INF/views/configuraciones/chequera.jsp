<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Chequeras</h3>
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
						<th>Administraci&oacute;n</th>
						<th>Cuenta</th>
						<th>Tipo Entidad</th>
						<th>Entidad</th>
						<th>Moneda</th>
						<th>Numero Inicial</th>
						<th>Numero Final</th>
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


		<form:form commandName="Chequera" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

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
								<label class="control-label">Administraci&oacute;n</label>
								<div class="controls">
									<form:select class='contAdministracionCombo selectpicker span12'  path ='administracion.id' multiple="false">
											<option></option>
											 <form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
										</form:select>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Numero Inicial</label>
								<div class="controls">
									<input class="span10" id="numeroIni" name="numeroIni"
										type="text" maxlength="50">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Numero Final</label>
								<div class="controls">
									<input class="span12" id="codigo" name="numeroFin"
										type="text" maxlength="20">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripci&oacute;n</label>
								<div class="controls">
									<textarea id="descripcion" maxlength="100" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; width: 179px; height: 102px;"></textarea>
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

						</div>
						<!-- // Column END -->

						<!-- Column -->
						<div class="span6">

							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
								   	<form:select id="cuentaCombo" class='contCuentaCombo selectpicker span12'  path ='cuentaId' multiple="false">
								  			<option></option>
											 <form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
										</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls"> 
									<input class=" contTipoEntidadInput span12" id="tipoEntidadNombre"  type="text" readonly>
									<input class=" contTipoEntidadIdInput span12" name="tipoEntidadId"  type="hidden" readonly>
								</div>
							</div>
		

							<div class="control-group">
								<label class="control-label">Entidad</label>
								<div class="controls">
									<select id="entidadCombo" name="entidadId" class="selectpicker span12">

								  </select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select id="monedaCombo" class='selectpicker span12'  path ='moneda.id' multiple="false">
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
							<i></i>Guardar
						</button>
						<button type="button"
							class="btn btn-icon btn-default glyphicons circle_remove contCancelNew">
							<i></i>Cancelar
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
<div class="contNoDisponibleForm modal hide fade" id="modal-simple" style="width:65%" >
			<div class="innerLR">

<form:form commandName="Chequera" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

	<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Complete los datos</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">

					<div class="row-fluid">
					
	<div class="span6">

						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Numero Cheque</label>
							<div class="controls"><input class="span5" id="contNumCheque" name="contNumCheque" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Motivo</label>
							<div class="controls"><textarea id="contMotivo" maxlength="100"  name="contMotivo" rows="4" cols="80" class="span6" style="margin: 0px; height: 119px;width: 230px"></textarea></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Beneficiario</label>
							<div class="controls"><input class="span12" id="contBeneficiario" name="contBeneficiario" type="text" maxlength="100"></div>
						</div>
			

						<!-- // Group END -->

						<!-- Group -->

						<!-- // Group END -->
					</div>
						<div class="span6">

						<div class="control-group">
							<label class="control-label" for="firstname">Importe</label>
							<div class="controls"><input class="span5" id="contImporte" name="contImporte" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Fecha emision</label>
							<div class="controls"><input class="span5 datepicker" id="contFechaEmision" name="contFechaEmision" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Fecha Vencimiento</label>
							<div class="controls"><input class="span5 datepicker" id="contFechaVto" name="contFechaVto" type="text" maxlength="100"></div>
						</div>

						<!-- // Group END -->

						<!-- Group -->

						<!-- // Group END -->
					</div>
					
					
					</div>
<hr class="separator">
<hr class="separator">
				<!-- Form actions -->
				<div class="form-actions">
					<button type="button" class="btn btn-icon btn-primary glyphicons circle_ok contGuardarNoDisponible"><i></i>Guardar</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancelar</button>
				</div>
      			</div>
			</div>
			<!-- // Widget END -->

			</form:form>
      			
      
</div>
</div>

