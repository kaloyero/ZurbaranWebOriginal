package com.contable.form;

import com.contable.common.beans.Form;

public class EstructuraContenidoCuentaForm implements Form {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private Integer cuentaId;

	private Integer entidadId;

	private MonedaForm moneda;

	public Integer getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}

	public Integer getEntidadId() {
		return entidadId;
	}

	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}

	public MonedaForm getMoneda() {
		return moneda;
	}

	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

		
}
