package com.contable.hibernate.dao;

import java.util.Collection;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.DocumentoValorTerce;

public interface DocumentoValorTerceDao extends GenericDao<DocumentoValorTerce, Integer> {


	public void anularValoresTerceroByListIds(Collection<Integer> valorTerceId);
	
}
