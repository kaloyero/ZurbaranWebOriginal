package com.contable.services;

import java.util.Date;

import com.contable.common.AbstractService;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.hibernate.model.Periodo;

public interface PeriodoService extends AbstractService<Periodo>{

	/**
	 * Devuelve el periodo seg�n la fecha indicada
	 * 
	 * @param idAdm
	 * @param fecha
	 * @param activo
	 * @return
	 */
	Periodo getPeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto);
	
	/**
	 * Valida que el periodo seg�n la fecha seleccionada exista y este abierto
	 * 
	 * @param idAdm
	 * @param fecha
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoExistenteByFecha(Integer idAdm,Date fecha);


	/**
	 * Valida que el periodo seg�n la fecha seleccionada exista y este abierto
	 * 
	 * @param idAdm
	 * @param fecha
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoExistenteByPeriodo(Periodo periodo);


	/**
	 * Valida para el Periodo que se intenta guardar
	 * 
	 * - Fecha Ini debe ser mayor a fecha Fin de otro periodo seg�n idAdministracion y 
	 * - Fecha Ini debe ser menor a fecha Ini de otro periodo seg�n idAdministracion y
	 * - Fecha Fin debe ser menor a fecha Ini de otro periodo seg�n idAdministracion y
	 * - Fecha Fin debe ser mayor a fecha Fin de otro periodo seg�n idAdministracion
	 * 
	 * @param idAdm
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 */
	ErrorRespuestaBean validaGuardarPeriodo(Integer idAdm,Date fechaIni,Date fechaFin);
	
	/**
	 * Valida para el Periodo que se intenta guardar
	 * 
	 * - Fecha Ini debe ser mayor a fecha Fin de otro periodo seg�n idAdministracion y 
	 * - Fecha Ini debe ser menor a fecha Ini de otro periodo seg�n idAdministracion 
	 * 
	 * @param idAdm
	 * @param fechaIni
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoFechaIni(Integer idAdm,Date fechaIni);

	/**
	 * Valida para el Periodo que se intenta guardar
	 * 
	 * - Fecha Fin debe ser menor a fecha Ini de otro periodo seg�n idAdministracion y
	 * - Fecha Fin debe ser mayor a fecha Fin de otro periodo seg�n idAdministracion
	 * 
	 * @param idAdm
	 * @param fechaFin
	 * @return
	 */
	ErrorRespuestaBean validaPeriodoFechaFin(Integer idAdm,Date fechaFin);


	/**
	 * Obtiene el ultimo periodo (mas reciente en fecha) por administracion.
	 * 
	 * @param idAdm
	 * @return
	 */
	public Periodo obtenerUltimoPeriodo (Integer idAdm);
	
	/**
	 * Obtiene el periodo actual, con estado activo, por administracion.
	 * 
	 * @param idAdm
	 * @return
	 */
	public Periodo obtenerPeriodoActual (Integer idAdm);

	/**
	 * Cierra los periodos anteriores
	 * 
	 * @param idAdm
	 */
	public void cerrarPeriodoAnterior(int idAdm);
}
