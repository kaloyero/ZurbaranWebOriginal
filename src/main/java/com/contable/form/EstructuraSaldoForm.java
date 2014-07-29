package com.contable.form;

import java.io.Serializable;


public class EstructuraSaldoForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private String contenidoNombre;
	private String codigo;
	private String documento;
	private Integer cuentaId;
	private String cuentaNombre;
	private Integer entidadId;
	private String entidadNombre;
	private Integer monedaId;
	private String monedaNombre;
	private String monedaCodigo;
	private String fecha;
	private String debito;
	private String credito;
	private String saldo;
	private String monedaCodigoMuestra;
	private String monedaNombreMuestra;
	private String debitoMuestra;
	private String creditoMuestra;
	private String saldoMuestra;
	private String tipoDocumentoNombre;
	private String documentoDescripcion;

	
	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}
	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	public String getDocumentoDescripcion() {
		return documentoDescripcion;
	}
	public void setDocumentoDescripcion(String documentoDescripcion) {
		this.documentoDescripcion = documentoDescripcion;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}
	public String getMonedaNombreMuestra() {
		return monedaNombreMuestra;
	}
	public void setMonedaNombreMuestra(String monedaNombreMuestra) {
		this.monedaNombreMuestra = monedaNombreMuestra;
	}
	public String getMonedaCodigoMuestra() {
		return monedaCodigoMuestra;
	}
	public void setMonedaCodigoMuestra(String monedaCodigoMuestra) {
		this.monedaCodigoMuestra = monedaCodigoMuestra;
	}
	public String getDebitoMuestra() {
		return debitoMuestra;
	}
	public void setDebitoMuestra(String debitoMuestra) {
		this.debitoMuestra = debitoMuestra;
	}
	public String getCreditoMuestra() {
		return creditoMuestra;
	}
	public void setCreditoMuestra(String creditoMuestra) {
		this.creditoMuestra = creditoMuestra;
	}
	public String getSaldoMuestra() {
		return saldoMuestra;
	}
	public void setSaldoMuestra(String saldoMuestra) {
		this.saldoMuestra = saldoMuestra;
	}
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
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}

	public String getContenidoNombre() {
		return contenidoNombre;
	}
	public void setContenidoNombre(String contenidoNombre) {
		this.contenidoNombre = contenidoNombre;
	}
	public String getMonedaNombre() {
		return monedaNombre;
	}
	public void setMonedaNombre(String monedaNombre) {
		this.monedaNombre = monedaNombre;
	}
	public String getMonedaCodigo() {
		return monedaCodigo;
	}
	public void setMonedaCodigo(String monedaCodigo) {
		this.monedaCodigo = monedaCodigo;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDebito() {
		return debito;
	}
	public void setDebito(String debito) {
		this.debito = debito;
	}
	public String getCredito() {
		return credito;
	}
	public void setCredito(String credito) {
		this.credito = credito;
	}

	
}
