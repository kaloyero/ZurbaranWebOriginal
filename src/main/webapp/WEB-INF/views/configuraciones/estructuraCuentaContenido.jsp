<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="contFormCuenta modal hide fade" id="modal-simple">
			<div class="innerLR">

<form:form commandName="EstructuraContenido" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

	
<table class="table table-bordered table-striped">
																	<thead>
																		<tr>
																			<th></th>
																			<th class="center span8">Id</th>
																			<th class="center span2">Cuenta</th>
																			<th class="center span2">Entidad</th>
																			<th class="center span2">Moneda</th>
																		</tr>
																	</thead>
																	<tbody id="contCancelacionesBody">
														<c:forEach var="cuenta" items="${EstructuraContenido.contenidoCuentas}" varStatus="loopStatus">   
														 				<tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

               																 <td class="contId">${cuenta.id}</td>
               																 <td>${cuenta.cuentaId}</td>
               																 <td>${cuenta.entidadId}</td>
               																 <td>${cuenta.moneda.nombre}</td>
               														 </tr>
               														 <tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

               																 <td class="contId"></td>
               																 <td><form:select class='contCuentaCombo  ' placeholder="Seleccione un valor"  path ='id'>
																						<option></option> 
																					<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
																			</form:select></td>
               																 <td></td>
               																 <td></td>
               														 </tr>
        															</c:forEach>
																	</tbody>
																	
																</table>

      			</form:form>	
      			<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok"><i></i>Save</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancel</button>
				</div>
      
</div>
</div>

