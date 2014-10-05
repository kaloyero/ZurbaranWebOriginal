<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="contEdit modal hide fade" id="modal-simple">
	<div class="innerLR">


		<form:form commandName="Chequera" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

			<!-- Widget -->
			<div class="widget">

				<!-- Widget heading -->
				<div class="widget-head">
					<h4 class="heading">Complete los datos</h4>
				</div>
				<!-- // Widget heading END -->

				<div class="widget-body">

					<div class="row-fluid">

						<!-- Column -->
						<div class="span6">

							<div class="control-group">
								<label class="control-label">Administraci&oacute;n</label>
								<div class="controls">
									<form:input path ="administracion.nombre" class="span10" id="administracionNombre3333"  type="text" maxlength="100" readonly="true"/>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Numero Inicial</label>
								<div class="controls">
									<form:input path ="numeroIni" class="span10" id="numeroIni" name="numeroIni" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Numero Final</label>
								<div class="controls">
									<form:input path ="numeroFin" class="span10" id="numeroFin" name="numeroFin" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripci&oacute;n</label>
								<div class="controls">
									<textarea id="descripcion" maxlength="100" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; width: 179px; height: 102px;"></textarea>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Estado</label>
								<div class="controls">
								<form:input path ="estado" class="span10" id="estado" name="estado" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>

	
							<!-- // Group END -->

						</div>
						<!-- // Column END -->

						<!-- Column -->
						<div class="span6">

							<div class="control-group">
								<label class="control-label">Cuenta</label>
								<div class="controls">
								   	<form:input path ="cuentaNombre" class="span10" id="cuentaNombre" name="cuentaNombre" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls"> 
									<form:input path ="tipoEntidadNombre" class="span10" id="tipoEntidadNombre" name="tipoEntidadNombre" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>
		

							<div class="control-group">
								<label class="control-label">Entidad</label>
								<div class="controls">
									<form:input path ="entidadNombre" class="span10" id="entidadNombre" name="entidadNombre" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Moneda</label>
								<div class="controls">
									<form:input path ="moneda.nombre" class="span10" id="monedaNombre" name="monedaNombre" type="text" maxlength="100" readonly="true"/>

								</div>
							</div>
				


							<!-- // Group END -->

						</div>
						<!-- // Column END -->

					</div>


					<hr class="separator">

					<!-- Row -->


					<!-- // Row END -->

					<hr class="separator">

					<!-- Form actions -->
				
					<!-- // Form actions END -->

				</div>
			</div>
			<!-- // Widget END -->

			</form:form>	
		<!-- // Form END -->

	</div>
</div>

