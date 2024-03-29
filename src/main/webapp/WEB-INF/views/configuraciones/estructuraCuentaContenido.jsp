<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
	
	.modal {z-index: 2}
	.modal-backdrop {z-index: 1 !important}
</style>
<div class="contFormCuenta modal hide fade" id="modal-simple" style="width:45%" >
			<div class="innerLR">

<form:form commandName="EstructuraContenido" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

	
<table class="table table-bordered table-striped" id="tableCuenta" style="width: 100%;">
																	<thead style="display: block;">
																		<tr>
																			<th></th>
																			<th class="center span8" style="display:none">Id</th>
																			<th class="center span2" style="width: 169px;">Cuenta</th>
																			<th class="center span2" style="
    width: 150px;
">Entidad</th>
																			<th class="center span2">Moneda</th>
																		</tr>
																	</thead>
																	<tbody id="contCuentasBody" style=" overflow: auto; display: block; height: 100px;">
														<c:forEach var="cuenta" items="${EstructuraContenido.contenidoCuentas}" varStatus="loopStatus">   
														 				<tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

               																 <td class="contId" style="display:none">${cuenta.id}</td>
               																 <td>${cuenta.cuentaNombre}</td>
               																 <td>${cuenta.entidadNombre}</td>
               																 <td>${cuenta.moneda.nombre}</td>
               														 </tr>
               								
        															</c:forEach>
        																					 <tr>
																			<td ><a href="#" class="contDelete"><img style="max-width:20px;height:20;display:inline;float:right;margin-top:0.1cm;" src="resources/images/delete.jpeg"></a></td>

               																 <td class="contId" style="display:none"></td>
               																 <td><form:select class='contCuentaCombo  ' placeholder="Seleccione un valor"  path ='id'>
																						<option></option> 
																					<form:options items="${cuentas}" itemValue="id" itemLabel="nombre" />
																			</form:select></td>
               																 <td><select class='contEntidadCombo' id="entidadCombo" name="entidadCombo" class="" placeholder="Seleccione un valor" style="
    width: 150px;"
">
																		</select></td>
               																 <td><select  class='contMonedaCombo' id="monedaCombo" name="monedaCombo" class="" placeholder="Seleccione un valor" style="
    width: 150px;"
">
																		</select></td>
               														 </tr>
																	</tbody>
																	
																</table>

      			</form:form>	
      			<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok contGuardar"><i></i>Guardar</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancelar</button>
				</div>
      
</div>
</div>

