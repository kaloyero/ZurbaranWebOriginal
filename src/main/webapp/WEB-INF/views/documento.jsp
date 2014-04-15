<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >
<form:select class='span10 contImputacionesBancoCombo selectpicker' style="visibility: hidden" path='cuentaId' multiple="false">
																					<form:options items="${conceptos}" itemValue="id" itemLabel="nombre" />
																				</form:select>
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
									<form:select class='contAdministracionCombo  span12 '  placeholder="Seleccione un valor"  style="width: 100%;" path ='administracion.id'>
																						<option></option> 
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Documento</label>
								<div class="controls">
										
										<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span5'  path ='tipoDocumentoId' multiple="false">
																																<option></option> 
										
										</form:select>
										<input class="span6" type="text">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
									<div class="span7">
										<input class="span7 contCuentaId" type="text" readonly> <font size="4"> / </font> <input class="contCuentaNombre span4" type="text" readonly>
									</div>
									<form:select id ="entidadCombo" class='contCuentaCombo selectpicker span5'  placeholder="Seleccione un valor" path ='entidadId' multiple="false">
									
																						<option></option> 
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Descripción</label>
								<div class="controls">
									<textarea id="descripcion" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; height: 100px;"></textarea>									
								</div>
							</div>
						</div>
						<div class="span5">
							<div class="control-group">
								<label class="control-label">Fecha Real</label>
								<div class="controls">								
									<input type="text" value="" class="contFechaReal datepicker span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fecha Ingreso</label>
								<div class="controls">
									<input type="text" value="" class="contFechaIngreso datepicker span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fecha Vto</label>
								<div class="controls">
									<input type="text" value="" class="contFechaVto datepicker span12">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select id ="monedaCombo" class='selectpicker span12'   placeholder="Seleccione un valor" path ='monedaId' multiple="false">
																						<option></option> 
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Cotizacion</label>
								<div class="controls">
									<input id ="headerCotizacion" type="text" value="" class="span12" readonly>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">TipoMovimiento</label>
								<div class="controls">
									<input id ="tipoMovimiento" type="text" value="" class="span12" readonly>
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
											<li class="contEgreso active"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Egreso </span><span>Valores</span></a></li>
											<li class="contImputaciones"><a href="#newtab2-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Imputaciones</span><span></span></a></li>
											<li class="contCancelaciones"><a href="#newtab2-3" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Cancelaciones</span><span></span></a></li>
											<li class="contValores"><a href="#newtab2-4" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Valores</span><span>Propios</span></a></li>
											<li class="contIngreso"><a href="#newtab2-5" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Ingreso</span><span>de Valores</span></a></li>
										</ul>
									</div>
									<!-- // Widget heading END -->
									
									<div class="widget-body">
										<div class="tab-content">
										
											<!-- Step 1 -->
											<div class="tab-pane active" id="newtab1-2">
												<div class="row-fluid">
																<!-- Table -->
																<div class="span7">
																<table class="span7 egreso table table-bordered table-striped">
																	<thead>
																		<tr>
																		
																		<td class="center "><input type="checkbox" ></td>
																			<th class="center span9">Numero</th>
																			<th class="center span9">Banco</th>
																			<th class="center span9">Emisor</th>
																			<th class="center span3">Importe</th>
																		</tr>
																	</thead>
																	<tbody>
																	

																	</tbody>
																	
																</table>
																</div>
														<div class="controls span3">
															<textarea class="contCancelacionesAreaSeleccion" id="descripcion" name="descripcion" rows="4" cols="50" style="width: 246px;height: 226px" ></textarea>														</div>
														</div>
											</div>
											<!-- // Step 1 END -->
											
											<!-- Step 2 -->
											<div class="tab-pane" id="newtab2-2">
												<div class="row-fluid">
																<!-- Table -->
																<table id="contImputaciones" class="table table-bordered table-striped">
<thead>
																		<tr>
																			<th class="center span3">Concepto</th>
																			<th class="center span3">Cuenta</th>
																			<th class="center span3">TipoEntidad</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripción</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Cotizacion</th>
																			<th class="center span2">Tipo Movimiento</th>
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody id="contImputacionesBody">
																		<tr>
																			<td class='contImputacionesConcepto'>
																				<form:select class='contImputacionesConceptoCombo span12 ' placeholder="Seleccione un valor"  path ='administracion.id'>
																						<option></option> 
																					<form:options items="${conceptos}" itemValue="id" itemLabel="nombre" />
																			</form:select>
																			</td>
																		 	<td class='contImputacionesCuenta'></td>
																		 	<td class='contImputacionesTipoEntidad'></td>
																		    <td class='contImputacionesEntidad'></td>
																			<td class='contImputacionesDescripcion'></td>
																			<td class='contImputacionesMoneda'></td>
																			<td class='contCotizacion'></td>
																			<td class='contImputacionesTipoMovimiento'></td>
																			
																			<td class='contImporte'><input type="number" min="1" value="1" class="span12">
																			</td>
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
																			<th class="center span8">Documento</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Importe</th>
																			<th class="center span2">Importe Total</th>
																			<th class="center span2">Importe Aplicado</th>
																			<th class="center span2">Importe Pendiente</th>
																			
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td ><select class="contCancelacionesCombo span10"  placeholder="Seleccione un valor" size="1" ><option></option> </select></td>
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
																<table id="contPropios" class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span3">Concepto</th>
																			<th class="center span3">Cuenta</th>
																			<th class="center span3">TipoEntidad</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripción</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Cotizacion</th>
																			<th class="center span2">Tipo Movimiento</th>
																			<th class="center span2">Importe</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Beneficiario</th>
																			<th class="center span2">Fecha Vecimiento</th>
																		</tr>
																	</thead>
																	<tbody id="contPropiosBody">
																		<tr>
																			<td class='contImputacionesConcepto'>
																				<form:select class='contImputacionesConceptoCombo  span12 '  placeholder="Seleccione un valor" path ='administracion.id'>
																						<option></option> 
																					<form:options items="${conceptos}" itemValue="id" itemLabel="nombre" />
																			</form:select>
																			</td>

																			<td class='contImputacionesCuenta'></td>
																		 	<td class='contImputacionesTipoEntidad'></td>
																		    <td class='contImputacionesEntidad'></td>
																			<td class='contImputacionesDescripcion'></td>
																			<td class='contImputacionesMoneda'></td>
																			<td class='contCotizacion'></td>
																			<td class='contImputacionesTipoMovimiento'></td>
																			<td class='contImporte'><input type="number" min="1" value="1" class="span12">
																			<td class='contImputacionesNumero'><input type="number" min="1" value="1" class="span12"></td>
																			<td class='contImputacionesBeneficiario'><input type="text" value="" class="span12"></td>
																			<td class='contImputacionesFechaVto'><input type="text" value="" class="datepicker span12">
																			</td>

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
																<table id="contIngreso" class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th class="center span3">Concepto</th>
																			<th class="center span3">Cuenta</th>
																			<th class="center span3">TipoEntidad</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripción</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Cotizacion</th>
																			<th class="center span2">Tipo Movimiento</th>
																			<th class="center span2">Importe</th>
																			<th class="center span2">Bancoooo</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Fecha Vecimiento</th>
																		</tr>
																	</thead>
																	<tbody id="contIngresoBody">
																		<tr>
																		    <td class='contImputacionesConcepto'>
																				<form:select class='contImputacionesConceptoCombo  span12 '  placeholder="Seleccione un valor"  path ='administracion.id'>
																						<option></option> 
																					<form:options items="${conceptos}" itemValue="id" itemLabel="nombre" />
																			</form:select>
																			</td>

																			<td class='contImputacionesCuenta'></td>
																		 	<td class='contImputacionesTipoEntidad'></td>
																		    <td class='contImputacionesEntidad'></td>
																			<td class='contImputacionesDescripcion'></td>
																			<td class='contImputacionesMoneda'></td>
																			<td class='contCotizacion'></td>
																			<td class='contImputacionesTipoMovimiento'></td>
																			<td class='contImporte'><input type="number" min="1" value="1" class="span12">
																			<td class='contImputacionesBanco'>
																				<form:select class='span10 contImputacionesBancoCombo selectpicker'  path='cuentaId' multiple="false">
																					<form:options items="${bancos}" itemValue="id" itemLabel="nombre" />
																				</form:select></td>
																			<td class='contImputacionesNumero'><input type="text" value="" class="span12"></td>
																			<td class='contImputacionesFechaVto'><input type="text" value="" class="datepicker span12">
																			</td>
																			
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
								
							</div>
						</div>

						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Imputaciones</label>
								<div class="controls">
									<input class="span3 contImputacionesTotal" type="text" value="0">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Cancelaciones</label>
								<div class="controls">
									<input class="span3 contCancelacionesTotal" type="text"  value="0">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Valores Propios</label>
								<div class="controls">
									<input class="span3 contPropiosTotal" type="text"  value="0">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Egreso Valores</label>
								<div class="controls">
									<input class="span3 contEgresoTotal" type="text"  value="0">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Ingreso Valores</label>
								<div class="controls">
									<input class="span3 contIngresoTotal" type="text"  value="0">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Debito</label>
								<div class="controls">
									<input class="span3 contDebito" type="text"  value="0">
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Credito</label>
								<div class="controls">
									<input class="span3 contCredito" type="text"  value="0">
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
						<button class ="guardar" type="button">Prueba Guardar!</button>
						

					</div>


				</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>