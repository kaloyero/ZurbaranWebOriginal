package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.form.CuentaMonedaForm;
import com.contable.hibernate.model.CuentaMoneda;

public class CuentaMonedaMapper {


	public List<CuentaMoneda> getEntidad(List<CuentaMonedaForm> forms,int idCuenta) {
		/* Guarda la lista de monedas */
		List<CuentaMoneda> monedas = new ArrayList<CuentaMoneda>();

		if (forms != null){
			MonedaMapper mapperMon = new MonedaMapper();
			if (forms != null){
				for (CuentaMonedaForm item: forms) {
					CuentaMoneda moneda = new CuentaMoneda();
					moneda.setId(item.getId());
					moneda.setMoneda(mapperMon.getEntidad(item.getMoneda()));
					moneda.setIdCuenta(Integer.valueOf(idCuenta));
					monedas.add(moneda);
				}
			}			
		}
		return monedas;
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
					moneda.setIdCuenta(String.valueOf(item.getIdCuenta()));
					monedas.add(moneda);
				}
			
			}
		}
		return monedas;
	}


}