<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Movimiento por Estructura</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span12">
							<div class="control-group span5"  >
								<label class="control-label">Administraci&oacute;n</label>
								<div class="controls contAdministracion">
									<form:select class='selectpicker contAdministracionCombo select-document'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>

							<div class="span5" style="margin-left: 25px !important">	
								Fecha Desde: 
								<input class="contFechaDesde span6 datepicker input-date-small input-marginRight" type="text" > 
								Hasta :
								<input class="contFechaHasta span6 datepicker input-date-small input-marginLeft" type="text" style="margin-right:28px;">
<!--								<input id="sinSaldo" type="checkbox" style="margin-right:8px;"/> Sin Saldos -->
								
							</div>
						</div>
						
						<div class="span12">
							<div class="control-group span5" style="margin-left: -12px;">
								<label class="control-label">Estructura</label>
								<div class="controls contEstructura">
								<form:select class='selectpicker contEstructuraCombo select-document'  path ='id' multiple="false" placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${estructuras}" itemValue="id" itemLabel="nombre" />
								</form:select>
								</div>
							</div>
								<div class="span4">
									<form:select id ="monedaComboEn" class='selectpicker span6 monedaEnCombo input-marginRight'  path ='id' multiple="false" placeholder="Mostrar Moneda en...">
											<option></option>
											<form:options items="${monedasEN}" itemValue="id" itemLabel="nombre" />
									</form:select> 
									<input id ="headerCotizacion" type="text" value="" style="margin-right:28px;" class="span4 input-date-small input-marginLeft" disabled placeholder="Cotizacion">
								</div>
							<div class="span2">
									<button class ="contBuscar save btn btn-danger guardar" type="button" style=";">Buscar</button>
									<button class ="contExcel save btn btn-danger guardar" type="button" >Exportar</button>
							</div>
								
						</div>
					<div class="span12" style="margin: 10px 0;">
						<hr style="background:#F87431; border:0; height:1px" />
					</div>
									
								</div>
							</div>

				</div>
				<table id="configurationSaldo" class="dynamicTable table table-striped table-bordered table-condensed tableSaldoEstructuraMovimiento">

				<!-- Table heading -->
				<thead>
					<tr>
						<th style="width: 25px;"></th>
						<th class="col1">Contenido</th>
						<th class="col2">Cuenta</th>
						<th class="col3">Entidad</th>
						<th class="col4">Fecha</th>
						<th class="col5"></th>
						<th class="campo-importe">Importe</th>
						<th class="campo-importe">Saldo</th>
						<th class="col5"></th>
						<th class="campo-importe">Importe</th>						
						<th class="campo-importe">Saldo</th>
						<th class="col2">Documento</th>
						<th class="col2">Descripci&oacute;n</th>
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