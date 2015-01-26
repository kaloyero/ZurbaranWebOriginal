package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.CalculosUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.form.CotizacionForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cotizacion;
import com.contable.manager.CotizacionManager;
import com.contable.manager.MonedaManager;
import com.contable.mappers.CotizacionMapper;
import com.contable.services.CotizacionService;

@Service("cotizacionManager")
public class CotizacionManagerImpl extends ConfigurationManagerImpl<Cotizacion,CotizacionForm> implements CotizacionManager{

	@Autowired
	CotizacionService cotizacionService;

	@Autowired
	MonedaManager monedaManager;

	@Override
	protected AbstractService<Cotizacion> getRelatedService() {
		return cotizacionService;
	}

	@Override
	protected Mapper<Cotizacion,CotizacionForm> getMapper() {
		return new CotizacionMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		list.add(Cotizacion.fieldMoneda());
		list.add(Cotizacion.fieldFecha());
		return list;
	}

	public CotizacionForm getUltimaCotizacion(int monedaId){
		
		
		return getMapper().getForm(cotizacionService.getUltimaCotizacion(monedaId));
	}

	public CotizacionForm getCotizacionByDate(int monedaId, Date fecha){
		return getMapper().getForm(cotizacionService.getCotizacionByDate(monedaId, fecha));
	}

	
	public CotizacionForm getUltimaCotizacionValidacion(int monedaId){
		Cotizacion cotizacion = cotizacionService.getUltimaCotizacion(monedaId); 

		if (cotizacion != null){
			if (cotizacion.getCotizacion() == null){
				/* - valida que si la moneda es local devuelva "0"  */
				cotizacion.setCotizacion(1.00);
			} else if (cotizacion.getMoneda().getMonedaLocal().equals(Constants.BD_ACTIVO)){
				/* - valida que si la cotizacion es null devuelva "1" */
				cotizacion.setCotizacion(0.00);
			}
		}
		return getMapper().getForm(cotizacion);
	}

	@Transactional
	@Override
	public List<CotizacionForm> getLista() {
		List<CotizacionForm> lista = new ArrayList<CotizacionForm>();
		
		List<MonedaForm> monedas = monedaManager.getLista();
		
		for (MonedaForm moneda : monedas) {
			//SI no es moneda local lo agrega a la lista. Y si la moneda esta ACTIVA.
			if (Constants.BD_INACTIVO.equals(moneda.getMonedaLocal()) && Constants.BD_ACTIVO.equals(moneda.getEstado())){
				CotizacionForm cotizacion = getUltimaCotizacion(moneda.getId());
				//le seteo el id de la moneda para que cuando modifique, traiga la moneda
				cotizacion.setId(moneda.getId());
				cotizacion.setMoneda(moneda);
				lista.add(cotizacion);
			}
		}
		
		return lista;
	}
	
	@Transactional
	@Override
	public ErrorRespuestaBean guardarNuevo(CotizacionForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
		getRelatedService().save(getMapper().getEntidad(form));
		
		return res;
	}

	@Transactional
	@Override
	public ErrorRespuestaBean update(CotizacionForm form){
		ErrorRespuestaBean res = new ErrorRespuestaBean(true);
//		//seteo el id en cero para que agregue el campo
//		form.setId(0);
//		//seteo la fecha actual en la que modifico la cotizacion
//		form.setFecha(DateUtil.getStringToday());

		//Guardo la cotizacion con la nueva fecha
		guardarNuevo(form);
		
		return res;
	}

	@Transactional
	@Override
	public CotizacionForm findById(Integer id){
		//Busca la ultima cotizacion para la moneda
		CotizacionForm cotizacion = getUltimaCotizacion(id);
		//Si no me devuelve la cotizacion
		if (cotizacion == null || cotizacion.getId() == 0){
			cotizacion = new CotizacionForm();
			//Toma la moneda
			MonedaForm moneda = monedaManager.findById(id);
			cotizacion.setMoneda(moneda);		
			//setea la fecha actual
			cotizacion.setFecha(DateUtil.getStringToday());
		}
		return cotizacion;
		
		
	}
	
	public List<CotizacionForm> obtenerHistoricoCotizacion (int idMoneda, String fechaIni, String fechaFin){
		List<CotizacionForm> historico = getMapper().getFormList(cotizacionService.obtenerHistorico(idMoneda, fechaIni, fechaFin));
		return historico;
	}

		public Double mostrarCotizacionEnmoneda (int monedaActual, int monedaAConvertir ,Double importe){
		    Double importeRespuesta = 0.0;
			//Pregunto si la moneda que muestro es igual a la que quiero mostrar. 
			if (monedaAConvertir ==  monedaActual){
				importeRespuesta = importe;
			} else{
				//Obtengo la COtizacion A convertir
				CotizacionForm cotForm =getUltimaCotizacion(monedaAConvertir); 
				Double cotizacionAConvertir = cotForm.getCotizacion();
				//Obtengo la COtizacion de la moneda
				Double cotizacionMoneda = getUltimaCotizacionValidacion(monedaActual).getCotizacion();
	
				importeRespuesta = ConvertionUtil.DouValueOf(CalculosUtil.calcularImporteByCOtizacion(importe, cotizacionMoneda, cotizacionAConvertir));
			}
		
		return importeRespuesta; 
	}
}