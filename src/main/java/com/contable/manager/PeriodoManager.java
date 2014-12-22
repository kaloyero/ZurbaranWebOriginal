package com.contable.manager;

import java.util.Date;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Periodo;

public interface PeriodoManager extends AbstractManager<Periodo,PeriodoForm>{

	/**
	 * Devuelve un periodo de acuerdo a la fecha seleccionada
	 * 
	 * @param idAdm
	 * @param fecha
	 * @param abierto
	 * @return
	 */
	PeriodoForm getPeriodoByFecha(int idAdm,String fecha, Boolean abierto);
	
	/**
	 * Valida que exista una Periodo para la fecha seleccionada
	 * 
	 * @param idAdm
	 * @param fecha
	 * @return
	 */
	//ErrorRespuestaBean validaPeriodoExistenteByFecha(int idAdm,String fecha);
	
	/**
	 * Valida que exista la "fecha" exista en el periodo actual
	 * 
	 * @param idAdm
	 * @param fecha
	 * @return
	 */
	public ErrorRespuestaBean validaFechaEnPeriodoActual(int idAdm,String fecha);
	public ErrorRespuestaBean validaFechaEnPeriodoActual(int idAdm,Date fecha);
	
	/**
	 * Valida que exista una Periodo para el periodo seleccionado
	 * 
	 * @param form
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoExistenteByPeriodo(PeriodoForm form);
	
	/**
	 * Valida la fecha Inicial de un periodo
	 * 
	 * @param idAdm
	 * @param fechaIni
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoFechaIni(int idAdm,String fechaIni);

	/**
	 * Valida la fecha Final de un periodo
	 * 
	 * @param idAdm
	 * @param fechaFin
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoFechaFin(int idAdm,String fechaFin);
	
	/**
	 * Devuelve la fecha de Inicio para crear un nuevo periodo
	 * - Toma la fecha de cierre del ultimo periodo y le suma un d�a
	 * - Si no existe periodo anterior devuelve la fecha del d�a
	 * 
	 * @param idAdm
	 * @return
	 */
	public String getFechaPeriodoInicial(int idAdm);
	
	/**
	 * Devuelve la fecha de cierre del periodo actual
	 * 
	 * @param idAdm
	 * @return
	 */
	public String getFechaCierrePeriodoActual(int idAdm);
	
	/**
	 * Devuelve el periodo abierto.
	 * 
	 * @param idAdm
	 * @return
	 */
	public PeriodoForm getPeriodoActual(int idAdm);	
}
