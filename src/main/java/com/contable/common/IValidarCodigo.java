package com.contable.common;

public interface IValidarCodigo {

	/**
	 * Valida que el campo "codigo" no este repetido
	 * 
	 * @param codigo
	 * @return True si el codigo es Repetido. False si el codigo no es repetido
	 */
	public boolean validarCodigoRepetido (String codigo); 

}