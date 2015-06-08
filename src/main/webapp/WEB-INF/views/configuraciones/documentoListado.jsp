<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
	td {word-wrap: break-word;}
	
</style>
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
						<div class="control-group"  >
							<label class="control-label">Administraci&oacute;n</label>
							<div class="controls contAdministracion">
								<form:select class='selectpicker span12 contAdministracionCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</div>
						</div>
					
					
							<div class="span12">
						<div class="control-group span5" style="margin-left: -11px;">
							<label class="control-label">Tipo Documento</label>
							<div class="controls contTipoDoc">
								<form:select  id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span12 select-document'  path ='tipoDocumentoId' multiple="false">
								<option></option> 
								</form:select>
							</div>
						</div>
						<div class="control-group span5"  >
							<label class="control-label" style="margin-top: 11px;">Numero Documento</label>
							<div class="controls contTipoDoc" style="margin-top: 11px;">
								<input id ="contNumeroFormateado" type="text" value="" class=" input-document " style="
    margin-left: 15px;
"/>
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
							<form:select id ="entidadCombo" class='contEntidadCombo selectpicker'  placeholder="Seleccione un valor" path ='entidadId' multiple="false" style="width: 400px;">
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
						</div>
						<div class="control-group span5"  >
							<label class="control-label">Descripci&oacute;n</label>
								<div class="controls" style="padding: 3px 0 5px 0;">
								<input id ="descripcion" type="text" value="" class=" input-document " />
								
								</div>
						</div>
					</div>
					<div class="span12">
						<div class="control-group span5" style="margin-left: -11px;">
							<label class="control-label" style="margin-top: 11px;">Moneda</label>
							<div class="controls contTipoDoc" style="margin-top: 11px;">
								<form:select class='selectpicker contMonedaCombo select-document'  path ='administracion.id' multiple="false"  placeholder="Seleccione un valor">
								<option></option>
								<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
								</form:select>
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
							<div class="span4" style="margin-left: -40px;/* margin-top:15px */">	
								Desde: <input class="contVencimientoDesde span5 datepicker input-date-small input-marginRight" type="text" > Hasta :<input class="contVencimientoHasta span5 datepicker input-date-small input-marginLeft" type="text" >

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
			
				</div>

				<hr style="background:#F87431; border:0; height:1px" /><BR>
				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed tableBusquedaDocumentos" style="table-layout: fixed;font-size: smaller;">
					<thead>
						<tr>
							<th style="width: 15px;">Id</th>
							<th style="width: 66px;">Tipo de Documento</th>
							<th>Numero</th>
							<th style="width: 78px;">Descripci&oacute;n</th>
							<th>Fecha Ingreso</th>
							<th style="width: 39px;">Fecha Vto</th>
							<th style="width: 69px;">Cuenta</th>
							<th>Tipo de Entidad</th>
							<th>Entidad</th>
							<th style="width: 19px;">Mon</th>
							<th>Importe Total</th>
							<th>Estado</th>
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