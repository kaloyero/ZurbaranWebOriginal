package com.contable.common.constants;

public interface ConstantsErrors {

	/** PERIODO */
	public static final Integer PERIODO_COD_1_COD_ERROR = 1;
	public static final String  PERIODO_COD_1_ERROR = "El periodo seleccionado No existe.";
	
	public static final Integer PERIODO_COD_2_COD_ERROR = 2;
	public static final String  PERIODO_COD_2_ERROR = "El periodo seleccionado se encuentra Inactivo. Si desea activarlo, puede hacerlo desde el panel de configuraci�n.";

	public static final Integer PERIODO_COD_3_COD_ERROR = 3;
	public static final String  PERIODO_COD_3_ERROR = "La fecha Inicial seleccionada no es v�lida, se encuentra dentro de otro Periodo.";

	public static final Integer PERIODO_COD_4_COD_ERROR = 4;
	public static final String  PERIODO_COD_4_ERROR = "La fecha Final seleccionada no es v�lida, se encuentra dentro de otro Periodo.";

	/** NUMERO REPETIDO */
	public static final Integer NUMEROREPETIDO_COD_1_COD_ERROR = 5;
	public static final String  NUMEROREPETIDO_COD_1_ERROR = "El numero que ha ingresado existe.";
	
	/** ANuLAR / NO SE PueDE ANULAR */
	public static final Integer ANULAR_COD_1_COD_ERROR = 6;
	public static final String  ANULAR_COD_1_ERROR = "El documento que intenta eliminar es aplicado por otro/s documento/s.";
	
	/** ELIMINAR / NO SE PueDE ELIMiNAR */
	public static final Integer ELIMINAR_COD_1_COD_ERROR = 6;
	public static final String  ELIMINAR_COD_1_ERROR = "No se puede Eliminar la entidad seleccionada.";
	public static final Integer ELIMINAR_COD_2_COD_ERROR = 7;
	public static final String  ELIMINAR_COD_2_ERROR = "No se puede Eliminar el documento seleccionado. El tipo de documento es automatico. Debe anular este documento.";

	/** CHEQUERA / VALIDACION */
	public static final Integer CHEQUERA_COD_1_COD_ERROR = 8;
	public static final String  CHEQUERA_COD_1_ERROR = "El numero de Cheque se encuentra en uso.";
	public static final Integer CHEQUERA_COD_2_COD_ERROR = 9;
	public static final String  CHEQUERA_COD_2_ERROR = "El numero de Cheque se encuentra No Disponible.";
	public static final Integer CHEQUERA_COD_3_COD_ERROR = 10;
	public static final String  CHEQUERA_COD_3_ERROR = "El n�mero de cheque seleccionado esta fuera del rango que permite la chequera";
	public static final Integer CHEQUERA_COD_4_COD_ERROR = 11;
	public static final String  CHEQUERA_COD_4_ERROR = "La chequera seleccionada se encuentra fuera de uso o no existe.";

	/** DOCUMENTO NUEVO / VALIDACION */
	public static final Integer DOCUMENTO_COD_1_COD_ERROR = 12;
	public static final String  DOCUMENTO_COD_1_ERROR = "El documento no contiene Movimientos.";
	public static final Integer DOCUMENTO_COD_2_COD_ERROR = 13;
	public static final String  DOCUMENTO_COD_2_ERROR = "La fecha de Ingreso no puede ser mayor a la Fecha actual.";
	public static final Integer DOCUMENTO_COD_3_COD_ERROR = 14;
	public static final String  DOCUMENTO_COD_3_ERROR = "La fecha de Ingreso no puede ser menor a la fecha real.";
	public static final Integer DOCUMENTO_COD_4_COD_ERROR = 15;
	public static final String  DOCUMENTO_COD_4_ERROR = "La fecha de Vencimiento no puede ser menor a la fecha de ingreso.";


	/** MONEDA / VALIDACION */
	public static final Integer MONEDA_COD_1_COD_ERROR = 16;
	public static final String  MONEDA_COD_1_ERROR = "El codigo ingresado existe.";

	/** CONCEPTO / VALIDACION */
	public static final Integer CONCEPTO_COD_1_COD_ERROR = 17;
	public static final String  CONCEPTO_COD_1_ERROR = "El codigo ingresado existe.";

}
