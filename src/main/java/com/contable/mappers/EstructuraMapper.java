package com.contable.mappers;

import java.util.HashSet;
import java.util.Set;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.form.EstructuraContenidoForm;
import com.contable.form.EstructuraForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public class EstructuraMapper extends MapperImpl<Estructura,EstructuraForm>{

	public Estructura getEntidad(EstructuraForm form) {
		Estructura ent = new Estructura();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			MonedaMapper mapMon = new MonedaMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			//Contenidos
			Set<EstructuraContenido> contenidos = new HashSet<EstructuraContenido>();
			if (form.getContenidos() != null){
			for (EstructuraContenidoForm conteForm : form.getContenidos()) {
				EstructuraContenido contenido = new EstructuraContenido();
				contenido.setCodigo(conteForm.getCodigo());
				contenido.setDescripcion(conteForm.getDescripcion());
				contenido.setId(conteForm.getId());
				contenido.setModo(conteForm.getModo());
				contenido.setEstructura(ent);
				//Contenidos Cuenta
				Set<EstructuraContenidoCuenta> contenidoCuentas = new HashSet<EstructuraContenidoCuenta>();
				for (EstructuraContenidoCuentaForm conteCuentaForm : conteForm.getContenidoCuentas()) {
					EstructuraContenidoCuenta contenidoCuenta = new EstructuraContenidoCuenta();
					contenidoCuenta.setCuentaId(conteCuentaForm .getCuentaId());
					contenidoCuenta.setEntidadesId(conteCuentaForm .getEntidadId());
					contenidoCuenta.setEstructuraContenido(contenido);
					contenidoCuenta.setMoneda(mapMon.getEntidad(conteCuentaForm .getMoneda()) );
					contenidoCuenta.setId(conteCuentaForm .getId());
					contenidoCuentas.add(contenidoCuenta);
				}
				contenido.setContenidos(contenidoCuentas);
				
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
			MonedaMapper mapMon = new MonedaMapper();
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setEstado(MapperUtil.getStatusToEntity(ent.getEstado()));
			//Contenidos
			Set<EstructuraContenidoForm> contenidos = new HashSet<EstructuraContenidoForm>();
			for (EstructuraContenido contenido : ent.getContenidos()) {
				EstructuraContenidoForm conteForm = new EstructuraContenidoForm();
				conteForm.setCodigo(contenido.getCodigo());
				conteForm.setDescripcion(contenido.getDescripcion());
				conteForm.setId(contenido.getId());
				conteForm.setModo(contenido.getModo());
				
				//Contenidos Cuenta
				Set<EstructuraContenidoCuentaForm> contenidoCuentas = new HashSet<EstructuraContenidoCuentaForm>();
				for (EstructuraContenidoCuenta conteCuenta : contenido.getContenidos()) {
					EstructuraContenidoCuentaForm contenidoCuentaForm = new EstructuraContenidoCuentaForm();
					contenidoCuentaForm.setCuentaId(conteCuenta .getCuentaId());
					contenidoCuentaForm.setEntidadId(conteCuenta .getEntidadesId());
					contenidoCuentaForm.setMoneda(mapMon.getForm(conteCuenta.getMoneda()) );
					contenidoCuentaForm.setId(conteCuenta.getId());
					contenidoCuentas.add(contenidoCuentaForm);
				}
				conteForm.setContenidoCuentas(contenidoCuentas);
				
				contenidos.add(conteForm);
			}
			form.setContenidos(contenidos);
		}
		return form;
	}

}