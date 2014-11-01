package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.UsuarioForm;
import com.contable.hibernate.model.Usuario;

public class UsuarioMapper extends MapperImpl<Usuario,UsuarioForm>{


	public Usuario getEntidad(UsuarioForm form) {
		Usuario ent = new Usuario();
		if (form != null){
			ent.setId(form.getId());
			ent.setDescripcion(form.getDescripcion());
			ent.setEmail(form.getEmail());
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			ent.setIdRole(form.getIdRole());
			
			ent.setPassword(form.getPassword());
			ent.setUsername(form.getUsername());
			ent.setValidaPassword(MapperUtil.getStatusToEntity(form.getValidaPassword()));
			ent.setValidaRol(MapperUtil.getStatusToEntity(form.getValidaRol()));

		} else {
			return null;
		}
		return ent;
	}
	
	public  UsuarioForm getForm(Usuario ent) {
		UsuarioForm form=new UsuarioForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setDescripcion(ent.getDescripcion());
			form.setEmail(ent.getEmail());
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			form.setIdRole(ent.getIdRole());
			form.setPassword(ent.getPassword());
			form.setUsername(ent.getUsername());
			form.setValidaPassword(MapperUtil.getStatusToForm(ent.getValidaPassword()));
			form.setValidaRol(MapperUtil.getStatusToForm(ent.getValidaRol()));
		}
		return form;
	}

}