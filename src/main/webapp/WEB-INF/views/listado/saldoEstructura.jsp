<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Saldo por Estructuras</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span12">

							<div class="span12">
								<div class="control-group span4">
										<label class="control-label">Administracion</label>
										<div class="controls contAdministracion">
											<form:select class='selectpicker select-document contAdministracionCombo'  path ='id' multiple="false" placeholder="Seleccione un valor">
											<option></option>
											<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
											</form:select>
										</div>
								</div>

								<div class="control-group span5" >
									<label class="control-label">Al</label>
									<div class="controls contDesde" >
										<div class="span7">
											<input class="contFechaDesde input-date-small datepicker" type="text" >
										</div>
									</div>
								</div>
							</div>

							<div class="span12">
								<div class="control-group span4" style="margin-left: -10px;">
									<label class="control-label">Estructura</label>
									<div class="controls contEstructura">
										<form:select class='selectpicker select-document contEstructuraCombo'  path ='id' multiple="false" placeholder="Seleccione un valor">
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
							</div>

						</div>
						<div class="span12" style="margin: 10px 0;">
							<hr style="background:#F87431; border:0; height:1px" />
						</div>

						<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

							<thead>
								<tr>
								<th>Contenido</th>
								<th>Cuenta</th>
								<th>Entidad</th>
								<th>Moneda</th>
								<th>Saldo</th>
								<th></th>
								<th>Saldo</th>
								
								</tr>
							</thead>
							<tbody>
							</tbody>

			</table>
			</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>