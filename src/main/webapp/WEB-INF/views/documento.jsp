<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Agregar Nuevo Documento</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">

					<!-- Row -->
					<div class="row-fluid">

						<div class="span7" style="width: 764px;">
							<div class="control-group"  >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
									<form:select class='contAdministracionCombo  span12 '  placeholder="Seleccione un valor" path="tipoEntidadId" style="width: 175px;">
										<option></option> 
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group contMoneda" style="width: 850px;">
								<div style="width:503px; float: left;">
									<label class="control-label">Descripci&oacute;n</label>
									<div class="controls">
										<textarea id="descripcion" maxlength= "50" name="descripcion" rows="2" cols="50" class="span8" style="width: 366px;margin: 0px; height: 105px;resize:none"></textarea>									
									</div>
								</div>
								<div style="width:280px; float: left;">
									<div class="span5" style="width: 200px;">
										<div class="control-group">
											<label class="control-label">Fecha Real</label>
											<div class="controls">								
												<input type="text" value="" class="contFechaReal datepicker span3" style="width: 85px;">  
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Fecha Ingreso</label>
											<div class="controls">								
												<input type="text" value="" class="contFechaIngreso datepicker span3" style="width: 85px;">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label">Fecha Vto</label>
											<div class="controls">
												<input type="text" value="" class="contFechaVto datepicker span3" style="width: 85px;">
											</div>
										</div>
									</div>
								</div>
							</div>								
							<div class="control-group" >
								<label class="control-label">Documento</label>
								<div class="controls contTipoDoc"  style="width: 764px;">

										<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span5'  path ='tipoDocumentoId' multiple="false" style="width: 175px;">
										</form:select>
										<select id="contNumeracion" name="estado" class="selectpicker span2 contLetra" disabled="disabled" placeholder="Letra" style="width: 75px;">
											<option></option>
											<option>A</option>
											<option>B</option>
											<option>C</option>
											<option>E</option>
											<option>X</option>
											</select> 
										<input class="span2 contEstablecimiento" type="text" readonly placeholder="Establecimiento" maxlength="4" style="margin-right: 5px;margin-left: 5px;width: 50px;">
										<input placeholder="A&ntilde;o" class="span2 contAnio" type="number" readonly style=" margin-right: 2px;width: 65px;">
										<input placeholder="Mes" class="span2 contMes" type="number" readonly style=" margin-right: 5px;width: 55px;">
										<input placeholder="Dia" class="span2 contDia" type="number" readonly style=" margin-right: 5px;width: 55px;">
										<input placeholder="Numero" class="span2 contNumeroFinal" maxlength="8" type="text" readonly style="width: 80px;">
								</div>
							</div>

							<div class="control-group" >
								<label class="control-label">Cuenta</label>
								<div class="controls contEntidad">
										<form:select id ="entidadCombo" class='contCuentaCombo selectpicker span5'  placeholder="Seleccione un valor" path ='entidadId' multiple="false" style="width: 175px;">
											<option></option> 
										</form:select> 
										<input class="contCuentaNombre span2" type="text" readonly style="width: 150px;margin-left: 8px;"> 
										<font size="4" style="margin: 0 10px;"> / </font>
										<input class="contTipoEntidad  span2" type="text" readonly style="width: 150px;">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select id ="monedaCombo" class='selectpicker span12'   placeholder="Seleccione un valor" path ='monedaId' multiple="false" style="width: 175px;">
										<option></option> 
									</form:select>
									<input id ="headerCotizacion" type="text" value="" class="span12" readonly style="width: 150px;margin-left: 8px;">							
								</div>
							</div>							

						</div>
						<div class="span5" style="width: 270px;background-color: #FAFAFA;padding: 10px 0 10px 10px;border-left: 1px dotted #ccc;">
							<div class="control-group">
								<label class="control-label">Total Imputaciones</label>
								<div class="controls">
									<input class="span8 contImputacionesTotal" type="text" value="0" readonly style=" width: 100px;">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Total Cancelaciones</label>
								<div class="controls">
									<input class="span8 contCancelacionesTotal" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Total Valores Propios</label>
								<div class="controls">
									<input class="span8 contPropiosTotal" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Total Egreso Valores</label>
								<div class="controls">
									<input class="span8 contEgresoTotal" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>

							<div class="control-group"  >
								<label class="control-label">Total Ingreso Valores</label>
								<div class="controls">
									<input class="span8 contIngresoTotal" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>

							<div class="control-group" >
								<label class="control-label">Debito</label>
								<div class="controls">
									<input class="span8 contDebito" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>

							<div class="control-group" >
								<label class="control-label">Credito</label>
								<div class="controls">
									<input class="span8 contCredito" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>

						</div>

						<BR>

						<div class="span10" style="margin-left: 0px !important; margin-top:20px; width: 100% !important;">
							<div class="wizard">
								<div class="widget widget-tabs widget-tabs-double">

									<!-- Widget heading -->
									<div class="widget-head">
										<ul>
											<li class="contEgreso active"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Egreso </span><span>Valores</span></a></li>
											<li class="contImputaciones"><a href="#newtab2-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Imputaciones</span><span></span></a></li>
											<li class="contCancelaciones"><a href="#newtab2-3" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Aplicaciones</span><span></span></a></li>
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
																<div class="span10">
																<table class="span10 egreso table table-bordered table-striped" style="width:100%">
																	<thead>
																		<tr>

																		<td class="center "><input type="checkbox" ></td>
																	        <th class="center span9">Id</th>
																			<th class="center span9">Numero</th>
																			<th class="center span9">Banco</th>
																			<th class="center span9">Cuenta</th>
																			<th class="center span9">Entidad</th>
																			<th class="center span9">Tipo Entidad</th>
																			<th class="center span3">Importe</th>
																		</tr>
																	</thead>
																	<tbody>



																	</tbody>

																</table>
																</div>
														<div class="span12">
															<textarea class="contCancelacionesAreaSeleccion" id="descripcion" name="descripcion" rows="4" cols="50" style="width: 546px;height: 100px" ></textarea>														</div>
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
																		<th></th>
																			<th class="center span3">Concepto</th>
																			<th class="center span3">Cuenta</th>
																			<th class="center span3">TipoEntidad</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripción</th>
																			<th class="center span5">Referencia</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Cotizacion</th>
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody id="contImputacionesBody">
																		<tr style='border:5px solid #427BD6'>
																		<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

																			<td class='contImputacionesConcepto'>
																				<form:select class='contImputacionesConceptoCombo span12 ' placeholder="Seleccione un valor"  path ='administracion.id'>
																						<option></option> 
																					<form:options items="${conceptosImpu}" itemValue="id" itemLabel="nombre" />
																			</form:select>
																			</td>
																		 	<td class='contImputacionesCuenta'></td>
																		 	<td class='contImputacionesTipoEntidad'></td>
																		    <td class='contImputacionesEntidad'></td>
																			<td class='contImputacionesDescripcion'></td>
																			<td class='contImputacionesReferencia'><input type="text" class="span12" maxlength="20"></td>
																			<td class='contImputacionesMoneda'></td>
																			<td class='contCotizacion'></td>

																			<td class='contImporte span12'><input type="text" min="0" value="0" class="span12" pattern="^\d+(\.\d{2})?$">
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
																		<th class="center span3"></th>

																			<th class="center span8">Documento</th>
																			<th class="center span2">Importe Aplicado</th>

																		</tr>
																	</thead>
																	<tbody id="contCancelacionesBody">
																		<tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

																			<td  ><select class="contCancelacionesCombo span10"  placeholder="Seleccione un valor" size="1" > </select></td>
																			<td class='contCancelacionPendiente'></td>
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
																		    <th class="center span3"></th>
																			<th class="center span3">Concepto</th>
																			<th class="center span3">Cuenta</th>
																			<th class="center span3">TipoEntidad</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripción</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Cotizacion</th>
																			<th class="center span2">Importe</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Beneficiario</th>
																			<th class="center span2">Fecha Vecimiento</th>
																		</tr>
																	</thead>
																	<tbody id="contPropiosBody">
																		<tr>
																		<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>
																			<td class='contImputacionesConcepto'>
																				<form:select class='contImputacionesConceptoCombo  span12 '  placeholder="Seleccione un valor" path="periodoId">
																						<option></option> 
																					<form:options items="${conceptosPropio}" itemValue="id" itemLabel="nombre" />
																			</form:select>
																			</td>

																			<td class='contImputacionesCuenta'></td>
																		 	<td class='contImputacionesTipoEntidad'></td>
																		    <td class='contImputacionesEntidad span10'></td>
																			<td class='contImputacionesDescripcion'></td>
																			<td class='contImputacionesMoneda'></td>
																			<td class='contCotizacion'></td>
																			<td class='contImporte span12'><input type="text" min="0" value="0" class="span12" pattern="^\d+(\.\d{2})?$"></td>
																			<td class='contImputacionesNumero'><input type="text" maxlength="11" class="span12"></td>
																			<td class='contImputacionesBeneficiario'><input type="text" value="" class="span12" maxlength="100"></td>
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
																			<th></th>
																			<th class="center span3">Concepto</th>
																			<th class="center span3">Cuenta</th>
																			<th class="center span3">TipoEntidad</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span5">Descripción</th>
																			<th class="center span2">Moneda</th>
																			<th class="center span2">Cotizacion</th>
																			<th class="center span2">Importe</th>
																			<th class="center span2">Banco</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Fecha Vecimiento</th>
																		</tr>
																	</thead>
																	<tbody id="contIngresoBody">
																		<tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

																		    <td class='contImputacionesConcepto'>
																				<form:select class='contImputacionesConceptoCombo  span12 '  placeholder="Seleccione un valor"  path ='periodoId'>
																						<option></option> 
																					<form:options items="${conceptosTercero}" itemValue="id" itemLabel="nombre" />
																			</form:select>
																			</td>

																			<td class='contImputacionesCuenta'></td>
																		 	<td class='contImputacionesTipoEntidad'></td>
																		    <td class='contImputacionesEntidad'></td>
																			<td class='contImputacionesDescripcion'></td>
																			<td class='contImputacionesMoneda'></td>
																			<td class='contCotizacion'></td>
																			<td class='contImporte span12'><input type="text" min="0" value="0" class="span12" pattern="^\d+(\.\d{2})?$"></td>
																			<td class='contImputacionesBanco'>
																				<form:select class='span10 contImputacionesBancoCombo selectpicker'  placeholder="Seleccione" path='cuentaId' multiple="false">
																					<option></option> 
																					<form:options items="${bancos}" itemValue="id" itemLabel="nombre" />
																				</form:select></td>
																			<td class='contImputacionesNumero'><input type="number" min="1" value="1" class="span12"></td>
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



						<div class="span12">

							<hr class="separator span12">

							<!-- Form actions -->
							<div class="form-actions">
							<button class =" save btn btn-icon btn-primary glyphicons circle_ok guardar" type="button">Guardar Documento</button>
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
