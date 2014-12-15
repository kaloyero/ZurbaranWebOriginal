package com.contable.form;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;


public class CuentaBusquedaForm implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer administracionId;
	private Integer cuentaId;
	private String cuentaNombre;
	private Integer tipoEntidadId;
	private String  tipoEntidadNombre;
	private Integer entidadId;
	
	private String entidadNombre;
	private Integer monedaId;
	private String monedaNombre;
	private String monedaCodigo;
	private String saldo;
	private String monedaMostrarNombre;
	private String monedaMostrarCodigo;
	private String totalMostrar;
	private String debitoMostrar;
	private String creditoMostrar;
	
	//solo resumen
	private Integer documentoId;
	private String  tipodocumentoNombre;
	private String  docDescripcion;
	private String  numeroLetra;
	private String  referencia;
	private Integer numeroEstablecimiento;
	private Integer numeroAnio;
	private Integer numeroMes;
	private Integer numeroDia;
	private Integer numero;
	private String cotizacion;
	private BigInteger aplicacionesEnDocumento;

	private Date fecha;
	private String fechaIngreso;
	private String numeroFormateado;
	private String debito;
	private String credito;
	
	

	public String getDebitoMostrar() {
		return debitoMostrar;
	}
	public void setDebitoMostrar(String debitoMostrar) {
		this.debitoMostrar = debitoMostrar;
	}
	public String getCreditoMostrar() {
		return creditoMostrar;
	}
	public void setCreditoMostrar(String creditoMostrar) {
		this.creditoMostrar = creditoMostrar;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public Integer getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
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
	public String getTotalMostrar() {
		return totalMostrar;
	}
	public void setTotalMostrar(String totalMostrar) {
		this.totalMostrar = totalMostrar;
	}
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	public String getTipodocumentoNombre() {
		return tipodocumentoNombre;
	}
	public void setTipodocumentoNombre(String tipodocumentoNombre) {
		this.tipodocumentoNombre = tipodocumentoNombre;
	}

	public String getNumeroLetra() {
		return numeroLetra;
	}
	public void setNumeroLetra(String numeroLetra) {
		this.numeroLetra = numeroLetra;
	}
	public Integer getNumeroEstablecimiento() {
		return numeroEstablecimiento;
	}
	public void setNumeroEstablecimiento(Integer numeroEstablecimiento) {
		this.numeroEstablecimiento = numeroEstablecimiento;
	}
	public Integer getNumeroAnio() {
		return numeroAnio;
	}
	public void setNumeroAnio(Integer numeroAnio) {
		this.numeroAnio = numeroAnio;
	}
	public Integer getNumeroMes() {
		return numeroMes;
	}
	public void setNumeroMes(Integer numeroMes) {
		this.numeroMes = numeroMes;
	}
	public Integer getNumeroDia() {
		return numeroDia;
	}
	public void setNumeroDia(Integer numeroDia) {
		this.numeroDia = numeroDia;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getNumeroFormateado() {
		return numeroFormateado;
	}
	public void setNumeroFormateado(String numeroFormateado) {
		this.numeroFormateado = numeroFormateado;
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
	public String getMonedaMostrarNombre() {
		return monedaMostrarNombre;
	}
	public void setMonedaMostrarNombre(String monedaMostrarNombre) {
		this.monedaMostrarNombre = monedaMostrarNombre;
	}
	public String getMonedaMostrarCodigo() {
		return monedaMostrarCodigo;
	}
	public void setMonedaMostrarCodigo(String monedaMostrarCodigo) {
		this.monedaMostrarCodigo = monedaMostrarCodigo;
	}
	public String getDocDescripcion() {
		return docDescripcion;
	}
	public void setDocDescripcion(String docDescripcion) {
		this.docDescripcion = docDescripcion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public BigInteger getAplicacionesEnDocumento() {
		return aplicacionesEnDocumento;
	}
	public void setAplicacionesEnDocumento(BigInteger aplicacionesEnDocumento) {
		this.aplicacionesEnDocumento = aplicacionesEnDocumento;
	}
	public String getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(String cotizacion) {
		this.cotizacion = cotizacion;
	}
	
		
}
