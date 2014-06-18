<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Resumen Estructura</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span12">
							<div class="control-group span4"  >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
									<form:select class='selectpicker contAdministracionCombo span12'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>

							<div class="span5">	
								Fecha Desde: 
								<input class="contFechaDesde span6 datepicker input-date-small input-marginRight" type="text" > 
								Hasta :
								<input class="contFechaHasta span6 datepicker input-date-small input-marginLeft" type="text" style="margin-right:28px;">

							</div>
						</div>
						
						<div class="span8">
							<div class="control-group span6" >
								<label class="control-label">Estructura</label>
								<div class="controls contEstructura">
								<form:select class='selectpicker contEstructuraCombo span12'  path ='id' multiple="false" placeholder="Seleccione un valor">
									<option></option>
									<form:options items="${estructuras}" itemValue="id" itemLabel="nombre" />
								</form:select>
								</div>
							</div>
						</div>
							<div class="control-group" >
								<label class="control-label"></label>
								<div class="controls " >
									<div class="span4">
										<button class ="contBuscar save btn btn-icon btn-primary glyphicons circle_ok guardar" type="button">Buscar</button>
									</div>
									
								</div>
							</div>

				</div>
				<hr style="background:#F87431; border:0; height:7px" />
				<BR>
				<table id="configurationSaldo" class="dynamicTable table table-striped table-bordered table-condensed tableSaldoEstructuraMovimiento">

				<!-- Table heading -->
				<thead>
					<tr>
						<th style="width: 25px;"></th>
						<th class="col1">Contenido</th>
						<th class="col2">Cuenta</th>
						<th class="col3">Entidad</th>
						<th class="col4">Fecha</th>
						<th class="campo-importe">Debito</th>
						<th class="campo-importe">Credito</th>						
						<th class="campo-importe">Saldo</th>
						<th class="col8">Documento</th>
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