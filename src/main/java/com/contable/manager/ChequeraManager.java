package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.form.ChequeraForm;
import com.contable.form.ValorPropioForm;
import com.contable.hibernate.model.Chequera;

public interface ChequeraManager extends ConfigurationManager<Chequera,ChequeraForm>{

	public ChequeraForm findViewById(int idChequera);
	
	public ErrorRespuestaBean validaNumeroChequeValido(int idChequera, int numero);
	
	
	/**
	 * Devuelve el ultimo numero de cheque valido para la chequera ingresada
	 * 
	 * @param idChequera
	 * @return
	 */
	public Integer getUltimoNumeroChequeValido(int idChequera);
	
	
	
	/**
	 * 
	 * Devuelve el ultimo numero de cheque valido para la cuenta y entidad ingresada.
	 * 
	 * @param idCuenta
	 * @param idEntidad
	 * @return
	 */
	public Integer getUltimoNumeroChequeValido(int idAdministracion, int idCuenta, int idEntidad);
	
	
	/**
	 * Devuelve el listado de cheques según la chequera seleccionada
	 * 
	 * @param chequeraId. Chequera que se desea consultar
	 * @return
	 */
	public List<ValorPropioForm> getListaChequeDetalle(int chequeraId);

}
