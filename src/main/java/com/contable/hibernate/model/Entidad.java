package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.contable.common.beans.Property;


@Entity
@Table(name = "entidades")
public class Entidad implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Entidad() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  Integer id ;
	
	@Column(name = "Nombre")
	private  String nombre;
	
	@Column(name = "CodigoReferencia")
	private  String codigoReferencia;
	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdTipoEntidad")
	private  TipoEntidad tipoEntidad;
	
	@Column(name = "Inactivo")
	private String  estado;

	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldEstado() {
		return new Property("estado",Property.TYPE_CADENA);
	}
	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldNombre() {
		return new Property("nombre",Property.TYPE_CADENA);
	}

	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldCodigoReferencia() {
		return new Property("codigoReferencia",Property.TYPE_CADENA);
	}

	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldTipoEntidad() {
		return new Property("tipoEntidad.nombre",Property.TYPE_CADENA);
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public TipoEntidad getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
