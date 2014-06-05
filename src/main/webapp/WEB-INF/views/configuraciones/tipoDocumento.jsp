<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Tipo Documento</h3>
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
						<th>Nombre</th>
						<th>Cuenta</th>
						<th>Tipo Entidad</th>
						<th>Entidad</th>
						<th>Tipo Movimiento</th>
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
			<!-- // Table END -->

		</div>
	</div>
	<!-- // Widget END -->


	<!-- Widget -->




</div>
<div class="span10 contNew modal hide fade"  style="left: 20% !important;" id="modal-simple">
	<div class="innerLR">


		<form:form commandName="TipoDocumento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">			

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
									<option></option>
										<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
									<input class="span12" id="nombre" name="nombre"
										type="text">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
									<form:select id ="cuentaCombo" class='contCuentaCombo selectpicker span12'  path ='cuentaId' multiple="false">

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
									<input name="TipoMovimiento" type="radio"
										class="checkbox" value="D" /> Debito
									</label> 
								</div>
								<div class="controls" >
									<label class="checkbox span6"> 
									<input type="radio" name="TipoMovimiento"
										class="checkbox" value="C" checked="checked" /> Credito
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
									<form:select id ="monedaCombo" class='contMonedaCombo selectpicker span12'  path ='moneda.id' multiple="false">

									</form:select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Entidad</label>
								<div class="controls">
									<form:select id ="entidadCombo" class='selectpicker span12'  path ='entidadId' multiple="false">

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
											<li class="active"><a href="#newtab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong"></span><span>Numeración</span></a></li>
											<li><a href="#newtab2-2" class="glyphicons user" data-toggle="tab"><i></i><span class="strong"></span><span>Permisos</span></a></li>
											<li><a href="#newtab2-3" class="glyphicons user" data-toggle="tab"><i></i><span class="strong"></span><span>Conceptos</span></a></li>
										
										</ul>
									</div>
									<!-- // Widget heading END -->
									
									<div class="widget-body">
										<div class="tab-content">
										
											<!-- Step 1 -->
											<div class="tab-pane active" id="newtab1-2">
												<div class="row-fluid">
													<div class="span4" style="background-color: rgba(185, 187, 186, 0.07);">
														<div class="control-group">
															<label class="span4">Tipo</label>
															<div class="span8">
																<div class="span12">
																	<label class="checkbox span12">
																	<input name="NumeracionTipo" type="radio"
																		class="checkbox tipoNumeracion" value="M" checked="checked" /> Manual
																	</label> 
																</div>
																<div class="span12">
																	<label class="checkbox span12">
																	<input name="NumeracionTipo" type="radio"
																		class="checkbox tipoNumeracion" value="A" /> Automática
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
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contControl" value="G" id="general" checked/> Control general
																	</label> 
																	<label class="checkbox span6">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contControl" value="E" /> Control por Entidad
																	</label> 
																</div>
																<div class="span12">
																	<label class="checkbox span3">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contPeriodo" value="H" disabled="disabled"  id="hist"/> Histórico
																	</label> 
																	<label class="checkbox span3">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contPeriodo" value="A" disabled="disabled"/> Anual
																	</label> 
																	<label class="checkbox span3">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contPeriodo" value="M" disabled="disabled"/> Mensual
																	</label> 
																	<label class="checkbox span3">
																	<input name="NumeracionPeriodo" type="radio"
																		class="checkbox contPeriodo" value="D" disabled="disabled"/> Diario
																	</label> 
																	
																</div>
															</div>
														</div>
													</div>
													<div class="span6" style="background-color: rgba(185, 187, 186, 0.07); margin-top: 8px;">
														<label for="inputTitle" class="span3" >Formato</label>
															<label class="checkbox span3">
															<input name="NumeracionFormato" type="radio"
																class="checkbox" value="N" /> Normal
															</label> 
															<label class="checkbox span6"> 
															<input type="radio" name="NumeracionFormato"
																class="checkbox" value="L" checked="checked" /> Letra + Establecimiento
															</label>
													</div>

												</div>
											</div>
											<!-- // Step 1 END -->
											
											<!-- Step 2 -->
											<div class="tab-pane" id="newtab2-2">
												<div class="row-fluid">
													<div class="span4">
														<div class="span12" >
														<label class="checkbox span12">
															<input name="PermiteImputaciones" type="checkbox" id="permiteImputaciones"
																class="checkbox" value="S" /> Imputaciones
															</label> 
															<label class="checkbox span12"> 
														
															<input type="checkbox" name="PermiteValProp" id="permiteValProp"
																class="checkbox" value="S" /> Valores Propios
															</label>
															
															<label class="checkbox span12">
															<input id="permiteIngValTer" name="PermiteIngValTer" type="checkbox"
																class="" value="S" /> Ingreso de valores de 3ros.
															</label> 
														</div>
													</div>
													<div class="span4">
															<label class="checkbox span12">
															<input name="PermiteEgrValTer" type="checkbox" id="permiteEgrValTer"
																class="checkbox" value="S" /> Egreso de valores de 3ros.
															</label> 
															<label class="checkbox span12">
															<input name="PermiteAplicaciones" type="checkbox" id="permiteAplicaciones"
																class="checkbox" value="S" /> Aplicaciones
															</label> 
													</div>

												</div>
											</div>
											
											<!-- // Step 2 END -->
											<div class="tab-pane" id="newtab2-3">
												<div class="row-fluid">
													<div class="span6">

														<form:select class="contConceptos" path="conceptos" multiple ="multiple" items="${conceptos}" itemValue="id" itemLabel="nombre" />																					
													</div>
												</div>
											</div>
									</div>
								</div>
							</div>
						</div>						

						<div class="span6">
							<div class="control-group">
								<label class="control-label">Estado</label>
								<div class="controls">
									<select id="estado" name="estado" class="selectpicker span6">
										<option value="T">Activo</option>
										<option value="F">No Activo</option>
									</select>
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
