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
@Table(name = "")
public class TipoDocumento implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	public TipoDocumento() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private  int id ;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "NumeracionTipo")
	private String numeracionTipo;
	
	@Column(name = "NumeracionPeriodo")
	private String numeracionPeriodo;
	
	@Column(name = "NumeracionFormato")
	private String numeracionFormato;

	@Column(name = "TipoMovimiento")
	private String tipoMovimiento;
	
	@Column(name = "PermiteAplicaciones")
	private String permiteAplicaciones;
	
	@Column(name = "PermiteImputaciones")
	private String permiteImputaciones;
	
	@Column(name = "PermiteValProp")
	private String permiteValProp;
	
	@Column(name = "PermiteIngValTer")
	private String permiteIngValTer;
	
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
    @JoinColumn(name="IdAdministracion")		
	private  Administracion administracion;
	
	@Column(name = "PermiteEgrValTer")
	private String permiteEgrValTer;

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
	public static Property fieldEntidad() {
		return new Property("entidad.nombre",Property.TYPE_CADENA);
	}
	
	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldCuenta() {
		return new Property("cuenta.nombre",Property.TYPE_CADENA);
	}

	/** Este metodo devuelve la informacion para filtrar	 */
	public static Property fieldMoneda() {
		return new Property("moneda.nombre",Property.TYPE_CADENA);
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
	public String getNumeracionTipo() {
		return numeracionTipo;
	}
	public void setNumeracionTipo(String numeracionTipo) {
		this.numeracionTipo = numeracionTipo;
	}
	public String getNumeracionPeriodo() {
		return numeracionPeriodo;
	}
	public void setNumeracionPeriodo(String numeracionPeriodo) {
		this.numeracionPeriodo = numeracionPeriodo;
	}
	public String getNumeracionFormato() {
		return numeracionFormato;
	}
	public void setNumeracionFormato(String numeracionFormato) {
		this.numeracionFormato = numeracionFormato;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public String getPermiteAplicaciones() {
		return permiteAplicaciones;
	}
	public void setPermiteAplicaciones(String permiteAplicaciones) {
		this.permiteAplicaciones = permiteAplicaciones;
	}
	public String getPermiteImputaciones() {
		return permiteImputaciones;
	}
	public void setPermiteImputaciones(String permiteImputaciones) {
		this.permiteImputaciones = permiteImputaciones;
	}
	public String getPermiteValProp() {
		return permiteValProp;
	}
	public void setPermiteValProp(String permiteValProp) {
		this.permiteValProp = permiteValProp;
	}
	public String getPermiteIngValTer() {
		return permiteIngValTer;
	}
	public void setPermiteIngValTer(String permiteIngValTer) {
		this.permiteIngValTer = permiteIngValTer;
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
	public String getPermiteEgrValTer() {
		return permiteEgrValTer;
	}
	public void setPermiteEgrValTer(String permiteEgrValTer) {
		this.permiteEgrValTer = permiteEgrValTer;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
