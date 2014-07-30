package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.EntidadDao;
import com.contable.hibernate.model.Entidad;
import com.contable.services.EntidadService;

@Service("entidadService")
public class EntidadServiceImpl extends AbstractServiceImpl<Entidad> implements EntidadService{

	@Autowired
    private EntidadDao entidadDao;

	protected GenericDao<Entidad, Integer> getDao() {
		return entidadDao;
	}
	
	public List<ConfigBean> getConfigEntidadesListByTipoEntidad(Integer idTipoEntidad){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		Property filtroAdm = new Property("tipoEntidad.id", null, idTipoEntidad);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_NAME,Constants.FIELD_REFERENCIA,filtroAdm,filtroEstado,Constants.FIELD_NAME,true);
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
	
}
