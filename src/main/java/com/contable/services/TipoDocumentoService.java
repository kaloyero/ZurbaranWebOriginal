package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.hibernate.model.TipoDocumento_v;

public interface TipoDocumentoService extends AbstractService<TipoDocumento>{

	List<TipoDocumento_v> getListaView();
}
