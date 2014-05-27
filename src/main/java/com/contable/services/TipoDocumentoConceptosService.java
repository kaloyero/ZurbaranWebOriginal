package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.model.TipoDocumentoConcepto;

public interface TipoDocumentoConceptosService extends AbstractService<TipoDocumentoConcepto>{

	public List<ConfigBean> getConceptosByIdTipoDocumento(int tipodocumento);
}
