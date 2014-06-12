<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Saldo por Estructuras Movimientos</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span7">
							<div class="control-group"  >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
								<form:select class='selectpicker span12 contAdministracionCombo'  path ='id' multiple="false" placeholder="Seleccione un valor">
								<option></option>
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
																				</form:select>
								</div>
							</div>
							<div class="control-group"  >
								<label class="control-label">Estructura</label>
								<div class="controls contEstructura">
								<form:select class='selectpicker span12 contEstructuraCombo'  path ='id' multiple="false" placeholder="Seleccione un valor">
								<option></option>
																					<form:options items="${estructuras}" itemValue="id" itemLabel="nombre" />
																				</form:select>
								</div>
							</div>
	
							<div class="control-group" >
								<label class="control-label">Fecha Desde</label>
								<div class="controls contDesde" >
									<div class="span7">
										<input class="contFechaDesde span5 datepicker" type="text" >
									</div>
									
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Fecha Hasta</label>
								<div class="controls contDesde" >
									<div class="span7">
										<input class="contFechaHasta span5 datepicker" type="text" >
									</div>
									
								</div>
							</div>
							
		

								</div>
						<div class="span5">

							
							
							<div class="control-group" >
								<label class="control-label"></label>
								<div class="controls " >
									<div class="span7">
										<button class ="contBuscar save btn btn-icon btn-primary glyphicons circle_ok guardar" type="button">Buscar</button>
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

						<th>Contenido</th>
						<th>Cuenta</th>
						<th>Entidad</th>
						<th>Debito</th>
						<th>Credito</th>						
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