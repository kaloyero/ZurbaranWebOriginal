package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.DocumentoMovimientoBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.mappers.ConceptoMapper;
import com.contable.services.ConceptoService;

@Service("conceptoManager")
public class ConceptoManagerImpl extends ConfigurationManagerImpl<Concepto,ConceptoForm> implements ConceptoManager{

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
		bean.setMonedas(cuentaManager.getMonedasConfigByCuenta(conceptoForm.getCuenta().getId()));
		/* Seteo las Entidades */
		bean.setEntidades(   entidadManager.getEntidadesByTipoEntidadForm(  conceptoForm.getCuenta().getTipoEntidad() )   );
		
		return bean; 
	}

	public List<ConfigBean> getConfigNameListByFiltro(Integer tipoDocumento,String tipoValor){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = conceptoService.getConceptListByFiltro(tipoDocumento,tipoValor);
		
		return list;
	}
	
}
