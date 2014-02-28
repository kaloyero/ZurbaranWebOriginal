package com.contable.form;

import com.contable.common.beans.Form;

/**
 * @author kaloye
 *
 */
public class CuentaMonedaForm implements Form  {

	private int id;
	private String idCuenta;
	private MonedaForm moneda;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}
	
}
