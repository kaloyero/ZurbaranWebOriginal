package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.beans.RespuestaBean;
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

	public RespuestaBean validaPeriodoExistenteByFecha(int idAdm,String fecha){
		Integer idAdministracion = parseIdAdmToService(idAdm);
		
		return periodoService.validaPeriodoExistenteByFecha(idAdministracion, DateUtil.convertStringToDate(fecha));
	}

	public RespuestaBean validaPeriodoExistenteByPeriodo(PeriodoForm form) {
		return periodoService.validaPeriodoExistenteByPeriodo(getMapper().getEntidad(form));
	}

	public RespuestaBean validaPeriodoFechaIni(int idAdm, String fechaIni) {
		Integer idAdministracion = parseIdAdmToService(idAdm);
		return periodoService.validaPeriodoFechaIni(idAdministracion, DateUtil.convertStringToDate(fechaIni));
	}

	public RespuestaBean validaPeriodoFechaFin(int idAdm, String fechaFin) {
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
	
}

