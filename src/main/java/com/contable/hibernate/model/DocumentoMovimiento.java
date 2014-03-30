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
	private  int idConcepto;
	
	@Column(name = "IdCuenta")
	private  int idCuenta;
	
	@Column(name = "IdTipoEntidad")
	private  int idTipoEntidad;
	
	@Column(name = "IdEntidad")
	private  int idEntidad;
	
	@Column(name = "Descripcion")
	private  String descripcion;
	
	@Column(name = "IdMoneda")
	private  int idMoneda;
	
	@Column(name = "Importe")
	private  double importe;
	
	@Column(name = "TipoMovimiento")
	private  int tipoMovimiento;
	
	@Column(name = "IdDocumento")
	private  int idDocumento;

	@Column(name = "Cotizacion")
	private  double cotizacion;

	
	public double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdConcepto() {
		return idConcepto;
	}
	public void setIdConcepto(int idConcepto) {
		this.idConcepto = idConcepto;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public int getIdTipoEntidad() {
		return idTipoEntidad;
	}
	public void setIdTipoEntidad(int idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
	}
	public int getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(int tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public int getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}	

	
}
