package com.contable.manager.impl;

import java.util.ArrayList;
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
import com.contable.form.ChequeraNoDisponibleForm;
import com.contable.hibernate.model.ChequeraNoDisponible;
import com.contable.hibernate.model.ValorPropio_v;
import com.contable.manager.ChequeraNoDisponibleManager;
import com.contable.mappers.ChequeraNoDisponibleMapper;
import com.contable.services.ChequeraNoDisponibleService;
import com.contable.services.ChequeraService;

@Service("chequeraNoDisponibleManager")
public class ChequeraNoDisponibleManagerImpl extends AbstractManagerImpl<ChequeraNoDisponible,ChequeraNoDisponibleForm> implements ChequeraNoDisponibleManager{

	@Autowired
	ChequeraNoDisponibleService chequeraNoDisponibleService;

	@Autowired
	ChequeraService chequeraService;

	@Override
	protected AbstractService<ChequeraNoDisponible> getRelatedService() {
		return chequeraNoDisponibleService;
	}

	@Override
	protected Mapper<ChequeraNoDisponible,ChequeraNoDisponibleForm> getMapper() {
		return new ChequeraNoDisponibleMapper();
	}
	
	@Transactional
	public ErrorRespuestaBean guardarNuevo(ChequeraNoDisponibleForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		
		if (existeCheque(form.getIdChequera(),form.getNumero())){
			//Si existe el cheque anulado que se quiere anular lanza una excepcion
			res.setValido(false);
			res.setCodError(ConstantsErrors.CHEQUERA_COD_2_COD_ERROR);
			res.setDescripcion("El cheque que se intenta anular ya ha sido ingresado.");
			res.setError(ConstantsErrors.CHEQUERA_COD_2_ERROR);
		} else {
			//Guardo el cheque 
			getRelatedService().save(getMapper().getEntidad(form));
		}
		//Actualizo el numero de cheque
		
		return res;
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

		if ( (list != null && list.size() > 0)){
			// Si la consulta devuelve resultados es porque existe un numero de cheque no disponiblepara esa chequera
			return true;		
		}
		return false;
		
	}
	
	public boolean existeCheque(int chequeraId, int numero) {
		
		boolean existeChequeNoDispo= existeChequeNoDisponible(chequeraId,numero);
		ValorPropio_v cheque = chequeraService.getCheque(chequeraId, numero);

		if ( existeChequeNoDispo || cheque != null){
			// Si la consulta devuelve resultados es porque existe un numero de cheque no disponible o en valores porpios para esa chequera
			return true;		
		}
		return false;
		
	}

	public Integer getUltimoNumeroChequeByChequera(int chequeraId) {
		return chequeraNoDisponibleService.getUltimoNumeroChequeByChequera(chequeraId);
	}
}
