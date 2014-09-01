package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.ChequeraDetalle_V;
import com.contable.hibernate.model.Chequera_V;

public interface ChequeraService extends AbstractService<Chequera>{
	
	public List<Chequera_V> getListaView();

	public Chequera_V findViewById(int id);
	
	/**
	 * Devuelve el listado de cheques según la chequera seleccionada
	 * 
	 * @param chequeraId. Chequera que se desea consultar
	 * @return
	 */
	public List<ChequeraDetalle_V> getListaChequeDetalle(int chequeraId);

}
