<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="contEdit modal hide fade" id="modal-simple" style="width:65%" >
			<div class="innerLR">

<form:form commandName="Chequera" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
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
							<label class="control-label" for="firstname">Numero Cheque</label>
							<div class="controls"><input class="span10" id="nombre" name="nombre" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Motivo</label>
							<div class="controls"><input class="span10" id="nombre" name="nombre" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Beneficiario</label>
							<div class="controls"><input class="span10" id="nombre" name="nombre" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Importe</label>
							<div class="controls"><input class="span10" id="nombre" name="nombre" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Fecha emision</label>
							<div class="controls"><input class="span10 datepicker" id="nombre" name="nombre" type="text" maxlength="100"></div>
						</div>
						<div class="control-group">
							<label class="control-label" for="firstname">Fecha Vencimientoo</label>
							<div class="controls"><input class="span10 datepicker" id="nombre" name="nombre" type="text" maxlength="100"></div>
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


				
				<!-- // Form actions END -->

			</div>
		</div>


      			</form:form>	
      			<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok contGuardar"><i></i>Save</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancel</button>
				</div>
      
</div>
</div>

