package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(readOnly=true)
//	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
 
		Usuario user = usuarioDao.findByUserName(username);
//		List<GrantedAuthority> authorities = 
//                                      buildUserAuthority(user.getUserRole());
 
		return (UserDetails) buildUserForAuthentication(user);
 
	}
 
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
//	private Usuario buildUserForAuthentication(Usuario user, 
//		List<GrantedAuthority> authorities) {
//		return new Usuario(user.getUsername(), user.getPassword(), 
//			true, true, true, true, authorities);
//	}

	private Usuario buildUserForAuthentication(Usuario user) {
			return new Usuario(user.getUsername(), user.getPassword(), user.getIdRole(),user.getHabilitado());
		}

	
//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
// 
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
// 
//		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
// 
//		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
// 
//		return Result;
//	}

}
