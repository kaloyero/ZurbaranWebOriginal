<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Resumen de Cuenta</h4>
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
								<div class="span5">							
									<label class="control-label">Moneda</label>
									<div class="controls contTipoDoc">
										<form:select class='selectpicker monedaCombo select-document'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
										</form:select>
									</div>
								</div>
							</div>

							<div class="control-group" >
								<div class="span4">
									<label class="control-label">Saldo Inicial</label>
									<div class="controls contEntidad" >
										<input class="contSaldoInicial campo-importe" type="text"  disabled>
									</div>
								</div>
								<div class="span4" >
									desde:
									<input class="contVencimientoDesde span5 datepicker input-date-small input-marginRight" type="text" >
									hasta:
									<input class="contVencimientoHasta span5 datepicker input-date-small input-marginRight" type="text" >
								</div>
							</div>
							
							<div class="control-group" >
								<div class="span5">
									<label class="control-label">Saldo Final</label>
									<div class="controls contEntidad" >
										<div class="span7">
											<input class="contSaldoFinal campo-importe" type="text" disabled >
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
				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Id</th>
						<th>Fecha Ingreso</th>
						<th>Tipo Documento</th>	
						<th>Numero Documento</th>				
						<th>Descripci&oacute;n</th>
						<th>Cuenta</th>
						<th>Tipo Entidad</th>
						<th>Entidad</th>
						<th>Moneda</th>
						<th>Debitos</th>
						<th>Creditos</th>
						<th>Saldo</th>
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