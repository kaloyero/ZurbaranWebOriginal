package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@SuppressWarnings("unchecked")
	@Transactional
	public Usuario loginUserName(String username, String password) {

		Criteria criteria = getSession().createCriteria(getEntityClass());
		
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		
       	List<Usuario> list = criteria.list();

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}
	
	@Transactional
	public boolean changeUsrPwd(String username, String password, String passwordNew) {	
		boolean success = true;
		Usuario usr = loginUserName(username, password);
		
		if (usr != null){
			StringBuilder queryStr = new StringBuilder();
		    
			queryStr.append("update `Usuarios` set `ClaveAcceso`='"+ passwordNew +"'");
			Query query = getSession().createSQLQuery(queryStr.toString());
		
			query.executeUpdate();
		} else {
			success= false;
		}
		
		return success;
	}
	
	
}
