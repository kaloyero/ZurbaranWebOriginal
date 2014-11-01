package com.contable.hibernate.dao;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {

	public Usuario findByUserName(String username);
	
	public Usuario loginUserName(String username, String password);

	public boolean changeUsrPwd(String username, String password, String passwordNew);
}
