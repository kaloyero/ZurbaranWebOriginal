package com.contable.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.contable.common.beans.Form;
import com.contable.manager.EntidadManager;


public class DocumentoGenericMapper implements Form {
	
	@Autowired
	private EntidadManager entidadManager;
	private DocumentoForm form ;

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	public DocumentoForm getDocumentoForm(DocumentoGenericForm[] listado) {
		form= new DocumentoForm();
		
		for (DocumentoGenericForm genericForm : listado) {
		    if  (genericForm.getSector().equalsIgnoreCase("Header")){
		    	createHeaderMap(genericForm);
		    	}
		    if  (genericForm.getSector().equalsIgnoreCase("imputaciones")){
		    	createImputacionMap(genericForm);
		    	}
		    if  (genericForm.getSector().equalsIgnoreCase("propios")){
		    	createValoresPropiosMap(genericForm);
		    	}
		    if  (genericForm.getSector().equalsIgnoreCase("ingreso")){
		    	createValoresIngresoTerMap(genericForm);
		    	}
		    if  (genericForm.getSector().equalsIgnoreCase("cancelacion")){
		    	createAplicacionMap(genericForm);
		    	}
		    }
		return form;
	}
	public void createHeaderMap(DocumentoGenericForm genericForm ) {
		
		AdministracionForm administracion =new AdministracionForm();
    	administracion.setId(genericForm.getAdministracionId());
    	form.setCuentaId(genericForm.getCuentaId());
    	//Entidad ent =((Entidad )entidadManager.findById(1)).getTipoEntidad().getId();
    	form.setAdministracion(administracion);
    	Integer tipoEntidad=1;
    	form.setTipoEntidadId(tipoEntidad);
    	form.setMonedaId(genericForm.getMonedaId());
    	form.setDescripcion(genericForm.getDescripcion());
    	form.setEntidadId(genericForm.getEntidadId());
    	form.setFechaIngreso(genericForm.getFechaIngreso());
    	form.setFechaReal(genericForm.getFechaReal());
    	form.setFechaVencimiento(genericForm.getFechaVencimiento());
    	form.setTipoDocumentoId(genericForm.getTipoDocumentoId());
    	form.setCotizacion(genericForm.getCotizacion());
    	form.setImporteTotal(genericForm.getImporteTotal());
    	form.setNumero(3);
    	form.setTipoMovimiento(genericForm.getTipoMovimiento());
    	form.setPeriodoId(1);

	}
	public void createImputacionMap(DocumentoGenericForm genericForm) {
		DocumentoMovimientoForm movimiento= new DocumentoMovimientoForm();
		movimiento.setConceptoId(genericForm.getConceptoId());
    	Integer tipoEntidad=1;
    	Integer cuentaId=1;
    	movimiento.setEntidadId(genericForm.getEntidadId());
    	//movimiento.setCuentaId(cuentaId);
    	//movimiento.setTipoEntidadId(tipoEntidad);
    	movimiento.setMonedaId(genericForm.getMonedaId());
    	movimiento.setCodMovimiento("IM");
    	//movimiento.setTipoMovimiento("D");
    	movimiento.setCotizacion(genericForm.getCotizacion());
    	movimiento.setImporte(genericForm.getImporteTotal());

    	form.getImputaciones().add(movimiento);

		
		// TODO Auto-generated method stub
	}
	public void createAplicacionMap(DocumentoGenericForm genericForm) {

		DocumentoAplicacionForm aplicacion =new DocumentoAplicacionForm();
		aplicacion.setDocumentoAplicaId(genericForm.getDocumentoAplicaId());
		aplicacion.setImporte(genericForm.getImporteAplicado());
		form.getAplicaciones().add(aplicacion);
	}
	public void createValoresIngresoTerMap(DocumentoGenericForm genericForm) {
		
		
		DocumentoMovimientoValorTerceForm movimientoIngTer = new DocumentoMovimientoValorTerceForm();
		DocumentoValTerceForm ingreTerForm =new DocumentoValTerceForm();
		BancoForm bancoForm =new BancoForm();
		
		bancoForm.setId(genericForm.getBancoId());
		ingreTerForm.setBanco(bancoForm);
		ingreTerForm.setNumero(genericForm.getNumero());
		ingreTerForm.setFechaVencimiento(genericForm.getFechaVencimiento());
		
		movimientoIngTer.setConceptoId(genericForm.getConceptoId());
    	Integer tipoEntidad=1;
    	Integer cuentaId=1;

    	movimientoIngTer.setEntidadId(genericForm.getEntidadId());
    	movimientoIngTer.setTipoEntidadId(tipoEntidad);
    	movimientoIngTer.setMonedaId(genericForm.getMonedaId());
    	movimientoIngTer.setTipoMovimiento("D");
    	movimientoIngTer.setCuentaId(cuentaId);

    	movimientoIngTer.setCodMovimiento("IT");
    	movimientoIngTer.setCotizacion(genericForm.getCotizacion());
    	movimientoIngTer.setValorTerce(ingreTerForm);
    	movimientoIngTer.setImporte(genericForm.getImporteTotal());

    	form.getValoresIngreTerce().add(movimientoIngTer);
    	
	}
	public void createValoresPropiosMap(DocumentoGenericForm genericForm) {
		DocumentoMovimientoValorPropioForm movimientoPropio = new DocumentoMovimientoValorPropioForm();
		DocumentoValPropioForm valorPropioForm =new DocumentoValPropioForm();
		ChequeraForm chequera =new ChequeraForm();
		
		chequera.setId(1);
		movimientoPropio.setConceptoId(genericForm.getConceptoId());
    	Integer tipoEntidad=1;
    	Integer cuentaId=1;
    	
    	movimientoPropio.setEntidadId(genericForm.getEntidadId());
    	movimientoPropio.setTipoMovimiento("D");
    	movimientoPropio.setTipoEntidadId(tipoEntidad);
    	movimientoPropio.setMonedaId(genericForm.getMonedaId());
    	movimientoPropio.setCodMovimiento("PR");
    	movimientoPropio.setCotizacion(genericForm.getCotizacion());
    	movimientoPropio.setCuentaId(cuentaId);
    	movimientoPropio.setImporte(genericForm.getImporteTotal());

    	valorPropioForm.setBeneficiario(genericForm.getBeneficiario());
    	valorPropioForm.setNumero(genericForm.getNumero());
    	valorPropioForm.setChequera(chequera);
    	valorPropioForm.setFechaVencimiento(genericForm.getFechaVencimiento());
    	movimientoPropio.setValorPropio(valorPropioForm);
    	
    	
    	
    	form.getValoresPropio().add(movimientoPropio);
	}
	
	public int createValoresEgresoMap() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
}
