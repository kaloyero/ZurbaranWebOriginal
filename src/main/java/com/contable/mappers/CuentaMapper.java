package com.contable.mappers;

import java.util.ArrayList;
import java.util.List;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.DocumentoUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.common.utils.MapperUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.CuentaForm;
import com.contable.hibernate.model.Cuenta;
import com.contable.hibernate.model.CuentaResumen_V;
import com.contable.hibernate.model.CuentaSaldo_V;

public class CuentaMapper extends MapperImpl<Cuenta,CuentaForm>{


	public Cuenta getEntidad(CuentaForm form) {
		Cuenta ent = new Cuenta();
		if (form != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			
			ent.setId(form.getId());
			ent.setNombre(form.getNombre());
			ent.setCodigo(form.getCodigo());
			ent.setDescripcion(form.getDescripcion());
			ent.setTipoSaldo(MapperUtil.getSaldoToEntity(form.getSaldo()));
			ent.setAdministracion(mapperAdm.getEntidad(form.getAdministracion()));
			ent.setTipoEntidad(mapperTpEnt.getEntidad(form.getTipoEntidad()));
			ent.setEstado(MapperUtil.getStatusToEntity(form.getEstado()));
			/* FIN lista de monedas */
			
		}
		return ent;
	}

	public  CuentaForm getForm(Cuenta ent) {
		CuentaForm form=new CuentaForm();
		if (ent != null){
			AdministracionMapper mapperAdm = new AdministracionMapper();
			TipoEntidadMapper mapperTpEnt = new TipoEntidadMapper();
			
			form.setId(ent.getId());
			form.setNombre(ent.getNombre());
			form.setCodigo(ent.getCodigo());
			form.setSaldo(MapperUtil.getSaldoToForm(ent.getTipoSaldo()));
			form.setDescripcion(ent.getDescripcion());
			form.setAdministracion(mapperAdm.getForm(ent.getAdministracion()));
			form.setTipoEntidad(mapperTpEnt.getForm(ent.getTipoEntidad()));
			form.setEstado(MapperUtil.getStatusToForm(ent.getEstado()));
		}
		return form;
	}

	
	public  List<CuentaBusquedaForm> getFormSaldoList(List<CuentaSaldo_V> entList) {
		List<CuentaBusquedaForm> formList=new ArrayList<CuentaBusquedaForm>();
		if (entList != null){
			for (CuentaSaldo_V ent : entList) {
				formList.add(  getForm(ent)  );
			}
		}
		return formList;
	}
	public  List<CuentaBusquedaForm> getFormResumenList(List<CuentaResumen_V> entList) {
		List<CuentaBusquedaForm> formList=new ArrayList<CuentaBusquedaForm>();
		if (entList != null){
			for (CuentaResumen_V ent : entList) {
				formList.add(  getForm(ent)  );
			}
		}
		return formList;
	}
	
	public  CuentaBusquedaForm getForm(CuentaSaldo_V ent) {
		CuentaBusquedaForm form=new CuentaBusquedaForm();
		if (ent != null){
			form.setAdministracionId(ent.getAdministracionId());
			form.setCuentaId(ent.getCuentaId());
			form.setEntidadId(ent.getEntidadId());
			form.setTipoEntidadId(ent.getTipoEntidadId());
			form.setMonedaId(ent.getMonedaId());
			form.setSaldo(FormatUtil.format2DecimalsStr(ent.getSaldoAAMM()));
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setEntidadNombre(ent.getEntidadNombre());
			form.setCuentaNombre(ent.getCuentaNombre());

		}
		return form;
	}
	public  CuentaBusquedaForm getForm(CuentaResumen_V ent) {
		CuentaBusquedaForm form=new CuentaBusquedaForm();
		if (ent != null){
			form.setAdministracionId(ent.getAdministracionId());
			form.setCuentaId(ent.getCuentaId());
			form.setEntidadId(ent.getEntidadId());
			form.setTipoEntidadId(ent.getTipoEntidadId());			
			form.setDocumentoId(ent.getDocumentoId());
			form.setFechaIngreso(DateUtil.convertDateToString(ent.getFechaIngreso()));
			form.setNumeroFormateado(DocumentoUtil.getNumeroFormato(ent.getNumeroLetra(), ent.getNumeroEstablecimiento(), ent.getNumeroAnio(), ent.getNumeroMes(), ent.getNumeroDia(), ent.getNumero()));
			form.setMonedaNombre(ent.getMonedaNombre());
			form.setDebito(FormatUtil.format2DecimalsStr(ent.getDebito()));
			form.setCredito(FormatUtil.format2DecimalsStr(ent.getCredito()));

		}
		return form;
	}

}