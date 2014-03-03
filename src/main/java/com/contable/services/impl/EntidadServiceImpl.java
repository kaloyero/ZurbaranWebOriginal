package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
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
	
	public List<ConfigBean> getConfigEntidadesListByTipoEntidad(int idTipoEntidad){
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		list = getDao().findComboListByFilter(Constants.FIELD_NAME, Constants.FIELD_ACTIVE, "tipoEntidad.id",idTipoEntidad,Constants.BD_ACTIVO, true);
		
		return list;
	}

	
}
