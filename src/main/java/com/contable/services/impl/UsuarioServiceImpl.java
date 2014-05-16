package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.UsuarioDao;
import com.contable.hibernate.model.Usuario;
import com.contable.services.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl extends AbstractServiceImpl<Usuario> implements UsuarioService{

	@Autowired
    private UsuarioDao usuarioDao;

	protected GenericDao<Usuario, Integer> getDao() {
		return usuarioDao;
	}
	

}
