package com.contable.hibernate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.hibernate.dao.EstructuraContenidoCuentaDao;
import com.contable.hibernate.model.EstructuraContenidoCuenta;

@Repository("estructuraContenidoCuentaDao")
public class EstructuraContenidoCuentaDaoImpl extends GenericDaoImpl<EstructuraContenidoCuenta, Integer> implements EstructuraContenidoCuentaDao{

	@Override
	protected Class<EstructuraContenidoCuenta> getEntityClass() {
		return EstructuraContenidoCuenta.class;
	}

	@Transactional
	public void update(List<EstructuraContenidoCuenta> idsCuentas,int idContenido) {
		List<EstructuraContenidoCuenta> cuentasActuales = this.findAllByProperty("IdEstructuraContenido", idContenido,false);
		
		//Actualiza las cuentas
		for (EstructuraContenidoCuenta idCta : idsCuentas) {
			if (idCta.getId() != 0){
				this.update(idCta);
			}
		}
		
		//Controla que cuentas ya no estan y las ELIMINA
		for (EstructuraContenidoCuenta cuenta : cuentasActuales) {
			boolean deleteCuenta = true;
			
			for (EstructuraContenidoCuenta idCta : idsCuentas) {
				if (cuenta.getId() == idCta.getId()){
					deleteCuenta = false;
				}
			}
			
			if (deleteCuenta){
				//elimina la moneda
				this.delete(cuenta);
			}
		}
		
		//AGREGA MONEDAS
		for (EstructuraContenidoCuenta idCta : idsCuentas) {
			boolean insert = true;
			for (EstructuraContenidoCuenta cuentaAct : cuentasActuales) {
				if (cuentaAct.getId() == idCta.getId()){
					insert =false;
				}
			}
			if (insert){
				this.save(idCta);
			}
		}
		

	}


	
}
