package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.model.Concepto;

public interface ConceptoService extends AbstractService<Concepto>{

	
	
	/**
	 * Toma la cuenta, el tipo de Entidad y la entidad por concepto.
	 * 
	 * @param conceptoIds lista de Conceptos
	 * @return
	 */
	public List<ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(List<Integer> conceptoIds);
	
	
	/**
	 * Toma los conceptos pertencientes al Tipo de Documento seleccionado.
	 * Filtra por tipo de valor.
	 * 
	 * @param tipoDocumento
	 * @param tipoValor
	 * @return
	 */
	public List<ConfigBean> getConceptListByFiltro(Integer tipoDocumento,String tipoValor);
	
	/**
	 * Toma los conceptos Filtra solo por tipo de valor.
	 * 
	 * @param tipoValor
	 * @return
	 */
	public List<ConfigBean> getConceptListByFiltro(String tipoValor);

}
