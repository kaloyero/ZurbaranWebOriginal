package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.DocumentoHeaderBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.form.CuentaForm;
import com.contable.form.CuentaMonedaForm;
import com.contable.form.MonedaForm;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.TipoDocumentoManager;
import com.contable.mappers.TipoDocumentoMapper;
import com.contable.services.TipoDocumentoService;

@Service("tipoDocumentoManager")
public class TipoDocumentoManagerImpl extends ConfigurationManagerImpl<TipoDocumento,TipoDocumentoForm> implements TipoDocumentoManager{

	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	@Autowired
	CuentaManager cuentaManager;

	@Autowired
	EntidadManager entidadManager;
	
	@Override
	protected AbstractService<TipoDocumento> getRelatedService() {
		return tipoDocumentoService;
	}

	@Override
	protected Mapper<TipoDocumento,TipoDocumentoForm> getMapper() {
		return new TipoDocumentoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(TipoDocumento.fieldNombre());
		list.add(TipoDocumento.fieldEstado());
		return list;
	}

	@Override
	public List<TipoDocumentoForm> getLista() {
		TipoDocumentoMapper mapper = new TipoDocumentoMapper();
		
		tipoDocumentoService.getLista_v();
		List<TipoDocumentoForm> list = mapper.getFormViewList(tipoDocumentoService.getLista_v());
		
		return list;
	}

	public List<TipoDocumentoForm> getListDocumentTypeByAdm(Integer idAdm) {
		List<TipoDocumentoForm> list = ((TipoDocumentoMapper) getMapper()).getFormViewList(tipoDocumentoService.getTipoDocumentosByIdAdm(idAdm));

		return list;
	}

	//TODO mover este metodo a DOCUMENTO SERVICE
	public String getLastDocNumeration(int idTipoDocumento,String numTipo, String numPeriodo, String numFormato) {
		String numeracion = "";
		if (numTipo.equals("M") ){
			if (numPeriodo.equals("G") ){
				if (numFormato.equals("N")){
					numeracion = "";	
				} else if (numFormato.equals("N")){
					numeracion = "A";
				}
			} else if (numPeriodo.equals("E") ){
				if (numFormato.equals("N")){
					numeracion = "";	
				} else if (numFormato.equals("N")){
					numeracion = "X";
				}
			}
		} else {
			Calendar fecha = Calendar.getInstance();
			String dia = Integer.toString(fecha.get(Calendar.DATE));
			String mes = Integer.toString(fecha.get(Calendar.MONTH));
			String anio = Integer.toString(fecha.get(Calendar.YEAR));
			Integer nextNum = 1; //TODO trear el ultimo segun el tipo de documento
			if (numPeriodo.equals("H") ){
				numeracion = ""+ String.valueOf(nextNum);	
			} else if (numPeriodo.equals("A") ){
				numeracion = ""+ anio + String.valueOf(nextNum);	
			} else if (numPeriodo.equals("M") ){
				numeracion = ""+ anio + mes + String.valueOf(nextNum);	
			} else if (numPeriodo.equals("D") ){
				numeracion = ""+ anio + mes + dia + String.valueOf(nextNum);	
			}
		}
		
		
		return numeracion;
	}

	public DocumentoHeaderBean getDocumentHeaderByTipodocumento(int idTipoDocumento) {
		DocumentoHeaderBean form = new DocumentoHeaderBean();
		
		//Obtengo la información del tipo documento
		
		//TipoDocumento tipoDoc = tipoDocumentoService.findById(idTipoDocumento);
		TipoDocumentoForm tipoDocForm = this.findById(idTipoDocumento);
		//Obtengo la cuenta y sus monedas
		CuentaForm cuentaForm = cuentaManager.findById(tipoDocForm.getCuentaId());
		
		/* Seteo el tipo de documento */
		form.setTipoDocumento(tipoDocForm);
		/* Seteo el tipo la Numeracion */
		form.setNumeracion(this.getLastDocNumeration(idTipoDocumento,tipoDocForm.getNumeracionTipo(), tipoDocForm.getNumeracionPeriodo(), tipoDocForm.getNumeracionFormato()));
		/* Seteo la Cuenta */
		form.setCuenta(cuentaForm);		
		/* Seteo las Monedas */
		form.setMonedas(  getMonedasParaDocumento(tipoDocForm, cuentaForm)  );
		/* Seteo las Entidades */
		form.setEntidades(   entidadManager.getEntidadesByTipoEntidadForm(cuentaForm.getTipoEntidad() )   );
		
		return form;
	}
	
	/**
	 * Valida de donde extrae las monedas, si del Tipo de Documento o la Cuenta
	 * 
	 * @param tipoDocForm
	 * @param cuentaForm
	 * @return
	 */
	private List<MonedaForm> getMonedasParaDocumento (TipoDocumentoForm tipoDocForm,CuentaForm cuentaForm ) {
		List<MonedaForm> monedas = new ArrayList<MonedaForm>();
		
		// Se fija si hay una moneda definida en el Tipo de Documento
		if (tipoDocForm.getMoneda() != null && tipoDocForm.getMoneda().getNombre() != null) {
			//Valida que la moneda este ACTIVA para poder operar
			if (tipoDocForm.getMoneda().getEstado().equals(Constants.UI_ACTIVO) ){
				//agrega la moneda
				monedas.add(tipoDocForm.getMoneda());
			}
		} else {
			//Si el tipo de Documento no tiene monedas definidas toma las de Cuenta moneda
			//Valida que tenga monedas la cuenta
			if (cuentaForm.getMonedas() != null){
				for (CuentaMonedaForm ctaMonedaForm : cuentaForm.getMonedas()) {
					//Valida que la moneda este ACTIVA para poder operar
					if (ctaMonedaForm.getMoneda().getEstado().equals(Constants.UI_ACTIVO) ){
						//agrega la moneda
						monedas.add(ctaMonedaForm.getMoneda());
					}
				}
			}
			
		}
		
		return monedas;
	}
	
}
