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

//	public List<ChequeraNoDisponibleForm> getListaChequesNoDisponiblesByChequera(Integer idChequera){
//		
//	}
	
}
