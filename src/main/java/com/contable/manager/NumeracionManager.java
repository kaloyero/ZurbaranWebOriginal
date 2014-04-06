package com.contable.manager;

import com.contable.common.ConfigurationManager;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;

public interface NumeracionManager extends ConfigurationManager<Numeracion,NumeracionForm>{

    /** devuelve la ultima numeraci�n establesida para el documento, seg�n el tipo de documento
     * 
     * @param idTipoDocumento
     * @param numTipo
     * @param numPeriodo
     * @param numFormato
     * @return
     */
    String getLastDocNumeration(int idTipoDocumento,String numTipo, String numPeriodo, String numFormato);

}
