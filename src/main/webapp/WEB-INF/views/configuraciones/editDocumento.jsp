<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style type="text/css">
.tab-pane {height: 180px !important;}
.select-document {width: 150px !important;}
input.fechaDocumento{width: 80px !important}
.input-document-cuentaEntidad{width: 189px !important}
.table-document-imputaciones {height: 180px !important;}
</style>



<div class="span12 contEdit modal hide fade PrintArea "  style="left: 8% !important;top: 5% !important;width:84%; height:615px;" id="modal-simple">
<button class ="save btn btn-danger print " type="button">Imprimir</button>	<button type="button" class="btn btn-icon btn-default glyphicons circle_remove contCancelEdit"><i></i>Salir</button>

	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<div class="widget" >
				<div class="widget-head header-document">
					<h4 class="heading">Documento</h4>
				</div>
				<div class="widget-body">
					<div class="row-fluid" style="background:#e5e5e5">
						<div class="span8"  style="padding-right: 20px;padding-top: 22px;">
							<div class="control-group">
								<div class="span8">
									<div class="control-group"  >
										<label class="control-label">Administraci&oacute;n</label>
										<div class="controls contAdministracion">
											<form:input path ="administracionNombre" class="select-document input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
										</div>
									</div>
									<label class="control-label">Descripci&oacute;n</label>
									<div class="controls">
										<form:textarea id="descripcion" name="descripcion" path="descripcion" rows="3" cols="50" class="span12" style="margin: 0px;" ></form:textarea>
									</div>
								</div>
								<div class="span4">
									<div class="control-group">
										<label class="control-label document-bold">Fecha Real</label>
										<div class="controls">								
											<form:input path ="fechaReal" class="input-readOnly fechaDocumento" id="nombre" name="nombre" type="text" readonly="true" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label document-bold">Fecha Ingreso</label>
										<div class="controls">
											<form:input path ="fechaIngreso" class="input-readOnly fechaDocumento" id="nombre" name="nombre" type="text" readonly="true" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label document-bold">Fecha Vto</label>
										<div class="controls">
											<form:input path ="fechaVencimiento" class="input-readOnly fechaDocumento" id="nombre" name="nombre" type="text" readonly="true" />
										</div>
									</div>
								</div>
							</div>
							<div class="control-group">
								<div class="span10">
									<div class="control-group" >
										<label class="control-label">Documento</label>
										<div class="controls contTipoDoc">
											<form:input path ="tipoDocumentoNombre" class="input-document-small input-readOnly select-document" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
											<form:input path ="numeroFormateado" class="input-document-small input-readOnly select-document" id="nombre" name="nombre" type="text" readonly="true" style="margin-left: 7px;"/>
										</div>
									</div>
								</div>
							</div>
							<div class="control-group" >
								<div class="span12">
									<label class="control-label">Cuenta</label>
									<div class="controls contEntidad" >				
											<form:input path ="cuentaNombre" class="input-document-small input-readOnly select-document" id="nombre" name="nombre" type="text" readonly="true" />
											/
											<form:input path ="tipoEntidadNombre" class="input-document-small input-readOnly select-document" id="nombre" name="nombre" type="text" readonly="true" />
											<option></option> 
											<form:input path ="entidadNombre" class="input-document-small input-readOnly select-document" id="nombre" name="nombre" type="text" readonly="true" />
									</div>
								</div>
							</div>
							<div class="control-group" >
								<div class="span5">
									<div class="control-group contMoneda">
										<label class="control-label">Moneda</label>
										<div class="controls">
											<form:input path ="monedaNombre" class="span12 input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />

										</div>
									</div>
								</div>
								<div class="span5">
									<div class="control-group">
										<label class="control-label">Cotizacion</label>
										<div class="controls">
											<form:input path ="cotizacion" class="span5 input-readOnly" id="nombre" name="nombre" type="text" readonly="true" /> 
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="span4 document-totales" >
							<div style="height: 266px; ">
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Total Imputaciones</label>
									<div class="controls">
										<form:input path ="totalImputacion" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
									</div>
								</div>
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Total Cancelaciones</label>
									<div class="controls">
										<form:input path ="totalCancelaciones" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />
									</div>
								</div>
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Total Valores Propios</label>
									<div class="controls">
										<form:input path ="totalValorPropio" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />
									</div>
								</div>
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Total Egreso Valores</label>
									<div class="controls">
										<form:input path ="totalEgresoValor" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />
									</div>
								</div>
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Total Ingreso Valores</label>
									<div class="controls">
										<form:input path ="totalIngresoValor" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />
									</div>
								</div>
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Debito</label>
									<div class="controls">
										<form:input path ="totalHeader" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
									</div>
								</div>
								<div class="control-group input-totales">
									<label class="control-label" style="width:128px;">Credito</label>
									<div class="controls">
										<form:input path ="totalHeader" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
										<form:input path ="totalValorPropio" class="span12 input-totales-ancho input-readOnly" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
									</div>
								</div>
							</div>
						</div>

						<div class="span12 document-tabla" style="height: 240px;">
							<div class="wizard">
								<div class="widget widget-tabs widget-tabs-double">
									<div class="widget-head">
										<ul>
											<c:if test="${fn:length(Documento.valoresEgreTerce) gt 0}">
												<li class="contEgreso active"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Egreso </span><span>Valores</span></a></li>
											</c:if>	
											<c:if test="${fn:length(Documento.imputaciones) gt 0}">
												<li class="contImputaciones"><a href="#newtab2-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Imputaciones</span><span></span></a></li>
											</c:if>
											<c:if test="${fn:length(Documento.aplicaciones) gt 0}">
												<li class="contCancelaciones"><a href="#newtab2-3" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Aplicaciones</span><span></span></a></li>
											</c:if>
											<c:if test="${fn:length(Documento.valoresPropio) gt 0}">
												<li class="contValores"><a href="#newtab2-4" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Valores</span><span>Propios</span></a></li>
											</c:if>
											<c:if test="${fn:length(Documento.valoresIngreTerce) gt 0}">
												<li class="contIngreso"><a href="#newtab2-5" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Ingreso</span><span>de Valores</span></a></li>
											</c:if>
										</ul>
									</div>
									<div class="widget-body">
										<div class="tab-content">
											<c:if test="${fn:length(Documento.valoresEgreTerce) gt 0}">
												<div class="tab-pane active" id="newtab1-2">
													<div class="row-fluid">
														<!-- Table -->
														<div class="span12">
															<table class="table-document-aplicaciones span8 egreso table table-bordered table-striped table-document-imputaciones">
																<thead>
																	<tr >
																		<th class="center span9 col1">Numero</th>
																		<th class="center span9 col2">Banco</th>
																		<th class="center span4 ">Emisor</th>
																		<th class="center span3 col3">Importe</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="valorEgre" items="${Documento.valoresEgreTerce}" varStatus="loopStatus">
																		<tr>
																			<td>${valorEgre.valorTerce.numero}</td>
																			<td>${valorEgre.valorTerce.bancoNombre}</td>
																			<td>${valorEgre.valorTerce.emisor}</td>
																			<td>${valorEgre.importe}</td>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</c:if>	
											<c:if test="${fn:length(Documento.imputaciones) gt 0}">
												<div class="tab-pane" id="newtab2-2">
													<div class="row-fluid">
														<!-- Table -->
														<table id="contImputaciones" class="table table-bordered table-striped table-document-imputaciones">
															<thead>
																<tr>
																	<th class="center span3 col1">Concepto</th>
																	<th class="center span3 col2">Cuenta</th>
																	<th class="center span3 col3">TipoEntidad</th>
																	<th class="center span2 col4">Entidad</th>
																	<th class="center span2 col4">Referencia</th>
																	<th class="center span5 col4">Descripci&oacute;n</th>
																	<th class="center span2 col5">Moneda</th>
																	<th class="center span2 col6">Cotizacion</th>
																	<th class="center span2 col7">Importe</th>
																</tr>
															</thead>
															<tbody id="contImputacionesBody">
																<c:forEach var="imputacion" items="${Documento.imputaciones}" varStatus="loopStatus">
																	<tr>
																		<td>${imputacion.conceptoNombre}</td>
																		<td>${imputacion.cuentaNombre}</td>
																		<td>${imputacion.tipoEntidadNombre}</td>
																		<td>${imputacion.entidadNombre}</td>
																		<td>${imputacion.referencia}</td>
																		<td>${imputacion.descripcion}</td>
																		<td>${imputacion.monedaNombre}</td>
																		<td>${imputacion.cotizacion}</td>
																		<td>${imputacion.importe}</td>
																	</tr>
																</c:forEach>
																<tr style='border:5px solid #427BD6'>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</c:if>
											<c:if test="${fn:length(Documento.aplicaciones) gt 0}">
												<div class="tab-pane" id="newtab2-3">
													<div class="row-fluid">
														<table class="table table-bordered table-striped table-document-imputaciones">
															<thead>
																<tr>
																	<th class="center span8 col1">Nombre Tipo Documento aplicado</th>
																	<th class="center span8 col2">Numero Documento</th>
																	<th class="center span8 col2">Numero</th>
																	<th class="center span2 col3">Importe Aplicado</th>
																</tr>
															</thead>
															<tbody id="contCancelacionesBody">
																<c:forEach var="aplicacion" items="${Documento.aplicaciones}" varStatus="loopStatus">
																<tr>

																	<td>${aplicacion.tipoDocumentoAplicaNombre}</td>
																	<td>${aplicacion.numeroAplicaText}</td>
																	<td>${aplicacion.numero}</td>
																	<td>${aplicacion.importeAplicado}</td>
																</tr>
															</c:forEach>
															</tbody>

														</table>
													</div>
												</div>
											</c:if>
											<c:if test="${fn:length(Documento.valoresPropio) gt 0}">
												<div class="tab-pane" id="newtab2-4">
													<div class="row-fluid">
														<table id="contPropios" class="table table-bordered table-striped table-document-imputaciones">
															<thead>
																<tr>
																	<th class="center span3">Concepto</th>
																	<th class="center span3">Cuenta</th>
																	<th class="center span3">TipoEntidad</th>
																	<th class="center span2">Entidad</th>
																	<th class="center span5">Descripci&oacute;n</th>
																	<th class="center span2">Moneda</th>
																	<th class="center span2">Cotizacion</th>
																	<th class="center span2">Importe</th>
																	<th class="center span2">Numero</th>
																	<th class="center span2">Beneficiario</th>
																	<th class="center span2">Fecha Vecimiento</th>
																</tr>
															</thead>
															<tbody id="contPropiosBody">
																<c:forEach var="propios" items="${Documento.valoresPropio}" varStatus="loopStatus">
																<tr>
																<td>${propios.conceptoNombre}</td>
																<td>${propios.cuentaNombre}</td>
																<td>${propios.tipoEntidadNombre}</td>
																<td>${propios.entidadNombre}</td>
																<td>${propios.descripcion}</td>
																<td>${propios.monedaNombre}</td>
																<td>${propios.cotizacion}</td>
																<td>${propios.importe}</td>
																<td>${propios.valorPropio.numero}</td>
																<td>${propios.valorPropio.beneficiario}</td>
																<td>${propios.valorPropio.fechaVencimiento}</td>
																</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											</c:if>
											<c:if test="${fn:length(Documento.valoresIngreTerce) gt 0}">
												<div class="tab-pane" id="newtab2-5">
													<div class="row-fluid">
														<table id="contIngreso" class="table table-bordered table-striped table-document-imputaciones">
															<thead>
																<tr >
																	<th class="center span3">Concepto</th>
																	<th class="center span3">Cuenta</th>
																	<th class="center span3">Tipo Entidad</th>
																	<th class="center span2">Entidad</th>
																	<th class="center span5">Descripci&oacute;n</th>
																	<th class="center span2">Moneda</th>
																	<th class="center span2">Cotizaci&oacute;n</th>
																	<th class="center span2">Importe</th>
																	<th class="center span2">Banco</th>
																	<th class="center span2">Numero</th>
																	<th class="center span2">Fecha Vto</th>
																</tr>
															</thead>
															<tbody id="contIngresoBody">
																<c:forEach var="ingreso" items="${Documento.valoresIngreTerce}" varStatus="loopStatus">
																	<tr>
																		<td>${ingreso.conceptoNombre}</td>
																		<td>${ingreso.cuentaNombre}</td>
																		<td>${ingreso.tipoEntidadNombre}</td>
																		<td>${ingreso.entidadNombre}</td>
																		<td>${ingreso.descripcion}</td>
																		<td>${ingreso.monedaNombre}</td>
																		<td>${ingreso.cotizacion}</td>
																		<td>${ingreso.importe}</td>
																		<td>${ingreso.valorTerce.banco.nombre}</td>
																		<td>${ingreso.valorTerce.numero}</td>
																		<td>${ingreso.valorTerce.fechaVencimiento}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
													</div>
												</div>
											</c:if>
										</div>
									</div>
								</div>
							</div>						
						</div>

					</div>
				</div>
			</div>

		</form:form>	


</div>


<script>
  

        $(".print").click(function(){
				$(".contNew").addClass("fade")
				window.print();
            //$(".PrintArea").printArea( );
        });


  </script>
