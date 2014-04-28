package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.contable.common.beans.Property;


@Entity
@Table(name = "estructuras")
public class Estructura implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Estructura() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Nombre")
	private  String nombre;
	
	@OneToOne(fetch=FetchType.EAGER )
	@JoinColumn(name="IdAdministracion")		
	private  Administracion administracion;
	
	@Column(name = "Inactivo")
	private String  estado;
	
	@Cascade(value= CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "estructura")
	private Set<EstructuraContenido> contenidos = new HashSet<EstructuraContenido>();

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
	public Set<EstructuraContenido> getContenidos() {
		return contenidos;
	}
	public void setContenidos(Set<EstructuraContenido> contenidos) {
		this.contenidos = contenidos;
	}

}
