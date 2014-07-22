<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="contEdit modal hide fade" id="modal-simple">
			<div class="innerLR">

	<!-- Form -->
			<form:form commandName="Estructura" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			<form:input path ="id" class="span12" id="id" name="id" type="hidden"/>

		<!-- Widget -->
		<div class="widget">

			<!-- Widget heading -->
			<div class="widget-head header-popup">
				<h4 class="heading">Complete los datos</h4>
			</div>
			<!-- // Widget heading END -->

			<div class="widget-body">

				<!-- Row -->
				<div class="row-fluid">

					<!-- Column -->
					<!-- Column -->
					<div class="span10">

						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Administracion</label>
							<div class="controls"><form:select class='selectpicker span10'  path ='administracion.id' multiple="false">
																					<form:options items="${administraciones}" itemValue="id" itemLabel="nombre" />
																				</form:select></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Nombre</label>
							<div class="controls"><form:input path ="nombre" class="span10" id="nombre" name="nombre" type="text" maxlength="100"/></div>
						</div>
				<div class="control-group">
												<label class="control-label">Estado</label>
												<div class="controls">
																		<form:select path ='estado'  id="estado" name="estado" class="selectpicker span5">
																		    <form:option value="F" label="Inactivo"/>
																			<form:option value="T" label="Activo"/>
																		</form:select>
																	</div>
												</div>

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
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Save</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancel</button>
				</div>
				<!-- // Form actions END -->

			</div>
		</div>
		<!-- // Widget END -->

			</form:form>	
	<!-- // Form END -->

</div>
</div>

