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
					<div class="span12">
						<div class="control-group span5"  >
							<label class="control-label">Administraci&oacute;n</label>
							<div class="controls contAdministracion">
								<form:select class='selectpicker span12 contAdministracionCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="control-group span5" >
							<label class="control-label">Documento</label>
							<div class="controls contTipoDoc">
								<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker select-document'  path ='tipoDocumentoId' multiple="false">
								<option></option> 
								</form:select>
							</div>
						</div>
					</div>

					<div class="control-group" >
						<label class="control-label">Cuenta</label>
						<div class="controls ">
							<div class="contCuenta span3" >
								<form:select class='selectpicker contCuentaCombo select-document span12'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
								</form:select>
								<font size="4" style="margin-left: 12px;"> / </font>
							</div>
							
							<input id ="contTipoEntidadInput" type="text" value="" class=" input-document " disabled>
							<input id ="contTipoEntidadId" type="hidden" value="" class="input-document" disabled>
							<form:select id ="entidadCombo" class='contEntidadCombo selectpicker select-document'  placeholder="Seleccione un valor" path ='entidadId' multiple="false">
							<option></option> 
							</form:select>
						</div>
					</div>					

					<div class="span12">
						<div class="control-group span5" style="margin-left: -11px;">
							<label class="control-label">Referencia</label>
							<div class="controls">
								<input id ="contReferencia" type="text" value="" class=" input-document">
							</div>
							<label class="control-label" style="margin-top: 11px;">Moneda</label>
							<div class="controls contTipoDoc" style="margin-top: 11px;">
								<form:select class='selectpicker contMonedaCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
								<option></option>
								<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</div>
						</div>
						<div class="control-group span5"  >
							<label class="control-label">Descripci&oacute;n</label>
								<div class="controls" style="padding: 3px 0 5px 0;">
									<textarea id="descripcion" maxlength= "100" name="descripcion" rows="2" cols="50" class="span12" style="margin: 0px; resize:none"></textarea>
								</div>
						</div>
					</div>
					<div class="control-group" >
						<label class="control-label"></label>
						<div class="controls contEntidad" >
							<div class="span1">
								<div class="span12">
									<label class="radio " style="padding-left: 20px;">
										<input id="ingreso" name="NumeracionPeriodo" type="radio"
										class="checkbox contControl" value="G" checked="checked" />
										<span style="margin-left: -120px;">Fecha Ingreso</span>
									</label> 
								</div>
								<div class="span12">
									<label class="radio " style="padding-left: 18px;">
										<input id="vencimiento" name="NumeracionPeriodo" type="radio" class="checkbox contControl" value="E" />
										<span style="margin-left: -100px;">Fecha Vto.</span>
									</label>
								</div>
							</div>
							<div class="span4" style="margin-top:15px">	
								Desde: <input class="contVencimientoDesde span5 datepicker input-date-small input-marginRight" type="text" > Hasta :<input class="contVencimientoHasta span5 datepicker input-date-small input-marginLeft" type="text" style="margin-right:28px;">

							</div>
						</div>
						<div class="control-group span3" >
							<label class="control-label"></label>
							<div class="controls " >
								<div class="span3">
									<button class ="contBuscar save btn btn-danger guardar" type="button" style="margin-top:15px">Buscar</button>
								</div>
							</div>
						</div>						
					</div>
				</div>

				<hr style="background:#F87431; border:0; height:1px" /><BR>

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