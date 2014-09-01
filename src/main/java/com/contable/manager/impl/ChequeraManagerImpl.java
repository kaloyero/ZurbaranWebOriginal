package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.constants.ConstantsErrors;
import com.contable.form.ChequeraForm;
import com.contable.form.ValorPropioForm;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.ChequeraDetalle_V;
import com.contable.manager.ChequeraManager;
import com.contable.manager.ChequeraNoDisponibleManager;
import com.contable.manager.DocumentoPropioManager;
import com.contable.mappers.ChequeraMapper;
import com.contable.mappers.DocumentoValorPropioMapper;
import com.contable.services.ChequeraService;

@Service("chequeraManager")
public class ChequeraManagerImpl extends ConfigurationManagerImpl<Chequera,ChequeraForm> implements ChequeraManager{

	@Autowired
	ChequeraService chequeraService;
	
	@Autowired
	DocumentoPropioManager documentoPropioManager;
	
	@Autowired
	ChequeraNoDisponibleManager chequeraNoDisponibleManager;
	
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

	public ErrorRespuestaBean validaNumeroChequeValido(int idChequera, int numero) {
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		
		ChequeraForm chequera = findViewById(idChequera);
		
		//VALIDA QUE LA CHEQUERA EXISTA Y SEA VALIDA
		if (chequera != null && Constants.BD_ACTIVO.equals(chequera.getEstado())){
			//VALIDA QUE EL NUMERO DE CHEQUE ESTE EN EL RANGO CORRECTO
			if (numero >= chequera.getNumeroIni() && numero <= chequera.getNumeroFin()) {
				//VALIDA QUE EL NUMERO DE CHEQUE NO EXISTA PARA ESA CHEQUERA
				//Valida que no exista en valores propios.
				if (documentoPropioManager.existeCheque(idChequera, numero)){
					res.setValido(false);
					res.setCodError(ConstantsErrors.CHEQUERA_COD_1_COD_ERROR);
					res.setError(ConstantsErrors.CHEQUERA_COD_1_ERROR);
					res.setDescripcion("El número de Cheque se encuentra en uso.");
				} else {
					//Valida que no exista en cheques no disponibles.
					if (chequeraNoDisponibleManager.existeChequeNoDisponible(idChequera, numero)){
						res.setValido(false);
						res.setCodError(ConstantsErrors.CHEQUERA_COD_2_COD_ERROR);
						res.setError(ConstantsErrors.CHEQUERA_COD_2_ERROR);
						res.setDescripcion("El número de Cheque se encuentra No Disponible.");
					}
				}
			} else {
				res.setValido(false);
				res.setCodError(ConstantsErrors.CHEQUERA_COD_3_COD_ERROR);
				res.setError(ConstantsErrors.CHEQUERA_COD_3_ERROR);
				res.setDescripcion("El número de cheque seleccionado esta fuera del rango que permite la chequera");
			}
		} else {
			res.setValido(false);
			res.setCodError(ConstantsErrors.CHEQUERA_COD_4_COD_ERROR);
			res.setError(ConstantsErrors.CHEQUERA_COD_4_ERROR);
			res.setDescripcion("La chequera seleccionada se encuentra fuera de uso o no existe.");
		}

		return res;
	}

	public Integer getUltimoNumeroChequeValido(int idChequera) {
		Integer res = null;
		
		
		ChequeraForm chequera = findViewById(idChequera);
		
		//VALIDA QUE LA CHEQUERA EXISTA Y SEA VALIDA
		if (chequera != null && Constants.BD_ACTIVO.equals(chequera.getEstado())){
			
			//Busca los numeros de cheques en chequeras
			Integer valorPropio =      documentoPropioManager.getUltimoNumeroChequeByChequera(idChequera);		
			Integer cheqNoDispo = chequeraNoDisponibleManager.getUltimoNumeroChequeByChequera(idChequera);
	
			if (valorPropio > cheqNoDispo){
				res = 	valorPropio + 1;
			} else {
				res = 	cheqNoDispo + 1;
			}
			
			if (res > chequera.getNumeroFin()) {
				//Si es mayor al numero final de lachequera devuelve null
				res = null;
			}
		} 
		return res;
		
	}

	public List<ValorPropioForm> getListaChequeDetalle(int chequeraId) {
		DocumentoValorPropioMapper mapper = new DocumentoValorPropioMapper();
		List<ChequeraDetalle_V> listDetail = chequeraService.getListaChequeDetalle(chequeraId);
		List<ValorPropioForm> list = mapper.getFormViewListDetail(listDetail);
		
		return list;
	}
	
}
