package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.model.Concepto;

public interface ConceptoService extends AbstractService<Concepto>{

	public List<ConfigBean> getConceptListByFiltro(Integer tipoDocumento,String tipoValor);
	
	/**
	 * Toma la cuenta, el tipo de Entidad y la entidad por concepto.
	 * 
	 * @param conceptoIds lista de Conceptos
	 * @return
	 */
	public List<ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(List<Integer> conceptoIds);
}
