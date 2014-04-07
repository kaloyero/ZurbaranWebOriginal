package com.contable.form;


public class DocumentoMovimientoValorTerceForm extends DocumentoMovimientoForm {
	
	private static final long serialVersionUID = 1L;

	String tipoMovimiento;
	DocumentoValTerceForm valorTerce;
	
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public DocumentoValTerceForm getValorTerce() {
		return valorTerce;
	}
	public void setValorTerce(DocumentoValTerceForm valorTerce) {
		this.valorTerce = valorTerce;
	}
	
	
}
