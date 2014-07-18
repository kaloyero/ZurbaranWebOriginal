<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="contEdit modal hide fade" id="modal-simple" style="width:65%" >
			<div class="innerLR">

<form:form commandName="Chequera" class="contFormEdit form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

	
<table class="table table-bordered table-striped" id="tableCuenta">
																	<thead>
																		<tr>
																			<th class="center span2">Numero de cheque no Disponible</th>
																			<th class="center span2">Motivo</th>

																		</tr>
																	</thead>
																	<tbody id="contCuentasBody">
														 				<tr>

               																 <td class="contId"><input  type="text"   style=" width: 100px;"></td>
               																 <td class="contId"><input  type="text"   style=" width: 100px;"></td>
               															
               														 </tr>
               								
        																
																	</tbody>
																	
																</table>

      			</form:form>	
      			<hr class="separator">

				<!-- Form actions -->
				<div class="form-actions">
					<button type="submit" class="btn btn-icon btn-primary glyphicons circle_ok contGuardar"><i></i>Save</button>
					<button type="button" class="btn btn-icon btn-default glyphicons circle_remove"><i></i>Cancel</button>
				</div>
      
</div>
</div>

