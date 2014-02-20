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


@Entity
@Table(name = "conceptos")
public class Concepto implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public Concepto() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;

	@Column(name = "Codigo")
	private String codigo;

	@Column(name = "Nombre")
	private String nombre;
  	
	@Column(name = "Descripcion")
	private String descripcion;
  	
	@Column(name = "TipoValor")
	private String tipoValor;
  	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdEntidad")
	private Entidad entidad;
  	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdCuenta")
	private Cuenta cuenta;
  	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdMoneda")
	private Moneda moneda;
  	
	@OneToOne(fetch=FetchType.EAGER )
    @JoinColumn(name="IdAdministraciones")		
	private  Administracion administracion;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoValor() {
		return tipoValor;
	}
	public void setTipoValor(String tipoValor) {
		this.tipoValor = tipoValor;
	}
	
	public Entidad getEntidad() {
		return entidad;
	}
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public Moneda getMoneda() {
		return moneda;
	}
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	public Administracion getAdministracion() {
		return administracion;
	}
	public void setAdministracion(Administracion administracion) {
		this.administracion = administracion;
	}
  	
}
