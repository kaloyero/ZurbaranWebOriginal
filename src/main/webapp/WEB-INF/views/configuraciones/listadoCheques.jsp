<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<div class="contListadoCheque modal hide fade" id="modal-simple" style="width:65% ;margin-top: -30px;margin-left: -370px;" >
			<div class="innerLR">


			<!-- Table -->
			<table id="configurationTableCheques" class="dynamicTable table table-striped table-bordered table-condensed">

				<!-- Table heading -->
				<thead>
					<tr>
						<th class="" style="width: 64px;">Numero Cheque</th>
																		<th>Beneficiario</th>
																		<th>Fecha Emision</th>
																		<th>Fecha Vencimiento</th>
																		<th>Estado</th>
																		<th style="width: 300px;">Motivo</th>
																		<th>Importe</th>
					</tr>
				</thead>
				<!-- // Table heading END -->

				<!-- Table body -->
				<tbody>

						<c:forEach var="cheque" items="${cheques}" varStatus="loopStatus">
																		<tr>
																			<td>${cheque.numero}</td>
																			<td>${cheque.beneficiario}</td>
																			<td>${cheque.fechaIngreso}</td>
																			<td>${cheque.fechaVencimiento}</td>
																			<td>${cheque.estado}</td>
																			<td>${cheque.motivo}</td>
																			<td>${cheque.importeValor}</td>
																			
																			
																		</tr>
																		
																	</c:forEach>

				</tbody>
				<!-- // Table body END -->

			</table>
			<!-- // Table END -->







	
								
</div>
</div>

