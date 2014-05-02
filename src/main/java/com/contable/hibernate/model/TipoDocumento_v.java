package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.contable.common.beans.Property;

@Entity
@Table(name = "tipodocumentos_v")
public class TipoDocumento_v implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public TipoDocumento_v() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Nombre",insertable=false, updatable=false)
	private String nombre;

    @Column(name="IdAdministracion")		
	private  Integer administracionId;

    @Column(name = "adm_nombre",insertable=false, updatable=false)
	private  String administracionNombre;
	
	@Column(name="IdCuenta",insertable=false, updatable=false)
	private Integer cuentaId;
  	
	@Column(name = "cta_nombre",insertable=false, updatable=false)
	private String cuentaNombre;

	@Column(name = "IdEntidad",insertable=false, updatable=false)
	private Integer entidadId;
	
	@Column(name = "ent_nombre",insertable=false, updatable=false)
	private String entidadNombre;
	
	@Column(name = "IdTipoEntidad",insertable=false, updatable=false)
	private Integer tipoEntidadId;
	
	@Column(name = "ten_nombre",insertable=false, updatable=false)
	private String tipoEntidadNombre;

    @Column(name="IdMoneda")
	private Integer monedaId;
  	
	@Column(name = "Nombre",insertable=false, updatable=false)
	private String monedaNombre;

	@Column(name = "Inactivo",insertable=false, updatable=false)
	private String  estado;

	@Column(name = "Inactivo",insertable=false, updatable=false)
	private String  numeracionTipo;
	
	
	
	public String getNumeracionTipo() {
		return numeracionTipo;
	}
	public void setNumeracionTipo(String numeracionTipo) {
		this.numeracionTipo = numeracionTipo;
	}
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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

}
