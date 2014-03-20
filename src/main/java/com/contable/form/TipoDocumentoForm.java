package com.contable.form;

import com.contable.common.beans.FormConfig;

public class TipoDocumentoForm implements FormConfig  {

	private static final long serialVersionUID = -3939874136485777943L;

	private int id;
	private String nombre;
	private AdministracionForm administracion;
	private CuentaForm cuenta;
	private EntidadForm entidad;
	private MonedaForm moneda;
	private String NumeracionTipo;
	private String NumeracionPeriodo;
	private String NumeracionFormato;
	private String TipoMovimiento;
	private String PermiteAplicaciones;
	private String PermiteImputaciones;
	private String PermiteValProp;
	private String PermiteIngValTer;
	private String PermiteEgrValTer;
	private String estado;
	
	
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
	public AdministracionForm getAdministracion() {
		return administracion;
	}
	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
	}
	public CuentaForm getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaForm cuenta) {
		this.cuenta = cuenta;
	}
	public EntidadForm getEntidad() {
		return entidad;
	}
	public void setEntidad(EntidadForm entidad) {
		this.entidad = entidad;
	}
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}
	public String getNumeracionTipo() {
		return NumeracionTipo;
	}
	public void setNumeracionTipo(String numeracionTipo) {
		NumeracionTipo = numeracionTipo;
	}
	public String getNumeracionPeriodo() {
		return NumeracionPeriodo;
	}
	public void setNumeracionPeriodo(String numeracionPeriodo) {
		NumeracionPeriodo = numeracionPeriodo;
	}
	public String getNumeracionFormato() {
		return NumeracionFormato;
	}
	public void setNumeracionFormato(String numeracionFormato) {
		NumeracionFormato = numeracionFormato;
	}
	public String getTipoMovimiento() {
		return TipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}
	public String getPermiteAplicaciones() {
		return PermiteAplicaciones;
	}
	public void setPermiteAplicaciones(String permiteAplicaciones) {
		PermiteAplicaciones = permiteAplicaciones;
	}
	public String getPermiteImputaciones() {
		return PermiteImputaciones;
	}
	public void setPermiteImputaciones(String permiteImputaciones) {
		PermiteImputaciones = permiteImputaciones;
	}
	public String getPermiteValProp() {
		return PermiteValProp;
	}
	public void setPermiteValProp(String permiteValProp) {
		PermiteValProp = permiteValProp;
	}
	public String getPermiteIngValTer() {
		return PermiteIngValTer;
	}
	public void setPermiteIngValTer(String permiteIngValTer) {
		PermiteIngValTer = permiteIngValTer;
	}
	public String getPermiteEgrValTer() {
		return PermiteEgrValTer;
	}
	public void setPermiteEgrValTer(String permiteEgrValTer) {
		PermiteEgrValTer = permiteEgrValTer;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
