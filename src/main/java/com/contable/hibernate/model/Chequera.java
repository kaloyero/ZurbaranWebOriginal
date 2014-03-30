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
@Table(name = "chequeras")
public class Chequera implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Chequera() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "NumeroIni",nullable=true)
	private  Integer numeroIni;
	
	@Column(name = "NumeroFin",nullable=false)
	private  Integer numeroFin;

	@Column(name = "IdConceptos",nullable=false)
	private  int conceptosId;
	
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
	public static Property fieldAdministracion() {
		return new Property("administracion.nombre",Property.TYPE_CADENA);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumeroIni() {
		return numeroIni;
	}
	public void setNumeroIni(Integer numeroIni) {
		this.numeroIni = numeroIni;
	}
	public Integer getNumeroFin() {
		return numeroFin;
	}
	public void setNumeroFin(Integer numeroFin) {
		this.numeroFin = numeroFin;
	}
	public int getConceptosId() {
		return conceptosId;
	}
	public void setConceptosId(int conceptosId) {
		this.conceptosId = conceptosId;
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
