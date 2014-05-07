package com.contable.common.constants;

public abstract class ConstantsErrors {

	/** PERIODO */
	public static final Integer PERIODO_COD_1_COD_ERROR = 1;
	public static final String  PERIODO_COD_1_ERROR = "El periodo seleccionado No existe.";
	
	public static final Integer PERIODO_COD_2_COD_ERROR = 2;
	public static final String  PERIODO_COD_2_ERROR = "El periodo seleccionado se encuentra Inactivo. Si desea activarlo, puede hacerlo desde el panel de configuración.";

	public static final Integer PERIODO_COD_3_COD_ERROR = 3;
	public static final String  PERIODO_COD_3_ERROR = "La fecha Inicial seleccionada no es válida, se encuentra dentro de otro Periodo.";

	public static final Integer PERIODO_COD_4_COD_ERROR = 4;
	public static final String  PERIODO_COD_4_ERROR = "La fecha Final seleccionada no es válida, se encuentra dentro de otro Periodo.";

	/** NUMERO REPETIDO */
	public static final Integer NUMEROREPETIDO_COD_1_COD_ERROR = 2;
	public static final String  NUMEROREPETIDO_COD_1_ERROR = "El numero que ha ingresado existe.";
	
	
	
}
