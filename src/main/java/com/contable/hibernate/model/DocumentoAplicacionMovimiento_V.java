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
@Table(name = "documentoaplicacionesmovimientos_v")
public class DocumentoAplicacionMovimiento_V implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public DocumentoAplicacionMovimiento_V() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	
	@Column(name = "IdAplicacion")
	private Integer aplicacionId;
	@Column(name = "IdDocumento")
	private Integer documentoId;
	@Column(name = "IdAdministracion")
	private Integer administracionId;
	@Column(name = "IdTipoDocumento")
	private Integer tipoDocumentoId;
	@Column(name = "nombreTipoDocumento")
	private String tipoDocumentoNombre;
	@Column(name = "NumeroFormateado")
	private String numeroFormateado;
	@Column(name = "FechaIngreso")
	private Date fechaIngreso;
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "ImporteTotal")
	private Double importeTotal;
	@Column(name = "Cotizacion")
	private Double cotizacion;
	@Column(name = "IdDocumentoAplica")
	private Integer docAplicaId;
	@Column(name = "IdAdministracionDocumentoAplicado")
	private Integer docAplicaAdministracionId;
	@Column(name = "IdTipoDocumentoAplicado")
	private Integer docAplicaTipoDocumentoId;
	@Column(name = "nombreTipoDocumentoAplicado")
	private String  docAplicaTipoDocumentoNombre;
	@Column(name = "NumeroFormateadoAplicacion")
	private String  docAplicaNumeroFormateado;
	@Column(name = "TotalAplicado")
	private Double  docAplicaTotal;
	@Column(name = "DescripcionAplicacion")
	private String  docAplicaDescripcion;
	@Column(name = "monedaNombreMov")
	private String movMonedaNombre;
	@Column(name = "monedaCodigoMov")
	private String movMonedaCodigo;
	@Column(name = "IdMovimiento")
	private Integer movId;
	@Column(name = "IdCuentaMov")
	private Integer movCuentaId;
	@Column(name = "IdTipoEntidadMov")
	private Integer movTipoEntidadId;
	@Column(name = "IdEntidadMov")
	private Integer movEntidadId;
	@Column(name = "IdMonedaMov")
	private Integer movMonedaId;
	@Column(name = "ImporteMov")
	private Double movImporte;
	@Column(name = "CotizacionMov")
	private Double movCotizacion;
	@Column(name = "Referencia")
	private String movReferencia;

	@Column(name = "IdCuenta")
	private Integer cuentaId;
	@Column(name = "cuentaNombre")
	private String cuentaNombre;
	@Column(name = "IdTipoEntidad")
	private Integer tipoEntidadId;
	@Column(name = "tipoentidadNombre")
	private String tipoentidadNombre;
	@Column(name = "IdEntidad")
	private Integer entidadId;
	@Column(name = "entidadNombre")
	private String entidadNombre;
	@Column(name = "IdMoneda")
	private Integer monedaId;
	@Column(name = "monedaNombre")
	private String monedaNombre;
	@Column(name = "monedaCodigo")
	private String monedaCodigo;

	
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
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
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
	public Double getDocAplicaTotal() {
		return docAplicaTotal;
	}
	public void setDocAplicaTotal(Double docAplicaTotal) {
		this.docAplicaTotal = docAplicaTotal;
	}
	public String getDocAplicaDescripcion() {
		return docAplicaDescripcion;
	}
	public void setDocAplicaDescripcion(String docAplicaDescripcion) {
		this.docAplicaDescripcion = docAplicaDescripcion;
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
	public Double getMovImporte() {
		return movImporte;
	}
	public void setMovImporte(Double movImporte) {
		this.movImporte = movImporte;
	}
	public Double getMovCotizacion() {
		return movCotizacion;
	}
	public void setMovCotizacion(Double movCotizacion) {
		this.movCotizacion = movCotizacion;
	}
	public String getMovReferencia() {
		return movReferencia;
	}
	public void setMovReferencia(String movReferencia) {
		this.movReferencia = movReferencia;
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
	public Integer getDocumentoId() {
		return documentoId;
	}
	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}
	
	
	
	
	
}
