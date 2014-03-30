package com.contable.form;

import com.contable.common.beans.Form;

/**
 * @author kaloye
 *
 */
public class CotizacionForm implements Form {

	private static final long serialVersionUID = -3946068796340014529L;

	private int id;
	private String fecha;
	private double cotizacion;
	private MonedaForm moneda;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public MonedaForm getMoneda() {
		return moneda;
	}

	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}
	
	
}
