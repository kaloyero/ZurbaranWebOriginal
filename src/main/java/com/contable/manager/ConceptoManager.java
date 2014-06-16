package com.contable.manager;

import java.util.HashMap;
import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ConsultasGeneralesBean;
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
	

	/**
	 * Toma los conceptos pertencientes al Tipo de Documento seleccionado.
	 * Filtra por tipo de valor.
	 * 
	 * @param tipoDocumento
	 * @param tipoValor
	 * @return
	 */
	List<ConfigBean> getConfigNameListByFiltro(Integer tipoDocumento,String tipoValor);
	
	/**
 	 * Toma los conceptos Filtra solo por tipo de valor.
	 * 
	 * @param tipoValor
	 * @return
	 */
	public List<ConfigBean> getConfigNameListByFiltro(String tipoValor);
	
	
	/**
	 * Toma la cuenta, el tipo de Entidad y la entidad por concepto.
	 * 
	 * @param conceptoIds lista de Conceptos
	 * @return
	 */
	public HashMap<Integer,ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(List<Integer> conceptoIds);

	
}
