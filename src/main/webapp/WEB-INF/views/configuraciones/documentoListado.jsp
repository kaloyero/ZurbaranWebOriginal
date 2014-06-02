<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

		<!-- Widget -->
		<div class="widget" >
			<div class="widget-head">
				<h4 class="heading">Busqueda Documentos</h4>
			</div>
			<div class="widget-body">
				<div class="row-fluid">
					<div class="span7">
						<div class="control-group"  >
							<label class="control-label">Administracion</label>
							<div class="controls contAdministracion">
								<form:select class='selectpicker span12 contAdministracionCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label">Documento</label>
							<div class="controls contTipoDoc">
								<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span5 select-document'  path ='tipoDocumentoId' multiple="false">
								<option></option> 
								</form:select>
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label">Cuenta</label>
							<div class="controls contCuenta" >
								<div class="span7">
									<form:select class='selectpicker span12 contCuentaCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
								</form:select>
								</div>
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label">Fecha Desde</label>
							<div class="controls contEntidad" >
								<div class="span6">
									<input class="contVencimientoDesde span5 datepicker input-date-small input-marginRight" type="text" > Hasta :<input class="contVencimientoHasta span5 datepicker input-date-small input-marginLeft" type="text">
								</div>
																<div class="span6">
									<div class="span12">

										
										<label class="radio span6" style="padding-left: 0;">
											<div class="radio" id="uniform-undefined"><span>
											<input id="ingreso" name="NumeracionPeriodo" type="radio"
											class="checkbox contControl" value="G" checked="checked" /> </span></div>Fecha Ingreso
										</label> 
										<label class="checkbox span6" style="padding-left: 0;">
											<input id="vencimiento" name="NumeracionPeriodo" type="radio"
											class="checkbox contControl" value="E" /> Fecha Vto.
										</label> 
									</div>
								</div>

							</div>
						</div>
						<div class="control-group" >
							<label class="control-label"></label>
							<div class="controls" >


							</div>
						</div>

					</div>
					<div class="span5">
						<div class="control-group" >
							<label class="control-label">Entidad</label>
							<div class="controls">
								<form:select id ="entidadCombo" class='contEntidadCombo selectpicker span12 select-document'  placeholder="Seleccione un valor" path ='entidadId' multiple="false">
								<option></option> 
								</form:select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Tipo Entidad</label>
							<div class="controls">
								<input id ="contTipoEntidadInput" type="text" value="" class="span12 input-document" disabled>
								<input id ="contTipoEntidadId" type="hidden" value="" class="span12 input-document" disabled>
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label">Moneda</label>
							<div class="controls contTipoDoc">
								<form:select class='selectpicker span12 contMonedaCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
								<option></option>
								<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Referencia</label>
							<div class="controls">
								<input id ="contReferencia" type="text" value="" class="span12 input-document">
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label"></label>
							<div class="controls " >
								<div class="span7">
									<button class ="contBuscar save btn btn-danger guardar" type="button">Buscar</button>
								</div>
							</div>
						</div>
					</div>
				</div>

				<hr style="background:#F87431; border:0; height:7px" /><BR>

				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th>Id</th>
							<th>Tipo de Documento</th>
							<th>Numero</th>
							<th>Fecha Ingreso</th>
							<th>Fecha Vencimiento</th>
							<th>Moneda</th>
							<th>Estado</th>
							<th>Importe Total</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
</form:form>	

</div>
</div>
