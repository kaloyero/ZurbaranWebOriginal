<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div class="contListadoCheque modal hide fade" id="modal-simple" style="width:65%" >
			<div class="innerLR">



		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">
			<table class="span8 table table-bordered table-striped ">
																<thead>
																	<tr >
																		<th class="center span9 col1">Numero Cheque</th>
																		<th class="center span9 col1">Beneficiario</th>
																		<th class="center span9 col1">Fecha Vencimiento</th>
																		<th class="center span9 col1">Fecha Emision</th>
																		<th class="center span9 col2">Estado</th>
																		<th class="center span4 ">Motivo</th>
																		<th class="center span4 ">Importe</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="cheque" items="${cheques}" varStatus="loopStatus">
																		<tr>
																			<td>${cheque.numero}</td>
																			<td>${cheque.beneficiario}</td>
																			<td>${cheque.fechaVencimiento}</td>
																			<td>${cheque.fechaIngreso}</td>
																			<td>${cheque.estado}</td>
																			<td>${cheque.motivo}</td>
																			<td>${cheque.importeValor}</td>
																			
																			
																		</tr>
																		
																	</c:forEach>
																</tbody>
															</table>
							
										</form:form>	
								
</div>
</div>

