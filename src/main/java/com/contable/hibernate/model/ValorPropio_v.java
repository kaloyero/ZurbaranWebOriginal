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
@Table(name = "valorespropios_v")
public class ValorPropio_v implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public ValorPropio_v() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	@Column(name = "Numero")
	private  int numero;
	@Column(name = "Beneficiario")
	private  String beneficiario;
	@Column(name = "FechaVencimiento")
	private  Date fechaVencimiento;

	@Column(name = "IdChequera")
	private  Integer chequeraId;
	@Column(name = "IdAdministracion")
	private Integer administracionId;
	@Column(name = "administracionNombre")
	private String administracionNombre;
	@Column(name = "FechaIngreso")
	private Date fechaIngreso;
	@Column(name = "IdDocumento")
	private Integer documentoId;
	@Column(name = "IdTipoDocumento")
	private String tipoDocumentoId;
	@Column(name = "nombreTipoDocumento")
	private String tipoDocumentoNombre;
	@Column(name = "NumeroFormateado")
	private String documentoFormateado;
	@Column(name = "IdMovimiento")
	private Integer movimientoId;
	@Column(name = "Cotizacion")
	private Double cotizacion;
	@Column(name = "importeValor")
	private Double importeValor;
	@Column(name = "IdCuenta")
	private Integer cuentaId;
	@Column(name = "IdTipoEntidad")
	private Integer tipoEntidadId;
	@Column(name = "IdEntidad")
	private Integer entidadId;
	@Column(name = "IdMoneda")
	private Integer monedaId;
	@Column(name = "monedaNombre")
	private String monedaNombre;
	@Column(name = "monedaCodigo")
	private String monedaCodigo;
	@Column(name = "cuentaNombre")
	private String cuentaNombre;
	@Column(name = "cuentaCodigo")
	private String cuentaCodigo;
	@Column(name = "tipoentidadNombre")
	private String tipoEntidadNombre;
	@Column(name = "entidadNombre")
	private String entidadNombre;
	@Column(name = "Estado")
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public String getAdministracionNombre() {
		return administracionNombre;
	}
	public void setAdministracionNombre(String administracionNombre) {
		this.administracionNombre = administracionNombre;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
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
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public Double getImporteValor() {
		return importeValor;
	}
	public void setImporteValor(Double importeValor) {
		this.importeValor = importeValor;
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
	public String getCuentaNombre() {
		return cuentaNombre;
	}
	public void setCuentaNombre(String cuentaNombre) {
		this.cuentaNombre = cuentaNombre;
	}
	public String getCuentaCodigo() {
		return cuentaCodigo;
	}
	public void setCuentaCodigo(String cuentaCodigo) {
		this.cuentaCodigo = cuentaCodigo;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
	}
	public Integer getChequeraId() {
		return chequeraId;
	}
	public void setChequeraId(Integer chequeraId) {
		this.chequeraId = chequeraId;
	}
	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}
	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	public String getDocumentoFormateado() {
		return documentoFormateado;
	}
	public void setDocumentoFormateado(String documentoFormateado) {
		this.documentoFormateado = documentoFormateado;
	}
	public String getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(String tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	
}
