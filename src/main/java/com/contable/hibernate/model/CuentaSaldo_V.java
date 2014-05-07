package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "saldoscuentasaamm_v")
public class CuentaSaldo_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public CuentaSaldo_V() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "IdAdministracion", updatable = false, insertable = false)
	private Integer administracionId;
	@Column(name = "IdCuenta", updatable = false, insertable = false)
	private Integer cuentaId;
	@Column(name = "cuentaNombre", updatable = false, insertable = false)
	private String cuentaNombre;
	@Column(name = "IdTipoEntidad", updatable = false, insertable = false)
	private Integer tipoEntidadId;
	@Column(name = "tipoentidadNombre", updatable = false, insertable = false)
	private String tipoentidadNombre;
	@Column(name = "IdEntidad", updatable = false, insertable = false)
	private Integer entidadId;
	@Column(name = "entidadNombre", updatable = false, insertable = false)
	private String entidadNombre;
	@Column(name = "IdMoneda", updatable = false, insertable = false)
	private Integer monedaId;
	@Column(name = "monedaNombre", updatable = false, insertable = false)
	private String monedaNombre;
	@Column(name = "monedaCodigo", updatable = false, insertable = false)
	private String monedaCodigo;
	@Column(name = "Anio", updatable = false, insertable = false)
	private Integer anio;
	@Column(name = "Mes", updatable = false, insertable = false)
	private Integer mes;
	@Column(name = "SaldoAAMM", updatable = false, insertable = false)
	private Double saldoAAMM;

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
	public String getTipoentidadNombre() {
		return tipoentidadNombre;
	}
	public void setTipoentidadNombre(String tipoentidadNombre) {
		this.tipoentidadNombre = tipoentidadNombre;
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
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Double getSaldoAAMM() {
		return saldoAAMM;
	}
	public void setSaldoAAMM(Double saldoAAMM) {
		this.saldoAAMM = saldoAAMM;
	}

}
