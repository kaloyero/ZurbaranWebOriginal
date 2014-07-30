package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.ConsultasGeneralesBean;
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
		if (tipoDocumento != null ){
			filtros.add(new Property(Restrictions.eq("idTipoDocumento", tipoDocumento), Property.OPERATOR_AND));
		}
		if (StringUtils.isNotBlank(tipoValor) ){
			filtros.add(new Property(Restrictions.like("concepto.tipoValor", tipoValor), Property.OPERATOR_AND));
			filtros.add(new Property(Restrictions.like("concepto.estado", Constants.BD_ACTIVO), Property.OPERATOR_AND));
//			filtros.add(new Property(Restrictions.like("tipoValor", tipoValor), Property.OPERATOR_AND));
		}
		
		//List<ConfigBean> list = getDao().findComboListByFilters				   (Constants.FIELD_NAME,Constants.FIELD_REFERENCIA,Constants.BD_ACTIVO,filtros,Constants.FIELD_NAME,true);
		List<ConfigBean> list = tipoDocumentoConceptoDao.findComboListByFilters(Constants.FIELD_NAME,Constants.FIELD_REFERENCIA,Constants.BD_ACTIVO,filtros,Constants.FIELD_NAME,true,"concepto");
		
		return list;
	}

	public List<ConfigBean> getConceptListByFiltro(String tipoValor){
		List<Property> filtros = new ArrayList<Property>();
		if (StringUtils.isNotBlank(tipoValor) ){
			filtros.add(new Property(Restrictions.like("tipoValor", tipoValor), Property.OPERATOR_AND));
			filtros.add(new Property(Restrictions.like("estado", Constants.BD_ACTIVO), Property.OPERATOR_AND));
		}
		List<ConfigBean> list = getDao().findComboListByFilters	(Constants.FIELD_NAME,Constants.FIELD_REFERENCIA,Constants.BD_ACTIVO,filtros,Constants.FIELD_NAME,true);
		
		return list;
	}

	
	public List<ConfigBean> getConfigNameList(){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,Constants.FIELD_REFERENCIA,null,filtroEstado,Constants.FIELD_NAME,true);
	}

	public List<ConfigBean> getConfigNameListByAdm(Integer idAdministracion){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		Property filtroAdm = new Property("administracion.id", null, idAdministracion);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,Constants.FIELD_REFERENCIA,filtroAdm,filtroEstado,Constants.FIELD_NAME,true);
	}

	public List<ConsultasGeneralesBean> getConceptoInfoParaDocumentoMov(List<Integer> conceptoIds){
		return conceptoDao.getConceptoInfoParaDocumentoMov(conceptoIds);
	}

}
