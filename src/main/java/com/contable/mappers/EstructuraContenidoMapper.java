package com.contable.mappers;

import java.util.HashSet;
import java.util.Set;

import com.contable.common.beans.MapperImpl;
import com.contable.form.EstructuraContenidoCuentaForm;
import com.contable.form.EstructuraContenidoForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

public class EstructuraContenidoMapper extends MapperImpl<EstructuraContenido,EstructuraContenidoForm>{

	public EstructuraContenido getEntidad(EstructuraContenidoForm conteForm) {
		EstructuraContenido contenido = new EstructuraContenido();
		EstructuraContenidoCuentaMapper mapCta = new EstructuraContenidoCuentaMapper();
		
		if (conteForm != null){
				
				contenido.setCodigo(conteForm.getCodigo());
				contenido.setDescripcion(conteForm.getDescripcion());
				contenido.setId(conteForm.getId());
				contenido.setModo(conteForm.getModo());
				if (conteForm.getEstructuraId() != null){
					Estructura est = new Estructura();
					est.setId(conteForm.getEstructuraId());
					contenido.setEstructura(est);	
				}
				
				//Contenidos Cuenta
				Set<EstructuraContenidoCuenta> contenidoCuentas = new HashSet<EstructuraContenidoCuenta>();
				if (conteForm.getContenidoCuentas() != null){ 
					for (EstructuraContenidoCuentaForm conteCuentaForm : conteForm.getContenidoCuentas()) {
						EstructuraContenidoCuenta contenidoCuenta = mapCta.getEntidad(conteCuentaForm) ;
						contenidoCuenta.setEstructuraContenido(contenido);
						contenidoCuentas.add(contenidoCuenta);
					}
				}
				contenido.setCuentas(contenidoCuentas);

		} else {
			return null;
		}
		return contenido;
	}
	
	public  EstructuraContenidoForm getForm(EstructuraContenido contenido) {
		EstructuraContenidoForm conteForm = new EstructuraContenidoForm();
		EstructuraContenidoCuentaMapper mapCta = new EstructuraContenidoCuentaMapper();
		
		if (contenido != null){
				
				conteForm.setCodigo(contenido.getCodigo());
				conteForm.setDescripcion(contenido.getDescripcion());
				conteForm.setId(contenido.getId());
				conteForm.setModo(contenido.getModo());
				
				//Contenidos Cuenta
				Set<EstructuraContenidoCuentaForm> contenidoCuentas = new HashSet<EstructuraContenidoCuentaForm>();
				if (contenido.getCuentas() != null){
					for (EstructuraContenidoCuenta conteCuenta : contenido.getCuentas()) {
						contenidoCuentas.add(mapCta.getForm(conteCuenta));
					}
				}
				conteForm.setContenidoCuentas(contenidoCuentas);
		} else {
			return null;
		}
		return conteForm;
	}

}