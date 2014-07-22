package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.ChequeraNoDisponibleForm;
import com.contable.hibernate.model.ChequeraNoDisponible;
import com.contable.manager.ChequeraNoDisponibleManager;
import com.contable.mappers.ChequeraNoDisponibleMapper;
import com.contable.services.ChequeraNoDisponibleService;

@Service("chequeraNoDisponibleManager")
public class ChequeraNoDisponibleManagerImpl extends AbstractManagerImpl<ChequeraNoDisponible,ChequeraNoDisponibleForm> implements ChequeraNoDisponibleManager{

	@Autowired
	ChequeraNoDisponibleService chequeraNoDisponibleService;
	
	@Override
	protected AbstractService<ChequeraNoDisponible> getRelatedService() {
		return chequeraNoDisponibleService;
	}

	@Override
	protected Mapper<ChequeraNoDisponible,ChequeraNoDisponibleForm> getMapper() {
		return new ChequeraNoDisponibleMapper();
	}
	
	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	public List<ChequeraNoDisponibleForm> getListaChequesNoDisponiblesByChequera(Integer idChequera) {
		List<ChequeraNoDisponibleForm> list = new ArrayList<ChequeraNoDisponibleForm>();
		
		list = getMapper().getFormList(chequeraNoDisponibleService.getListaChequesNoDisponiblesByChequera(idChequera));
		
		return list;
	}

	public boolean existeChequeNoDisponible(int chequeraId, int numero) {
		
		List<ChequeraNoDisponible> list = chequeraNoDisponibleService.getListaChequeNoDisponible(chequeraId,numero);
		
		if (list != null && list.size() > 0){
			// Si la consulta devuelve resultados es porque existe un numero de cheque para esa chequera
			return true;		
		}
		return false;
		
	}

	public Integer getUltimoNumeroChequeByChequera(int chequeraId) {
		return chequeraNoDisponibleService.getUltimoNumeroChequeByChequera(chequeraId);
	}
}
