package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.model.Concepto;

public interface ConceptoService extends AbstractService<Concepto>{

	List<ConfigBean> getConceptListByFiltro(Integer tipoDocumento,String tipoValor);
}
