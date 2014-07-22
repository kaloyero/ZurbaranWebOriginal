<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Valores Propios</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

					<div class="span12">
						<div class="control-group"  >
							<label class="control-label">Administracion</label>
							<div class="controls contAdministracion">
								<form:select class='selectpicker select-document contAdministracionCombo'  path ='id' multiple="false" placeholder="Seleccione un valor">
								<option></option>
								<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
								</form:select>
							</div>
						</div>

						<div class="control-group" >
							<label class="control-label">Cuenta</label>
							<div class="controls">
								<div class="span3">
									<select id="contCuentaCombo" name="estado" class="selectpicker contLetra select-document span12" placeholder="Seleccione un valor">
											<option></option>
									</select>
									<font size="4" style="margin-left: 12px;"> / </font>
								</div>
								<input id ="contTipoEntidadInput" type="text" value="" class="input-document" disabled>
								<input id ="contTipoEntidadId" type="hidden" value="" class="input-document" disabled>
								<select id="entidadCombo" placeholder="Seleccione un valor" class="select-document">
								<option></option>
								</select>
							</div>
						</div>		
										
						<div class="control-group" >
							<label class="control-label">Moneda</label>
							<div class="controls contTipoDoc">
								<form:select class='selectpicker select-document contMonedaCombo'  path ='id' multiple="false"  placeholder="Seleccione un valor">
								<option></option>
								<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
							</form:select>
							</div>
					</div>
				<div class="control-group" >
					<label class="control-label">Vto Desde:</label>
					<div class="controls contEntidad" >
						<div class="span7">
							<input class="contVencimientoDesde input-date-small input-marginRight datepicker" type="text" > Hasta : <input class="contVencimientoHasta input-date-small input-marginRight datepicker" type="text" >

						</div>

					</div>
				</div>

				<div class="control-group" >
					<label class="control-label">Emitido desde:</label>
					<div class="controls contEntidad" >
						<div class="span7">
							<input class="contEmitidoDesde input-date-small input-marginRight datepicker" type="text" > Hasta : <input class="contEmitidoHasta input-date-small input-marginRight datepicker" type="text" > <button class ="contBuscar save btn btn-danger guardar" type="button" style="margin-left: 200px;">Buscar</button>											
						</div>

					</div>
				</div>
											<div class="span12" style="margin: 10px 0;">
								<hr style="background:#F87431; border:0; height:1px" />
							</div>


						</div>
						

						

				


		</div>

			<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Id</th>
						<th>Numero</th>
						<th>Fecha Vto</th>
						<th>Cuenta</th>
						<th>Entidad</th>
						<th>Estado</th>
						<th>Moneda</th>
						<th>Importe</th>
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
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>