package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.ChequeraDetalle_V;
import com.contable.hibernate.model.Chequera_V;
import com.contable.hibernate.model.ValorPropio_v;

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

	/**
	 * Devuelve la ultima chequera ingresada para la cuenta y la entidad
	 * 
	 * @param cuentaId
	 * @param entidadId
	 * @return
	 */
	public Chequera getChequeByCuentaEntidad(int idAdministracion, int cuentaId, int entidadId, int monedaId);
	
	
	/**
	 * devuelve un cheque por la chequera y el numero de cheque
	 * 
	 * @param idChequera
	 * @param numero
	 * @return
	 */
	public ValorPropio_v getCheque(int idChequera, int numero);
}
