<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="contEdit modal hide fade container-popup" id="modal-simple ">
	<div class="innerLR">


		<form:form commandName="Concepto" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>

			<!-- Widget -->
			<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head header-popup">
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
									<form:input path ="nombre" class="span12" id="nombre" name="nombre" type="text" maxlength="50"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Codigo</label>
								<div class="controls">
									<form:input path ="codigo" class="span12" id="codigo" name="codigo" type="text" maxlength="20"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">

									<form:textarea maxlength="100" id="descripcion" path="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; height: 110px;"/>
									
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
											 <form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />

								</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls"> 
									<form:input path ="cuenta.tipoEntidad.nombre" class="contTipoEntidadInput span12 input-readOnly" id="tipoEntidad" name="tipoEntidad" type="text" readonly="true"/>
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
									<form:select id="monedaCombo" class='selectpicker span7'  path ='moneda.id' multiple="false">
										<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
						<div class="control-group">
								<label class="control-label">Tipo Valor</label>
								<div class="controls">
									<form:select path="tipoValor" id="tipoValor" name="tipoValor" class="selectpicker span7">
															<form:option value="N">No es Valor</form:option>
															<form:option value="P">Cheque Propio</form:option>
															<form:option value="T">Cheque Terceros</form:option>
									</form:select>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Estado</label>
								<div class="controls">
									<form:select path="estado" id="estado" name="estado" class="selectpicker span7">
											<form:option value="T">Activo</form:option>
											<form:option value="F">Inactivo</form:option>
									</form:select>
								</div>
							</div>				


							<!-- // Group END -->

						</div>
						<!-- // Column END -->

					</div>


					<hr class="separator separatorMarginTop">

					<!-- Row -->


					<!-- // Row END -->

					<!-- Form actions -->
					<div class="form-actions">
						<button type="submit"
							class="save btn btn-icon btn-primary glyphicons circle_ok">
							<i></i>Guardar
						</button>
						<button type="button"
							class="btn btn-icon btn-default glyphicons circle_remove contCancelEdit">
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

