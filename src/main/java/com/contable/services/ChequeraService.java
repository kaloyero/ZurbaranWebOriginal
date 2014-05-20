package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.Chequera_V;

public interface ChequeraService extends AbstractService<Chequera>{
	
	public List<Chequera_V> getListaView();

	public Chequera_V findViewById(int id);

}
