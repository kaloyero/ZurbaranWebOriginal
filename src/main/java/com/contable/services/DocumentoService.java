package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.common.beans.FiltroDocumentoBean;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.Documento_v;

public interface DocumentoService extends AbstractService<Documento>{

	public List<Documento_v> getListaView();

	public List<Documento_v> buscarPorFiltros(FiltroDocumentoBean filtros,String campoOrden,boolean orderByAsc);

	public Documento_v findViewById(int id);
	
}
