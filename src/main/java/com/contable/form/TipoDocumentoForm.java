package com.contable.form;

import com.contable.common.beans.FormConfig;

public class TipoDocumentoForm implements FormConfig  {

	private static final long serialVersionUID = -3939874136485777943L;

	private int id;
	private String nombre;
	private Integer administracionId;
	private String administracionNombre;
	private Integer cuentaId;
	private String cuentaNombre;
	private Integer entidadId;
	private String entidadNombre;
	private Integer monedaId;
	private String monedaNombre;
	private String NumeracionTipo;
	private String NumeracionPeriodo;
	private String NumeracionFormato;
	private String TipoMovimiento;
	private String PermiteAplicaciones="N";
	private String PermiteImputaciones="N";
	private String PermiteValProp="N";
	private String PermiteIngValTer="N";
	private String PermiteEgrValTer="N";
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
	public Integer getAdministracionId() {
		return administracionId;
	}
	public void setAdministracionId(Integer administracionId) {
		this.administracionId = administracionId;
	}
	public String getAdministracionNombre() {
		return administracionNombre;
	}
	public void setAdministracionNombre(String administracionNombre) {
		this.administracionNombre = administracionNombre;
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
	public Integer getMonedaId() {
		return monedaId;
	}
	public void setMonedaId(Integer monedaId) {
		this.monedaId = monedaId;
	}
	public String getMonedaNombre() {
		return monedaNombre;
	}
	public void setMonedaNombre(String monedaNombre) {
		this.monedaNombre = monedaNombre;
	}

}
