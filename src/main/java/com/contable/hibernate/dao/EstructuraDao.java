package com.contable.hibernate.dao;

import java.util.List;

import com.contable.common.GenericDao;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Estructura;

public interface EstructuraDao extends GenericDao<Estructura, Integer> {

	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha, Integer monedaMostrarId);
}
