package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.model.Concepto;

public interface ConceptoDao extends GenericDao<Concepto, Integer> {

	/**
	 * Toma la cuenta, el tipo de Entidad y la entidad por concepto.
	 * 
	 * @param conceptoIds lista de Conceptos
	 * @return
	 */
	public List<ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(Integer[] conceptoIds);

}
