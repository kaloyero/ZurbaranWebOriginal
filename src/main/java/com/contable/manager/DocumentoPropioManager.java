package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.form.DocumentoValPropioForm;
import com.contable.form.ValorPropioForm;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoPropioManager extends AbstractManager<DocumentoValorPropio,DocumentoValPropioForm>{

	public List<ValorPropioForm> buscarPorFiltros(FiltroValPropiosBean filtros,String campoOrden,boolean orderByAsc);	

	public void exportExcel(FiltroValPropiosBean filtros);
	
	/**
	 * Chequea si existe unnumero de cheque para esa chequera
	 * devuelve true - si existe
	 * 			false - si no existe
	 * 
	 * @param chequeraId
	 * @param numero
	 * @return
	 */
	public boolean existeCheque(int chequeraId, int numero);
	
	/**
	 * Devuelve el ultimo numero de cheuqeu en la tabla valores propios.
	 * 
	 * @param chequeraId
	 * @return
	 */
	public Integer getUltimoNumeroChequeByChequera(int chequeraId);

}
