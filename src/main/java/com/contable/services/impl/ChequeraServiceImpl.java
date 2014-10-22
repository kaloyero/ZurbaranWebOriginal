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
import com.contable.hibernate.dao.ChequeraDao;
import com.contable.hibernate.dao.ChequeraDetalle_VDao;
import com.contable.hibernate.dao.Chequera_VDao;
import com.contable.hibernate.dao.ValorPropio_VDao;
import com.contable.hibernate.model.Chequera;
import com.contable.hibernate.model.ChequeraDetalle_V;
import com.contable.hibernate.model.Chequera_V;
import com.contable.hibernate.model.ValorPropio_v;
import com.contable.services.ChequeraService;

@Service("chequeraService")
public class ChequeraServiceImpl extends AbstractServiceImpl<Chequera> implements ChequeraService{

	@Autowired
    private ChequeraDao chequeraDao;

	@Autowired
    private Chequera_VDao chequera_VDao;

	@Autowired
    private ValorPropio_VDao valorPropio_VDao;

	@Autowired
    private ChequeraDetalle_VDao chequeraDetalle_VDao;

	protected GenericDao<Chequera, Integer> getDao() {
		return chequeraDao;
	}

	public List<Chequera_V> getListaView() {
		List<Chequera_V> list = new ArrayList<Chequera_V>();
		list = chequera_VDao.findAll(false);
		
		return list;
	}

	public Chequera_V findViewById(int id) {
		return chequera_VDao.findById(id);
	}
	
	public List<ChequeraDetalle_V> getListaChequeDetalle(int chequeraId) {
		List<ChequeraDetalle_V> list = new ArrayList<ChequeraDetalle_V>();
		list = chequeraDetalle_VDao.findAllByProperty("chequeraId", chequeraId,false);
		
		return list;
	}

	public Chequera getChequeByCuentaEntidad(int idAdministracion, int cuentaId, int entidadId) {
		
		List<Property> properties = new ArrayList<Property>();
		
		properties.add(new Property(Restrictions.eq("administracion.id", idAdministracion), Property.OPERATOR_AND));
		properties.add(new Property(Restrictions.eq("cuentaId", cuentaId), Property.OPERATOR_AND));
		properties.add(new Property(Restrictions.eq("entidad.id", entidadId), Property.OPERATOR_AND));
		properties.add(new Property(Restrictions.eq("estado", Constants.BD_ACTIVO), Property.OPERATOR_AND));
		
		
		Chequera chequera = chequeraDao.findEntityByPropertyList(properties,false);
		
		return chequera;
	}

	public ValorPropio_v getCheque(int idChequera, int numero) {
		return valorPropio_VDao.getCheque(idChequera, numero);
	}

}
