<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

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
								<form:select class='selectpicker span12 contAdministracionCombo'  path ='id' multiple="false">
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
																				</form:select>
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Banco</label>
								<div class="controls ">
										<form:select class='selectpicker span12 contBancoCombo'  path ='id' multiple="false">
																					<form:options items="${bancos}" itemValue="id" itemLabel="nombre" />
																				</form:select>
								</div>
							</div>
				
							<div class="control-group" >
								<label class="control-label">Cuenta</label>
								<div class="controls ">
										<select id="contCuentaCombo" name="estado" class="selectpicker span8 contLetra">
		
										</select>
								</div>
							</div>
								<div class="control-group" >
								<label class="control-label">Entidad</label>
								<div class="controls">
										<select id="entidadCombo">
										</select>
								</div>
							</div>
								<div class="control-group" >
								<label class="control-label">Moneda</label>
								<div class="controls contTipoDoc">
										<select id="monedaCombo" name="estado" class="selectpicker span8 contLetra">
																	
										</select>
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Vencimiento Desde</label>
								<div class="controls contEntidad" >
									<div class="span7">
										<input class="contVencimientoDesde span5 datepicker" type="text" > Hasta :<input class="contVencimientoHasta span5 datepicker" type="text" >
									</div>
									
								</div>
							</div>
							
							<div class="control-group" >
								<label class="control-label">Emitido desde</label>
								<div class="controls contEntidad" >
									<div class="span7">
										<input class="contEmitidoDesde span5 datepicker" type="text" > Hasta :<input class="contEmitidoHasta span5 datepicker" type="text" >
									</div>
									
								</div>
							</div>

								</div>
						<div class="span5">
							
							<div class="control-group">
								<label class="control-label">En cartera</label>
								<div class="controls">
									<input id ="tipoMovimiento" type="checkbox" value="" class="span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Entregados/Depositos</label>
								<div class="controls">
									<input id ="tipoMovimiento" type="checkbox" value="" class="span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<input id ="contTipoEntidadInput" type="text" value="" class="span12" disabled>
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
				<BR>
				<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Numero</th>
						<th>Fecha Vto</th>
						<th>Cuenta/Entidad</th>
						<th>Moneda</th>
						<th>Importe</th>
						<th>Estado</th>
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
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>