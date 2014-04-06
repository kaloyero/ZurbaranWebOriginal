package com.contable.form;

import java.io.Serializable;

import com.contable.common.constants.Constants;

public class TipoDocumentoForm implements Serializable  {

	private static final long serialVersionUID = -3939874136485777943L;

	private int id;
	private String  nombre;
	private AdministracionForm administracion;	
	private Integer cuentaId;
	private String  cuentaNombre;
	private Integer entidadId;
	private String  entidadNombre;
	private MonedaForm moneda;
	private String  NumeracionTipo;
	private String  NumeracionPeriodo;
	private String  NumeracionFormato;
	private String  TipoMovimiento;
	private String  PermiteAplicaciones=Constants.UI_NO;
	private String  PermiteImputaciones=Constants.UI_NO;
	private String  PermiteValProp=Constants.UI_NO;
	private String  PermiteIngValTer=Constants.UI_NO;
	private String  PermiteEgrValTer=Constants.UI_NO;
	private String  estado;
	
	
	public AdministracionForm getAdministracion() {
		return administracion;
	}
	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
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
	public MonedaForm getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaForm moneda) {
		this.moneda = moneda;
	}

}
