package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.MapperUtil;
import com.contable.form.CuentaForm;
import com.contable.form.CuentaMonedaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaMoneda;

public class CuentaMapper extends MapperImpl<Cuenta,CuentaForm>{


	public Cuenta getEntidad(CuentaForm form) {
		Cuenta ent = new Cuenta();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setCodigo(form.getCodigo());
			ent.setDescripcion(form.getDescripcion());
			ent.setTipoSaldo(form.getSaldo());
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setTipoEntidad(mapperTpEnt.getEntidad(form.getTipoEntidad()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			/* Guarda la lista de monedas */
			List<CuentaMoneda> monedas = new ArrayList<CuentaMoneda>();
			if (form.getMonedas() != null){
				for (CuentaMonedaForm item: form.getMonedas()) {
					CuentaMoneda moneda = new CuentaMoneda();
					moneda.setId(item.getId());
					moneda.setMoneda(mapperMon.getEntidad(item.getMoneda()));
					if (StringUtils.isNotBlank(item.getIdCuenta())){
						moneda.setIdCuenta(Integer.valueOf(item.getIdCuenta()));
					}
					monedas.add(moneda);
				}
			}
			ent.setMonedas(monedas);
			/* FIN lista de monedas */
			
		}
		return ent;
	}

	public  CuentaForm getForm(Cuenta ent) {
		CuentaForm form=new CuentaForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			MonedaMapper mapperMon = new MonedaMapper();
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setCodigo(ent.getCodigo());
			form.setSaldo(ent.getTipoSaldo());
			form.setDescripcion(ent.getDescripcion());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setTipoEntidad(mapperTpEnt.getForm(ent.getTipoEntidad()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
			/* Guarda la lista de monedas */
			List<CuentaMonedaForm> monedas = new ArrayList<CuentaMonedaForm>();
				if (ent.getMonedas() != null){
				for (CuentaMoneda item: ent.getMonedas()) {
					CuentaMonedaForm moneda = new CuentaMonedaForm();
					moneda.setId(item.getId());
					moneda.setMoneda(mapperMon.getForm(item.getMoneda()));
					moneda.setIdCuenta(String.valueOf(item.getIdCuenta()));
				}
			}
			form.setMonedas(monedas);
			/* FIN lista de monedas */
			
		}
		return form;
	}


}