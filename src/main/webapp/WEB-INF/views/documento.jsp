<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3> Documento</h3>
	<div class="buttons pull-right">
		<a href="#" class="nuevo btn btn-primary btn-icon glyphicons circle_plus"><i></i> Nuevo</a>
	</div>
	<div class="clearfix"></div>
</div>
<div class="innerLR">

	<!-- Widget -->
	<div class="widget">

		<!-- Widget heading -->
		<div class="widget-head">
			<h4 class="heading">Listado</h4>
		</div>
		<!-- // Widget heading END -->

		<div class="widget-body">

			<!-- Table -->
			<table id="configurationTable"
				class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Id</th>
						<th>Administracion</th>
						<th>Codigo</th>
						<th>Nombre</th>
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>

					<!-- // Table row END -->

				</tbody>
				<!-- // Table body END -->

			</table>
			<!-- // Table END -->

		</div>
	</div>
	<!-- // Widget END -->


	<!-- Widget -->




</div>

<div class="span11 contNew modal hide fade"  style="left: 20% !important;" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">			

			<!-- Widget -->
			<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Agregar Nuevo Documento</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span7">
							<div class="control-group">
								<label class="control-label">Administracion</label>
								<div class="controls">
									<form:select class='contAdministracionCombo selectpicker span12'  path ='administracionId' multiple="false">
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Documento</label>
								<div class="controls">
										<form:select class='selectpicker span5'  path ='tipoDocumentoId' multiple="false">
											<form:options items="${tipoDocumentos}" itemValue="id" itemLabel="nombre" />
										</form:select>
										<input class="span6" type="text">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
									<div class="span7">
										<input class="span7" type="text"> <font size="4"> / </font> <input class="span4" type="text">
									</div>
									<form:select id ="cuentaCombo" class='contCuentaCombo selectpicker span5'  path ='cuentaId' multiple="false">
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Descripci�n</label>
								<div class="controls">
									<textarea id="descripcion" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; height: 100px;"></textarea>									
								</div>
							</div>
						</div>
						<div class="span5">
							<div class="control-group">
								<label class="control-label">Fecha Real</label>
								<div class="controls">
									<input type="text" id="datepicker" value="" class="hasDatepicker span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fecha Ingreso</label>
								<div class="controls">
									<input type="text" id="datepicker" value="" class="hasDatepicker span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fecha Vto</label>
								<div class="controls">
									<input type="text" id="datepicker" value="" class="hasDatepicker span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select id ="monedaCombo" class='selectpicker span12'  path ='monedaId' multiple="false">
										<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>

						</div>
						
						<BR>
						
						<div class="span10" style="margin-left: 0px !important;">
							<div class="wizard">
								<div class="widget widget-tabs widget-tabs-double">
								
									<!-- Widget heading -->
									<div class="widget-head">
										<ul>
											<li class="active"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Cancelaciones</span><span></span></a></li>
											<li><a href="#newtab2-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Imputaciones</span><span></span></a></li>
											<li><a href="#newtab2-3" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Egreso</span><span>de Valores</span></a></li>
											<li><a href="#newtab2-4" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Valores</span><span>Propios</span></a></li>
											<li><a href="#newtab2-5" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Ingreso</span><span>de Valores</span></a></li>
										</ul>
									</div>
									<!-- // Widget heading END -->
									
									<div class="widget-body">
										<div class="tab-content">
										
											<!-- Step 1 -->
											<div class="tab-pane active" id="newtab1-2">
												<div class="row-fluid">
																<!-- Table -->
																<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span9">Documento</th>
																			<th class="center span3">Importe</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td ></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td ></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td class="center"></td>
																			<td></td>
																		</tr>
																	</tbody>
																	
																</table>
														
												</div>
											</div>
											<!-- // Step 1 END -->
											
											<!-- Step 2 -->
											<div class="tab-pane" id="newtab2-2">
												<div class="row-fluid">
																<!-- Table -->
																<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span3">Concepto</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripci�n</th>
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td class="center"></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																	</tbody>
																	
																</table>
												</div>
											</div>
											<!-- // Step 2 END -->
											<!-- Step 3 -->
											<div class="tab-pane" id="newtab2-3">
												<div class="row-fluid">

																<!-- Table -->
																<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span2">Concepto</th>
																			<th class="center span2">Tipo</th>
																			<th class="center span2">Banco</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Fecha Vto</th>
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td class="center"></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																	</tbody>
																	
																</table>


												</div>
											</div>
											<!-- // Step 3 END -->
											<!-- Step 4 -->
											<div class="tab-pane" id="newtab2-4">
												<div class="row-fluid">

																<!-- Table -->
																<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span2">Concepto</th>
																			<th class="center span2">Tipo</th>
																			<th class="center span2">Banco</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Fecha Vto</th>
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td class="center"></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																	</tbody>
																</table>
												</div>
											</div>
											<!-- // Step 4 END -->
											<!-- Step 5 -->
											<div class="tab-pane" id="newtab2-5">
												<div class="row-fluid">

																<!-- Table -->
																<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span2">Concepto</th>
																			<th class="center span2">Tipo</th>
																			<th class="center span2">Banco</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Fecha Vto</th>
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td ></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																		<tr>
																			<td class="center"></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																			<td></td>
																		</tr>
																	</tbody>
																</table>
												</div>
											</div>
											<!-- // Step 5 END -->
											
									</div>
								</div>
							</div>
						</div>						
						</div>

						<div class="span2">
							<div class="control-group">
								<div class="widget" style="height: 148px;">
								
								</div>
							</div>
						</div>

						<div class="span10">
							<div class="control-group">
								<label class="control-label">Total</label>
								<div class="controls">
									<input class="span6" type="text">
								</div>
							</div>
						</div>
						<div class="span2">
							<div class="control-group">

							</div>
						</div>

						
						<div class="span12">

							<hr class="separator span12">
		
							<!-- Form actions -->
							<div class="form-actions">
								<button type="submit"
									class="save btn btn-icon btn-primary glyphicons circle_ok">
									<i></i>Save
								</button>
								<button type="button"
									class="btn btn-icon btn-default glyphicons circle_remove">
									<i></i>Cancel
								</button>
							</div>
						</div>

					</div>


				</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>