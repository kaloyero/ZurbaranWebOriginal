package com.contable.services;

import java.util.Collection;
import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumento_v;

public interface TipoDocumentoService extends AbstractService<TipoDocumento>{

	public List<TipoDocumento_v> getLista_v();
	
	public TipoDocumento_v findById_v(Integer id);
	
	public List<TipoDocumento_v> getTipoDocumentosByIdAdm(Integer idAdm);
	
	public void saveConceptos(int tipoDocumento, Collection<Integer> conceptos);
	
	public void updateTipodocumentoconcepto(Collection<Integer> idsConceptos, int idTipoDocumento);
}
