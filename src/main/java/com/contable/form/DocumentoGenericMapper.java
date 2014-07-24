package com.contable.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.contable.common.beans.Form;
import com.contable.common.utils.FormatUtil;
import com.contable.manager.EntidadManager;


public class DocumentoGenericMapper implements Form {
	
	private static final long serialVersionUID = 1L;
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
		    if  (genericForm.getSector().equalsIgnoreCase("egreso")){
		    	createValoresEgresoMap(genericForm);
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
    	//Integer tipoEntidad=1;
    	//form.setTipoEntidadId(tipoEntidad);
    	form.setMonedaId(genericForm.getMonedaId());
    	form.setDescripcion(genericForm.getDescripcion());
    	form.setEntidadId(genericForm.getEntidadId());
    	form.setFechaIngreso(genericForm.getFechaIngreso());
    	form.setDescripcion(genericForm.getDescripcion());
    	form.setFechaReal(genericForm.getFechaReal());
    	form.setFechaVencimiento(genericForm.getFechaVencimiento());
    	form.setTipoDocumentoId(genericForm.getTipoDocumentoId());
    	form.setCotizacion(genericForm.getCotizacion());
    	form.setImporteTotal(genericForm.getImporteTotal());
    	form.setNumero(genericForm.getNumero());
    	form.setNumeroAnio(genericForm.getNumeroAnio());
    	form.setNumeroDia(genericForm.getNumeroDia());
    	form.setNumeroEstablecimiento(genericForm.getNumeroEstablecimiento());
    	form.setNumeroLetra(genericForm.getNumeroLetra());
    	form.setNumeroMes(genericForm.getNumeroMes());
    	form.setTipoMovimiento(genericForm.getTipoMovimiento());
    	form.setPeriodoId(1);

	}
	public void createImputacionMap(DocumentoGenericForm genericForm) {
		DocumentoMovimientoForm movimiento= new DocumentoMovimientoForm();
		movimiento.setConceptoId(genericForm.getConceptoId());
    	movimiento.setEntidadId(genericForm.getEntidadId());
    	movimiento.setReferencia(genericForm.getReferencia());
    	//movimiento.setCuentaId(cuentaId);
    	//movimiento.setTipoEntidadId(tipoEntidad);
    	movimiento.setMonedaId(genericForm.getMonedaId());
    	movimiento.setCodMovimiento("IM");
    	//movimiento.setTipoMovimiento("D");
    	movimiento.setCotizacion(genericForm.getCotizacion());
    	movimiento.setImporte(FormatUtil.format2DecimalsStr(genericForm.getImporteTotal()));

    	form.getImputaciones().add(movimiento);

		
		// TODO Auto-generated method stub
	}
	public void createAplicacionMap(DocumentoGenericForm genericForm) {

		DocumentoAplicacionForm aplicacion =new DocumentoAplicacionForm();
		aplicacion.setDocumentoAplicaId(genericForm.getDocumentoAplicaId());
		aplicacion.setImporteAplicado(genericForm.getImporteAplicado());
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
    	//Integer tipoEntidad=1;
    	//Integer cuentaId=1;

		movimientoIngTer.setEntidadId(genericForm.getEntidadId());
    	//movimientoIngTer.setTipoEntidadId(tipoEntidad);
    	movimientoIngTer.setMonedaId(genericForm.getMonedaId());
    	movimientoIngTer.setTipoMovimiento("D");
    	//movimientoIngTer.setCuentaId(cuentaId);

    	movimientoIngTer.setCodMovimiento("IT");
    	movimientoIngTer.setCotizacion(genericForm.getCotizacion());
    	movimientoIngTer.setValorTerce(ingreTerForm);
    	movimientoIngTer.setImporte(FormatUtil.format2DecimalsStr(genericForm.getImporteTotal()));

    	form.getValoresIngreTerce().add(movimientoIngTer);
    	
	}
	public void createValoresPropiosMap(DocumentoGenericForm genericForm) {
		DocumentoMovimientoValorPropioForm movimientoPropio = new DocumentoMovimientoValorPropioForm();
		DocumentoValPropioForm valorPropioForm =new DocumentoValPropioForm();
		ChequeraForm chequera =new ChequeraForm();
		
		chequera.setId(1);
		movimientoPropio.setConceptoId(genericForm.getConceptoId());
    	//Integer tipoEntidad=1;
    	//Integer cuentaId=1;
    	
    	movimientoPropio.setEntidadId(genericForm.getEntidadId());
    	movimientoPropio.setTipoMovimiento("D");
    	//movimientoPropio.setTipoEntidadId(tipoEntidad);
    	movimientoPropio.setMonedaId(genericForm.getMonedaId());
    	movimientoPropio.setCodMovimiento("PR");
    	movimientoPropio.setCotizacion(genericForm.getCotizacion());
    	//movimientoPropio.setCuentaId(cuentaId);
    	movimientoPropio.setImporte(FormatUtil.format2DecimalsStr(genericForm.getImporteTotal()));

    	valorPropioForm.setBeneficiario(genericForm.getBeneficiario());
    	valorPropioForm.setNumero(genericForm.getNumero());
    	valorPropioForm.setChequera(chequera);
    	valorPropioForm.setFechaVencimiento(genericForm.getFechaVencimiento());
    	movimientoPropio.setValorPropio(valorPropioForm);
    	
    	
    	
    	form.getValoresPropio().add(movimientoPropio);
	}
	
	public void createValoresEgresoMap(DocumentoGenericForm genericForm) {
		// TODO Auto-generated method stub
		DocumentoValTerceForm terceForm=new DocumentoValTerceForm();
		DocumentoMovimientoValorTerceForm movimientoTerce= new DocumentoMovimientoValorTerceForm();
		movimientoTerce.setValorTerce(terceForm);
		terceForm.setId(genericForm.getValorTerceId());
		form.getValoresEgreTerce().add(movimientoTerce);
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
}
