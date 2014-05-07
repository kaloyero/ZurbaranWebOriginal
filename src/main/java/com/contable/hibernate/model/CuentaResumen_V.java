package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "resumencuentamovimientos_v")
public class CuentaResumen_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public CuentaResumen_V() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdAdministracion", updatable = false, insertable = false)
	private Integer administracionId;
	@Column(name = "FechaIngreso",updatable=false,insertable=false)
	private Date fechaIngreso;
	@Column(name = "tipodocumentoNombre",updatable=false,insertable=false)
	private String tipodocumentoNombre;
	@Column(name = "NumeroLetra",updatable=false,insertable=false)
	private String numeroLetra;
	@Column(name = "NumeroEstablecimiento",updatable=false,insertable=false)
	private Integer numeroEstablecimiento;
	@Column(name = "NumeroAnio",updatable=false,insertable=false)
	private Integer numeroAnio;
	@Column(name = "NumeroMes",updatable=false,insertable=false)
	private Integer numeroMes;
	@Column(name = "NumeroDia",updatable=false,insertable=false)
	private Integer numeroDia;
	@Column(name = "Numero",updatable=false,insertable=false)
	private Integer numero;
	@Column(name = "IdDocumento",updatable=false,insertable=false)
	private Integer documentoId;
	@Column(name = "IdMovimiento",updatable=false,insertable=false)
	private Integer movimientoId;
	@Column(name = "Descripcion",updatable=false,insertable=false)
	private String descripcion;
	@Column(name = "Referencia",updatable=false,insertable=false)
	private String referencia;
	@Column(name = "IdCuenta",updatable=false,insertable=false)
	private Integer cuentaId;
	@Column(name = "IdTipoEntidad",updatable=false,insertable=false)
	private Integer tipoEntidadId;
	@Column(name = "IdEntidad",updatable=false,insertable=false)
	private Integer entidadId;
	@Column(name = "IdMoneda",updatable=false,insertable=false)
	private String monedaId;
	@Column(name = "monedaNombre",updatable=false,insertable=false)
	private String monedaNombre;
	@Column(name = "monedaCodigo",updatable=false,insertable=false)
	private String monedaCodigo;
	@Column(name = "Debito",updatable=false,insertable=false)
	private Double debito;
	@Column(name = "Credito",updatable=false,insertable=false)
	private Double credito;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	public Integer getMovimientoId() {
		return movimientoId;
	}
	public void setMovimientoId(Integer movimientoId) {
		this.movimientoId = movimientoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public Integer getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Integer cuentaId) {
		this.cuentaId = cuentaId;
	}
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public Integer getEntidadId() {
		return entidadId;
	}
	public void setEntidadId(Integer entidadId) {
		this.entidadId = entidadId;
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
	public Double getDebito() {
		return debito;
	}
	public void setDebito(Double debito) {
		this.debito = debito;
	}
	public Double getCredito() {
		return credito;
	}
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	

}
