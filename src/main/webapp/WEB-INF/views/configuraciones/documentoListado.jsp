<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Valores de Terceros/Propios</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span7">
							<div class="control-group"  >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
								<form:select class='selectpicker span12 contAdministracionCombo'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
								<option></option>
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
																				</form:select>
								</div>
							</div>
				
								<div class="control-group" >
								<label class="control-label">Documento</label>
								<div class="controls contTipoDoc">
										
										<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span5'  path ='tipoDocumentoId' multiple="false">
																																<option></option> 
										
										</form:select>
										<input class="span6" type="text">
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Cuenta</label>
								<div class="controls contEntidad" >
									<div class="span7">
										<input class="contCuentaNombre span5" type="text" readonly> <font size="4"> / </font> <input class="contTipoEntidad  span5" type="text" readonly>
									</div>
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label"></label>
								<div class="controls " >
									<div class="span7">
									<div class="span12">
																	<label class="checkbox span6">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contControl" value="G" /> Fecha Ingreso
																	</label> 
																	<label class="checkbox span6">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contControl" value="E" /> Fecha Vencimiento
																	</label> 
																</div>
									</div>
									
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Fecha Desde</label>
								<div class="controls contEntidad" >
									<div class="span7">
										<input class="contVencimientoDesde span5 datepicker" type="text" > Hasta :<input class="contVencimientoHasta span5 datepicker" type="text" >
									</div>
									
								</div>
							</div>
							
							

								</div>
						<div class="span5">
							
								<div class="control-group" >
								<label class="control-label">Entidad</label>
								<div class="controls">
										<form:select id ="entidadCombo" class='contCuentaCombo selectpicker span5'  placeholder="Seleccione un valor" path ='entidadId' multiple="false">
									
																						<option></option> 
									</form:select>
								</div>
							</div>
								<div class="control-group" >
								<label class="control-label">Moneda</label>
								<div class="controls contTipoDoc">
										<select id="monedaCombo" name="estado" class="selectpicker span8 contLetra" placeholder="Seleccione un valor">
										<option></option> 
										</select>
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
						<th>Id</th>
						<th>Administracion</th>
						<th>Tipo de Documento</th>
						<th>Numero</th>
						<th>Fecha Ingreso</th>
						<th>Fecha Vencimiento</th>
						<th>Moneda</th>
						<th>Importe Total</th>
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
			</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>