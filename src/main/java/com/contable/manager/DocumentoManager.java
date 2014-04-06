package com.contable.manager;

import java.util.List;

import com.contable.common.AbstractManager;
import com.contable.common.beans.ConfigBean;
import com.contable.form.DocumentoForm;
import com.contable.hibernate.model.Documento;

public interface DocumentoManager extends AbstractManager<Documento,DocumentoForm>{

	List<ConfigBean> getListaDocAplicaciones(Integer cuenta, Integer tipoEntidad, Integer entidad, Integer moneda );
	
}
