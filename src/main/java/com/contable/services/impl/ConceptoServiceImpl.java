package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.ConceptoDao;
import com.contable.hibernate.dao.TipoDocumentoConceptoDao;
import com.contable.hibernate.model.Concepto;
import com.contable.services.ConceptoService;

@Service("conceptoService")
public class ConceptoServiceImpl extends AbstractServiceImpl<Concepto> implements ConceptoService{

	@Autowired
    private ConceptoDao conceptoDao;

	@Autowired
    private TipoDocumentoConceptoDao tipoDocumentoConceptoDao;

	protected GenericDao<Concepto, Integer> getDao() {
		return conceptoDao;
	}
	
	@Transactional
	public List<ConfigBean> getConceptListByFiltro(Integer tipoDocumento,String tipoValor){
		List<Property> filtros = new ArrayList<Property>();
		
		filtros.add(new Property(Restrictions.eq("idTipoDocumento", tipoDocumento), Property.OPERATOR_AND));
		filtros.add(new Property(Restrictions.like("concepto.tipoValor", tipoValor), Property.OPERATOR_AND));
		
		List<ConfigBean> list = tipoDocumentoConceptoDao.findComboListByFilters("concepto",Constants.FIELD_NAME,Constants.BD_ACTIVO,filtros,Constants.FIELD_NAME,true);
		
		return list;
	}

	
}
