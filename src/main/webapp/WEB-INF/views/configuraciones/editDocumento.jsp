<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="span6 contEdit modal hide fade "  style="left: 0% !important;top: 0 !important;width:90%" id="modal-simple">
	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget" >

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Documento</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span5">
							<div class="control-group"  >
								<label class="control-label">Administracion</label>
								<div class="controls contAdministracion">
<form:input path ="administracionNombre" class="span12" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Documento</label>
								<div class="controls contTipoDoc">
										
										<form:input path ="tipoDocumentoNombre" class="span12" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 

								</div>
							</div>
								<div class="control-group" >
								<label class="control-label">Numeracion</label>
								<div class="controls contNumeracion">
										
										
								</div>
							</div>
							<div class="control-group" >
								<label class="control-label">Cuenta</label>
								<div class="controls contEntidad" >
									<div class="span12">
								   <form:input path ="cuentaNombre" class="span8" id="nombre" name="nombre" type="text" readonly="true" />/<form:input path ="tipoEntidadNombre" class="span5" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 

									</div>
										<form:input path ="entidadNombre" class="span8" id="nombre" name="nombre" type="text" readonly="true" />

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
<form:input path ="fechaReal" class="span12" id="nombre" name="nombre" type="text" readonly="true" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fecha Ingreso</label>
								<div class="controls">
<form:input path ="fechaIngreso" class="span12" id="nombre" name="nombre" type="text" readonly="true" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Fecha Vto</label>
								<div class="controls">
<form:input path ="fechaVencimiento" class="span12" id="nombre" name="nombre" type="text" readonly="true" />
								</div>
							</div>
							<div class="control-group contMoneda">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:input path ="monedaNombre" class="span12" id="nombre" name="nombre" type="text" readonly="true" />

								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Cotizacion</label>
								<div class="controls">
									<form:input path ="cotizacion" class="span12" id="nombre" name="nombre" type="text" readonly="true" /> 
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
										<c:if test="${fn:length(Documento.valoresEgreTerce) gt 0}">
											<li class="contEgreso active"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Egreso </span><span>Valores</span></a></li>
										</c:if>	
										<c:if test="${fn:length(Documento.imputaciones) gt 0}">
											<li class="contImputaciones"><a href="#newtab2-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Imputaciones</span><span></span></a></li>
										</c:if>
											
										<c:if test="${fn:length(Documento.aplicaciones) gt 0}">
											<li class="contCancelaciones"><a href="#newtab2-3" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Cancelaciones</span><span></span></a></li>
											</c:if>
										<c:if test="${fn:length(Documento.valoresPropio) gt 0}">
											<li class="contValores"><a href="#newtab2-4" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Valores</span><span>Propios</span></a></li>
											</c:if>
										<c:if test="${fn:length(Documento.valoresIngreTerce) gt 0}">
											<li class="contIngreso"><a href="#newtab2-5" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong">Ingreso</span><span>de Valores</span></a></li>
										</c:if>
										</ul>
									</div>
									<!-- // Widget heading END -->
									
									<div class="widget-body">
										<div class="tab-content">
										
											<!-- Step 1 -->
											<c:if test="${fn:length(Documento.valoresEgreTerce) gt 0}">
											<div class="tab-pane active" id="newtab1-2">
												<div class="row-fluid">
																<!-- Table -->
																<div class="span10">
																<table class="span10 egreso table table-bordered table-striped">
																	<thead>
																		<tr>
																		
																			<th class="center span9">Numero</th>
																			<th class="center span9">Banco</th>
																			<th class="center span9">Emisor</th>
																			<th class="center span3">Importe</th>
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
											<!-- // Step 1 END -->
											
											<!-- Step 2 -->
											<c:if test="${fn:length(Documento.imputaciones) gt 0}">
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
																			<th class="center span2">Importe</th>
																		</tr>
																	</thead>
																	<tbody id="contImputacionesBody">
																	<c:forEach var="imputacion" items="${Documento.imputaciones}" varStatus="loopStatus">
            															<tr>
               																 <td>${imputacion.conceptoNombre}</td>
               																 <td>${imputacion.cuentaNombre}</td>
               																 <td>${imputacion.tipoEntidadNombre}</td>
               																 <td>${imputacion.entidadNombre}</td>
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
											<!-- // Step 2 END -->
											<!-- Step 3 -->
											<c:if test="${fn:length(Documento.aplicaciones) gt 0}">
											<div class="tab-pane" id="newtab2-3">
												<div class="row-fluid">

																<!-- Table -->
																<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			
																			<th class="center span8">Numero</th>
																			<th class="center span2">Importe Pendiente</th>
																			
																		</tr>
																	</thead>
																	<tbody id="contCancelacionesBody">
																	<c:forEach var="aplicacion" items="${Documento.aplicaciones}" varStatus="loopStatus">
            															<tr>
               																 <td>${aplicacion.numero}</td>
               																 <td>${aplicacion.importeAplicado}</td>
               														 </tr>
        															</c:forEach>
																	</tbody>
																	
																</table>


												</div>
											</div>
											</c:if>
											<!-- // Step 3 END -->
											<!-- Step 4 -->
											<c:if test="${fn:length(Documento.valoresPropio) gt 0}">
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
											<!-- // Step 4 END -->
											<!-- Step 5 -->
											<c:if test="${fn:length(Documento.valoresIngreTerce) gt 0}">
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
																			<th class="center span2">Importe</th>
																			<th class="center span2">Bancoooo</th>
																			<th class="center span2">Numero</th>
																			<th class="center span2">Fecha Vecimiento</th>
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
						<form:input path ="totalImputacion" class="span12" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Cancelaciones</label>
								<div class="controls">
									<input class="span8 contCancelacionesTotal" type="text"  value="0" readonly>
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Valores Propios</label>
								<div class="controls">
								<form:input path ="totalValorPropio" class="span12" id="nombre" name="nombre" type="text" readonly="true" />
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Egreso Valores</label>
								<div class="controls">
								<form:input path ="totalEgresoValor" class="span12" id="nombre" name="nombre" type="text" readonly="true" />
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Total Ingreso Valores</label>
								<div class="controls">
							<form:input path ="totalIngresoValor" class="span12" id="nombre" name="nombre" type="text" readonly="true" />
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Debito</label>
								<div class="controls">
								<form:input path ="totalHeader" class="span12" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
								</div>
							</div>
						</div>
						<div class="span4">
							<div class="control-group">
								<label class="control-label">Credito</label>
								<div class="controls">
								<form:input path ="totalHeader" class="span12" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
								<form:input path ="totalValorPropio" class="span12" id="nombre" name="nombre" type="text" readonly="true" />																					<option></option> 
								
								</div>
							</div>
						</div>
						<div class="span2">
							<div class="control-group">

							</div>
						</div>

						
						<div class="span12">

							<hr class="separator span12">
		
					
						</div>
						

					</div>


				</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>