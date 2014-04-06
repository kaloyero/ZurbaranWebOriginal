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
	
	/** Campo INACTIVO en el modelo */
	public static final String FIELD_ACTIVE = "estado";

	/** Campo TIPO de VALOR Valores de Terceros */
	public static final String TIPODOCUMENTO_TIPOVALOR_VALTERCE = "T";
	
	/** Campo TIPO de VALOR Valor Propio */
	public static final String TIPODOCUMENTO_TIPOVALOR_VALPROPIO = "P";
	
}
