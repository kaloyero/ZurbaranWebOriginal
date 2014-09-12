package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

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

	
	@SuppressWarnings("unchecked")
	public Usuario findByUserName(String username) {

		List<Usuario> users = new ArrayList<Usuario>();

		users = getSession().createQuery("from User where username=?").setParameter(1, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
		
	
}
