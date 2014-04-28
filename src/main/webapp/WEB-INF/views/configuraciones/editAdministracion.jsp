<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="contEdit modal hide fade" id="modal-simple">

<div class="innerLR">

	<!-- Form -->
	<form:form commandName="Administracion" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
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
					<div class="span12">

						<!-- Group -->

						<div class="tab-pane active" id="newtab2-2">
												<div class="row-fluid">
																<!-- Table -->
																<table id="contImputaciones" class="table table-bordered table-striped">
<thead>
																		<tr>
																		<th class="center span3">Cuenta</th>
																			<th class="center span3">Tipo Entidad</th>
																			<th class="center span3">Entidad</th>
																		</tr>
																	</thead>
																	<tbody id="contImputacionesBody">
																		<tr style='border:5px solid #427BD6'>
														
																			<td class='contImputacionesMoneda'><input type="text" class="span12"></td>
																			<td class='contCotizacion'><input type="text" class="span12" ></td>
																			
																			<td class='contImporte span3'><input  list="browsers" name="browser" value="Firefox">
<datalist id="browsers">
  <option value="Internet Explorer" label="INNN">
  <option value="Firefox">
  <option value="Chrome">
  <option value="Opera">
  <option value="Safari">
</datalist>
<input type="submit">
																			</td>
																		</tr>
																		
																	</tbody>
																	
																</table>
														
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
