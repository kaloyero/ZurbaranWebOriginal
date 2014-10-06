package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.hibernate.model.ValorPropio_v;

/**
 * @author kaloye
 *
 */
public interface ValorPropio_VDao extends GenericDao<ValorPropio_v, Integer> {

	public List<ValorPropio_v> buscarEnValoresPropiosByFiltros(FiltroValPropiosBean filtro, String campoOrder, boolean orderByAsc);
	
	
	/**
	 * Retorna un cheque para un id de chequera y un numero de cheque
	 * 
	 * @param chequeraId
	 * @param numero
	 * @return
	 */
	public ValorPropio_v getCheque(int chequeraId, int numero);
	
}
