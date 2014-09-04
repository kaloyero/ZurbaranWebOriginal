package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.IValidarCodigo;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.common.beans.DocumentoMovimientoBean;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.constants.ConstantsErrors;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.mappers.ConceptoMapper;
import com.contable.services.ConceptoService;

@Service("conceptoManager")
public class ConceptoManagerImpl extends ConfigurationManagerImpl<Concepto,ConceptoForm> implements ConceptoManager, IValidarCodigo{

	@Autowired
	ConceptoService conceptoService;
	
	@Autowired
	EntidadManager entidadManager;
	
	@Autowired
	CuentaManager cuentaManager;

	@Override
	protected AbstractService<Concepto> getRelatedService() {
		return conceptoService;
	}

	@Override
	protected Mapper<Concepto,ConceptoForm> getMapper() {
		return new ConceptoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Concepto.fieldNombre());
		list.add(Concepto.fieldAdministracion());
		list.add(Concepto.fieldCodigo());
		list.add(Concepto.fieldCuenta());
		list.add(Concepto.fieldDescripcion());
		list.add(Concepto.fieldEntidad());
		list.add(Concepto.fieldMoneda());
		list.add(Concepto.fieldNombre());
		list.add(Concepto.fieldEstado());
		return list;
	}

	public DocumentoMovimientoBean getDocumentMovByConcept(int conceptoId){
		DocumentoMovimientoBean bean = new DocumentoMovimientoBean();

		ConceptoForm conceptoForm = this.findById(conceptoId);
		
		/* Seteo el Concepto */
			bean.setConcepto(conceptoForm);
		
		/* Seteo la Cuenta */
			bean.setCuenta(conceptoForm.getCuenta());

		/* Seteo las Monedas con su cotizacion */
			List<ConfigBean> listaMonedas = new ArrayList<ConfigBean>();
			if (conceptoForm.getMoneda() == null || conceptoForm.getMoneda().getId() == null){
				//Si la Moneda del concepto es null Trae las monedas correspondientes a la cuenta
				listaMonedas = cuentaManager.getMonedasConfigByCuenta(conceptoForm.getCuenta().getId());
			} else {
				ConfigBean configBean = new ConfigBean(conceptoForm.getMoneda().getId(),conceptoForm.getMoneda().getCodigo(), conceptoForm.getMoneda().getNombre());
				listaMonedas.add(configBean);
			}
			bean.setMonedas(listaMonedas);
		
		/* Seteo las Entidades */
			List<ConfigBean> listaEntidades = new ArrayList<ConfigBean>();
			if (conceptoForm.getEntidad() == null || conceptoForm.getEntidad().getId() == null){
				//Si la Entidad del concepto es null Trae las entidades correspondientes al Tipo de Entidad
				listaEntidades = entidadManager.getEntidadesByTipoEntidadForm(  conceptoForm.getCuenta().getTipoEntidad() ,Constants.CAMPO_EXTRA_NINGUNO  ) ;
			} else {
				ConfigBean configBean = new ConfigBean(conceptoForm.getEntidad().getId(), conceptoForm.getEntidad().getNombre(),conceptoForm.getEntidad().getCodigoReferencia());
				listaEntidades.add(configBean);
			}
			bean.setEntidades(   listaEntidades   );
		
		return bean; 
	}

	public List<ConfigBean> getConfigNameListByFiltro(Integer tipoDocumento,String tipoValor){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = conceptoService.getConceptListByFiltro(tipoDocumento,tipoValor);
		
		return list;
	}

	public List<ConfigBean> getConfigNameListByFiltro(String tipoValor){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = conceptoService.getConceptListByFiltro(tipoValor);
		
		return list;
	}

	public HashMap<Integer,ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(List<Integer> conceptoIds){
		HashMap<Integer,ConsultasGeneralesBean> map = new HashMap<Integer, ConsultasGeneralesBean>();
		List<ConsultasGeneralesBean> lista = conceptoService.getConceptoInfoParaDocumentoMov(conceptoIds);
		for (ConsultasGeneralesBean bean : lista) {
			map.put(bean.getId(), bean);
		}
		
		return map;
	}

	
	
	
	@Override
	@Transactional
	public ErrorRespuestaBean guardarNuevo(ConceptoForm form) {
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);

		//Valido que el c�digo no este repetido
		res = validarConceptoCodigoRepetido(form.getCodigo());
		if (res.isValido()){
			res = super.guardarNuevo(form);
		}
		
		return res;
	}

	@Override
	@Transactional
	public ErrorRespuestaBean update(ConceptoForm form) {
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		//Valido que el c�digo no este repetido
		res = validarConceptoCodigoRepetido(form.getCodigo());
		if (res.isValido()){
			res = super.update(form);
		}
		
		return res;
	}

	private ErrorRespuestaBean validarConceptoCodigoRepetido(String codigo){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		//Valido que el c�digo no este repetido
		if (validarCodigoRepetido(codigo)){
			res.setValido(false);
			res.setCodError(ConstantsErrors.CONCEPTO_COD_1_COD_ERROR);
			res.setError(ConstantsErrors.CONCEPTO_COD_1_ERROR);
			res.setDescripcion("El c�digo ingresado existe.");
		}		
		
		return res;
	}

	@Override
	public boolean validarCodigoRepetido(String codigo) {
		return conceptoService.validarCodigoNoRepetido(codigo);
	}

	@Override
	public boolean validarCodigoRepetido(String codigo, int id) {
		return conceptoService.validarCodigoNoRepetido(codigo,id);
	}
}
