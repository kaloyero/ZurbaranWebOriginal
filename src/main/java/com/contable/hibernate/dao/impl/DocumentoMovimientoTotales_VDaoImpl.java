package com.contable.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericBaseDaoImpl;
import com.contable.common.beans.ConsultasGeneralesBean;
import com.contable.hibernate.dao.DocumentoMovimientoTotales_VDao;
import com.contable.hibernate.model.DocumentoMovimientoTotales_V;

@Repository("documentoMovimientoTotales_VDao")
public class DocumentoMovimientoTotales_VDaoImpl extends GenericBaseDaoImpl<DocumentoMovimientoTotales_V> implements DocumentoMovimientoTotales_VDao{

	@Override
	protected Class<DocumentoMovimientoTotales_V> getEntityClass() {
		return DocumentoMovimientoTotales_V.class;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<ConsultasGeneralesBean> getMovimientosTotales(int documentoId) {
		
		StringBuilder queryStr = new StringBuilder();
		/*SELECT*/
		queryStr.append("SELECT this_.IdDocumento as id, SUM(this_.TotalMovimientoMonedaDoc) as campoDecimal1, this_.CodMovimiento as campoCadena1 ");
		/*FROM*/
		queryStr.append(" FROM documentototalespormovimiento_v this_ ");
		/*WHERE*/
		queryStr.append(" WHERE this_.IdDocumento= '"+ documentoId +"' ");
		/*GROUP BY*/
		queryStr.append(" GROUP BY this_.IdDocumento, this_.CodMovimiento ");

		Query query = getSession().createSQLQuery(queryStr.toString())
				.addScalar("id")
				.addScalar("campoDecimal1",Hibernate.DOUBLE)
				.addScalar("campoCadena1",Hibernate.STRING)
				.setResultTransformer( Transformers.aliasToBean(ConsultasGeneralesBean.class));

		List<ConsultasGeneralesBean> list = query.list();

	    return list;
	    
	}

}
