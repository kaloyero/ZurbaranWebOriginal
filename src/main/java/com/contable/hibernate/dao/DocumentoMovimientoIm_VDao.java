package com.contable.hibernate.dao;

import java.util.Collection;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;

public interface DocumentoMovimientoIm_VDao extends GenericDao<DocumentoMovimientoIm_V, Integer> {

	public Collection<Integer> buscarPorReferenciaEnDocumentos(String referencia);

}
