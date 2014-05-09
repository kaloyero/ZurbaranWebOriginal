<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Busqueda Documentos</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">

					<!-- Row -->
					<div class="row-fluid">

						<div class="span11">
							<div class="control-group span4 " >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
									<form:select class='selectpicker span12 contAdministracionCombo'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group span4" >
								<label class="control-label">Documento</label>
								<div class="controls contTipoDoc">
										<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span12'  path ='tipoDocumentoId' multiple="false">
																																<option></option> 
										
										</form:select>
								</div>
							</div>
						</div>
						<div class="span11">
							<div class="control-group span4 " >
								<label class="control-label">Cuenta</label>
								<div class="controls contCuenta" >
									<div class="">
									<form:select class='selectpicker span12 contCuentaCombo'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
																				<option></option>
																					<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
																				</form:select>
									</div>
								</div>
							</div>
							<div class="control-group span4" >
								<label class="control-label">Tipo Entidad</label>
								<div class="controls" >
									<input class="" type="text">
								</div>
							</div>
							<div class="control-group span4" >
								<label class="control-label">Entidad</label>
								<div class="controls" >
										<form:select id ="entidadCombo" class='contEntidadCombo selectpicker span12'  placeholder="Seleccione un valor" path ='entidadId' multiple="false">
									
																						<option></option> 
									</form:select>
								</div>
							</div>
						</div>
						
						<div class="span11">
							<div class="control-group span4" >
								<label class="control-label">Moneda</label>
								<div class="controls contTipoDoc">
										<form:select class='selectpicker span12 contMonedaCombo'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
																				<option></option>
																					<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
																				</form:select>
								</div>
							</div>			
							<div class="span8">
								<div class="control-group span5" >
									<div class="span10">
										<label class="checkbox">
											<input id="ingreso" name="NumeracionPeriodo" type="radio"
												class="checkbox contControl" value="G" checked="checked" /> Fecha Ingreso
										</label> 
									</div>
									<div class="span10">
											<label class="checkbox">
											<input id="vencimiento" name="NumeracionPeriodo" type="radio"
												class="checkbox contControl" value="E" /> Fecha Vencimiento
											</label> 
									</div>
								</div>
								<div class="control-group span7" >
									<div class="contEntidad" >
										<div class="">
											Fecha Desde: <input class="contVencimientoDesde span3 datepicker" type="text" > Hasta :<input class="contVencimientoHasta span3 datepicker" type="text" >
										</div>
									</div>
								</div>
							</div>
				
						</div>
						
							<div class="control-group" >
								<label class="control-label"></label>
								<div class="controls " >
									<div class="span7">
										<button class ="contBuscar save btn btn-icon btn-primary glyphicons circle_ok guardar" type="button">Buscar documento</button>
									</div>
									
								</div>
							</div>

						</div>
						

						

				


				</div>
				<hr style="background:#F87431; border:0; height:7px" />
				<BR>
				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th width="8%">Id</th>
						<th width="11%">Administracion</th>
						<th width="15%">Tipo de Documento</th>
						<th width="11%">Numero</th>
						<th width="11%">Fecha Ingreso</th>
						<th width="11%">Fecha Vencimiento</th>
						<th width="11%">Moneda</th>
						<th width="11%">Importe Total</th>
						<th width="11%">Acciones</th>
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>

					<!-- // Table row END -->

				</tbody>
				<!-- // Table body END -->

			</table>
			</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>