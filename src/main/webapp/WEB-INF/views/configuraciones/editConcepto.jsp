<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="contEdit modal hide fade" id="modal-simple">
	<div class="innerLR">


		<form:form commandName="Concepto" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>

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
									<form:select class='contAdministracionCombo selectpicker span12'  path ='administracion.id' multiple="false">
											 <form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
										</form:select>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
									<form:input path ="nombre" class="span12" id="nombre" name="nombre" type="text"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Codigo</label>
								<div class="controls">
									<form:input path ="codigo" class="span12" id="codigo" name="codigo" type="text"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">

																	<form:textarea id="descripcion" path="descripcion" rows="4" cols="50" class="span6" style="margin: 0px; width: 179px; height: 102ppx;"/>
									
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
								   <form:select  id="cuentaCombo" class='contCuentaCombo selectpicker span12'  path ='cuenta.id' multiple="false">
											 <option value="-1"></option>
											 <form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />

								</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls"> 
									<form:input path ="cuenta.tipoEntidad.nombre" class="contTipoEntidadInput span12" id="tipoEntidad" name="tipoEntidad" type="text"/>
																</div>
							</div>

							<div class="control-group">
								<label class="control-label">Entidad</label>
								<div class="controls">
									<form:select  id="entidadCombo" class='selectpicker span12'  path ='entidad.id' multiple="false">
									 <form:options items="${entidades}" itemValue="id" itemLabel="nombre" />
									
								</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='moneda.id' multiple="false">
										<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
						<div class="control-group">
								<label class="control-label">Tipo Valor</label>
								<div class="controls">
									<select id="estado" name="tipoValor" class="selectpicker span12">
																			<option value="E">Efectivo</option>
																			<option value="P">Cheque Propio</option>
																			<option value="T">Cheque Terceros</option>
																		</select>
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

