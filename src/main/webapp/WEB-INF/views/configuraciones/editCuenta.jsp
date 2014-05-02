<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="contEdit modal hide fade" id="modal-simple">
	<div class="innerLR">


				<form:form commandName="Cuenta" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
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

						<!-- Column -->
						<div class="span10">
							<div class="control-group">
								<label class="control-label">Administracion</label>
								<div class="controls">
									<form:select class='contAdministracionCombo selectpicker span12'  path ='administracion.id' multiple="false">
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
								<form:input path ="nombre" class="span10" id="nombre" name="nombre" type="text" maxlength="50"/>
			
								</div>
							</div>
								<div class="control-group">
								<label class="control-label" for="firstname">Codigo</label>
								<div class="controls">
									<form:input path ="codigo" class="span5" id="codigo" name="codigo" type="text" maxlength="20"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">
															<form:textarea resize="none" maxlength="100" id="descripcion" path="descripcion" rows="5" cols="100" class="span12" style="margin: 0px; width: 322px; height: 121px;resize:none"/>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<form:select class='selectpicker span8'  path ='tipoEntidad.id' multiple="false">
																					<form:options items="${tipoEntidades}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>



							<div class="control-group">
								<label class="control-label">Monedas</label>
								<div class="controls" style="width: 100%;">
											<div class="widget-body uniformjs span6" style="margin-left: 12px;">
																						<form:select path="idsMonedas" multiple ="true" items="${monedas}" itemValue="id" itemLabel="nombre" />

											</div>
											<div class="widget-body uniformjs span3" style="width: 40%;">
												<label >Saldo</label>
												
												<label class="checkbox">  
													<form:radiobutton path="saldo" value="D"/>Deudor
													
												</label> <label class="checkbox"> 
													<form:radiobutton path="saldo" value="A"/>Acreedor

												</label>
											</div>
											
								</div>
							</div>

							<div class="control-group">
												<label class="control-label">Estado</label>
												<div class="controls">
																		<form:select path ='estado'  id="estado" name="estado" class="selectpicker span12">
																		    <form:option value="F" label="Inactivo"/>
																			<form:option value="T" label="Activo"/>
																		</form:select>
																	</div>
												</div>




							<!-- // Group END -->

							<!-- Group -->

							<!-- // Group END -->

						</div>
						<!-- // Column END -->

						<!-- Column -->

						<!-- // Column END -->

					</div>
					<!-- // Row END -->

					<hr class="separator">

					<!-- Row -->


					<!-- // Row END -->

					<hr class="separator">

					<!-- Form actions -->
					<div class="form-actions">
						<button type="submit"
							class="contUpdate btn btn-icon btn-primary glyphicons circle_ok">
							<i></i>Save
						</button>
						<button type="button"
							class="btn btn-icon btn-default glyphicons circle_remove">
							<i></i>Cancel
						</button>
					</div>
					<!-- // Form actions END -->

				</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>

</div>

