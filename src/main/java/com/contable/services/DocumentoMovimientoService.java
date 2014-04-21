package com.contable.services;

import java.util.List;

import com.contable.common.AbstractService;
import com.contable.hibernate.model.DocumentoMovimiento;
import com.contable.hibernate.model.DocumentoMovimientoEv_V;
import com.contable.hibernate.model.DocumentoMovimientoIm_V;
import com.contable.hibernate.model.DocumentoMovimientoIv_V;
import com.contable.hibernate.model.DocumentoMovimientoVp_V;

public interface DocumentoMovimientoService extends AbstractService<DocumentoMovimiento>{

	public List<DocumentoMovimientoIm_V> getMovimientosImputacionByIdDoc(Integer documentoId);

	public List<DocumentoMovimientoVp_V> getMovimientosValorPropioByIdDoc(Integer documentoId);

	public List<DocumentoMovimientoIv_V> getMovimientosIngreValorByIdDoc(Integer documentoId);

	public List<DocumentoMovimientoEv_V> getMovimientosEgreValorByIdDoc(Integer documentoId);
	
}
