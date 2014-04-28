<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Valores de Terceros</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span7">
							<div class="control-group"  >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
								<select id="contNumeracion" name="estado" class="selectpicker span8 contLetra">
																			<option></option>
																			<option>X</option>
																			<option>A</option>
																			<option>B</option>
																			<option>C</option>
																			<option>E</option>
										</select>
								</div>
							</div>
				
							<div class="control-group" >
								<label class="control-label">Cuenta</label>
								<div class="controls contEntidad" >
									<div class="span7">
										<input class="contCuentaNombre span3" type="text" > <font size="4"> / </font> <input class="contTipoEntidad  span3" type="text" >
										<select id="contNumeracion" name="estado" class="selectpicker span5 contLetra">
																			<option></option>
																			<option>X</option>
																			<option>A</option>
																			<option>B</option>
																			<option>C</option>
																			<option>E</option>
										</select>
									</div>
									
								</div>
							</div>

							<div class="control-group" >
								<label class="control-label">Emitido</label>
								<div class="controls contEntidad" >
									<div class="span7">
										<input class="contCuentaNombre span3" type="text" > <font size="4"> / </font> <input class="contTipoEntidad  span3" type="text" >
										<select id="contNumeracion" name="estado" class="selectpicker span5 contLetra">
																			<option></option>
																			<option>X</option>
																			<option>A</option>
																			<option>B</option>
																			<option>C</option>
																			<option>E</option>
										</select>
									</div>
									
								</div>
							</div>
								</div>
						<div class="span5">
							
							<div class="control-group">
								<label class="control-label">Emision</label>
								<div class="controls">
									<input id ="tipoMovimiento" type="text" value="" class="span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Hasta</label>
								<div class="controls">
									<input id ="tipoMovimiento" type="text" value="" class="span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Vencimiento</label>
								<div class="controls">
									<input id ="tipoMovimiento" type="text" value="" class="span12">
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
						<th>Fecha Ingreso</th>
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