package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.Documento_v;

public interface DocumentoService extends AbstractService<Documento>{

	List<Documento_v> getListaView();
	
	public List<Documento> getListaDocsAplication(Integer cuenta,
			Integer tipoEntidad, Integer entidad, Integer moneda, Boolean estadoActivo);
	
}
