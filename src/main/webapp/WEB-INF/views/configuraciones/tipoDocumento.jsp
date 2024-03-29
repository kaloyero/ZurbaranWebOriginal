<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
	input {vertical-align: top !important; margin:0 !important;}
	.form-checkbox {height:119px; display:block; overflow-y: scroll; border: 1px solid #ccc;}
	.form-checkbox input {float: left; margin: 3px !important;}
	.form-checkbox label {overflow: auto;}
	.form-checkbox span {width: 100px !important;height: 10px;}
	.tab-pane {height: 119px !important;}
	.modal {z-index: 2}
	.modal-backdrop {z-index: 1 !important}
</style>

<div class="heading-buttons">
	<h3>Tipo de Documentos</h3>
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


					<div class="row-fluid">
						<div class="control-group">
							<div class="span12">
								<div class="span6">
									<div class="control-group">	
										<label class="control-label">Administracion</label>
										<div class="controls">
											<form:select class='contAdministracionCombo selectpicker span12' placeholder="Seleccione un valor"  path ='administracion.id' multiple="false">
												<option></option>
												<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
											</form:select>
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">									
										<label class="control-label" for="firstname">Nombre</label>
										<div class="controls">
											<form:input path ="nombre" class="span12" id="nombre" name="nombre" type="text" maxlength="50"/>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="control-group">
							<div class="span12">
								<label class="control-label">Cuenta</label>
								<div class="controls">
									<form:select id ="cuentaCombo" class='contCuentaCombo selectpicker span3' placeholder="Seleccione un valor" path ='cuentaId' multiple="false">
										<option></option>
										<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
									</form:select>
									<form:select id ="entidadCombo" class='selectpicker span3'  path ='entidadId' multiple="false">

									</form:select>
								</div>
							</div>
						</div>
						<div class="control-group">
							<div class="span9">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<input class=" contTipoEntidadInput span9 input-readOnly" id="codigo"  type="text" readonly>
								</div>
							</div>
						</div>
						<div class="control-group">
							<div class="span12">							
								<div class="span6">
									<div class="control-group">
										<label class="control-label">Tipo de Movimiento</label>
										<div class="controls" >
											<label class="checkbox span6" >
												<form:radiobutton path="TipoMovimiento" value="D" style="margin-top: 4px !important;margin-right: 5px !important;" checked="checked"/>Debito
											</label> 
										</div>
										<div class="controls" >
											<label class="checkbox span6"  > 
												<form:radiobutton path="TipoMovimiento" value="C" style="margin-top: 4px !important;margin-right: 5px !important;"/>Credito
											</label>
										</div>
									</div>
								</div>
								<div class="span6">
									<div class="control-group">
										<label class="control-label">Moneda</label>
										<div class="controls">
											<form:select id ="monedaCombo" class='contMonedaCombo selectpicker span6'  path ='moneda.id' multiple="false">
		
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>


						<BR>
						<div class="span12">
							<div class="wizard">
								<div class="widget widget-tabs widget-tabs-double">
									<div class="widget-head">
										<ul>
											<li class="active"><a href="#tab1-2" class="glyphicons calculator" data-toggle="tab"><i></i><span class="strong"></span><span>Numeraci&oacute;n</span></a></li>
											<li><a href="#tab2-2" class="glyphicons user" data-toggle="tab"><i></i><span class="strong"></span><span>Permisos</span></a></li>
											<li><a href="#tab2-3" class="glyphicons user" data-toggle="tab"><i></i><span class="strong"></span><span>Conceptos</span></a></li>
										</ul>
									</div>
									<div class="widget-body">
										<div class="tab-content">
											<div class="tab-pane active" id="tab1-2">
		<div class="row-fluid">
			<div class="span4" style="background-color: rgba(185, 187, 186, 0.07); padding: 5px; border-top: 1px solid red;">
				<label for="inputTitle" class="span12" style="   font-weight: bold;   border-bottom: 1px red;">Formato</label>
				<label class="checkbox span12">
						<form:radiobutton id="NumeracionFormato1" class="checkbox" path="NumeracionFormato" value="N" /> Normal
					
				</label> 
				<label class="checkbox span12"> 
				  <form:radiobutton id="NumeracionFormato2" class="checkbox" path="NumeracionFormato" value="L" /> Letra + Establecimiento
				</label>
			</div>
			<div class="span2" style="background-color: rgba(246, 246, 246, 1);">
				<div class="control-group" style="border-top: 1px solid red;  padding: 5px;">
					<label class="span4" style="font-weight: bold;">Tipo</label>
					<div class="span12">
						<div class="span12">
							<label class="checkbox span12">
								<form:radiobutton class="checkbox tipoNumeracion" path="NumeracionTipo" value="M"/>Manual
							</label> 
						</div>
						<div class="span12">
							<label class="checkbox span12">
								<form:radiobutton class="checkbox tipoNumeracion" path="NumeracionTipo" value="A" style="margin-left: -2px;"/>Automatica
							</label> 
						</div>
					</div>
				</div>
			</div>
			<div class="span6" style="background-color: rgba(246, 246, 246, 1);height: 115px;">
				<div class="control-group" style="border-top: 1px solid rgb(255, 56, 56);padding: 5px;height: 115px;">
					<label class="span12" style="font-weight: bold;">Periodo</label>
					<div class="span10" id="contManual" hide style="height: 80px;">
						<div class="span12">
							<label class="checkbox span5">
								<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="H" style="margin-left: -4px;" id="hist"/> Hist&oacute;rico
							</label> 
							<label class="checkbox span5">
								<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="A"/> Anual
							</label> 
						</div>
						<div class="span12">													
							<label class="checkbox span5">
					       		<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="M" style="margin-left: -4px;"/> Mensual
							</label> 
							<label class="checkbox span5">
								<form:radiobutton class="checkbox contPeriodo" path="NumeracionPeriodo" value="D"/> Diario
							</label> 
						</div>
					</div>
					<div class="span10" id="contAutomatica" style="height: 80px;" >
						<div class="span12">
							<label class="checkbox span6">
							<form:radiobutton  class="checkbox contControl" path="NumeracionPeriodo" value="G" id="general"/> Control General
							
							</label> 
							<label class="checkbox span6">
							 <form:radiobutton  class="checkbox contControl" path="NumeracionPeriodo" value="E" /> Control por Entidad							
							</label> 
						</div>
					</div>
				</div>
			</div>
		</div>
											</div>
											<div class="tab-pane" id="tab2-2">
												<div class="row-fluid">
													<div class="span4">
														<div class="span12" >
															<label class="checkbox span12">
																<form:checkbox path="PermiteImputaciones" class="checkbox" value="S" id="permiteImputaciones" style="margin-right: 5px !important;"/> Imputaciones 
															</label>
															<label class="checkbox span12">
																<form:checkbox path="PermiteValProp" class="checkbox" value="S" id="permiteValProp" style="margin-right: 5px !important;"/> Valores Propios
															</label>
															<label class="checkbox span12">
																<form:checkbox id="permiteIngValTer" path="PermiteIngValTer" class="checkbox" value="S" style="margin-right: 5px !important;"/> Ingreso de valores de 3ros. 
															</label> 
														</div>
													</div>
													<div class="span4">
														<label class="checkbox span12">
															<form:checkbox path="PermiteEgrValTer" class="checkbox" value="S" id="permiteEgrValTer" style="margin-right: 5px !important;"/> Egreso de valores de 3ros. 
														</label> 
														<label class="checkbox span12">
															<form:checkbox path="PermiteAplicaciones" class="checkbox" value="S" id="permiteAplicaciones" style="margin-right: 5px !important;"/> Aplicaciones
														</label> 
													</div>
												</div>
											</div>
											<div class="tab-pane" id="tab2-3">
												<div class="row-fluid">
													<div class="span6">
														<div class="span12" >
															<div class="form-checkbox">
																<span>
																	<input id="selecAll" type="checkbox" />
																	<label for="selecAll">TODOS</label>
																</span>																
																<form:checkboxes class="contConceptos" path="conceptos" multiple ="multiple" items="${conceptos}" itemValue="id" itemLabel="nombre" />
															</div>
														</div>
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
									<form:select path ='estado'  id="estado" name="estado" class="selectpicker span6">
										<form:option value="T" label="Activo"/>
										<form:option value="F" label="Inactivo"/>
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
									<i></i>Guardar
								</button>
								<button type="button"
									class="btn btn-icon btn-default glyphicons circle_remove contCancelNew">
									<i></i>Cancelar
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
