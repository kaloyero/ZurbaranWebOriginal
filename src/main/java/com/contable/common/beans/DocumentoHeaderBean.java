package com.contable.common.beans;

import java.io.Serializable;
import java.util.List;

import com.contable.form.CuentaForm;
import com.contable.form.DocumentoValTerceForm;
import com.contable.form.MonedaForm;
import com.contable.form.TipoDocumentoForm;

public class DocumentoHeaderBean implements Serializable {

	private static final long serialVersionUID = -3939874136485777943L;

	private  CuentaForm  cuenta ;
	private  TipoDocumentoForm tipoDocumento ;
	private  String numeracion;
	private  List<MonedaForm> monedas;
	private  List<ConfigBean> entidades;
	
	private  List<ConfigBean> conceptoImp;
	private  List<ConfigBean> conceptoIngValTer;
	private  List<ConfigBean> conceptoValProp;
	private  List<ConfigBean> docsAplicaciones;
	private  List<DocumentoValTerceForm> docsValTerce;
	
	
	public List<DocumentoValTerceForm> getDocsValTerce() {
		return docsValTerce;
	}
	public void setDocsValTerce(List<DocumentoValTerceForm> docsValTerce) {
		this.docsValTerce = docsValTerce;
	}
	public List<ConfigBean> getDocsAplicaciones() {
		return docsAplicaciones;
	}
	public void setDocsAplicaciones(List<ConfigBean> docsAplicaciones) {
		this.docsAplicaciones = docsAplicaciones;
	}
	public CuentaForm getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaForm cuenta) {
		this.cuenta = cuenta;
	}
	public TipoDocumentoForm getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoForm tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}
	public List<MonedaForm> getMonedas() {
		return monedas;
	}
	public void setMonedas(List<MonedaForm> monedas) {
		this.monedas = monedas;
	}
	public List<ConfigBean> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<ConfigBean> entidades) {
		this.entidades = entidades;
	}
	public List<ConfigBean> getConceptoImp() {
		return conceptoImp;
	}
	public void setConceptoImp(List<ConfigBean> conceptoImp) {
		this.conceptoImp = conceptoImp;
	}
	public List<ConfigBean> getConceptoIngValTer() {
		return conceptoIngValTer;
	}
	public void setConceptoIngValTer(List<ConfigBean> conceptoIngValTer) {
		this.conceptoIngValTer = conceptoIngValTer;
	}
	public List<ConfigBean> getConceptoValProp() {
		return conceptoValProp;
	}
	public void setConceptoValProp(List<ConfigBean> conceptoValProp) {
		this.conceptoValProp = conceptoValProp;
	}
	
}
