package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.Property;
import com.contable.hibernate.dao.DocumentoAplicacionPendiente_VDao;
import com.contable.hibernate.model.DocumentoAplicacionPendiente_V;

@Repository("documentoAplicacionPendiente_VDao")
public class DocumentoAplicacionPendiente_VDaoImpl extends GenericDaoImpl<DocumentoAplicacionPendiente_V, Integer> implements DocumentoAplicacionPendiente_VDao{

	@Override
	protected Class<DocumentoAplicacionPendiente_V> getEntityClass() {
		return DocumentoAplicacionPendiente_V.class;
	}
	
	@Transactional
	public List<DocumentoAplicacionPendiente_V> getListaDocsAplicationPendiente(Integer cuenta,
			Integer tipoEntidad, Integer entidad, Integer moneda) {

		List<Property> filtros = new ArrayList<Property>();

		/* Filtros */
			filtros.add(new Property(Restrictions.eq("cuentaId", cuenta), Property.OPERATOR_AND));
			filtros.add(new Property(Restrictions.eq("moneda.id", moneda), Property.OPERATOR_AND));
			filtros.add(new Property(Restrictions.eq("tipoEntidadId", tipoEntidad), Property.OPERATOR_AND));
			filtros.add(new Property(Restrictions.eq("entidadId", entidad), Property.OPERATOR_AND));
				
		String orderByField = "numeroLetra,numeroEstablecimiento,numeroAnio,numeroMes,numeroDia,numero";
							  
		List<DocumentoAplicacionPendiente_V> list = this.listFilterByProperties(null, filtros, orderByField, true);
		
		return list;
	}


}
