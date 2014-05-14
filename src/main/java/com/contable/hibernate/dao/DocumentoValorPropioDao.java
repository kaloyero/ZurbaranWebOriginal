package com.contable.hibernate.dao;

import java.util.Collection;

import com.contable.common.GenericDao;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoValorPropioDao extends GenericDao<DocumentoValorPropio, Integer> {

	
	public void anularValoresPropiosByListIds(Collection<Integer> valorPropId);
}
