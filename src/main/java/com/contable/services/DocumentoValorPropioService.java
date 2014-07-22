package com.contable.services;

import java.util.Collection;
import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.DocumentoValorPropio;
import com.contable.hibernate.model.ValorPropio_v;

public interface DocumentoValorPropioService extends AbstractService<DocumentoValorPropio>{
	
	public List<ValorPropio_v> buscarPorFiltros(FiltroValPropiosBean filtros, String campoOrden, boolean orderByAsc);
	
	public void anularValoresPropioByListIds(Collection<Integer> valorPropioId);
	
	/**
	 * Obtiene el ultimo numero para la chequera seleccionada en valores propios. Si no encuentra devuelve NULL
	 * 
	 * @param chequeraId
	 * @return
	 */
	public Integer getUltimoNumeroChequeByChequera(int chequeraId);
}
