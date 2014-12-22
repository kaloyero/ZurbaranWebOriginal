package com.contable.common.constants;

public interface Constants {

	/** Este campo se ZERO cero 0 */
	public static final String ZERO = "0.00";

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
	public static final String BD_ACREEDOR = "C";
	
	public static final Integer UI_ADM_VALUE_TODAS = -1;
	
	public static final Integer BD_ADM_VALUE_TODAS = null;
	
	public static final String UI_ADM_CAMPO_TODAS = "TODAS";
	
	public static final String CAMPO_EXTRA_NINGUNO = "< NO AGREGA FILA >";
	
	public static final String CAMPO_EXTRA_NINGUNO2 = "< NINGUNO >";
	
	public static final String CAMPO_EXTRA_TODAS = "< TODAS >";
	
	public static final String CAMPO_EXTRA_BLANCO = "";	
	
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
	public static final String UI_ACREEDOR = "C";
	
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

	public static final String TIPODOCUMENTO_TIPOMOV_DEBITO = "D";
	public static final String TIPODOCUMENTO_TIPOMOV_CREDITO = "C";
	
	public static final String DOCUMENTO_CODMOVIMIENTO_ENCABEZADO = "EN";
	public static final String DOCUMENTO_CODMOVIMIENTO_IMPUTACIONES = "IM";
	public static final String DOCUMENTO_CODMOVIMIENTO_INGRESOVALORES = "IV";
	public static final String DOCUMENTO_CODMOVIMIENTO_EGRESOVALORES = "EV";
	public static final String DOCUMENTO_CODMOVIMIENTO_VALORESPROPIOS = "VP";
	
	public static final String DOCUMENTO_ESTADO_ANULADO = "A";

	/** Campo Permiso_xxx cuando es nulo */
	public static final String CAMPO_PERMISO_NULO = "N";

	/** Campos de numeracion */
	public static final String CAMPO_NUMERACION_TIPO_MANUAL 	  = "M";
	public static final String CAMPO_NUMERACION_TIPO_AUTOMATICA   = "A";
	public static final String CAMPO_NUMERACION_FORMATO_LETRA	  = "L";
	public static final String CAMPO_NUMERACION_FORMATO_NORMAL	  = "N";
	public static final String CAMPO_NUMERACION_PERIODO_GENERAL   = "G";
	public static final String CAMPO_NUMERACION_PERIODO_ENTIDAD   = "E";
	public static final String CAMPO_NUMERACION_PERIODO_HISTORICO = "H";
	public static final String CAMPO_NUMERACION_PERIODO_ANUAL 	  = "A";
	public static final String CAMPO_NUMERACION_PERIODO_MENSUAL   = "M";
	public static final String CAMPO_NUMERACION_PERIODO_DIARIO 	  = "D";
	
	public static final String ESTRUCTURA_AGRUPA 	  			  = "A";
	public static final String ESTRUCTURA_AGRUPA_DESCRIPCION 	  = "Agrupa";	
	public static final String ESTRUCTURA_DETALLA 	  			  = "D";
	public static final String ESTRUCTURA_DETALLA_DESCRIPCION 	  = "Detalla";
	
	public static final String ESTRUCTURA_MOV_SALDO_INICIAL 	  = "INI";
	public static final String ESTRUCTURA_MOV_SALDO_FINAL 	  	  = "FIN";
	public static final String ESTRUCTURA_MOV_SALDO_MOVIMINETO 	  = "MOV";
	public static final String ESTRUCTURA_MOV_SALDO_MTO_APLICADO  = "MVA";

	public static final String CUENTA_RESUMEN_SALDO 	  		  = "SALDO";
	public static final String CUENTA_RESUMEN_SALDO_MONEDA_EN     = "SALDO_MUESTRA_EN";
	
}
