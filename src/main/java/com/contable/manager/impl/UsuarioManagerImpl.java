package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.UsuarioForm;
import com.contable.hibernate.model.Usuario;
import com.contable.manager.UsuarioManager;
import com.contable.mappers.UsuarioMapper;
import com.contable.services.UsuarioService;

@Service("usuarioManager")
public class UsuarioManagerImpl extends ConfigurationManagerImpl<Usuario,UsuarioForm> implements UsuarioManager{

	@Autowired
	UsuarioService usuarioService;
	
	@Override
	protected AbstractService<Usuario> getRelatedService() {
		return usuarioService;
	}

	@Override
	protected Mapper<Usuario,UsuarioForm> getMapper() {
		return new UsuarioMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	public boolean loginUser(String usuario, String clave) {
		
		return usuarioService.loginUser(usuario, clave);

	}

	public boolean changePass (String usuario,String clave, String claveNueva){
		return usuarioService.changeUsrPwd(usuario, clave, claveNueva);
	}
	
}
