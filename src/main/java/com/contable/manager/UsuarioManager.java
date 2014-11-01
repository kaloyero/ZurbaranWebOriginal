package com.contable.manager;

import com.contable.common.ConfigurationManager;
import com.contable.form.UsuarioForm;
import com.contable.hibernate.model.Usuario;

public interface UsuarioManager extends ConfigurationManager<Usuario,UsuarioForm>{
	
	public boolean loginUser (String usuario, String clave);

	public boolean changePass (String usuario,String clave, String claveNueva);
}
