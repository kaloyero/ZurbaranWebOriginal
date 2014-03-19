package com.contable.form;

import java.util.List;

import com.contable.common.beans.FormConfig;

public class CuentaForm implements FormConfig  {


	private int id;
	private AdministracionForm administracion;
	private TipoEntidadForm tipoEntidad;
	private List<CuentaMonedaForm> monedas;
	private List<Integer> idsMonedas;
	private String codigo; 
	private String nombre;
	private String descripcion;
	private String saldo;
	private String estado;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AdministracionForm getAdministracion() {
		return administracion;
	}
	public void setAdministracion(AdministracionForm administracion) {
		this.administracion = administracion;
	}
	public TipoEntidadForm getTipoEntidad() {
		return tipoEntidad;
	}
	public void setTipoEntidad(TipoEntidadForm tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
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
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<CuentaMonedaForm> getMonedas() {
		return monedas;
	}
	public void setMonedas(List<CuentaMonedaForm> monedas) {
		this.monedas = monedas;
	}
	public List<Integer> getIdsMonedas() {
		return idsMonedas;
	}
	public void setIdsMonedas(List<Integer> idsMonedas) {
		this.idsMonedas = idsMonedas;
	}
	
	
}
