package com.contable.form;

import com.contable.common.beans.Form;


/**
 * @author kaloye
 *
 */
public class ChequeraNoDisponibleForm implements Form {

	private static final long serialVersionUID = 1L;

	private int id;
	private Integer numero;
	private String  importe;
	private String  motivo;
	private String  beneficiario;
	private ChequeraForm chequera;
	private String fechaEmision;
	private String fechaVto;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public ChequeraForm getChequera() {
		return chequera;
	}
	public void setChequera(ChequeraForm chequera) {
		this.chequera = chequera;
	}
	public String getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public String getFechaVto() {
		return fechaVto;
	}
	public void setFechaVto(String fechaVto) {
		this.fechaVto = fechaVto;
	}
	
}
