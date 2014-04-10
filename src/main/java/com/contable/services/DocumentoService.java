package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;
import com.contable.hibernate.model.Documento_v;

public interface DocumentoService extends AbstractService<Documento>{

	List<Documento_v> getListaView();


}
