package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.hibernate.dao.UsuarioDao;
import com.contable.hibernate.model.Usuario;
import com.contable.services.UsuarioService;


@Service("usuarioService")
public class UsuarioServiceImpl extends AbstractServiceImpl<Usuario> implements UsuarioService {

	@Autowired
    private UsuarioDao usuarioDao;

	protected GenericDao<Usuario, Integer> getDao() {
		return usuarioDao;
	}

	@Override
	@Transactional
	public boolean loginUser(String user, String pass) {
		Usuario us = usuarioDao.loginUserName(user, pass);
		if (us == null) {
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean changeUsrPwd(String user, String pass, String newPass) {
		return usuarioDao.changeUsrPwd(user, pass, newPass);
	}	
	

}
