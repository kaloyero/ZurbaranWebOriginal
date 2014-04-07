package com.contable.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.RespuestaBean;
import com.contable.common.constants.Constants;
import com.contable.common.constants.ConstantsErrors;
import com.contable.hibernate.dao.PeriodoDao;
import com.contable.hibernate.model.Periodo;
import com.contable.services.PeriodoService;

@Service("periodoService")
public class PeriodoServiceImpl extends AbstractServiceImpl<Periodo> implements PeriodoService{

	@Autowired
    private PeriodoDao periodoDao;

	protected GenericDao<Periodo, Integer> getDao() {
		return periodoDao;
	}

	public Periodo getPeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto){
		return periodoDao.getPeriodoByFecha(idAdm,fecha,abierto);
	}

	public RespuestaBean validaPeriodoExistenteByFecha(Integer idAdm,Date fecha){
		
		return validaPeriodoExistenteByPeriodo(    getPeriodoByFecha(idAdm,fecha, null)   );
	}

	public RespuestaBean validaPeriodoExistenteByPeriodo(Periodo periodo) {
		RespuestaBean res = new RespuestaBean();
		
		if (periodo == null || periodo.getId() == 0){
			//No existe el periodo
			res.setValido(false);
			res.setCodError(ConstantsErrors.PERIODO_COD_1_COD_ERROR);
			res.setError(ConstantsErrors.PERIODO_COD_1_ERROR);
		} else if (periodo.getEstado().equals(Constants.PERIODO_CERRADO)) {
			//Periodo Inactivo
			res.setValido(false);
			res.setCodError(ConstantsErrors.PERIODO_COD_2_COD_ERROR);
			res.setError(ConstantsErrors.PERIODO_COD_2_ERROR);
		} else {
			//Periodo valido
			res.setValido(true);
		}
		return res;
	}


	public RespuestaBean validaGuardarPeriodo(Integer idAdm,Date fechaIni,Date fechaFin){
		RespuestaBean res = validaPeriodoFechaIni(idAdm,fechaIni);
		if (res.isValido()){
			res = validaPeriodoFechaFin(idAdm,fechaFin);
		} 
		
		return res;
	}
	
	public RespuestaBean validaPeriodoFechaIni(Integer idAdm,Date fechaIni){
		RespuestaBean res = new RespuestaBean();
		
		Periodo periodo= periodoDao.validatePeriodoByFecha(idAdm, fechaIni, null, true);
		
		if (periodo == null || periodo.getId() == 0){
			res.setValido(true);
		} else {
			res.setValido(false);
			res.setCodError(ConstantsErrors.PERIODO_COD_3_COD_ERROR);
			res.setError(ConstantsErrors.PERIODO_COD_3_ERROR);
		}
		
		return res;
		
	}

	public RespuestaBean validaPeriodoFechaFin(Integer idAdm,Date fechaFin){
		RespuestaBean res = new RespuestaBean();
		
		Periodo periodo= periodoDao.validatePeriodoByFecha(idAdm, fechaFin, null, false);
		
		if (periodo == null || periodo.getId() == 0){
			res.setValido(true);
		} else {
			res.setValido(false);
			res.setCodError(ConstantsErrors.PERIODO_COD_4_COD_ERROR);
			res.setError(ConstantsErrors.PERIODO_COD_4_ERROR);
		}
		
		return res;		
	}

	
}
