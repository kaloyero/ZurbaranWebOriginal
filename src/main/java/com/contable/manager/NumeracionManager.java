package com.contable.manager;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.NumeroBean;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionManager extends AbstractManager<Numeracion,NumeracionForm>{

    /** devuelve la ultima numeración establecida para el documento, según el tipo de documento
     * 
     * (*) En el caso de que la ADMINISTRACION no sea enviada devolvera todos los campos en NULL
     * (*) En el caso de que el TIPO DE DOCUMENTO no sea enviado devolvera todos los campos en NULL
     * (*) En el caso de que el TIPO del Documento sea MANUAL devueve el siguiente Formato:
     * 		- NULL para los campos que no deben aparecer
     * 		- "" para los campos que se deben completar.
     * (*) En el caso de que el tipo de Documento sea AUTOMATICO devueve el siguiente Formato:
     * 		- NULL para los campos que no deben aparecer
     * 		- "" para los campos que se deben completar.
     * 		- XXX para los campos que tienen algún valor
     * 		- En el caso de que no se envíe la fecha devolvera todos los campos en NULL
	 *		- En el caso de que el FORMATO requiera Letra + Establecimiento y estos no se envién devolvera los campos Letra y Establecimiento "" y "" respectivamente, dejando el resto de los campos en NULL.
	 *		- En el caso de que el PERIODO requiera la fecha y esta no se envié devolvera todos los campos en NULL. 
     * 
	 * @param idAdministracion
	 * @param idTipoDocumento
	 * @param fechaIngreso
	 * @param letra
	 * @param establecimiento
	 * @return
	 */
	public NumeroBean getLastDocNumeration(int idAdministracion, int idTipoDocumento, String fechaIngreso, String letra, Integer establecimiento);

	/**
	 * Valida el numero que se ingresa no este repetido
	 * 
	 * @param idAdministracion
	 * @param idTipoDocumento
	 * @param idEntidad
	 * @param numero
	 * @param letra
	 * @param establesimiento
	 * @return
	 */
	public ErrorRespuestaBean validarNumeroNoRepetido(Integer idAdministracion, Integer idTipoDocumento,Integer idEntidad, String numero, String letra, String establesimiento);
	
	public ErrorRespuestaBean validarNumeroNoRepetido(Integer idAdministracion, Integer idTipoDocumento,Integer idEntidad, NumeroBean num);
	
	public void actualizarNumeracion(Integer idAdministracion, Integer idTipoDocumento, NumeroBean num);
	
}
