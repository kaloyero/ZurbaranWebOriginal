package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.ChequeraForm;
import com.contable.hibernate.model.Chequera;
import com.contable.manager.ChequeraManager;
import com.contable.mappers.ChequeraMapper;
import com.contable.services.ChequeraService;

@Service("chequeraManager")
public class ChequeraManagerImpl extends ConfigurationManagerImpl<Chequera,ChequeraForm> implements ChequeraManager{

	@Autowired
	ChequeraService chequeraService;
	
	@Override
	protected AbstractService<Chequera> getRelatedService() {
		return chequeraService;
	}

	@Override
	protected Mapper<Chequera,ChequeraForm> getMapper() {
		return new ChequeraMapper();
	}
	
	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}

	@Override
	public List<ChequeraForm> getLista() {
		ChequeraMapper mapper = new ChequeraMapper();

		List<ChequeraForm> list = mapper.getFormViewList(((ChequeraService) getRelatedService()).getListaView());

		return list;
	}

	public ChequeraForm findViewById(int idChequera) {
		ChequeraMapper mapper = new ChequeraMapper();
		ChequeraForm chequera = mapper.getForm(chequeraService.findViewById(idChequera)); 
		return chequera;
	}

	
}
