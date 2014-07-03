<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="contEdit modal hide fade container-popup" id="modal-simple">
	<div class="innerLR">


			<form:form commandName="Cuenta" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>


			<div class="widget">

				<div class="widget-head header-popup">
					<h4 class="heading">Complete los datos</h4>
				</div>
				<div class="widget-body">
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
									<form:input path ="nombre" class="span12" id="nombre" name="nombre" type="text" maxlength="50"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Codigo</label>
								<div class="controls">
									<form:input path ="codigo" class="span12" id="codigo" name="codigo" type="text" maxlength="20"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">
									<form:textarea resize="none" maxlength="100" id="descripcion" path="descripcion" rows="5" cols="100" class="span12"  style="margin: 0px; height: 85px;"/>
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<form:select class='selectpicker span12'  path ='tipoEntidad.id' multiple="false">
										<form:options items="${tipoEntidades}" itemValue="id" itemLabel="nombre" />
									</form:select>
								</div>
							</div>							
							<div class="control-group">
								<label class="control-label">Monedas</label>
								<div class="controls">
									<div class="uniformjs span12">
										<form:select path="idsMonedas" multiple ="true" items="${monedas}" itemValue="id" itemLabel="nombre" class="span12"/>
									</div>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Saldo</label>
								<label class="controls">  
									<form:radiobutton path="saldo" value="D" style="padding:5px"/><span style="padding:5px">Deudor</span>
									<form:radiobutton path="saldo" value="A" style="padding:5px"/><span style="padding:5px">Acreedor</span>
								</label>
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
						</div>
					</div>

					<hr class="separator separatorMarginTop">

					<!-- Form actions -->
					<div class="form-actions">
						<button type="submit"
							class="contUpdate btn btn-icon btn-primary glyphicons circle_ok">
							<i></i>Guardar
						</button>
						<button type="button"
							class="btn btn-icon btn-default glyphicons circle_remove contCancelEdit">
							<i></i>Cancelar
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

