package com.contable.form;

import com.contable.common.beans.FormConfig;


/**
 * @author kaloye
 *
 */
public class ChequeraForm implements FormConfig {

	private static final long serialVersionUID = 1L;

	private int id;
	private Integer numeroIni;
	private Integer numeroFin;
	private AdministracionForm administracion;
	private Integer conceptoId;
	private String estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumeroIni() {
		return numeroIni;
	}
	public void setNumeroIni(Integer numeroIni) {
		this.numeroIni = numeroIni;
	}
	public Integer getNumeroFin() {
		return numeroFin;
	}
	public void setNumeroFin(Integer numeroFin) {
		this.numeroFin = numeroFin;
	}
	public AdministracionForm getAdministracion() {
		return administracion;
	}
	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
	}
	public Integer getConceptoId() {
		return conceptoId;
	}
	public void setConceptoId(Integer conceptoId) {
		this.conceptoId = conceptoId;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
