<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="heading-buttons">
	<h3>Estructura Contenido</h3>
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
			<table id="configurationTable" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th>Id</th>
						<th>Codigo</th>
						<th>Modo</th>
						<th>Estructura</th>
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

</div>

<div class="contNew modal hide fade" id="modal-simple">

<div class="innerLR">

	<!-- Form -->
	<form:form commandName="EstructuraContenido" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

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

						<!-- Group -->
						<div class="control-group">
							<label class="control-label" for="firstname">Estructuras</label>
							<div class="controls"><form:select class='selectpicker span10'  path ='estructuraId' multiple="false">
																					<form:options items="${estructuras}" itemValue="id" itemLabel="nombre" />
																				</form:select></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Codigo</label>
							<div class="controls"><input class="span5" id="codigo" name="codigo" type="text"></div>
						</div>
						<div class="control-group">
												<label class="control-label">Modo</label>
												<div class="controls">
																		<select id="estado" name="modo" class="selectpicker span6">
																			<option value="A">Agrupa</option>
																			<option value="D">Detalla</option>
																		</select>
																	</div>
												</div>
						<div class="control-group">
							<label class="control-label" for="firstname" id="descripcion" >Descripcion</label>
							<div class="controls">
								<textarea id="descripcion" maxlength="100" name="descripcion" rows="4" cols="100" class="span10" style="margin: 0px; width: 322px; height: 121px;"></textarea></div>
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
