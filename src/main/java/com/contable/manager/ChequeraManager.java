package com.contable.manager;

import com.contable.common.ConfigurationManager;
import com.contable.form.ChequeraForm;
import com.contable.hibernate.model.Chequera;

public interface ChequeraManager extends ConfigurationManager<Chequera,ChequeraForm>{

	public ChequeraForm findViewById(int idChequera);
	
}
