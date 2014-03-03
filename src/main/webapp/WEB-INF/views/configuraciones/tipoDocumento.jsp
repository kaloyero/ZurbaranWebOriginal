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
						<th>Codigo</th>
						<th>Nombre</th>
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
<div class="modal hide fade" id="modal-simple">
	<div class="innerLR">


		<form id="validateSubmitForm" style="margin-bottom: 0;" novalidate="novalidate" class="form-horizontal" action="/ZurbaranWeb/cuenta/show" method="get" autocomplete="off">
			

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
						<div class="span6">
							<div class="control-group">
								<label class="control-label">Administracion</label>
								<div class="controls">
									<select id="administracion.id" name="administracion.id" class="contAdministracion selectpicker span12">
																					<option value="1">Boca</option><option value="2">R</option><option value="3">Ca</option><option value="4">da</option><option value="5">Ea</option><option value="6">ga</option><option value="7">Er</option><option value="8">hh</option><option value="9">n</option><option value="10">r</option><option value="11">r33</option><option value="12">4</option><option value="13">34</option>
									</select>
								</div>
							</div>
							<!-- Group -->
							<div class="control-group">
								<label class="control-label" for="firstname">Nombre</label>
								<div class="controls">
									<input class="span12" id="nombre" name="nombre" type="text">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="firstname">Descripcion</label>
								<div class="controls">
									<textarea id="descripcion" name="descripcion" rows="4" cols="50" class="span12" style="margin: 0px; width: 273px; height: 100px;">Des
										</textarea>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tipo Entidad</label>
								<div class="controls">
									<select id="tipoEntidad.id" name="tipoEntidad.id" class="selectpicker span12">
																					<option value="5">Tipo1</option><option value="6">aa</option><option value="7">aa</option>
									</select>
								</div>
							</div>

							<div class="row-fluid">
								<div class="span6">
									<div class="control-group">
										<div class="widget-body uniformjs">

											<label class="checkbox"> <input type="checkbox" class="checkbox" value="1"> Manual
											</label> <label class="checkbox"> <input type="checkbox" class="checkbox" value="1" checked="checked"> Automatica
											</label>
										</div>
									</div>

								</div>
								<div class="span6">
									<div class="control-group">

										<div class="widget-body uniformjs">
											<label class="checkbox"> <input name="saldo" type="radio" class="checkbox" value="D"> Control General
											</label> <label class="checkbox"> <input type="radio" name="saldo" class="checkbox" value="A" checked="checked"> Control por unidad
											</label>
											<label class="checkbox"> <input name="saldo" type="radio" class="checkbox" value="D"> Historico
											</label> 
											<label class="checkbox"> <input name="saldo" type="radio" class="checkbox" value="D"> Anual
											</label> 
											<label class="checkbox"> <input name="saldo" type="radio" class="checkbox" value="D"> Mensual
											</label> 
											<label class="checkbox"> <input name="saldo" type="radio" class="checkbox" value="D"> Diario
											</label> 
										</div>
									</div>

								</div>


							</div>
<div class="control-group">
										<div class="widget-body uniformjs">

											<label class="checkbox"> <input type="checkbox" class="checkbox" value="1"> Debito
											</label> <label class="checkbox"> <input type="checkbox" class="checkbox" value="1" checked="checked"> Automatico
											</label>
										</div>
									</div>
									<div class="control-group">
										<div class="widget-body uniformjs">

											<label class="checkbox"> <input type="checkbox" class="checkbox" value="1"> Imputaciones
											</label> <label class="checkbox"> <input type="checkbox" class="checkbox" value="1" checked="checked"> Valores propios
											</label>
											<label class="checkbox"> <input type="checkbox" class="checkbox" value="1"> Valores de 3eros
											</label> <label class="checkbox"> <input type="checkbox" class="checkbox" value="1" checked="checked">Aplicaciones
											</label>
										</div>
									</div>
							<div class="control-group">
												<label class="control-label">Estado</label>
												<div class="controls">
																		<select id="estado" name="estado" class="selectpicker span12">
																			<option value="T">Activo</option>
																			<option value="F">No Activo</option>
																		</select>
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
						<button type="submit" class="save btn btn-icon btn-primary glyphicons circle_ok">
							<i></i>Save
						</button>
						<button type="button" class="btn btn-icon btn-default glyphicons circle_remove">
							<i></i>Cancel
						</button>
					</div>
					<!-- // Form actions END -->

				</div>
			</div>
			<!-- // Widget END -->

			</form>

	</div>
</div>



