package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.TipoDocumentoConceptoDao;
import com.contable.hibernate.model.TipoDocumentoConcepto;
import com.contable.services.TipoDocumentoConceptosService;

@Service("tipoDocumentoConceptosService")
public class TipoDocumentoConceptosServiceImpl extends AbstractServiceImpl<TipoDocumentoConcepto> implements TipoDocumentoConceptosService{

	@Autowired
    private TipoDocumentoConceptoDao tipoDocumentoConceptoDao;
	
	protected GenericDao<TipoDocumentoConcepto, Integer> getDao() {
		return tipoDocumentoConceptoDao;
	}

	@Override	
	@Deprecated
	public List<ConfigBean> getConfigNameList(){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,null,null,filtroEstado,"id",true);
	}

	@Override
	public List<ConfigBean> getConfigNameListByAdm(Integer idAdministracion){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		Property filtroAdm = new Property("administracion.id", null, idAdministracion);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,null,filtroAdm,filtroEstado,"id",true);
	}

	public List<ConfigBean> getConceptosByIdTipoDocumento(int tipodocumento){
		return tipoDocumentoConceptoDao.getConceptosConfigByIdTipodocumento(tipodocumento);
	}
	
}
