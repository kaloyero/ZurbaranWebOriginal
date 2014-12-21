package com.contable.hibernate.dao;

import java.util.Date;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Periodo;

public interface PeriodoDao extends GenericDao<Periodo, Integer> {

	Periodo getPeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto);
	
	Periodo validatePeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto, boolean fechaIni);
	
	/**
	 * Obtener el periodo mas reciente creado
	 * 
	 * @param idAdm
	 * @return
	 */
	public Periodo obtenerPeriodoMasReciente (Integer idAdm);
	
	/**
	 * Obtiene el periodo actual aierto
	 * 
	 * @param idAdm
	 * @return
	 */
	public Periodo obtenerPeriodoActual (Integer idAdm);

	/**
	 * Cambia el estado de los periodos anteriores a cerrado.
	 * 
	 * @param idAdm
	 */
	public void cerrarPeriodoAnterior(int idAdm);
}
