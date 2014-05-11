package com.contable.services.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.NumeroBean;
import com.contable.common.utils.ConvertionUtil;
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
	
	public Integer getUltimoNumero(Integer idAdministracion, Integer idTipoDocumento,String letra, Integer establecimiento,Integer numAnio,Integer numMes,Integer numDia) {
		
		Integer numero = numeracionDao.getUltimoNumero(idAdministracion,idTipoDocumento, letra, establecimiento, numAnio, numMes, numDia);
		
		return numero;
	}

	public void actualizarNumeracion(Integer idAdministracion,Integer idTipoDocumento, NumeroBean num) {
		String numLetra = null;
		Integer numEstablecimiento = null;
		Integer numAnio = null;
		Integer numMes = null;
		Integer numDia = null;
		//SETEO los FILTROS
		if (StringUtils.isNotBlank(num.getNumeroAnio()) )
			numAnio = Integer.parseInt(num.getNumeroAnio());
		if (StringUtils.isNotBlank(num.getNumeroMes()))
			numMes = Integer.parseInt(num.getNumeroMes());
		if (StringUtils.isNotBlank(num.getNumeroDia()))
			numDia = Integer.parseInt(num.getNumeroDia());
		if (StringUtils.isNotBlank(num.getNumeroLetra()))
			numLetra = num.getNumeroLetra();
		if (StringUtils.isNotBlank(num.getNumeroEstablecimiento()))
			numEstablecimiento = Integer.parseInt(num.getNumeroEstablecimiento());
		
		//Obtengo el numero que voy a actualizar
		Numeracion numero = numeracionDao.getNumeroByFiltros(idAdministracion,idTipoDocumento, numLetra,numEstablecimiento,numAnio, numMes, numDia);
		
		if (numero != null){
			//Seteo el ultimo numero
			numero.setUltimoNumero(ConvertionUtil.IntValueOf(num.getNumero()));
			//Actualiza el ultimo numero
			getDao().update(numero);
		} else {
			//Agrega el nuevo numero
			Numeracion numNuevo = new Numeracion();
			numNuevo.setAdministracionId(idAdministracion);
			numNuevo.setNumeroAnio(numAnio);
			numNuevo.setNumeroDia(numDia);
			numNuevo.setNumeroMes(numMes);
			numNuevo.setUltimoNumero(ConvertionUtil.IntValueOf(num.getNumero()));
			numNuevo.setTipoDocumentoId(idTipoDocumento);
			getDao().save(numNuevo);
		}
		
	}


}
