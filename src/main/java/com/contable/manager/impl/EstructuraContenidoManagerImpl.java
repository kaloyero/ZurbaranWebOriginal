package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.form.EstructuraContenidoForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.manager.EstructuraContenidoManager;
import com.contable.mappers.EstructuraContenidoMapper;
import com.contable.services.EstructuraContenidoService;
import com.contable.services.EstructuraService;

@Service("estructuraContenidoManager")
public class EstructuraContenidoManagerImpl extends ConfigurationManagerImpl<EstructuraContenido,EstructuraContenidoForm> implements EstructuraContenidoManager{

	@Autowired
	EstructuraService estructuraService;

	@Autowired
	EstructuraContenidoService estructuraContenidoService;

	@Override
	protected AbstractService<EstructuraContenido> getRelatedService() {
		return estructuraContenidoService;
	}

	@Override
	protected Mapper<EstructuraContenido,EstructuraContenidoForm> getMapper() {
		return new EstructuraContenidoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(EstructuraContenidoForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		estructuraContenidoService.save(getMapper().getEntidad(form));
		return res;
	}

	@Transactional
	@Override
	public List<EstructuraContenidoForm> getLista() {
		
		List<Estructura> estructuras = estructuraService.listAll();
		List<EstructuraContenidoForm> list = new ArrayList<EstructuraContenidoForm>();
		for (Estructura estructura : estructuras) {
			if (estructura.getContenidos() != null){
				for (EstructuraContenido contenido : estructura.getContenidos()) {
					EstructuraContenidoForm form = getMapper().getForm(contenido); 
					
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
	
	@Transactional
	@Override
	public List<EstructuraContenidoForm> getListaDataTable(int pagina,int cantRegistros, String filterText, String orderBy, boolean orderAsc) {
		List<Estructura> estructuras = estructuraService.listAll();
		List<EstructuraContenidoForm> list = new ArrayList<EstructuraContenidoForm>();
		for (Estructura estructura : estructuras) {
			if (estructura.getContenidos() != null){
				for (EstructuraContenido contenido : estructura.getContenidos()) {
					EstructuraContenidoForm form = getMapper().getForm(contenido); 
					
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
