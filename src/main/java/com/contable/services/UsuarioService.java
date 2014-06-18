package com.contable.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Usuario;

public interface UsuarioService extends AbstractService<Usuario>{

	UserDetails loadUserByUsername(String username)	throws UsernameNotFoundException;

}
