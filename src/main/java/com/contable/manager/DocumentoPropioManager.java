package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.form.DocumentoValPropioForm;
import com.contable.hibernate.model.DocumentoValorPropio;

public interface DocumentoPropioManager extends AbstractManager<DocumentoValorPropio,DocumentoValPropioForm>{

	public List<DocumentoValPropioForm> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc);
	
}
