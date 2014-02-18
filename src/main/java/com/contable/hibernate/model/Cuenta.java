package com.contable.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cuentas")
public class Cuenta implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Cuenta() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Codigo")
	private  String Codigo;
	
	@Column(name = "Nombre")
	private  String Nombre;
	
	@Column(name = "Descripcion")
	private  String Descripcion;
	
	@Column(name = "TipoSaldo")
	private  String TipoSaldo;
	
	@Column(name = "IdTipoEntidad")
	private  int IdTipoEntidad;
	
	@Column(name = "IdAdministracion")
	private  int IdAdministracion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getTipoSaldo() {
		return TipoSaldo;
	}

	public void setTipoSaldo(String tipoSaldo) {
		TipoSaldo = tipoSaldo;
	}

	public int getIdTipoEntidad() {
		return IdTipoEntidad;
	}

	public void setIdTipoEntidad(int idTipoEntidad) {
		IdTipoEntidad = idTipoEntidad;
	}

	public int getIdAdministracion() {
		return IdAdministracion;
	}

	public void setIdAdministracion(int idAdministracion) {
		IdAdministracion = idAdministracion;
	}	
	

	
}
