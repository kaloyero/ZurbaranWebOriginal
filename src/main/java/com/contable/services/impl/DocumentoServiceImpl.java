package com.contable.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractServiceImpl;
import com.contable.common.GenericDao;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.DocumentoDao;
import com.contable.hibernate.dao.Documento_VDao;
import com.contable.hibernate.model.Documento;
import com.contable.hibernate.model.Documento_v;
import com.contable.services.DocumentoService;

@Service("documentoService")
public class DocumentoServiceImpl extends AbstractServiceImpl<Documento> implements DocumentoService{

	@Autowired
    private DocumentoDao documentoDao;

	@Autowired
    private Documento_VDao documento_VDao;

	
	protected GenericDao<Documento, Integer> getDao() {
		return documentoDao;
	}
	
	public List<Documento_v> getListaView() {
		
		List<Documento_v> list = new ArrayList<Documento_v>();
		list = documento_VDao.findAll(false);
		
		return list;
	}

	public List<Documento> getListaDocsAplication(Integer cuenta,
			Integer tipoEntidad, Integer entidad, Integer moneda, Boolean estadoActivo) {

		List<Property> filtros = new ArrayList<Property>();

		/* Filtros */
		if (cuenta != null)
			filtros.add(new Property(Restrictions.eq("idCuenta", cuenta), Property.OPERATOR_AND));
		if (moneda != null)
			filtros.add(new Property(Restrictions.eq("idMoneda", moneda), Property.OPERATOR_AND));
		if (tipoEntidad != null)
			filtros.add(new Property(Restrictions.eq("idTipoEntidad", tipoEntidad), Property.OPERATOR_AND));
		if (entidad != null)
			filtros.add(new Property(Restrictions.eq("idEntidad", entidad), Property.OPERATOR_AND));
		
		//Valido que el estado
		if (estadoActivo != null){
			if (estadoActivo){
				//Valido que el estado sea Activo
				filtros.add(new Property(Restrictions.eq("estado", Constants.BD_ACTIVO), Property.OPERATOR_AND));
			} else {
				//Valido que el estado sea InActivo
				filtros.add(new Property(Restrictions.eq("estado", Constants.BD_INACTIVO), Property.OPERATOR_AND));
			}
		}
		
		String orderByField = "numeroLetra,numeroEstablecimiento,numeroAnio,numeroMes,numeroDia,numero";
							  
		List<Documento> list = getDao().listFilterByProperties(null, filtros, orderByField, true);
		
		return list;
	}
	

}
