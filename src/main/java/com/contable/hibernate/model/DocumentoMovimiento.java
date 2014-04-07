package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "documentomovimientos")
public class DocumentoMovimiento implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoMovimiento() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "IdConcepto")
	private  Integer conceptoId;
	
	@Column(name = "IdCuenta")
	private  Integer cuentaId;
	
	@Column(name = "IdTipoEntidad")
	private  Integer tipoEntidadId;
	
	@Column(name = "IdEntidad")
	private  Integer entidadId;
	
	@Column(name = "CodMovimiento")
	private  String codMovimiento;

	@Column(name = "Descripcion")
	private  String descripcion;
	
	@Column(name = "IdMoneda")
	private  Integer monedaId;
	
	@Column(name = "Importe")
	private  Double importe;
	
	@Column(name = "TipoMovimiento")
	private  String tipoMovimiento;
	
	@Column(name = "IdDocumento")
	private  Integer idDocumento;

	@Column(name = "Cotizacion")
	private  Double cotizacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getConceptoId() {
		return conceptoId;
	}

	public void setConceptoId(Integer conceptoId) {
		this.conceptoId = conceptoId;
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

	public String getCodMovimiento() {
		return codMovimiento;
	}

	public void setCodMovimiento(String codMovimiento) {
		this.codMovimiento = codMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}

	
	
}
