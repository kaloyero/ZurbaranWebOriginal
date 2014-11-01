package com.contable.services;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Usuario;

public interface UsuarioService extends AbstractService<Usuario>{

	boolean loginUser(String user, String pass);
	
	public boolean changeUsrPwd(String user, String pass, String newPass);

}
