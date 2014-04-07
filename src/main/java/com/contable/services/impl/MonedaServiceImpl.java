package com.contable.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.MonedaDao;
import com.contable.hibernate.model.Moneda;
import com.contable.services.MonedaService;

@Service("monedaService")
public class MonedaServiceImpl extends AbstractServiceImpl<Moneda> implements MonedaService{

	@Autowired
    private MonedaDao monedaDao;

	protected GenericDao<Moneda, Integer> getDao() {
		return monedaDao;
	}

	public List<ConfigBean> getConfigNameList(){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		return getDao().findComboListByFilterConfig(Constants.FIELD_REFERENCIA,Constants.FIELD_NAME,null,filtroEstado,"monedaLocal,nombre",false);
	}

	public List<ConfigBean> getConfigNameListByAdm(Integer idAdministracion){
		Property filtroEstado = new Property(Constants.FIELD_ESTADO, null, Constants.BD_ACTIVO);
		Property filtroAdm = new Property("administracion.id", null, idAdministracion);
		
		return getDao().findComboListByFilterConfig(Constants.FIELD_REFERENCIA,Constants.FIELD_NAME,filtroAdm,filtroEstado,"monedaLocal,nombre",false);
	}
	
}
