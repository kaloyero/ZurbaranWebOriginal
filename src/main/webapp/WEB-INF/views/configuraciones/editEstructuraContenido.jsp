<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="contEdit modal hide fade" id="modal-simple">
			<div class="innerLR">

	<!-- Form -->
			<form:form commandName="EstructuraContenido" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
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
					<!-- Column -->
					<div class="span6">

						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Estructuras</label>
							<div class="controls"><form:select class='selectpicker span12'  path ='estructuraId' multiple="false">
																					<form:options items="${estructuras}" itemValue="id" itemLabel="nombre" />
																				</form:select></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Codigo</label>
							<div class="controls"><form:input path ="codigo" class="span12" id="codigo" type="text" maxlength="50"/></div>
						</div>
						<div class="control-group">
												<label class="control-label">Modo</label>
												<div class="controls">
																		<form:select path ='modo'  id="modo" name="modo" class="selectpicker span12">
																		    <form:option value="A" label="Agrupa"/>
																			<form:option value="D" label="Detalla"/>
																		</form:select>
																	</div>
												</div>
						<div class="control-group">
							<label class="control-label" for="firstname" id="descripcion" >Descripcion</label>
							<div class="controls">
							<form:textarea id="descripcion" maxlength="100" path="descripcion" rows="5" cols="100" class="span12" style="margin: 0px; width: 322px; height: 121px;"/>
						</div>
						<!-- Group -->

						<!-- // Group END -->

					</div>
					<!-- // Column END -->

					<!-- Column -->

					<!-- // Column END -->
		</div>

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

