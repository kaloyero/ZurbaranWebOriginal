package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.DocumentoHeaderBean;
import com.contable.form.TipoDocumentoForm;
import com.contable.hibernate.model.TipoDocumento;

public interface TipoDocumentoManager extends ConfigurationManager<TipoDocumento,TipoDocumentoForm>{

       List<TipoDocumentoForm> getListDocumentTypeByAdm(Integer idAdm);

       String getLastDocNumeration(String numTipo, String numPeriodo, String numFormato);

       DocumentoHeaderBean getDocumentHeaderByTipodocumento(int idTipoDocumento);
}
