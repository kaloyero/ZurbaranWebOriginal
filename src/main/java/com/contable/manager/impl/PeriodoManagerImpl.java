package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.ConstantsErrors;
import com.contable.common.utils.DateUtil;
import com.contable.form.PeriodoForm;
import com.contable.hibernate.model.Periodo;
import com.contable.manager.PeriodoManager;
import com.contable.mappers.PeriodoMapper;
import com.contable.services.PeriodoService;

@Service("periodoManager")
public class PeriodoManagerImpl extends AbstractManagerImpl<Periodo,PeriodoForm> implements PeriodoManager{

	@Autowired
	PeriodoService periodoService;
	
	@Override
	protected AbstractService<Periodo> getRelatedService() {
		return periodoService;
	}

	@Override
	protected Mapper<Periodo,PeriodoForm> getMapper() {
		return new PeriodoMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}
	
	public PeriodoForm getPeriodoByFecha(int idAdm,String fecha, Boolean abierto){
		Integer idAdministracion = parseIdAdmToService(idAdm);
		return getMapper().getForm(periodoService.getPeriodoByFecha(idAdministracion,DateUtil.convertStringToDate(fecha),abierto));
	}

	public ErrorRespuestaBean validaPeriodoExistenteByFecha(int idAdm,String fecha){
		Integer idAdministracion = parseIdAdmToService(idAdm);
		return periodoService.validaPeriodoExistenteByFecha(idAdministracion, DateUtil.convertStringToDate(fecha));
	}

	public ErrorRespuestaBean validaFechaEnPeriodoActual(int idAdm,String fecha){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		
		//Obtengo el periodo actual
		Periodo periodo = periodoService.obtenerPeriodoActual(idAdm);
		
		if (DateUtil.convertStringToDate(fecha).before(periodo.getFechaIni()) || 
				DateUtil.convertStringToDate(fecha).after(periodo.getFechaFin())) {
				//No existe la fecha dentro del periodo actual
				res.setValido(false);
				res.setCodError(ConstantsErrors.PERIODO_COD_5_COD_ERROR);
				res.setError(ConstantsErrors.PERIODO_COD_5_ERROR);
				res.setDescripcion("No existe la fecha dentro del periodo actual");
		}
		
		return res;
	}
	
	public ErrorRespuestaBean validaFechaEnPeriodoActual(int idAdm,Date fecha){
		return validaFechaEnPeriodoActual(idAdm, DateUtil.convertDateToString(fecha));
	}
	
	public ErrorRespuestaBean validaPeriodoExistenteByPeriodo(PeriodoForm form) {
		return periodoService.validaPeriodoExistenteByPeriodo(getMapper().getEntidad(form));
	}

	public ErrorRespuestaBean validaPeriodoFechaIni(int idAdm, String fechaIni) {
		Integer idAdministracion = parseIdAdmToService(idAdm);
		return periodoService.validaPeriodoFechaIni(idAdministracion, DateUtil.convertStringToDate(fechaIni));
	}

	public ErrorRespuestaBean validaPeriodoFechaFin(int idAdm, String fechaFin) {
		Integer idAdministracion = parseIdAdmToService(idAdm);
		return periodoService.validaPeriodoFechaFin(idAdministracion, DateUtil.convertStringToDate(fechaFin));
	}
	
	private Integer parseIdAdmToService(int idAdm){
		Integer idAdministracion = idAdm;
		//Si el id que resive del form es -1, quiere decir que no tiene administracion
		if (idAdm == -1){
			idAdministracion = null;
		}
		return idAdministracion;
	}

	public String getFechaPeriodoInicial(int idAdm) {
		//Seteo la fecha inicial como actual.
		String fechaInicial = DateUtil.getStringToday();
		
		if (idAdm > 0){
			//Traigo la ultima fecha de cierre
			Periodo periodo = periodoService.obtenerUltimoPeriodo(idAdm);
			//Si existe periodo seteo la fecha. Le sumo un día a la fecha de cierre
			if (periodo != null){
				fechaInicial = DateUtil.convertDateToString(DateUtil.sumarDias(periodo.getFechaFin(), 1));
			}
		}
		
		return fechaInicial;
	}

	@Override
	@Transactional
	public ErrorRespuestaBean guardarNuevo(PeriodoForm form) {
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		
		
		res = validaPeriodoFechaIni(form.getAdministracion().getId(), form.getFechaIni());
		if (res.isValido() == false) {
			return res;
		}
		res = validaPeriodoFechaFin(form.getAdministracion().getId(), form.getFechaFin());
		if (res.isValido() == false) {
			return res;
		}
		
		int idPeriodo = getRelatedService().save(getMapper().getEntidad(form));
		
		
		
		
		return res;
	}

	@Override
	public String getFechaCierrePeriodoActual(int idAdm) {
		//Seteo la fecha inicial como actual.
		String fechaInicial = DateUtil.getStringToday();
		
		if (idAdm > 0){
			//Traigo la ultima fecha de cierre
			Periodo periodo = periodoService.getPeriodoByFecha(idAdm,DateUtil.getDateToday(),true);
			
			if (periodo != null){
				fechaInicial = DateUtil.convertDateToString(periodo.getFechaFin());
			}
		}
		
		return fechaInicial;	}

	@Override
	public PeriodoForm getPeriodoActual(int idAdm) {
		Integer idAdministracion = parseIdAdmToService(idAdm);
		return getMapper().getForm(periodoService.obtenerPeriodoActual(idAdministracion));
	}
	
}

