package com.contable.form;

import java.io.Serializable;


public class DocumentoAplicacionMovimientoForm implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoAplicacionMovimientoForm() {
	}

	private  int id ;
	private Integer aplicacionId;
	private Integer administracionId;
	private Integer tipoDocumentoId;
	private String tipoDocumentoNombre;
	private String numeroFormateado;
	private String fechaIngreso;
	private String descripcion;
	private String importeTotal;
	private String importeMostrarTotal;
	private String cotizacion;
	private Integer docAplicaId;
	private Integer docAplicaAdministracionId;
	private Integer docAplicaTipoDocumentoId;
	private String  docAplicaTipoDocumentoNombre;
	private String  docAplicaNumeroFormateado;
	private String  docAplicaTotal;
	private String  docAplicaMostrarTotal;
	private String  docAplicaDescripcion;

	private String monedaMostrarNombre;
	private String monedaMostrarCodigo;
	
	private Integer movId;
	private Integer movCuentaId;
	private Integer movTipoEntidadId;
	private Integer movEntidadId;
	private Integer movMonedaId;
	private String movMonedaNombre;
	private String movMonedaCodigo;
	private String movImporte;
	private String movCotizacion;
	private String movReferencia;
	
	private Integer docAplicaCuentaId;
	private String docAplicaCuentaNombre;
	private Integer docAplicaTipoEntidadId;
	private String docAplicaTipoEntidadNombre;
	private Integer docAplicaEntidadId;
	private String docAplicaEntidadNombre;
	private Integer docAplicaMonedaId;
	private String docAplicaMonedaNombre;
	private String docAplicaMonedaCodigo;

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getAplicacionId() {
		return aplicacionId;
	}
	public void setAplicacionId(Integer aplicacionId) {
		this.aplicacionId = aplicacionId;
	}
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public Integer getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(Integer tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}
	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	public String getNumeroFormateado() {
		return numeroFormateado;
	}
	public void setNumeroFormateado(String numeroFormateado) {
		this.numeroFormateado = numeroFormateado;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getDocAplicaId() {
		return docAplicaId;
	}
	public void setDocAplicaId(Integer docAplicaId) {
		this.docAplicaId = docAplicaId;
	}
	public Integer getDocAplicaAdministracionId() {
		return docAplicaAdministracionId;
	}
	public void setDocAplicaAdministracionId(Integer docAplicaAdministracionId) {
		this.docAplicaAdministracionId = docAplicaAdministracionId;
	}
	public Integer getDocAplicaTipoDocumentoId() {
		return docAplicaTipoDocumentoId;
	}
	public void setDocAplicaTipoDocumentoId(Integer docAplicaTipoDocumentoId) {
		this.docAplicaTipoDocumentoId = docAplicaTipoDocumentoId;
	}
	public String getDocAplicaTipoDocumentoNombre() {
		return docAplicaTipoDocumentoNombre;
	}
	public void setDocAplicaTipoDocumentoNombre(String docAplicaTipoDocumentoNombre) {
		this.docAplicaTipoDocumentoNombre = docAplicaTipoDocumentoNombre;
	}
	public String getDocAplicaNumeroFormateado() {
		return docAplicaNumeroFormateado;
	}
	public void setDocAplicaNumeroFormateado(String docAplicaNumeroFormateado) {
		this.docAplicaNumeroFormateado = docAplicaNumeroFormateado;
	}
	public String getDocAplicaDescripcion() {
		return docAplicaDescripcion;
	}
	public void setDocAplicaDescripcion(String docAplicaDescripcion) {
		this.docAplicaDescripcion = docAplicaDescripcion;
	}

	public String getMovMonedaNombre() {
		return movMonedaNombre;
	}
	public void setMovMonedaNombre(String movMonedaNombre) {
		this.movMonedaNombre = movMonedaNombre;
	}
	public String getMovMonedaCodigo() {
		return movMonedaCodigo;
	}
	public void setMovMonedaCodigo(String movMonedaCodigo) {
		this.movMonedaCodigo = movMonedaCodigo;
	}
	public Integer getMovId() {
		return movId;
	}
	public void setMovId(Integer movId) {
		this.movId = movId;
	}
	public Integer getMovCuentaId() {
		return movCuentaId;
	}
	public void setMovCuentaId(Integer movCuentaId) {
		this.movCuentaId = movCuentaId;
	}
	public Integer getMovTipoEntidadId() {
		return movTipoEntidadId;
	}
	public void setMovTipoEntidadId(Integer movTipoEntidadId) {
		this.movTipoEntidadId = movTipoEntidadId;
	}
	public Integer getMovEntidadId() {
		return movEntidadId;
	}
	public void setMovEntidadId(Integer movEntidadId) {
		this.movEntidadId = movEntidadId;
	}
	public Integer getMovMonedaId() {
		return movMonedaId;
	}
	public void setMovMonedaId(Integer movMonedaId) {
		this.movMonedaId = movMonedaId;
	}
	public String getMovImporte() {
		return movImporte;
	}
	public void setMovImporte(String movImporte) {
		this.movImporte = movImporte;
	}
	public String getMovReferencia() {
		return movReferencia;
	}
	public void setMovReferencia(String movReferencia) {
		this.movReferencia = movReferencia;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(String importeTotal) {
		this.importeTotal = importeTotal;
	}
	public String getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(String cotizacion) {
		this.cotizacion = cotizacion;
	}
	public String getDocAplicaTotal() {
		return docAplicaTotal;
	}
	public void setDocAplicaTotal(String docAplicaTotal) {
		this.docAplicaTotal = docAplicaTotal;
	}
	public String getMovCotizacion() {
		return movCotizacion;
	}
	public void setMovCotizacion(String movCotizacion) {
		this.movCotizacion = movCotizacion;
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
	public String getImporteMostrarTotal() {
		return importeMostrarTotal;
	}
	public void setImporteMostrarTotal(String importeMostrarTotal) {
		this.importeMostrarTotal = importeMostrarTotal;
	}
	public String getDocAplicaMostrarTotal() {
		return docAplicaMostrarTotal;
	}
	public void setDocAplicaMostrarTotal(String docAplicaMostrarTotal) {
		this.docAplicaMostrarTotal = docAplicaMostrarTotal;
	}
	public Integer getDocAplicaCuentaId() {
		return docAplicaCuentaId;
	}
	public void setDocAplicaCuentaId(Integer docAplicaCuentaId) {
		this.docAplicaCuentaId = docAplicaCuentaId;
	}
	public String getDocAplicaCuentaNombre() {
		return docAplicaCuentaNombre;
	}
	public void setDocAplicaCuentaNombre(String docAplicaCuentaNombre) {
		this.docAplicaCuentaNombre = docAplicaCuentaNombre;
	}
	public Integer getDocAplicaTipoEntidadId() {
		return docAplicaTipoEntidadId;
	}
	public void setDocAplicaTipoEntidadId(Integer docAplicaTipoEntidadId) {
		this.docAplicaTipoEntidadId = docAplicaTipoEntidadId;
	}
	public String getDocAplicaTipoEntidadNombre() {
		return docAplicaTipoEntidadNombre;
	}
	public void setDocAplicaTipoEntidadNombre(String docAplicaTipoEntidadNombre) {
		this.docAplicaTipoEntidadNombre = docAplicaTipoEntidadNombre;
	}
	public Integer getDocAplicaEntidadId() {
		return docAplicaEntidadId;
	}
	public void setDocAplicaEntidadId(Integer docAplicaEntidadId) {
		this.docAplicaEntidadId = docAplicaEntidadId;
	}
	public String getDocAplicaEntidadNombre() {
		return docAplicaEntidadNombre;
	}
	public void setDocAplicaEntidadNombre(String docAplicaEntidadNombre) {
		this.docAplicaEntidadNombre = docAplicaEntidadNombre;
	}
	public Integer getDocAplicaMonedaId() {
		return docAplicaMonedaId;
	}
	public void setDocAplicaMonedaId(Integer docAplicaMonedaId) {
		this.docAplicaMonedaId = docAplicaMonedaId;
	}
	public String getDocAplicaMonedaNombre() {
		return docAplicaMonedaNombre;
	}
	public void setDocAplicaMonedaNombre(String docAplicaMonedaNombre) {
		this.docAplicaMonedaNombre = docAplicaMonedaNombre;
	}
	public String getDocAplicaMonedaCodigo() {
		return docAplicaMonedaCodigo;
	}
	public void setDocAplicaMonedaCodigo(String docAplicaMonedaCodigo) {
		this.docAplicaMonedaCodigo = docAplicaMonedaCodigo;
	}

	
}
