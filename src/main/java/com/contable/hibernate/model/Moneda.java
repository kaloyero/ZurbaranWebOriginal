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
@Table(name = "monedas")
public class Moneda implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Moneda() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  Integer id ;
	
	@Column(name = "Codigo")
	private  String codigo;
	
	@Column(name = "Nombre")
	private  String nombre;
	
	@Column(name = "MonedaLocal")
	private  String monedaLocal;

	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdAdministracion")		
	private  Administracion administracion;

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
	public static Property fieldAdministracion() {
		return new Property("administracion.nombre",Property.TYPE_CADENA);
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Administracion getAdministracion() {
		return administracion;
	}
	public void setAdministracion(Administracion administracion) {
		this.administracion = administracion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMonedaLocal() {
		return monedaLocal;
	}

	public void setMonedaLocal(String monedaLocal) {
		this.monedaLocal = monedaLocal;
	}

	
}
