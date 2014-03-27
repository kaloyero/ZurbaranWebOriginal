package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.DocumentoHeaderBean;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;

public interface TipoDocumentoManager extends ConfigurationManager<TipoDocumento,TipoDocumentoForm>{

       List<TipoDocumentoForm> getListDocumentTypeByAdm(Integer idAdm);

    /** devuelve la ultima numeraci�n establesida para el documento, seg�n el tipo de documento
     * 
     * @param idTipoDocumento
     * @param numTipo
     * @param numPeriodo
     * @param numFormato
     * @return
     */
    String getLastDocNumeration(int idTipoDocumento,String numTipo, String numPeriodo, String numFormato);

   /** Obtiene la informaci�n necesar�a para el header del documento cuando se selecciona un "tipo de Documento"
    * 
     * @param idTipoDocumento
     * @return
     */
    DocumentoHeaderBean getDocumentHeaderByTipodocumento(int idTipoDocumento);
}
