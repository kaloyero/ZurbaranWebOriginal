package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.DocumentoMovimientoBean;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;

public interface ConceptoManager extends ConfigurationManager<Concepto,ConceptoForm>{

	/**
	 * 
	 * 
	 * @param conceptoId
	 * @return
	 */
	DocumentoMovimientoBean getDocumentMovByConcept(int conceptoId);
	

	List<ConfigBean> getConfigNameListByFiltro(Integer tipoDocumento,String tipoValor);
}
