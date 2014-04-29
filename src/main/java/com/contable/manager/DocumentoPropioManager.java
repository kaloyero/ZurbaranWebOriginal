package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.FiltroValPropiosBean;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoValPropioForm;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoPropioManager extends AbstractManager<DocumentoValorPropio,DocumentoValPropioForm>{

	public List<DocumentoMovimientoValorPropioForm> buscarPorFiltros(FiltroValPropiosBean filtros,String campoOrden,boolean orderByAsc);
	
}
