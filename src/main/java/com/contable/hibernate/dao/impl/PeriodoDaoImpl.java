package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.PeriodoDao;
import com.contable.hibernate.model.Periodo;

@Repository("periodoDao")
public class PeriodoDaoImpl extends GenericDaoImpl<Periodo, Integer> implements PeriodoDao{

	@Override
	protected Class<Periodo> getEntityClass() {
		return Periodo.class;
	}

	@Transactional
	public Periodo getPeriodoByFecha(Integer idAdm,Date fecha, Boolean abierto){
		List<Property> properties = new ArrayList<Property>();
		
		//valida que sea mayor o igual a la fecha de inicio de un periodo
		properties.add(new Property(Restrictions.ge("fechaIni", fecha), Property.OPERATOR_AND));
		//valida que sea menor o igual a la fecha de fin de un periodo
		properties.add(new Property(Restrictions.le("fechaFin", fecha), Property.OPERATOR_AND));

		/* SETEO DE ADMINISTRACION Y ESTADO */
		setAdministracionAndEstado(properties, idAdm, abierto);
		
		return findEntityByPropertyList(properties,true);

	}

	@Transactional
	public Periodo validatePeriodoByFecha(Integer idAdm, Date fecha,
			Boolean abierto, boolean fechaIni) {
		List<Property> properties = new ArrayList<Property>();
		
		if (fechaIni){
			//Fecha(Ini) debe ser mayor a fecha Fin de otro periodo
			properties.add(new Property(Restrictions.gt("fechaFin", fecha), Property.OPERATOR_AND));
			//Fecha(Ini) debe ser menor a fecha Ini de otro periodo
			properties.add(new Property(Restrictions.lt("fechaIni", fecha), Property.OPERATOR_AND));
		} else {
			//Fecha(Fin) debe ser menor a fecha Ini de otro periodo
			properties.add(new Property(Restrictions.lt("fechaIni", fecha), Property.OPERATOR_AND));
			//Fecha(Fin) debe ser mayor a fecha Fin de otro periodo
			properties.add(new Property(Restrictions.gt("fechaIni", fecha), Property.OPERATOR_AND));
		}
		
		/* SETEO DE ADMINISTRACION Y ESTADO */
		setAdministracionAndEstado(properties, idAdm, abierto);
		
		return findEntityByPropertyList(properties,true);

	}

	@Transactional
	private void setAdministracionAndEstado(List<Property> properties, Integer idAdm,Boolean abierto){
		//Envio de idAdministracion
		properties.add(new Property("administracion.id",null,idAdm));
				
		if (abierto != null){
			//Envio de Estado
			if (abierto) {
				//Periodo Abierto
				properties.add(new Property(Restrictions.like(Constants.FIELD_ESTADO, Constants.PERIODO_ABIERTO), Property.OPERATOR_AND));
			} else {
				//Periodo Cerrado
				properties.add(new Property(Restrictions.like(Constants.FIELD_ESTADO, Constants.PERIODO_CERRADO), Property.OPERATOR_AND));
				
			}
		}		
	}

	
}
