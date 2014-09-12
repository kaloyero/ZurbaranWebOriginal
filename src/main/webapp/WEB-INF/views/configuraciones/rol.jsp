<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<STYLE TYPE="text/css">
.flecha{
	
}

.flecha a{
	margin: 4px 12px;
}

.glyphicons i:before {
  font: 19px/1em 'Glyphicons' !important;
  color: #B12C2C !important;
}

</STYLE>
<div class="heading-buttons">
	<h3>Roles</h3>
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
						<th>Nombre</th>
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

</div>

<div class="contNew modal hide fade" id="modal-simple">

<div class="innerLR">

	<!-- Form -->
	<form:form commandName="Administracion" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

		<!-- Widget -->
		<div class="widget">

			<!-- Widget heading -->
			<div class="widget-head header-popup">
				<h4 class="heading">Complete los datos</h4>
			</div>
			<!-- // Widget heading END -->

			<div class="widget-body">


				<div class="row-fluid">

					<div class="span12">

						<div class="control-group">
							<label class="control-label" for="firstname">Nombre Rol</label>
							<div class="controls"><input class="span10" id="nombre" name="nombre" type="text" maxlength="100"></div>
						</div>

						<div class="control-group">
							<label class="control-label" for="firstname" id="descripcion" >Descripcion</label>
							<div class="controls">
								<textarea id="descripcion" maxlength="100" name="descripcion" rows="4" cols="100" class="span12" style="margin: 0px; width: 322px; height: 121px;resize:none"></textarea></div>
						</div>

						<div class="control-group">	
												
							<div class="span5">										
								<select multiple size="10" id="from">
							      <option value="html">Html</option>
							      <option value="css">Css</option>
							      <option value="google">Google</option>
							      <option value="javascript">Javascript</option>
							      <option value="jquery">Jquery</option>
							      <option value="regex">Regex</option>
							      <option value="php">Php</option>
							      <option value="mysql">Mysql</option>
							      <option value="xml">Xml</option>
							      <option value="json">Json</option>
							    </select>
							</div>
							<div class="span1 flecha" href="#" style="text-align:center">			
						        <a id="allToRight" href="#" class="glyphicons no-js circle_arrow_right"><i></i></a><br/> 
						        <a id="selectedToRight" href="#" class="glyphicons no-js right_arrow"><i></i></a><br/> 
						        <a id="selectedToLeft" href="#" class="glyphicons no-js left_arrow"><i></i></a> 
						        <a id="allToLeft" href="#" class="glyphicons no-js circle_arrow_left"><i></i></a><br/> 
						        
							</div>
						 	<div class="span5">
							    <select multiple id="to" size="10">
							    </select>						
							</div>								
																
						</div>	

						<hr class="separator">


						<div class="form-actions">
							<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Guardar</button>
							<button type="button" class="btn btn-icon btn-default glyphicons circle_remove contCancelNew"><i></i>Cancelar</button>
						</div>											
				
					</div>

			</div>
		</div>
		<!-- // Widget END -->

			</form:form>	
	<!-- // Form END -->

</div>
</div>
