package com.contable.manager;

import com.contable.common.AbstractManager;
import com.contable.form.ChequeraNoDisponibleForm;
import com.contable.hibernate.model.ChequeraNoDisponible;

public interface ChequeraNoDisponibleManager extends AbstractManager<ChequeraNoDisponible,ChequeraNoDisponibleForm>{

	
	/**
	 * true / si existe el numero de cheque para esa chequera
	 * false / si NO existe el numero de cheque para esa chequera
	 * 
	 * @param chequeraId
	 * @param numero
	 * @return
	 */
	public boolean existeChequeNoDisponible(int chequeraId, int numero);
	
	/**
	 * Devuelve el ultimo numero de cheuqeu en la tabla valores propios.
	 * 
	 * @param chequeraId
	 * @return
	 */
	public Integer getUltimoNumeroChequeByChequera(int chequeraId);

}
