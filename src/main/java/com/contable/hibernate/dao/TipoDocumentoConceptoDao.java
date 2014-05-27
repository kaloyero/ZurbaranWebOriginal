package com.contable.hibernate.dao;

import java.util.Collection;
import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.ConfigBean;
import com.contable.hibernate.model.TipoDocumentoConcepto;

public interface TipoDocumentoConceptoDao extends GenericDao<TipoDocumentoConcepto, Integer> {


	public void update(Collection<Integer> idsConceptos,int idTipoDocumento);
	
	public List<TipoDocumentoConcepto> getConceptosByIdTipodocumento(int idTipoDocumento);
	
	public List<ConfigBean> getConceptosConfigByIdTipodocumento(int idTipoDocumento);
	
}
