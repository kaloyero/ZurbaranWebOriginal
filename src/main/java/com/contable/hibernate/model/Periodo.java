package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "periodos")
public class Periodo implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Periodo() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "FechaIni")
	private  Date fechaIni;
	
	@Column(name = "FechaFin")
	private  Date fechaFin;

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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

}
