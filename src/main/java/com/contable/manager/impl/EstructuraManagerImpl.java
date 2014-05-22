package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.common.utils.FormatUtil;
import com.contable.form.CuentaBusquedaForm;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.Estructura;
import com.contable.hibernate.model.EstructuraContenido;
import com.contable.hibernate.model.EstructuraContenidoCuenta;
import com.contable.manager.EstructuraManager;
import com.contable.mappers.EstructuraMapper;
import com.contable.services.CuentaService;
import com.contable.services.EstructuraContenidoService;
import com.contable.services.EstructuraService;

@Service("estructuraManager")
public class EstructuraManagerImpl extends ConfigurationManagerImpl<Estructura,EstructuraForm> implements EstructuraManager{

	@Autowired
	EstructuraService estructuraService;

	@Autowired
	CuentaService cuentaService;

	@Autowired
	EstructuraContenidoService estructuraContenidoService;

	@Override
	protected AbstractService<Estructura> getRelatedService() {
		return estructuraService;
	}

	@Override
	protected Mapper<Estructura,EstructuraForm> getMapper() {
		return new EstructuraMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
//		list.add(Chequera.fieldMoneda());
//		list.add(Chequera.fieldFecha());
		return list;
	}


	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion){
		String fecha = DateUtil.getStringToday();
		List<EstructuraSaldoForm> saldosEstructura = new ArrayList<EstructuraSaldoForm>();
		
		Estructura estructura = estructuraService.findById(idEstructura);
		
		if (idEstructura <1 || idAdministracion < 1 ){
			return saldosEstructura;
		}
		
		for (EstructuraContenido contenido : estructura.getContenidos()) {
			List<CuentaBusquedaForm> listaSaldos = new ArrayList<CuentaBusquedaForm>();
			for (EstructuraContenidoCuenta conteCuenta : contenido.getCuentas()) {
				//Por cada cuenta consulto y agrego a lista de saldos
				listaSaldos.addAll(getListadoPorContenidoCuenta(fecha, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), conteCuenta.getEntidad().getId(), conteCuenta.getMoneda().getId()));
			}
			if (Constants.ESTRUCTURA_AGRUPA.equals(contenido.getModo())){
				EstructuraSaldoForm form = new EstructuraSaldoForm();
				//Agrupo los saldos
				double saldoAgrupado = 0.0; 
				for (CuentaBusquedaForm saldoCuenta : listaSaldos) {
					saldoAgrupado += ConvertionUtil.DouValueOf(saldoCuenta.getSaldo()) ;
					form.setMonedaCodigo(saldoCuenta.getMonedaCodigo());
					form.setMonedaNombre(saldoCuenta.getMonedaNombre());
				}
				form.setContenidoNombre(contenido.getCodigo());
				form.setSaldo(FormatUtil.format2DecimalsStr(saldoAgrupado));
				
			} else if (Constants.ESTRUCTURA_DETALLA.equals(contenido.getModo())){
				for (CuentaBusquedaForm cuentaBusquedaForm : listaSaldos) {
					saldosEstructura.add( getEstructuraSaldoForm(cuentaBusquedaForm, contenido.getCodigo()));
				}
			}
		}
		
		return saldosEstructura;
		
	}
	
	private EstructuraSaldoForm getEstructuraSaldoForm (CuentaBusquedaForm cuentaForm, String contenidoNombre) {
		EstructuraSaldoForm form = new EstructuraSaldoForm();
		form.setContenidoNombre(contenidoNombre);
		form.setCuentaNombre(cuentaForm.getCuentaNombre());
		form.setEntidadNombre(cuentaForm.getEntidadNombre());
		form.setMonedaNombre(cuentaForm.getMonedaNombre());
		form.setMonedaCodigo(cuentaForm.getMonedaCodigo());
		form.setSaldo(cuentaForm.getSaldo());	
		return form;
		
	}

	private List<CuentaBusquedaForm> getListadoPorContenidoCuenta(String fecha, String modo, int idAdm,int cuenta,Integer entidad, Integer moneda){
		/* LISTA Q VOY A MOSTRAR */
		List<CuentaBusquedaForm> lista =  new ArrayList<CuentaBusquedaForm>();
		
		

		if (StringUtils.isBlank(fecha)){
			//Si no se le pasa la fecha devuelve una lista vacia
			return lista;
		}
		
		FiltroCuentaBean filtros = new FiltroCuentaBean(idAdm, fecha,cuenta, entidad, moneda) ;
		
		/*Seteo la fecha Actual*/
		filtros.setFechaHasta(fecha);

		//Obtengo los movimientos del mes Actual
		List<CuentaBusquedaForm> movimientosMes = cuentaService.buscarSaldoCuentaActualByFiltros(filtros, "", true);
		//List<CuentaSaldo_V> movimientosMes = new ArrayList<CuentaSaldo_V>();

		/*Obtengo los saldos del mes anterior*/
		List<CuentaBusquedaForm> movimientosMesAnterior = cuentaService.buscarSaldoPorFiltros(filtros,"",true);

		
		//Si la lista de movimientos del mes no esta vacía
		if ( ! movimientosMes.isEmpty() ) {
			if ( ! movimientosMesAnterior.isEmpty() ) {
				if (Constants.ESTRUCTURA_DETALLA.equals(modo)){
					//si tengo que Detallar filtro los listados
					lista.addAll(filtroDetalla(movimientosMes, movimientosMesAnterior));
				} else {
					//Si no solamente uno las busquedas
					lista.addAll(movimientosMesAnterior);
				}
			}

			//Agrego los registros de mes actual a la tabla
			lista.addAll(movimientosMes);
		} else {
			//Si esta vacía solo agrego las del mes anterior
			lista = movimientosMesAnterior;
		}

		return lista;
	}
	
	
	private List<CuentaBusquedaForm> filtroDetalla(List<CuentaBusquedaForm> movimientosMes,List<CuentaBusquedaForm> movimientosMesAnterior){
		List<CuentaBusquedaForm> lista =  new ArrayList<CuentaBusquedaForm>();
		
			//itereo la lista de movimientos de mes actual
			for (CuentaBusquedaForm mesAnt : movimientosMesAnterior) {			
				boolean agregar = true;
				//itereo la lista de movimientos de mes actual buscando si alguno pertenece al periodo
				for (CuentaBusquedaForm mesAct : movimientosMes) {
					agregar = detalla(mesAnt, mesAct);
				}
				//Si luego de iterar los movimientos del mes actual, el saldo no esta en la lista lo agrego
				if (agregar){
					//Agrego saldo nuevo
					lista.add(mesAnt);
				}
			}
		return lista;
		
	}

	private boolean detalla(CuentaBusquedaForm mesAnt,CuentaBusquedaForm mesAct){
		boolean agrega = true;
		//Pregunto si todos los campos por los que agrupo son iguales
		if ( (mesAct.getAdministracionId() == null && mesAnt.getAdministracionId() == null) || (mesAct.getAdministracionId().equals(mesAnt.getAdministracionId()))){
			if ( (mesAct.getCuentaId() == null && mesAnt.getCuentaId() == null) || ( mesAct.getCuentaId().equals(mesAnt.getCuentaId()))){
				if ( (mesAct.getTipoEntidadId() == null && mesAnt.getTipoEntidadId() == null) || (mesAct.getTipoEntidadId().equals(mesAnt.getTipoEntidadId()))){
					if ( (mesAct.getEntidadId() == null && mesAnt.getEntidadId() == null) || (mesAct.getEntidadId().equals(mesAnt.getEntidadId()))){
						if ( (mesAct.getMonedaId() == null && mesAnt.getMonedaId() == null) || (mesAct.getMonedaId().equals(mesAnt.getMonedaId()))){	
							//Si esta el saldo, lo actualizo 
							mesAct.setSaldo(FormatUtil.format2DecimalsStr(ConvertionUtil.DouValueOf(mesAct.getSaldo()) + ConvertionUtil.DouValueOf(mesAnt.getSaldo())));
							//existe, NO lo agrego
							agrega = false;				
						}
					}
				}
			}
		}		
		return agrega;
		
	}
}
