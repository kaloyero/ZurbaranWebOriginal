package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.CuentaMonedaDao;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.hibernate.model.Moneda;

@Repository("cuentaMonedaDao")
public class CuentaMonedaDaoImpl extends GenericDaoImpl<CuentaMoneda, Integer> implements CuentaMonedaDao{

	@Override
	protected Class<CuentaMoneda> getEntityClass() {
		return CuentaMoneda.class;
	}

	@Transactional
	public void save(List<CuentaMoneda> dtoList) {
		for (CuentaMoneda dto : dtoList) {
			this.save(dto);	
		}
	}

	@Transactional
	public void update(List<Integer> idsMonedas,int idCuenta) {
		List<CuentaMoneda> ctaMonedas = this.findAllByProperty("idCuenta", idCuenta,false);
	
		//Controla que monedas ya no estan y las ELIMINA
		for (CuentaMoneda ctaMoneda : ctaMonedas) {
			boolean deleteMoneda = true;
			
			for (Integer idMoneda : idsMonedas) {
				if (ctaMoneda.getMoneda().getId().equals(idMoneda)){
					deleteMoneda = false;
				}
			}
			
			if (deleteMoneda){
				//elimina la moneda
				this.delete(ctaMoneda);
			}
		}
		
		//AGREGA MONEDAS
		for (Integer idMoneda : idsMonedas) {
			boolean insert = true;
			for (CuentaMoneda ctaMoneda : ctaMonedas) {
				if (ctaMoneda.getMoneda().getId().equals(idMoneda)){
					insert =false;
				}
			}
			if (insert){
				CuentaMoneda monCta = new CuentaMoneda();
				Moneda mon = new Moneda(); 
				mon.setId(idMoneda);
				monCta.setIdCuenta(idCuenta);
				monCta.setMoneda(mon);

				this.save(monCta);
			}
			
		}

	}
	
	public List<CuentaMoneda> getMonedasByIdCuenta(int idCuenta){
		List<CuentaMoneda> lista = this.findAllByProperty("idCuenta" ,idCuenta,false);
		return lista;
	}

	public List<ConfigBean> getMonedasConfigByIdCuenta(int idCuenta){
		List<Property> filtros = new ArrayList<Property>();
		
		filtros.add(new Property(Restrictions.eq("idCuenta", idCuenta), Property.OPERATOR_AND));

		List<ConfigBean> list = this.findComboListByFilters(Constants.FIELD_REFERENCIA,Constants.FIELD_NAME,Constants.BD_ACTIVO,filtros,"moneda.monedaLocal,moneda.nombre",true,"moneda");		
		
		return list;

	}

}
