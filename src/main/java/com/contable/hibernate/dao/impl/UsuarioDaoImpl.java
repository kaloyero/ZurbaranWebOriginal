package com.contable.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.UsuarioDao;
import com.contable.hibernate.model.Usuario;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}

}
