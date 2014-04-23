<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="span10 contEdit modal hide fade"  style="left: 20% !important;" id="modal-simple">
	<div class="innerLR">


		<form:form commandName="TipoDocumento" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">			
			<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>

			<!-- Widget -->
			<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Complete los datos</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">



					<!-- Row -->
					<div class="row-fluid">

						<div class="span6">
							<div class="control-group">
								<label class="control-label">Administracion</label>
								<div class="controls">
									<form:select class='contAdministracionCombo selectpicker span12'  path ='administracion.id' multiple="false">
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
									<form:input path ="nombre" class="span12" id="nombre" name="nombre" type="text"/>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
									<form:select id ="cuentaCombo" class='contCuentaCombo selectpicker span12'  path ='cuentaId' multiple="false">
										<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
										
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo de Entidad</label>
								<div class="controls">

									
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo de Movimiento</label>
								<div class="controls" >
									<label class="checkbox span6">
								<form:radiobutton path="TipoMovimiento" value="D"/>Deudor
									</label> 
								</div>
								<div class="controls" >
									<label class="checkbox span6"> 
										<form:radiobutton path="TipoMovimiento" value="C"/>Acreedor
									</label>
									
								</div>
							</div>
							
						</div>
						<div class="span6">
							<div class="control-group" style="height: 70px;">
								<label class="control-label"></label>
								<div class="controls">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:select class='contMonedaCombo selectpicker span12'  path ='moneda.id' multiple="false">
																					<form:options items="${monedas}" itemValue="id" itemLabel="nombre" />

									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Entidad</label>
								<div class="controls">
									<form:select id ="entidadCombo" class='selectpicker span12'  path ='entidadId' multiple="false">
									<form:options items="${entidades}" itemValue="id" itemLabel="nombre" />

									</form:select>
								</div>
							</div>
						</div>
						
						<BR>
						
						<div class="span12">


							<div class="wizard">
								<div class="widget widget-tabs widget-tabs-double">
								
									<!-- Widget heading -->
									<div class="widget-head">
										<ul>
											<li class="active"><a href="#edittab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong"></span><span>Numeración</span></a></li>
											<li><a href="#edittab2-2" class="glyphicons user" data-toggle="tab"><i></i><span class="strong"></span><span>Permisos</span></a></li>
										</ul>
									</div>
									<!-- // Widget heading END -->
									
									<div class="widget-body">
										<div class="tab-content">
										
											<!-- Step 1 -->
											<div class="tab-pane active" id="edittab1-2">
												<div class="row-fluid">
													<div class="span4" style="background-color: rgba(185, 187, 186, 0.07);">
														<div class="control-group">
															<label class="span4">Tipo</label>
															<div class="span8">
																<div class="span12">
																	<label class="checkbox span12">
																		<form:radiobutton class="checkbox tipoNumeracion" path="NumeracionTipo" value="M"/>Manual
																	</label> 
																</div>
																<div class="span12">
																	<label class="checkbox span12">
															<form:radiobutton class="checkbox tipoNumeracion" path="NumeracionTipo" value="A"/>Automatica
																	</label> 
																</div>
															</div>
														</div>
													</div>
													<div class="span8" style="background-color: rgba(185, 187, 186, 0.07);">
														<div class="control-group">
															<label class="span2">Periodo</label>
															<div class="span10">
																<div class="span12">
																	<label class="checkbox span6">
																	<form:radiobutton class="checkbox contControl" path="NumeracionPeriodo" value="G"/> Control general
																	</label> 
																	<label class="checkbox span6">
																	<form:radiobutton class="checkbox contControl" path="NumeracionPeriodo" value="E"/> Control por Entidad
																	</label> 
																</div>
																<div class="span12">
																	<label class="checkbox span3">
																	<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="H" /> Histórico
																	</label> 
																	<label class="checkbox span3">
																	<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="A"/> Anual
																	</label> 
																	<label class="checkbox span3">
															       <form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="M"/> Mensual
																	</label> 
																	<label class="checkbox span3">
																	<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="D"/> Diario
																	</label> 
																	
																</div>
															</div>
														</div>
													</div>
													<div class="span6" style="background-color: rgba(185, 187, 186, 0.07); margin-top: 8px;">
														<label for="inputTitle" class="span3" >Formato</label>
															<label class="checkbox span3">
														<form:radiobutton class="checkbox" path="NumeracionFormato" value="N"/> Normal
																
															</label> 
															<label class="checkbox span6"> 
										<form:radiobutton class="checkbox" path="NumeracionFormato" value="L"/> Letra + Establecimiento
															</label>
													</div>

												</div>
											</div>
											<!-- // Step 1 END -->
											
											<!-- Step 2 -->
											<div class="tab-pane" id="edittab2-2">
												<div class="row-fluid">
													<div class="span4">
														<div class="span12" >
															<label class="checkbox span12">
															<form:checkbox path="PermiteImputaciones" class="checkbox" value="S"/> Imputaciones 
															</label>
															<label class="checkbox span12">
															<form:checkbox path="PermiteValProp" class="checkbox" value="S"/> Valores Propios
															</label>
														 
															<label class="checkbox span12">
															<form:checkbox path="PermiteIngValTer" class="checkbox" value="S"/> Ingreso de valores de 3ros. 
															</label> 
														</div>
													</div>
													<div class="span4">
															<label class="checkbox span12">
															<form:checkbox path="PermiteEgrValTer" class="checkbox" value="S"/> Egreso de valores de 3ros. 
															</label> 
															<label class="checkbox span12">
															<form:checkbox path="PermiteAplicaciones" class="checkbox" value="S"/> Aplicaciones
												> 
															</label> 
													</div>

												</div>
											</div>
											<!-- // Step 2 END -->
									</div>
								</div>
							</div>



						
						</div>						
						<div class="span12">
							<div class="control-group">
								<label class="control-label">Estado</label>
								<div class="controls">
									<form:select path ='estado'  id="estado" name="estado" class="selectpicker span12">
																		    <form:option value="F" label="Inactivo"/>
																			<form:option value="T" label="Activo"/>
																		</form:select>
								</div>
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
