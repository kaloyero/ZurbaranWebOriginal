package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.utils.ConvertionUtil;
import com.contable.form.CuentaMonedaForm;
import com.contable.hibernate.model.CuentaMoneda;
import com.contable.hibernate.model.Moneda;

public class CuentaMonedaMapper {


	public List<CuentaMoneda> getEntidad(List<Integer> monedas,int idCuenta) {
		/* Guarda la lista de monedas */
		List<CuentaMoneda> ctaMonedas = new ArrayList<CuentaMoneda>();

		if (monedas != null){
			for (Integer id: monedas) {
				CuentaMoneda moneda = new CuentaMoneda();
				Moneda mon = new Moneda();
				mon.setId(id);
				moneda.setMoneda(mon);
				moneda.setIdCuenta(idCuenta);
				ctaMonedas.add(moneda);
			}
		}			
		return ctaMonedas;
	}

	public  List<CuentaMonedaForm> getForm(List<CuentaMoneda> ents) {
		/* Guarda la lista de monedas */
		List<CuentaMonedaForm> monedas = new ArrayList<CuentaMonedaForm>();

		if (ents != null){
			MonedaMapper mapperMon = new MonedaMapper();

				if (ents != null){
				for (CuentaMoneda item: ents) {
					CuentaMonedaForm moneda = new CuentaMonedaForm();
					moneda.setId(item.getId());
					moneda.setMoneda(mapperMon.getForm(item.getMoneda()));
					moneda.setIdCuenta(ConvertionUtil.StrValueOf(item.getIdCuenta()));
					monedas.add(moneda);
				}
			
			}
		}
		return monedas;
	}


}