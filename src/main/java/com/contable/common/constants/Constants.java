package com.contable.common.constants;

public abstract class Constants {

	/** Este campo se refierea como seguarda el dato SI en la base de datos */
	public static final String BD_SI = "S";
	
	/** Este campo se refierea como seguarda el dato NO en la base de datos */
	public static final String BD_NO = "N";
	
	/** Este campo se refierea como seguarda el dato ACTIVO en la base de datos */
	public static final String BD_ACTIVO = "T";
	
	/** Este campo se refierea como seguarda el dato NO ACTIVO en la base de datos */
	public static final String BD_INACTIVO = "F";

	/** Este campo se refierea como seguarda el dato SALDO DEUDOR en la base de datos */
	public static final String BD_DEUDOR = "D";
	
	/** Este campo se refierea como seguarda el dato SALDO ACREEDOR en la base de datos */
	public static final String BD_ACREEDOR = "A";
	
	public static final int UI_ADM_VALUE_TODAS = -1;
	
	public static final Integer BD_ADM_VALUE_TODAS = null;
	
	public static final String UI_ADM_CAMPO_TODAS = "TODAS";
	
	/** Este campo se refierea como viene el dato SI de la vista(ui) */
	public static final String UI_SI = "S";
	
	/** Este campo se refierea como viene el dato NO de la vista(ui) */
	public static final String UI_NO = "N";

	/** Este campo se refierea como viene el dato ACTIVO de la vista(ui) */
	public static final String UI_ACTIVO = "T";
	
	/** Este campo se refierea como viene el dato NO sACTIVO de la vista(ui) */
	public static final String UI_INACTIVO = "F";

	/** Este campo se refierea como viene el dato SALDO DEUDOR de la vista(ui) */
	public static final String UI_DEUDOR = "D";
	
	/** Este campo se refierea como viene el dato SALDO ACREEDOR de la vista(ui) */
	public static final String UI_ACREEDOR = "A";
	
	/** Campo NOMBRE en el modelo */
	public static final String FIELD_NAME = "nombre";
	
	/** Campo REFERENCIA en el modelo */
	public static final String FIELD_REFERENCIA = "codigo";

	/** Campo INACTIVO en el modelo */
	public static final String FIELD_ESTADO = "estado";
	
	public static final String PERIODO_ABIERTO = "A";
	
	public static final String PERIODO_CERRADO = "C";

	/** Campo TIPO de VALOR Valores de Terceros */
	public static final String TIPODOCUMENTO_TIPOVALOR_NOVALOR = "N";

	/** Campo TIPO de VALOR Valores de Terceros */
	public static final String TIPODOCUMENTO_TIPOVALOR_VALTERCE = "T";
	
	/** Campo TIPO de VALOR Valor Propio */
	public static final String TIPODOCUMENTO_TIPOVALOR_VALPROPIO = "P";
	
	public static final String TIPODOCUMENTO_VALORTERCE_EGRESO = "E";
	public static final String TIPODOCUMENTO_VALORTERCE_INGRESO = "I";

	public static final String DOCUMENTO_CODMOVIMIENTO_ENCABEZADO = "EN";
	public static final String DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES = "IM";
	public static final String DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES = "IV";
	public static final String DOCUMENTO_CODMOVIMIENTO_EGRESOVALOERS = "EV";
	public static final String DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS = "VP";

	/** Campo Permiso_xxx cuando es nulo */
	public static final String CAMPO_PERMISO_NULO = "N";

}
