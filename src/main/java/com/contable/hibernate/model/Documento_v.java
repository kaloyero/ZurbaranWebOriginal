package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.contable.common.beans.Property;


@Entity
@Table(name = "documentos_v")
public class Documento_v implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Documento_v() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "NumeroLetra",insertable=false, updatable=false)
	private String  numeroLetra;
	@Column(name = "NumeroEstablecimiento",insertable=false, updatable=false)
	private Integer numeroEstablecimiento;
	@Column(name = "NumeroAnio",insertable=false, updatable=false)
	private Integer numeroAnio;
	@Column(name = "NumeroMes",insertable=false, updatable=false)
	private Integer numeroMes;
	@Column(name = "NumeroDia",insertable=false, updatable=false)
	private Integer numeroDia;
	@Column(name = "Numero",insertable=false, updatable=false)
	private Integer numero;
	
	@Column(name = "Descripcion",insertable=false, updatable=false)
	private String descripcion;
	@Column(name = "FechaReal",insertable=false, updatable=false)
	private Date fechaReal;
	@Column(name = "FechaIngreso",insertable=false, updatable=false)
	private Date fechaIngreso;
	@Column(name = "fechaVencimiento",insertable=false, updatable=false)
	private Date fechaVencimiento;

	@Column(name="IdCuenta",insertable=false, updatable=false)
	private Integer periodoId;
	
	@Column(name="Cotizacion",insertable=false, updatable=false)
	private Double cotizacion;
	
	@Column(name="ImporteTotal",insertable=false, updatable=false)
	private Double importeTotal;
	
	@Column(name="IdEntidad",insertable=false, updatable=false)
	private Integer entidad;
  	
	@Column(name = "entidadNombre",insertable=false, updatable=false)
	private String entidadNombre;

	@Column(name="IdCuenta",insertable=false, updatable=false)
	private Integer cuentaId;
  	
	@Column(name = "cuentaNombre",insertable=false, updatable=false)
	private String cuentaNombre;

	@Column(name = "cuentaCodigo",insertable=false, updatable=false)
	private String cuentaCodigo;

	@Column(name = "IdTipoDocumento",insertable=false, updatable=false)
	private Integer idTipoDocumento;
	
	@Column(name = "tipodocumentoNombre",insertable=false, updatable=false)
	private String tipodocumentoNombre;

    @Column(name="IdMoneda")
	private Integer moneda;

    @Column(name = "monedaNombre",insertable=false, updatable=false)
	private String monedaNombre;
    
    @Column(name = "monedaCodigo",insertable=false, updatable=false)
	private String monedaCodigo;

    @Column(name="IdAdministracion",insertable=false, updatable=false)
	private  Integer administracionId;

    @Column(name = "administracionNombre",insertable=false, updatable=false)
	private String administracionNombre;

	@Column(name = "Estado")
	private String  estado;

	@Column(name = "tipoentidadNombre",insertable=false, updatable=false)
	private String tipoEntidadNombre;

	@Column(name = "NumeroFormateado",insertable=false, updatable=false)
	private String numeroFormato;
    @Column(name="IdTipoEntidad",insertable=false, updatable=false)
	private  Integer tipoEntidadId;
    @Column(name="IdDocumentoAnuladoPor",insertable=false, updatable=false)
	private  Integer idDocumentoAnuladoPor;

    @Column(name="IdDocumentoAnulaA",insertable=false, updatable=false)
	private  Integer idDocumentoAnulaA;

    @Column(name="descripcionEstado",insertable=false, updatable=false)
	private  String descripcionEstado;
    
    @Column(name="CantidadAplicaciones",insertable=false, updatable=false)
	private  Integer cantidadAplicaciones;

        /** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldEstado() {
		return new Property("estado",Property.TYPE_CADENA);
	}
	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldNombre() {
		return new Property("nombre",Property.TYPE_CADENA);
	}
	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldEntidad() {
		return new Property("entidadNombre",Property.TYPE_CADENA);
	}
	
	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldCuenta() {
		return new Property("cuentaNombre",Property.TYPE_CADENA);
	}

	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldMoneda() {
		return new Property("monedaNombre",Property.TYPE_CADENA);
	}

	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldAdministracion() {
		return new Property("administracionNombre",Property.TYPE_CADENA);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
	public Integer getEntidad() {
		return entidad;
	}
	public void setEntidad(Integer entidad) {
		this.entidad = entidad;
	}
	public String getEntidadNombre() {
		return entidadNombre;
	}
	public void setEntidadNombre(String entidadNombre) {
		this.entidadNombre = entidadNombre;
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
	public String getCuentaCodigo() {
		return cuentaCodigo;
	}
	public void setCuentaCodigo(String cuentaCodigo) {
		this.cuentaCodigo = cuentaCodigo;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getTipodocumentoNombre() {
		return tipodocumentoNombre;
	}
	public void setTipodocumentoNombre(String tipodocumentoNombre) {
		this.tipodocumentoNombre = tipodocumentoNombre;
	}
	public Integer getMoneda() {
		return moneda;
	}
	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}
	public Date getFechaReal() {
		return fechaReal;
	}
	public void setFechaReal(Date fechaReal) {
		this.fechaReal = fechaReal;
	}
	public String getTipoEntidadNombre() {
		return tipoEntidadNombre;
	}
	public void setTipoEntidadNombre(String tipoEntidadNombre) {
		this.tipoEntidadNombre = tipoEntidadNombre;
	}
	public String getNumeroFormato() {
		return numeroFormato;
	}
	public void setNumeroFormato(String numeroFormato) {
		this.numeroFormato = numeroFormato;
	}
	public Integer getTipoEntidadId() {
		return tipoEntidadId;
	}
	public void setTipoEntidadId(Integer tipoEntidadId) {
		this.tipoEntidadId = tipoEntidadId;
	}
	public Integer getIdDocumentoAnuladoPor() {
		return idDocumentoAnuladoPor;
	}
	public void setIdDocumentoAnuladoPor(Integer idDocumentoAnuladoPor) {
		this.idDocumentoAnuladoPor = idDocumentoAnuladoPor;
	}
	public Integer getPeriodoId() {
		return periodoId;
	}
	public void setPeriodoId(Integer periodoId) {
		this.periodoId = periodoId;
	}
	public Integer getIdDocumentoAnulaA() {
		return idDocumentoAnulaA;
	}
	public void setIdDocumentoAnulaA(Integer idDocumentoAnulaA) {
		this.idDocumentoAnulaA = idDocumentoAnulaA;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}
	public Integer getCantidadAplicaciones() {
		return cantidadAplicaciones;
	}
	public void setCantidadAplicaciones(Integer cantidadAplicaciones) {
		this.cantidadAplicaciones = cantidadAplicaciones;
	}


	
}
