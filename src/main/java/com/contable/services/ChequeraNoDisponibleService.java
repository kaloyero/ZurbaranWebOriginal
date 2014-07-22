package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.ChequeraNoDisponible;

public interface ChequeraNoDisponibleService extends AbstractService<ChequeraNoDisponible>{
	
	public List<ChequeraNoDisponible> getListaChequesNoDisponiblesByChequera(int idChequera);
	
	public List<ChequeraNoDisponible> getListaChequeNoDisponible(int chequeraId, int numero);
	
	/**
	 * Obtiene el ultimo numero para la chequera seleccionada en Cheques no disponibles. Si no encuentra devuelve NULL
	 * 
	 * @param chequeraId
	 * @return
	 */
	public Integer getUltimoNumeroChequeByChequera(int chequeraId);
}
