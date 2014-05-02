package com.contable.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.NumeroBean;
import com.contable.hibernate.dao.NumeracionDao;
import com.contable.hibernate.model.Numeracion;
import com.contable.services.NumeracionService;

@Service("numeracionService")
public class NumeracionServiceImpl extends AbstractServiceImpl<Numeracion> implements NumeracionService{

	@Autowired
    private NumeracionDao numeracionDao;

	protected GenericDao<Numeracion, Integer> getDao() {
		return numeracionDao;
	}
	
	public Integer getUltimoNumero(Integer idAdministracion, Integer idTipoDocumento,Integer numAnio,Integer numMes,Integer numDia) {
		
		Integer numero = numeracionDao.getUltimoNumero(idAdministracion,idTipoDocumento, numAnio, numMes, numDia);
		
		return numero;
	}

	public void actualizarNumeracion(Integer idAdministracion,
			Integer idTipoDocumento, NumeroBean num) {
		Integer numAnio = Integer.parseInt(num.getNumeroAnio());
		Integer numMes = Integer.parseInt(num.getNumeroMes());
		Integer numDia = Integer.parseInt(num.getNumeroDia());
		
		Numeracion numero = numeracionDao.getNumeroByFiltros(idAdministracion,idTipoDocumento, numAnio, numMes, numDia);
		
		if (numero != null){
			//Actualiza el ultimo numero
			getDao().update(numero);
		} else {
			//Agrega el nuevo numero
			Numeracion numNuevo = new Numeracion();
			numNuevo.setAdministracionId(idAdministracion);
			numNuevo.setNumeroAnio(numAnio);
			numNuevo.setNumeroDia(numDia);
			numNuevo.setNumeroMes(numMes);
			numNuevo.setUltimoNumero(Integer.parseInt(num.getNumero()));
			numNuevo.setTipoDocumentoId(idTipoDocumento);
			getDao().save(numero);
		}
		
	}


}
