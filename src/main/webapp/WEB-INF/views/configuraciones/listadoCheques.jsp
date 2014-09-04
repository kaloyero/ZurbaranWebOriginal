<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style type="text/css">

</style>
<div class="span12 contListadoCheque modal hide fade PrintArea "  style="left: 8% !important;top: 5% !important;width:64%; height:215px;" id="modal-simple">

	<div class="innerLR">

		<form:form commandName="Documento" class="contFormNew form-horizontal" style="margin-bottom: 0;" id="validateSubmitForm" method="get" autocomplete="off" novalidate="novalidate">

						<div class="span12 document-tabla" style="height: 440px;">
							<div class="wizard">
								<div class="widget widget-tabs widget-tabs-double">
						
									<div class="widget-body">
												<div class="tab-pane active" id="newtab1-2">
													<div class="row-fluid">
														<!-- Table -->
														<div class="span12">
															<table class="span8 table table-bordered table-striped ">
																<thead>
																	<tr >
																		<th class="center span9 col1">Numero Cheque</th>
																		<th class="center span9 col2">Estado</th>
																		<th class="center span4 ">Motivo</th>
																		<th class="center span4 ">Importe</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="cheque" items="${cheques}" varStatus="loopStatus">
																		<tr>
																			<td>${cheque.numero}</td>
																			<td>${cheque.estado}</td>
																			<td>${cheque.motivo}</td>
																			<td>${cheque.importe}</td>
																		</tr>
																		
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											
												</div>
										</div>
									</div>
								</div>
										</form:form>	
								
</div>
</div>

