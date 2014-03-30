package com.contable.form;

import com.contable.common.beans.FormConfig;

public class EstructuraForm implements FormConfig  {

	private static final long serialVersionUID = 1L;

	private int id;
	private String estado;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
}
