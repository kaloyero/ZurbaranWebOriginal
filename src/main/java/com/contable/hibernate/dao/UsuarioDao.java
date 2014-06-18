package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {

	Usuario findByUserName(String username);
	
}
