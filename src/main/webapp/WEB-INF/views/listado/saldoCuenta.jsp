<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Saldo de Cuenta</h4>
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
									<form:select class='selectpicker span12 contAdministracionCombo select-document selectpicker'  path ='id' multiple="false" placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
									</div>
								</div>
							</div>
	
				
							<div class="control-group" >
								<div class="span12">
								<label class="control-label">Cuenta</label>
								<div class="controls ">
									<div class="contCuenta span3" >
										<select id="contCuentaCombo" name="estado" class="selectpicker contLetra select-document selectpicker" placeholder="Seleccione un valor">
												<option></option>
										</select>
										<font size="4" style="margin-left: 12px;">  </font>
									</div>
									<input id ="contTipoEntidadInput" type="text" value="" class="input-document" disabled>
									<input id ="contTipoEntidadId" type="hidden" value="" class="input-document" disabled>
									<select id="entidadCombo" placeholder="Seleccione un valor" multiple="multiple">
									<option></option>
									</select>
								</div>
								</div>
							</div>

							
								<div class="span12">
						<div class="control-group span5" style="margin-left: -11px;">
							<label class="control-label">Moneda</label>
									<div class="controls contTipoDoc">
										<form:select class='selectpicker monedaCombo select-document selectpicker'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
										</form:select>
									</div>
						</div>
						<div class="control-group span5" >
							<label class="control-label">Mostrar en</label>
									<div class="controls contTipoDoc">					
										<form:select id ="monedaComboEn" class='selectpicker select-document monedaEnCombo selectpicker'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${monedasEN}" itemValue="id" itemLabel="nombre" />
										</form:select> 
									</div>
						</div>
					</div>
					
				
						<div class="span12">
						<div class="control-group span5" style="margin-left: -11px;">
							<div class="span4">
									<label class="control-label">Al</label>
									<div class="controls contTipoDoc">					
										<input class="contVencimientoDesde input-date-small input-marginRight datepicker" type="text" >
									</div>
								</div>
						</div>
						<div class="control-group span5" >
							<div class="span4">
									<label class="control-label">Mostrar saldo cero</label>
									<div class="controls contTipoDoc">					
										<input id="saldoCero" name="mostrarSaldosZero" type="checkbox"  value="true">
									</div>
								</div>
						</div>
					</div>
				
				
				
				
				
				
				
				

							<div class="control-group" >
								<label class="control-label">Cotizacion</label>
									<div class="controls contTipoDoc">					
									 <input id ="headerCotizacion" type="text" value="" class="span5 input-date-small input-marginRight" disabled>
									</div>

								
								
							</div>
						
				
							
							<div class="control-group" >
								<div class="span10">
									<label class="control-label"></label>
									<div class="controls" >
										<div class="span9" >
											<button class ="contBuscar save btn btn-danger guardar" type="button">Buscar</button>
											<button class ="contExcel save btn btn-danger guardar" type="button" >Exportar</button>
											
										</div>
									</div>
								</div>
							</div>
							<hr style="background:#F87431; border:0; height:1px; margin:20px 0;" />
						</div>

				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
				
						<th>Cuenta</th>
						<th>Entidad</th>
						<th>Moneda</th>
						<th>Saldo</th>
						<th>Saldo en</th>
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