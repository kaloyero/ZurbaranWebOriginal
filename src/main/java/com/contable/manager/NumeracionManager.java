package com.contable.manager;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.NumeroBean;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionManager extends ConfigurationManager<Numeracion,NumeracionForm>{

    /** devuelve la ultima numeración establesida para el documento, según el tipo de documento
     * 
     * @param idTipoDocumento
     * @param numTipo
     * @param numPeriodo
     * @param numFormato
     * @return
     */
	public NumeroBean getLastDocNumeration(int idTipoDocumento, String fechaIngreso);

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
}
