package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
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


	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha){
		//Si la fecha viene vacía devuelve un listado vacio
		if (StringUtils.isBlank(fecha)){
			return new ArrayList<EstructuraSaldoForm>(); 
		}
		
		List<EstructuraSaldoForm> saldosEstructura = new ArrayList<EstructuraSaldoForm>();
		
		Estructura estructura = estructuraService.findById(idEstructura);
		
		if (idEstructura <1 || idAdministracion < 1 ){
			return saldosEstructura;
		}
		
		for (EstructuraContenido contenido : estructura.getContenidos()) {
			List<CuentaBusquedaForm> listaSaldos = new ArrayList<CuentaBusquedaForm>();
			for (EstructuraContenidoCuenta conteCuenta : contenido.getCuentas()) {
				Integer entidad = null;
				if (conteCuenta.getEntidad() != null)
					entidad = conteCuenta.getEntidad().getId();
				
				//Por cada cuenta consulto y agrego a lista de saldos
				listaSaldos.addAll(getListadoPorContenidoCuenta(fecha, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId()));
			}
			if (Constants.ESTRUCTURA_AGRUPA.equals(contenido.getModo())){
				/* Obtengo saldos */
				HashMap<Integer, EstructuraSaldoForm> saldos = getSaldosAgrupadosPorMonedas(listaSaldos, contenido.getCodigo());
				/*Agrego los Saldos Iniciales al listado que voy a mostrar */ 
				for (Integer key : saldos.keySet()) {
					saldosEstructura.add(saldos.get(key));
				}

				
				
			} else if (Constants.ESTRUCTURA_DETALLA.equals(contenido.getModo())){
				for (CuentaBusquedaForm cuentaBusquedaForm : listaSaldos) {
					saldosEstructura.add( getEstructuraSaldoForm(cuentaBusquedaForm, contenido.getCodigo()));
					
				}
			}
		}
		
		return saldosEstructura;
		
	}

	public List<EstructuraSaldoForm> getEstructuraMovimientosSaldos (int idEstructura, int idAdministracion,String fechaInicial,String fechaFinal){
		/* Inicialiso lista que voy a retornar */
		List<EstructuraSaldoForm> saldosEstructura = new ArrayList<EstructuraSaldoForm>();
		
		/* Obtengo la estructura que voy a mostrar */
		Estructura estructura = estructuraService.findById(idEstructura);
		
		/* VALIDACIONES
		 * Si el numero de estructura o la administración es < a 1
		 * Si ALGUNA fecha viene vacía 
		 * devuelve un listado vacio
		 */
		if (idEstructura <1 || idAdministracion < 1 
				|| StringUtils.isBlank(fechaInicial) || StringUtils.isBlank(fechaFinal)){
			return saldosEstructura;
		}
		
		/* le resto un día a la fecha inicial */
		String fechaSaldoInicial = DateUtil.sumarDias(fechaInicial, -1);
		
		/* Comienza a iterar la estructura */
		for (EstructuraContenido contenido : estructura.getContenidos()) {
			List<CuentaBusquedaForm> listaSaldoInicial = new ArrayList<CuentaBusquedaForm>();
			List<CuentaBusquedaForm> listaSaldoFinal = new ArrayList<CuentaBusquedaForm>();
			List<CuentaBusquedaForm> listaResumen = new ArrayList<CuentaBusquedaForm>();

			for (EstructuraContenidoCuenta conteCuenta : contenido.getCuentas()) {
				Integer entidad = null;
				if (conteCuenta.getEntidad() != null)
					entidad = conteCuenta.getEntidad().getId();
				
				/* Saldos Ini */
				listaSaldoInicial.addAll(getListadoPorContenidoCuenta(fechaSaldoInicial, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId()));
				/* Saldos Fin */
				listaSaldoFinal.addAll(getListadoPorContenidoCuenta(fechaFinal, contenido.getModo(), idAdministracion, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId()));
				
				/* Obtengo Lista de resumen Movimientos*/
				FiltroCuentaBean filtros = new FiltroCuentaBean(idAdministracion, fechaInicial, fechaFinal, conteCuenta.getCuenta().getId(), entidad, conteCuenta.getMoneda().getId());
				listaResumen.addAll(cuentaService.buscarResumenPorFiltros(filtros));
			}
			/* AGRUPA */
			if (Constants.ESTRUCTURA_AGRUPA.equals(contenido.getModo())){
				/* Obtengo saldos Iniciales */
				HashMap<Integer, EstructuraSaldoForm> saldosIni = getSaldosAgrupadosPorMonedas(listaSaldoInicial, contenido.getCodigo());
				/* Obtengo saldos Finales */
				HashMap<Integer, EstructuraSaldoForm> saldosFin = getSaldosAgrupadosPorMonedas(listaSaldoFinal, contenido.getCodigo());

				/*Agrego los Saldos Iniciales al listado que voy a mostrar con los movimientos */ 
				for (Integer key : saldosIni.keySet()) {
					/* Agrego saldo Inicial */
					saldosEstructura.add(saldosIni.get(key));
					/* obtengo los movimientos por saldos*/
					for (CuentaBusquedaForm mov : listaResumen) {
						if (key.equals(mov.getMonedaId())) {
							EstructuraSaldoForm form = new EstructuraSaldoForm();
							form.setCodigo("MOV");
							form.setMonedaCodigo(mov.getMonedaCodigo());
							form.setMonedaNombre(mov.getMonedaNombre());
							form.setDebito(mov.getDebito());
							form.setCredito(mov.getCredito());
							saldosEstructura.add(form);
						}
					}
					/* Agrego saldo Final */
					saldosEstructura.add(saldosFin.get(key));
				}
				
			/* DETALLA */
			} else if (Constants.ESTRUCTURA_DETALLA.equals(contenido.getModo())){
				HashMap<String, EstructuraSaldoForm> saldosFin = new HashMap<String, EstructuraSaldoForm>();
				/* Saldo Final */
				for (CuentaBusquedaForm saldo : listaSaldoFinal) {
					String clave = saldo.getCuentaId()+ "-" + saldo.getEntidadId();
					saldosFin.put(clave, getEstructuraSaldoForm(saldo, contenido.getCodigo()));
				}
				
				/* Saldo Inicial */
				for (CuentaBusquedaForm saldo : listaSaldoInicial) {
					saldosEstructura.add( getEstructuraSaldoForm(saldo, contenido.getCodigo()));
					for (CuentaBusquedaForm mov : listaResumen) {
						//selecciona el resumen por cuenta y entidad
						if (mov.getCuentaId().equals(saldo.getCuentaId())){
							if ( ( (mov.getEntidadId() == null ||  mov.getEntidadId() < 1) && (saldo.getEntidadId() == null ||  saldo.getEntidadId() < 1) )
									|| mov.getEntidadId().equals(saldo.getEntidadId())){
								EstructuraSaldoForm form = new EstructuraSaldoForm();
								form.setCodigo("MOV");
								form.setMonedaCodigo(mov.getMonedaCodigo());
								form.setMonedaNombre(mov.getMonedaNombre());
								form.setDebito(mov.getDebito());
								form.setCredito(mov.getCredito());
								saldosEstructura.add(form);		
							}
						}
					}
					String clave = saldo.getCuentaId()+ "-" + saldo.getEntidadId();
					saldosEstructura.add(saldosFin.get(clave));
					
				}

			}
		}
		
		return saldosEstructura;
		
	}
	
	private HashMap<Integer, EstructuraSaldoForm> getSaldosAgrupadosPorMonedas(List<CuentaBusquedaForm> listaSaldo, String nombreContenido) {
		HashMap<Integer, EstructuraSaldoForm> saldos = new HashMap<Integer, EstructuraSaldoForm>();
		for (CuentaBusquedaForm saldoCuenta : listaSaldo) {
			if (saldos.containsKey(saldoCuenta.getMonedaId())){
				//Summo el nuevo saldo al que tengo guardado el saldosIni
				Double nuevoSaldo = ConvertionUtil.DouValueOf(saldos.get(saldoCuenta.getMonedaId()).getSaldo())  + ConvertionUtil.DouValueOf(saldoCuenta.getSaldo()); 
				//Actualizo el nuevo saldo
				saldos.get(saldoCuenta.getMonedaId()).setSaldo(FormatUtil.format2DecimalsStr(nuevoSaldo));
			} else {
				//Creo un nuevo Saldo para esa moneda
				EstructuraSaldoForm form = new EstructuraSaldoForm();
				form.setCodigo("SAI");
				form.setMonedaCodigo(saldoCuenta.getMonedaCodigo());
				form.setMonedaNombre(saldoCuenta.getMonedaNombre());
				form.setContenidoNombre(nombreContenido);
				form.setSaldo(FormatUtil.format2DecimalsStr(saldoCuenta.getSaldo()));
				saldos.put(saldoCuenta.getMonedaId(), form);
			}
		}
		
		return saldos;
	}
	
	
	private EstructuraSaldoForm getEstructuraSaldoForm (CuentaBusquedaForm cuentaForm, String contenidoNombre) {
		EstructuraSaldoForm form = new EstructuraSaldoForm();
		form.setContenidoNombre(contenidoNombre);
		form.setCodigo("SAL");
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
		
		//Obtengo los movimientos del mes Actual
		List<CuentaBusquedaForm> movimientosMes = cuentaService.buscarSaldoCuentaActualByFiltros(filtros,fecha, "", true);
		//List<CuentaSaldo_V> movimientosMes = new ArrayList<CuentaSaldo_V>();

		/*Obtengo los saldos del mes anterior*/
		List<CuentaBusquedaForm> movimientosMesAnterior = cuentaService.buscarSaldoPorFiltros(filtros,fecha,"",true);

		//Si la lista de movimientos del mes no esta vacía
		if ( ! movimientosMes.isEmpty() ) {
			if ( ! movimientosMesAnterior.isEmpty() ) {
				if (Constants.ESTRUCTURA_DETALLA.equals(modo)){
					//si tengo que Detallar filtro los listados. Modifico movimientosMes 
					filtroDetalla(movimientosMes, movimientosMesAnterior);
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
	
	
	private void filtroDetalla(List<CuentaBusquedaForm> movimientosMes,List<CuentaBusquedaForm> movimientosMesAnterior){
		
			//itereo la lista de movimientos de mes actual
			for (CuentaBusquedaForm mesAnt : movimientosMesAnterior) {			
				boolean agregar = true;
				//itereo la lista de movimientos de mes actual buscando si alguno pertenece al periodo
				for (CuentaBusquedaForm mesAct : movimientosMes) {
					//Pregunto si todos los campos por los que agrupo son iguales
					if ( (mesAct.getAdministracionId() == null && mesAnt.getAdministracionId() == null) || (mesAct.getAdministracionId().equals(mesAnt.getAdministracionId()))){
						if ( (mesAct.getCuentaId() == null && mesAnt.getCuentaId() == null) || ( mesAct.getCuentaId().equals(mesAnt.getCuentaId()))){
							if ( (mesAct.getTipoEntidadId() == null && mesAnt.getTipoEntidadId() == null) || (mesAct.getTipoEntidadId().equals(mesAnt.getTipoEntidadId()))){
								if ( (mesAct.getEntidadId() == null && mesAnt.getEntidadId() == null) || (mesAct.getEntidadId().equals(mesAnt.getEntidadId()))){
									if ( (mesAct.getMonedaId() == null && mesAnt.getMonedaId() == null) || (mesAct.getMonedaId().equals(mesAnt.getMonedaId()))){	
										//Si esta el saldo, lo actualizo 
										mesAct.setSaldo(FormatUtil.format2DecimalsStr(ConvertionUtil.DouValueOf(mesAct.getSaldo()) + ConvertionUtil.DouValueOf(mesAnt.getSaldo())));
										//existe, NO lo agrego
										agregar = false;				
									}
								}
							}
						}
					}		
				}
				//Si luego de iterar los movimientos del mes actual, el saldo no esta en la lista lo agrego
				if (agregar){
					//Agrego saldo nuevo
					movimientosMes.add(mesAnt);
				}
			}
		
	}

}
