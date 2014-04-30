package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.form.EstructuraContenidoForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.manager.EstructuraManager;
import com.contable.mappers.EstructuraMapper;
import com.contable.services.EstructuraContenidoService;
import com.contable.services.EstructuraService;

@Service("estructuraManager")
public class EstructuraManagerImpl extends ConfigurationManagerImpl<Estructura,EstructuraForm> implements EstructuraManager{

	@Autowired
	EstructuraService estructuraService;

	@Autowired
	EstructuraContenidoService estructuraContenidoService;

	@Override
	protected AbstractService<Estructura> getRelatedService() {
		return estructuraService;
	}

	@Override
	protected Mapper<Estructura,EstructuraForm> getMapper() {
		return new EstructuraMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	@Transactional
	public void guardarNuevoContenido(EstructuraContenidoForm form){
		EstructuraMapper mapper = new EstructuraMapper();
		estructuraContenidoService.save(mapper.getEntidad(form));
	}

	public List<ConfigBean> getContenidosConfig(Integer idAdministracion, String extraRow) {
		List<ConfigBean> list = new ArrayList<ConfigBean>();
		// Si viene -1 quiere decir que son todos
		if (idAdministracion  == -1 ){
			list = getRelatedService().getConfigNameListByAdm(null);	
		} else {
			list = getRelatedService().getConfigNameListByAdm(idAdministracion);
		}
		//Agrega el campo extra
		agergarExtraRow(list, extraRow);
		
		return list;
	}

	public List<EstructuraContenidoForm> getContenidos() {
		EstructuraMapper mapper = new EstructuraMapper();
		List<Estructura> estructuras = estructuraService.listAll();
		List<EstructuraContenidoForm> list = new ArrayList<EstructuraContenidoForm>();
		for (Estructura estructura : estructuras) {
			if (estructura.getContenidos() != null){
				for (EstructuraContenido contenido : estructura.getContenidos()) {
					EstructuraContenidoForm form = mapper.getForm(contenido); 
					
					if (estructura.getAdministracion() != null){
						form.setAdministracionNombre(estructura.getAdministracion().getNombre());
					} else {
						form.setAdministracionNombre(Constants.UI_ADM_CAMPO_TODAS);
					}
					form.setEstructuraNombre(estructura.getNombre());
					form.setEstructuraId(estructura.getId());
					
					list.add(form);
				}
			}
		}
		
		return list;
	}
}
