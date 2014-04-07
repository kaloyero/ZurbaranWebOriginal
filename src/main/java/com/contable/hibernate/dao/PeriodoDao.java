package com.contable.hibernate.dao;

import java.util.Date;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.Periodo;

public interface PeriodoDao extends GenericDao<Periodo, Integer> {

	Periodo getPeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto);
	
	Periodo validatePeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto, boolean fechaIni);

}
