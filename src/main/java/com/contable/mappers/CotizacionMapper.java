package com.contable.mappers;

import com.contable.common.beans.MapperImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.CotizacionForm;
import com.contable.hibernate.model.Cotizacion;

public class CotizacionMapper extends MapperImpl<Cotizacion,CotizacionForm>{


	public Cotizacion getEntidad(CotizacionForm form) {
		Cotizacion ent = new Cotizacion();
		MonedaMapper mapperMnd = new MonedaMapper();
				
		ent.setId(form.getId());
		ent.setMoneda(mapperMnd.getEntidad(form.getMoneda()));
		ent.setFecha(DateUtil.convertStringToDate(form.getFecha()));
		ent.setCotizacion(form.getCotizacion());
		return ent;
	}
	
	public  CotizacionForm getForm(Cotizacion ent) {
		CotizacionForm form=new CotizacionForm();
		MonedaMapper mapperMnd = new MonedaMapper();
		
		form.setId(ent.getId());
		form.setCotizacion(ent.getCotizacion());
		form.setFecha(DateUtil.convertDateToString(ent.getFecha()));
		form.setMoneda(mapperMnd.getForm(ent.getMoneda()));
	
		return form;
	}

}