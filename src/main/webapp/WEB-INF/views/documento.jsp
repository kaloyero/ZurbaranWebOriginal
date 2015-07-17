<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style type="text/css">
.select-document {width: 210px !important;}
input.fechaDocumento{width: 80px !important}
.input-document-cuentaEntidad{width: 189px !important}
.estiloAlerta{color: red !important}

</style>

<div class="span12 contNew "  style="left: 0% !important;width:100%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

		<!-- Widget -->
		<div class="widget" >

			<!-- Widget heading -->
			<div class="widget-head">
				<h4 class="heading">Agregar Documento</h4>
			</div>

			<div class="widget-body">

				<!-- Row -->
				<div class="row-fluid" style="background:#e5e5e5">
				
				<input type="hidden" value="" class="fechaDefault">								
				
					<div class="span8"  style="padding-right: 20px;padding-top: 22px;">
						<div class="control-group">
							<div class="span8">
								<div class="control-group" style="padding: 3px 0;">
									<label class="control-label document-bold">Administraci&oacute;n</label>
									<div class="controls contAdministracion">
										<form:select class='contAdministracionCombo select-document'  placeholder="Seleccione un valor" path="tipoEntidadId">
										<option></option> 
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
										</form:select>
									</div>
								</div> 	
								<label class="control-label document-bold">Descripci&oacute;n</label>
								<div class="controls" style="padding: 3px 0 5px 0;">
									<textarea id="descripcion" maxlength= "200" name="descripcion" rows="2" cols="50" class="span12" style="margin: 0px; resize:none"></textarea>
								</div>
							</div>
							<div class="span3">
								<div class="control-group">
									<label class="control-label document-bold">Fecha Real</label>
									<div class="controls">								
										<input type="text" value="${fecha}" class="contFechaReal datepicker fechaDocumento">  
									</div>
								</div>
								<div class="control-group">
									<label class="control-label document-bold">Fecha Ingreso</label>
									<div class="controls">								
										<input type="text" value="" class="contFechaIngreso datepicker fechaDocumento" >
									</div>
								</div>
								<div class="control-group">
									<label class="control-label document-bold" >Fecha Vto</label>
									<div class="controls">
										<input type="text" value="" class="contFechaVto datepicker fechaDocumento">
									</div>
								</div>
							</div>
						</div>								
						<div class="control-group" style="padding: 3px 0;">
							<label class="control-label document-bold">Documento</label>
							<div class="controls contTipoDoc">
								<form:select id="tipoDocumentoCombo" placeholder="Seleccione un valor" class='contTipoDocCombo selectpicker span5 select-document'  path ='tipoDocumentoId' multiple="false">
								</form:select>
								<select id="contNumeracion" name="estado" class="selectpicker span2 contLetra ducument-numeroLetra" disabled="disabled" placeholder="Letra">
									<option></option>
									<option>A</option>
									<option>B</option>
									<option>C</option>
									<option>E</option>
									<option>X</option>
								</select> 
								<input class="span2 contEstablecimiento ducument-numeroEstablecimiento" type="text" readonly placeholder="Establecimiento" maxlength="4" style="margin-right: 5px;margin-left: 5px;width: 50px;">
								<input placeholder="A&ntilde;o" class="span2 contAnio ducument-numeroAno" type="number" readonly style=" margin-right: 2px;">
								<input placeholder="Mes" class="span2 contMes  ducument-numeroMes" type="number" readonly max="12" min="1" style=" margin-right: 5px;">
								<input placeholder="Dia" class="span2 contDia ducument-numeroDia" type="number" readonly max="31" min="1" style=" margin-right: 5px;">
								<input placeholder="Numero" class="span2 contNumeroFinal ducument-numero" maxlength="8" type="text" readonly >
							</div>
						</div>
						<div class="control-group" >
							<label class="control-label document-bold">Cuenta</label>
							<div class="controls contEntidad">
								<input class="contCuentaNombre span2 input-document-cuentaEntidad input-readOnly" type="text" style="
    width: 210px !important;
" > 
								<font size="4" style="margin: 0 05px;"> / </font>
								<input class="contTipoEntidad  span2 input-document-cuentaEntidad input-readOnly" type="text" readonly >
								<form:select id ="entidadCombo" class='contCuentaCombo selectpicker select-document'  placeholder="Seleccione un valor" path ='entidadId' multiple="false">
									<option></option> 
								</form:select> 
							</div>
						</div>
						<div class="control-group" id="grupoMonedas">
							<label class="control-label document-bold">Moneda</label>
							<div class="controls contMoneda">
								<form:select id ="monedaCombo" class='selectpicker span12 select-document'   placeholder="Seleccione un valor" path ='monedaId' multiple="false">
								<option></option> 
								</form:select>
								<input id ="headerCotizacion" type="text" value="" class="span12 input-document-cotizacion" readonly style="margin-left: 8px;">							
								<input id ="tipoMovimiento" type="hidden" value="" class="span12" readonly style="width: 150px;margin-left: 8px;">	
								<input type="hidden" value="" class="span12 contCuentaId">								
							</div>
						</div>							
					</div>
					<div class="span4 document-totales" >
						<div style="height: 210px; ">
							<div id="contImputacionesTotalLabel" class="control-group input-totales">
								<label class="control-label" id='contLabelImputacionTotal2' style="width:128px;">Total Imputaciones</label>
								<div class="controls">
									<input id='contLabelImputacionTotal' class="span1 " type="text" value="" readonly="readonly"  style="width: 35px;font-size: smaller; margin-left: -10px">
									<input class="span8 contImputacionesTotal input-readOnly campo-importe" type="text" value="0" readonly="readonly" >
								</div>
							</div>
							<div id="contCancelacionesTotalLabel" class="control-group input-totales">
								<label class="control-label" style="width:128px;"  >Total Cancelaciones</label>
								<div class="controls" >
									<input id='contLabelCancelacionTotal' class="span1 " type="text" value="" readonly="readonly"  style="  width: 35px;font-size: smaller; margin-left: -10px">
								
									<input class="span8 contCancelacionesTotal input-readOnly campo-importe" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>
	
							<div id="contPropiosTotalLabel" class="control-group input-totales">
								<label class="control-label"  style="width:128px;" >Total Valores Propios</label>
								<div class="controls" >
									<input id='contLabelPropioTotal'class="span1 " type="text" value="" readonly="readonly"  style="  width: 35px;font-size: smaller; margin-left: -10px">
								
									<input class="span8 contPropiosTotal input-readOnly campo-importe" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>
	
							<div id="contEgresoTotalLabel" class="control-group input-totales">
								<label class="control-label" style="width:128px;" >Total Egreso Valores</label>
								<div class="controls" >
									<input id='contLabelEgresoTotal' class="span1 " type="text" value="" readonly="readonly"  style="width: 35px;font-size: smaller; margin-left: -10px">
								
									<input class="span8 contEgresoTotal input-readOnly campo-importe" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>
	
							<div id="contIngresoTotalLabel" class="control-group"  >
								<label class="control-label" style="width:128px;" >Total Ingreso Valores</label>
								<div class="controls" >
								<input id='contLabelIngresoTotal' class="span1 " type="text" value="" readonly="readonly"  style="width: 35px;font-size: smaller; margin-left: -10px">
									<input class="span8 contIngresoTotal input-readOnly campo-importe" type="text"  value="0" readonly style=" width: 100px;">
								</div>
							</div>
						</div>
						<div class="control-group input-totales" >
							<label class="control-label" style="width:128px;" >Debito</label>
							<div class="controls">
								<input id='contLabelDebitoTotal' class="span1 " type="text" value="" readonly="readonly"  style="width: 35px;font-size: smaller; margin-left: -10px">
								<input class="span8 contDebito campo-importe" type="text"  value="0" readonly style=" width: 100px;">
							</div>
						</div>

						<div class="control-group" >
							<label class="control-label" style="width:128px;">Credito</label>
							<div class="controls">
									<input id='contLabelCreditoTotal' class="span1 " type="text" value="" readonly="readonly"  style="width: 35px;font-size: smaller; margin-left: -10px">
								<input class="span8 contCredito campo-importe" type="text"  value="0" readonly style=" width: 100px;">
							</div>
						</div>
					</div>

	<BR>

		<div class="span10 document-tabla">
			<div class="wizard">
				<div class="widget widget-tabs widget-tabs-double">

					<!-- Widget heading -->
					<div class="widget-head">
						<ul>
							<li class="contEgreso"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Egreso </span><span>Valores</span></a></li>
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
							<div class="tab-pane" id="newtab1-2">
								<div class="row-fluid">
									<!-- Table -->
									<div class="span9">
										<table class="span12 egreso table table-bordered table-striped table-document-tabegreso">
											<thead>
												<tr>
													<td class="center col1"><input type="checkbox" ></td>
													<th class="center col2">Id</th>
													<th class="center col3">Numero</th>
													<th class="center col4">Banco</th>
													<th class="center col5">Cuenta</th>
													<th class="center col6">Entidad</th>
													<th class="center col7">Tipo Entidad</th>
													<th class="center col7">Moneda</th>
													<th class="center col7">Cotizaci&oacute;n</th>
													<th class="center col8">Importe</th>
												</tr>
											</thead>
											<tbody>
											</tbody>

										</table>
									</div>
									<div class="span3">
										<div style="padding:5px 0 !important; font-weight: bold !important;"> Valores seleccionados</div>
										<textarea class="contCancelacionesAreaSeleccion span12" id="descripcion" name="descripcion" rows="4" cols="50" style="min-height: 173px; width:300px !important;padding-left: 5px;padding-top: 3px;overflow-y: scroll;border-color: #EEEEEE;" ></textarea>														</div>
									</div>
								</div>
								<!-- // Step 1 END -->

								<!-- Step 2 -->
								<div class="tab-pane" id="newtab2-2">
									<div class="row-fluid">
										<!-- Table -->
										<table id="contImputaciones" class="table table-bordered table-striped table-document-imputaciones">
											<thead>
												<tr>
													<th class="center col0"></th>
													<th class="center col1">Concepto</th>
													<th class="center col2">Cuenta</th>
													<th class="center col3">TipoEntidad</th>
													<th class="center col4">Entidad</th>
													<th class="center col5">Referencia</th>
													<th class="center col6">Moneda</th>
													<th class="center col7">Cotizaci&oacute;n</th>
													<th class="center col8">Importe</th>
												</tr>
											</thead>
											<tbody id="contImputacionesBody">
												<tr style='border:5px solid #427BD6'>
													<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

													<td class='contImputacionesConcepto'>
														<form:select class='contImputacionesConceptoCombo span12 ' placeholder="Seleccione un valor"  path ='administracion.id'>
														<option></option> 
													</form:select>
												</td>
												<td class='contImputacionesCuenta'></td>
												<td class='contImputacionesTipoEntidad'></td>
												<td class='contImputacionesEntidad'></td>
												<td class='contImputacionesReferencia'><input type="text" class="span12" maxlength="50"></td>
												<td class='contImputacionesMoneda'></td>
												<td class='contCotizacion'></td>

												<td class='contImporte'><input type="text" min="0"  class="campo-importe" pattern="^\d+(\.\d{2})?$">
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
									<table class="table table-bordered table-striped table-document-aplicaciones">
										<thead>
											<tr>
												<th class="center span1 col0"></th>
												<th class="center span12">Documento</th>
												<th class="center campo-importe ">Importe Aplicado</th>

											</tr>
										</thead>
										<tbody id="contCancelacionesBody">
											<tr>
												<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

												<td  ><select class="contCancelacionesCombo span12" style="width:700px;" placeholder="Seleccione un valor" size="1" > 
													<option></option>
												</select></td>
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
									<table id="contPropios" class="table table-bordered table-striped table-document-valores">
										<thead>
											<tr>
												<th class="center col0"></th>
												<th class="center col2">Concepto</th>
												<th class="center col3">Cuenta</th>
												<th class="center col4">Tipo Entidad</th>
												<th class="center col5">Entidad</th>
												<th class="center col6">Descripci&oacute;n</th>
												<th class="center col7">Moneda</th>
												<th class="center col8">Cotizaci&oacute;n</th>
												<th class="center col9">Importe</th>
												<th class="center col10">Numero</th>
												<th class="center col11">Beneficiario</th>
												<th class="center col12">Fecha Vto</th>
											</tr>
										</thead>
										<tbody id="contPropiosBody">
											<tr>
												<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>
												<td class='contImputacionesConcepto'>
													<form:select class='contImputacionesConceptoCombo  span12 '  placeholder="Seleccione un valor" path="periodoId">
													<option></option> 
												</form:select>
											</td>

											<td class='contImputacionesCuenta'></td>
											<td class='contImputacionesTipoEntidad'></td>
											<td class='contImputacionesEntidad span10'></td>
											<td class='contImputacionesDescripcion'></td>
											<td class='contImputacionesMoneda'></td>
											<td class='contCotizacion'></td>
											<td class='contImporte campo-importe'><input type="text" min="0"  class="campo-importe" pattern="^\d+(\.\d{2})?$"></td>
											<td class='contPropioNumero'><input type="text" maxlength="10" class="span12" ></td>
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
								<table id="contIngreso" class="table table-bordered table-striped table-document-tabingreso">
									<thead>
										<tr>
											<th class="center span3 col0"></th>
											<th class="center span3 col1">Concepto</th>
											<th class="center span3 col2">Cuenta</th>
											<th class="center span5 col3">Tipo Entidad</th>
											<th class="center span2 col4">Entidad</th>
											<th class="center span5 col5">Descripci&oacute;n</th>
											<th class="center span2 col6">Moneda</th>
											<th class="center span2 col7">Cotizaci&oacute;n</th>
											<th class="center col8">Importe</th>
											<th class="center span5 col9">Banco</th>
											<th class="center span2 col10">Numero</th>
											<th class="center span5 col11">Fecha Vto</th>
										</tr>
									</thead>
									<tbody id="contIngresoBody">
										<tr>
											<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

											<td class='contImputacionesConcepto'>
												<form:select class='contImputacionesConceptoCombo  span12 '  placeholder="Seleccione un valor"  path ='periodoId'>
												<option></option> 
											</form:select>
										</td>

										<td class='contImputacionesCuenta'></td>
										<td class='contImputacionesTipoEntidad'></td>
										<td class='contImputacionesEntidad'></td>
										<td class='contImputacionesDescripcion'></td>
										<td class='contImputacionesMoneda'></td>
										<td class='contCotizacion'></td>
										<td class='contImporte campo-importe'><input type="text" min="0"  class="campo-importe" pattern="^\d+(\.\d{2})?$"></td>
										<td class='contImputacionesBanco'>
											<form:select class='span10 contImputacionesBancoCombo selectpicker'  placeholder="Seleccione" path='cuentaId' multiple="false">
											<option></option> 
											<form:options items="${bancos}" itemValue="id" itemLabel="nombre" />
										</form:select></td>
										<td class='contIngresoNumero'><input type="text"  class="span12" maxlength="10"></td>
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
	<!-- Form actions -->
	<div class="form-actions">
		<button class ="save btn btn-danger guardar" type="button">Guardar Documento</button>
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
