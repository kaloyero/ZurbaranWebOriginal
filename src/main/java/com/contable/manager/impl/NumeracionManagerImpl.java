package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;
import com.contable.manager.NumeracionManager;
import com.contable.mappers.NumeracionMapper;
import com.contable.services.NumeracionService;

@Service("numeracionManager")
public class NumeracionManagerImpl extends ConfigurationManagerImpl<Numeracion,NumeracionForm> implements NumeracionManager{

	@Autowired
	NumeracionService numeracionService;
	
	@Override
	protected AbstractService<Numeracion> getRelatedService() {
		return numeracionService;
	}

	@Override
	protected Mapper<Numeracion,NumeracionForm> getMapper() {
		return new NumeracionMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		return list;
	}

	//TODO mover este metodo a DOCUMENTO SERVICE
	public String getLastDocNumeration(int idTipoDocumento,String numTipo, String numPeriodo, String numFormato) {
		String numeracion = "";
		if (numTipo.equals("M") ){
			if (numPeriodo.equals("G") ){
				if (numFormato.equals("N")){
					numeracion = "";	
				} else if (numFormato.equals("N")){
					numeracion = "A";
				}
			} else if (numPeriodo.equals("E") ){
				if (numFormato.equals("N")){
					numeracion = "";	
				} else if (numFormato.equals("N")){
					numeracion = "X";
				}
			}
		} else {
			Calendar fecha = Calendar.getInstance();
			String dia = Integer.toString(fecha.get(Calendar.DATE));
			String mes = Integer.toString(fecha.get(Calendar.MONTH));
			String anio = Integer.toString(fecha.get(Calendar.YEAR));
			Integer nextNum = 1; //TODO trear el ultimo segun el tipo de documento
			if (numPeriodo.equals("H") ){
				numeracion = ""+ String.valueOf(nextNum);	
			} else if (numPeriodo.equals("A") ){
				numeracion = ""+ anio + String.valueOf(nextNum);	
			} else if (numPeriodo.equals("M") ){
				numeracion = ""+ anio + mes + String.valueOf(nextNum);	
			} else if (numPeriodo.equals("D") ){
				numeracion = ""+ anio + mes + dia + String.valueOf(nextNum);	
			}
		}
		
		
		return numeracion;
	}

	
}
