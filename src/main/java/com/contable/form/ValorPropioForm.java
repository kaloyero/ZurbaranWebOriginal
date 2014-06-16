package com.contable.form;

import com.contable.common.beans.Form;

public class ValorPropioForm implements Form {
	
	private static final long serialVersionUID = 1L;
	
	private  int id ;
	private  Integer numero;
	private  String beneficiario;
	private  String fechaVencimiento;
	private Integer administracionId;
	private String administracionNombre;
	private String fechaIngreso;
	private Integer documentoId;
	private Integer movimientoId;
	private Double cotizacion;
	private Double importeValor;
	private Integer cuentaId;
	private Integer tipoEntidadId;
	private Integer entidadId;
	private Integer monedaId;
	private String monedaNombre;
	private String monedaCodigo;
	private String cuentaNombre;
	private String cuentaCodigo;
	private String tipoEntidadNombre;
	private String entidadNombre;
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
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
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
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

	
	
}
