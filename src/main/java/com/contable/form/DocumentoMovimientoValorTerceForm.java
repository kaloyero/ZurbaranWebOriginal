package com.contable.form;


/**
 * @author kaloye
 *
 */
public class DocumentoMovimientoValorTerceForm extends DocumentoMovimientoForm {
	
	private static final long serialVersionUID = 1L;

	private String tipoMovimientoValorTerce;
	private Integer idMovimiento;
	private DocumentoValTerceForm valorTerce;
	
	public Integer getIdMovimiento() {
		return idMovimiento;
	}
	public void setIdMovimiento(Integer idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public String getTipoMovimientoValorTerce() {
		return tipoMovimientoValorTerce;
	}
	public void setTipoMovimientoValorTerce(String tipoMovimientoValorTerce) {
		this.tipoMovimientoValorTerce = tipoMovimientoValorTerce;
	}
	public DocumentoValTerceForm getValorTerce() {
		return valorTerce;
	}
	public void setValorTerce(DocumentoValTerceForm valorTerce) {
		this.valorTerce = valorTerce;
	}
	
	
}
