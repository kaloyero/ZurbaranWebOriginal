package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericBaseDao;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.model.DocumentoMovimientoTotales_V;

public interface DocumentoMovimientoTotales_VDao extends GenericBaseDao<DocumentoMovimientoTotales_V> {

	public List<ConsultasGeneralesBean> getMovimientosTotales(int documentoId);

}
