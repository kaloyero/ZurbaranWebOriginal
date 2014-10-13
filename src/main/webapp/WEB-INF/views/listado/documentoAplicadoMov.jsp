<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="documentoAplicado" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Busqueda Aplicaciones</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span12">
							<div class="control-group">
								<div class="span5">
									<label class="control-label">Administracion</label>
									<div class="controls contAdministracion">
									<form:select class='selectpicker span12 contAdministracionCombo select-document'  path ='id' multiple="false" placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
									</div>
								</div>
							</div>
							
										
							<div class="control-group">
								<div class="span12">
									<label class="control-label">Cuenta</label>
									<div class="controls ">
										<div class="contCuenta span3" >
											<select id="contCuentaCombo" name="estado" class="selectpicker contLetra select-document span12" placeholder="Seleccione un valor">
												<option></option>
											</select>
											<font size="4" style="margin-left: 12px;"> / </font>
										</div>
										<input id ="contTipoEntidadInput" type="text" value="" class="input-document" disabled>
										<input id ="contTipoEntidadId" type="hidden" value="" class="input-document" disabled>
										<select id="entidadCombo" placeholder="Seleccione un valor">
											<option></option>
										</select>
									</div>
								</div>
							</div>


							<div class="control-group" >
								<div class="span7">							
									<label class="control-label">Moneda</label>
									<div class="controls contTipoDoc">
										<div class="span3" >
											<form:select class='selectpicker monedaCombo ' style='width: 110px !important;' path ='id' multiple="false" placeholder="buscar en..">
											<option></option>
											<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
											</form:select>
										</div>
										<div class="span3" >
											<form:select class='selectpicker monedaComboMostrar ' style='width: 110px !important;'   path ='id' multiple="false" placeholder="Mostrar en..">
											<option></option>
											<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
											</form:select>
										</div>
									</div>									
								</div>
							</div>

							<div class="control-group" >
								<div class="span5">
									<label class="control-label">Numero de Documento</label>
									<div class="controls contEntidad" >
										<input id="contDocumento" class="" type="text"  style=" background-color: white; ">
									</div>
								</div>
								<div class="span5" >
									desde:
									<input class="contVencimientoDesde span5 datepicker input-date-small input-marginRight" type="text" >
									hasta:
									<input class="contVencimientoHasta span5 datepicker input-date-small input-marginRight" type="text" >
								</div>
							</div>
							
							<div class="control-group" >
								<div class="span5">
									<label class="control-label">Referencia</label>
									<div class="controls contEntidad" >
										<div class="span9">
											<input id="contReferencia" class="" type="text"  style=" background-color: white; ">
										</div>
									</div>
								</div>
								<div class="span3" >
									<button class ="contBuscar save btn btn-danger guardar" type="button" style="float: right;">Buscar</button>
								</div>
							</div>

						</div>
				</div>
				<hr style="background:#F87431; border:0; height:1px" />
				<BR>
				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed" style="table-layout: fixed;">

				<!-- Table heading -->
				<thead>
					<tr>
						<th style="width: 8px;">Id</th>
						<th>Fecha Ingreso</th>
						<th style="width: 48px;">Tipo Documento</th>	
						<th style="width: 36px;">Numero</th>				
						<th style="width: 48px;">Descripci&oacute;n</th>
						<th>Moneda</th>
						<th>Importe</th>
						<th style="width: 38px;">Cotizacion</th>
						<th style="width: 48px;">Tipo Documento Aplicado</th>
						<th style="width: 36px;">Numero</th>
						<th style="width: 48px;">Descripci&oacute;n</th>
						<th>Moneda</th>
						<th>Importe</th>
						<th>Cotizacion</th>
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