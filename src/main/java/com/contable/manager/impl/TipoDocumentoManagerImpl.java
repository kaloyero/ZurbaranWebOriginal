package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.DocumentoHeaderBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.form.CuentaForm;
import com.contable.form.CuentaMonedaForm;
import com.contable.form.DocumentoValTerceForm;
import com.contable.form.EntidadForm;
import com.contable.form.MonedaForm;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.DocumentoManager;
import com.contable.manager.DocumentoTerceManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.TipoDocumentoManager;
import com.contable.mappers.TipoDocumentoMapper;
import com.contable.services.TipoDocumentoConceptosService;
import com.contable.services.TipoDocumentoService;

@Service("tipoDocumentoManager")
public class TipoDocumentoManagerImpl extends ConfigurationManagerImpl<TipoDocumento,TipoDocumentoForm> implements TipoDocumentoManager{

	@Autowired
	TipoDocumentoService tipoDocumentoService;
	
	@Autowired
	TipoDocumentoConceptosService tipoDocumentoConceptosService;

	@Autowired
	DocumentoManager documentoManager;
	
	@Autowired
	DocumentoTerceManager documentoTerceManager;

	@Autowired
	CuentaManager cuentaManager;

	@Autowired
	EntidadManager entidadManager;
	
	@Autowired
	ConceptoManager conceptoManager;
	
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
//		form.setNumeracion(this.getLastDocNumeration(idTipoDocumento,tipoDocForm.getNumeracionTipo(), tipoDocForm.getNumeracionPeriodo(), tipoDocForm.getNumeracionFormato()));
		/* Seteo la Cuenta */
		form.setCuenta(cuentaForm);		
		/* Seteo las Monedas */
		List<MonedaForm> monedas = getMonedasParaDocumento(tipoDocForm, cuentaForm); 
		form.setMonedas(  monedas  );
		/* Seteo las Entidades */
		List<ConfigBean> entidades=entidadManager.getEntidadesByTipoEntidadForm(cuentaForm.getTipoEntidad() ,Constants.CAMPO_EXTRA_NINGUNO ); 
		form.setEntidades(   entidades   );

		/* Seteo listados de Conceptos según permisos */ 
		if (tipoDocForm.getPermiteImputaciones().equals(Constants.UI_SI)){
//EXCEPCION : si no trae conceptos xq no los tiene el tipo documento, toma directamente los conceptos 
			List<ConfigBean> lista = getListaDeConceptos(idTipoDocumento, Constants.TIPODOCUMENTO_TIPOVALOR_NOVALOR); 
			form.setConceptoImp(lista);
		}	
		if (tipoDocForm.getPermiteIngValTer().equals(Constants.UI_SI)){
//EXCEPCION : si no trae conceptos xq no los tiene el tipo documento, toma directamente los conceptos
			List<ConfigBean> lista = getListaDeConceptos(idTipoDocumento, Constants.TIPODOCUMENTO_TIPOVALOR_VALTERCE); 
			form.setConceptoIngValTer(lista);
		}
		if (tipoDocForm.getPermiteValProp().equals(Constants.UI_SI)){
//EXCEPCION : si no trae conceptos xq no los tiene el tipo documento, toma directamente los conceptos
			List<ConfigBean> lista = getListaDeConceptos(idTipoDocumento, Constants.TIPODOCUMENTO_TIPOVALOR_VALPROPIO); 
			form.setConceptoValProp(lista);
		}
		if (tipoDocForm.getPermiteEgrValTer().equals(Constants.UI_SI)){
			form.setDocsValTerce(  getEgresoDeValoresDisponibles()  );
		}
		if (tipoDocForm.getPermiteAplicaciones().equals(Constants.UI_SI)){
			form.setDocsAplicaciones(  getListDocumentosParaAplicaciones(idTipoDocumento,cuentaForm, monedas, entidades)  );
		}

		return form;
	}
	
	private List<ConfigBean> getListaDeConceptos(Integer idTipoDocumento, String tipoValor){
		List<ConfigBean> lista = conceptoManager.getConfigNameListByFiltro(idTipoDocumento, tipoValor); 
		if (lista.isEmpty()){
			lista = conceptoManager.getConfigNameListByFiltro(tipoValor);
		}
		return lista;
	}
	
	
	private List<DocumentoValTerceForm> getEgresoDeValoresDisponibles(){
		List<DocumentoValTerceForm> lista = documentoTerceManager.getListaDocumentosDisponiblesTerceros();
//		if (lista != null && lista.isEmpty() == false){
//			for (DocumentoValTerceForm documentoValTerceForm : lista) {
//				
//			}
//		}
		return lista;
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
		
		// Se fija si hay una moneda definida en el Tipo de Documento. Valida tambien que la moneda este ACTIVA para poder operar
		if (tipoDocForm.getMoneda() != null && tipoDocForm.getMoneda().getNombre() != null && tipoDocForm.getMoneda().getEstado().equals(Constants.UI_ACTIVO)) {
				//agrega la moneda
				monedas.add(tipoDocForm.getMoneda());
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
	
	/**
	 * Devuelve la lista de de documentos para Cancelar (APLICACIONES)
	 * 
	 * @param cuentaForm
	 * @param monedas
	 * @param entidades
	 * @return
	 */
	private List<ConfigBean> getListDocumentosParaAplicaciones (Integer idTipoDocumento,CuentaForm cuentaForm,List<MonedaForm> monedas,List<ConfigBean> entidades ) {
		List<ConfigBean> lista = new ArrayList<ConfigBean>();
		
		if (monedas != null && ! monedas.isEmpty()){
			//Recupero la primer moneda
			Integer primerMoneda = monedas.get(0).getId();
			if (cuentaForm.getTipoEntidad() == null || cuentaForm.getTipoEntidad().getId() == null){
				lista = documentoManager.getDocAplicacionesLista(idTipoDocumento, cuentaForm.getId(), null, primerMoneda);
			} else {
				if (entidades == null || entidades.isEmpty() || entidades.get(0).getId() <= 0){
					lista = documentoManager.getDocAplicacionesLista(idTipoDocumento, cuentaForm.getId(), null, primerMoneda);
				} else {
					lista = documentoManager.getDocAplicacionesLista(idTipoDocumento, cuentaForm.getId(), entidades.get(0).getId(), primerMoneda);
				}
			}
		}
		
		return lista;
	}

	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(TipoDocumentoForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		int idTipoDoc = tipoDocumentoService.save(getMapper().getEntidad(form));
		tipoDocumentoService.saveConceptos(idTipoDoc , form.getConceptos());
		return res;
	}

	@Override
	@Transactional
	public ErrorRespuestaBean update(TipoDocumentoForm form) {
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		getRelatedService().update(getMapper().getEntidad(form));
		tipoDocumentoService.updateTipodocumentoconcepto(form.getConceptos(), form.getId());
		return res;
	}

	@Override
	@Transactional
	public TipoDocumentoForm findById(Integer id) {
		TipoDocumentoForm form = getMapper().getForm(getRelatedService().findById(id) );
		if (form.getEntidadId()  != null){
			EntidadForm entidadForm = entidadManager.findById(id);
			if (entidadForm != null){
				form.setEntidadNombre(entidadForm.getNombre());
			}
		}
		
		
		Collection<ConfigBean> conceptos = tipoDocumentoConceptosService.getConceptosByIdTipoDocumento(form.getId());  
		form.setConceptoConf(conceptos);
		
		Collection<Integer> conceptosInt = new ArrayList<Integer>(); 
		for (ConfigBean configBean : conceptos) {
			conceptosInt.add(configBean.getId());
		}
		
		form.setConceptos(conceptosInt);
		
		return form;
	}

	
}
