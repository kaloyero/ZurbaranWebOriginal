<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Estructura" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Valores de Tercero</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span12">
							<div class="control-group"  >
								<div class="span5">
									<label class="control-label">Administracion</label>
									<div class="controls contAdministracion">
										<form:select class='selectpicker span12 contAdministracionCombo select-document'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
										</form:select>
									</div>
								</div>
								<div class="span4" style="margin-left: -1px;">
									<label class="control-label">Banco</label>
									<div class="controls ">
										<form:select class='selectpicker contBancoCombo select-document'  path ='id' multiple="false" placeholder="Seleccione un valor">
										<option></option>
										<form:options items="${bancos}" itemValue="id" itemLabel="nombre" />
										</form:select>
									</div>
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
								<label class="control-label"></label>
								<div class="controls contEntidad" >
									<div class="span1">
										<div class="span12">
											<label class="radio " style="padding-left: 20px;">
												<input id ="cartera" name="Tipo" type="radio" value="" checked="checked">
												<span style="margin-left: -100px;">En cartera</span>
											</label> 
										</div>
										<div class="span12">
											<label class="radio " style="padding-left: 18px;">
												<input id ="deposito" name="Tipo" type="radio" value="" >
												<span style="margin-left: -100px;">Fecha Vto.</span>
											</label>
										</div>
									</div>
									<div class="span5 contEntidad" style="margin-top:15px;">	
										Vto. Desde: <input class="contVencimientoDesde span5 datepicker input-date-small input-marginRight" type="text" > Hasta :<input class="contVencimientoHasta span5 datepicker input-date-small input-marginLeft" type="text" style="margin-right:28px;">

									</div>
								</div>
								<div class="control-group span3" style="margin-left: -70px;">
									<label class="control-label"></label>
									<div class="controls " >
										<div class="span3">
											<button class ="contBuscar save btn btn-danger guardar" type="button" style="margin-top:15px">Buscar</button>
										</div>
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
						<th>Tipo Documento</th>
						<th>Numero</th>
						<th>Fecha Vto</th>
						<th>Cuenta</th>
						<th>Tipo Entidad</th>
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