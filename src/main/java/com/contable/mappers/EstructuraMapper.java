package com.contable.mappers;

import java.util.HashSet;
import java.util.Set;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.EstructuraContenidoForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;

public class EstructuraMapper extends MapperImpl<Estructura,EstructuraForm>{

	public Estructura getEntidad(EstructuraForm form) {
		Estructura ent = new Estructura();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			EstructuraContenidoMapper mapperEstCon = new EstructuraContenidoMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			//Contenidos
			Set<EstructuraContenido> contenidos = new HashSet<EstructuraContenido>();
			if (form.getContenidos() != null){
				for (EstructuraContenidoForm conteForm : form.getContenidos()) {
					EstructuraContenido contenido = mapperEstCon.getEntidad(conteForm);
					contenido.setEstructura(ent);
					contenidos.add(contenido);
				}
			}
			ent.setContenidos(contenidos);

		} else {
			return null;
		}
		return ent;
	}

	
	public  EstructuraForm getForm(Estructura ent) {
		EstructuraForm form=new EstructuraForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			EstructuraContenidoMapper mapperEstCon = new EstructuraContenidoMapper();			
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToEntity(ent.getEstado()));
			//Contenidos
			Set<EstructuraContenidoForm> contenidos = new HashSet<EstructuraContenidoForm>();
			if (ent.getContenidos() != null){
				for (EstructuraContenido contenido : ent.getContenidos()) {
					EstructuraContenidoForm conteForm = mapperEstCon.getForm(contenido);
					
					contenidos.add(conteForm);
				}
			}
			form.setContenidos(contenidos);
		}
		return form;
	}


}