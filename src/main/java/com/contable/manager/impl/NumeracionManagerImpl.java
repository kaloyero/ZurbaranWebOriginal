package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.DateUtil;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;
import com.contable.manager.NumeracionManager;
import com.contable.mappers.NumeracionMapper;
import com.contable.services.NumeracionService;

@Service("numeracionManager")
public class NumeracionManagerImpl extends ConfigurationManagerImpl<Numeracion,NumeracionForm> implements NumeracionManager{

	@Autowired
	NumeracionService numeracionService;
	
	@Override
	protected AbstractService<Numeracion> getRelatedService() {
		return numeracionService;
	}

	@Override
	protected Mapper<Numeracion,NumeracionForm> getMapper() {
		return new NumeracionMapper();
	}

	@Override
	protected List<Property> getFilterFields() {
		List<Property> list = new ArrayList<Property>(); 
		return list;
	}

	public String getLastDocNumeration(int idTipoDocumento, String fechaIngreso) {
		String numeroLetra = "";
		String numeroEstablecimiento = "";
		String numeroAnio = "";
		String numeroMes = "";
		String numeroDia = "";
		String numero= "";
		
		//averiguar estos datos por el tipoDeDocumento
//		Integer idAdministracion = ;
		String numTipo = "";
		String numPeriodo = "";
		String numFormato = "";
		Date fecha = DateUtil.convertStringToDate(fechaIngreso);
		
		
		if (Constants.CAMPO_NUMERACION_TIPO_MANUAL.equals(numTipo) ){
			if (Constants.CAMPO_NUMERACION_PERIODO_GENERAL.equals(numPeriodo) ){
				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato)){
					//Se debe INGRESAR el NUMERO
//					setDocumentoNumeracion(null,null,null,null,null,"");
				} else if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato)){
					//Se debe INGRESAR la LETRA, ESTABLECIMIENTO y el NUMERO
//					setDocumentoNumeracion("","",null,null,null,"");
				}
			} else 	if (Constants.CAMPO_NUMERACION_PERIODO_ENTIDAD.equals(numPeriodo) ){
				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato) ){
					//Se debe INGRESAR el NUMERO
//					setDocumentoNumeracion(null,null,null,null,null,"");
				} else 	if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato) ){
					//Se debe INGRESAR la LETRA, ESTABLECIMIENTO y el NUMERO
//					setDocumentoNumeracion("","",null,null,null,"");

				}
			}
		} else if (Constants.CAMPO_NUMERACION_TIPO_AUTOMATICA.equals(numTipo) ){
		//TIPO de NUMERACION es AUTOMATICA ("A")
			//Calendar fecha = Calendar.getInstance();
//			String dia = Integer.toString(fecha.get(Calendar.DATE));
//			String mes = Integer.toString(fecha.get(Calendar.MONTH));
//			String anio = Integer.toString(fecha.get(Calendar.YEAR));
				if (Constants.CAMPO_NUMERACION_PERIODO_HISTORICO.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion y idTipoDocumento
					 * Devuelvo ultimo numero + 1
					 */
					int ultimoNumero = 0;
//					setDocumentoNumeracion("","",null,null,null,String.valueOf(ultimoNumero));
				} else if (Constants.CAMPO_NUMERACION_PERIODO_ANUAL.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion ,idTipoDocumento, ano
					 * Devuelvo ultimo numero + 1
					 */
//					String anoActual = 2014;
					int ultimoNumero = 0;
//					setDocumentoNumeracion(null,null,anoActual,null,null,String.valueOf(ultimoNumero));
				} else if (Constants.CAMPO_NUMERACION_PERIODO_MENSUAL.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion ,idTipoDocumento, ano , mes
					 * Devuelvo ultimo numero + 1
					 */
					int anoActual = 2014;
					int mesActual = 5;
					int ultimoNumero = 0;
 
//					setDocumentoNumeracion(null,null,anoActual,mesActual,null,String.valueOf(ultimoNumero));
				} else if (Constants.CAMPO_NUMERACION_PERIODO_DIARIO.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion ,idTipoDocumento, ano , mes y dia
					 * Devuelvo ultimo numero + 1
					 */
//					String anoActual = 2014;
//					String mesActual = 5;
//					int diaActual = 5;
//					int ultimoNumero = 0;
// 
//					setDocumentoNumeracion(null,null,null,mes,null,String.valueOf(ultimoNumero));

				}
		}
		return numFormato;
	}

	private String setDocumentoNumeracion(String numLetra, String numEstablecimiento, String numAnio, String numMes, String numDia, String num){
		String numeroLetra = numLetra;
		String numeroEstablecimiento = numEstablecimiento;
		String numeroAnio = numAnio;
		String numeroMes = numMes;
		String numeroDia = numDia;
		String numero= num;
		
		return "hola";
	}


//	public ErrorRespuestaBean validarNumeroNoRepetido(Integer idAdministracion, Integer idTipoDocumento,Integer idEntidad, String numero, String letra, String establesimiento) {

//		if (Constants.CAMPO_NUMERACION_TIPO_MANUAL.equals(numTipo) ){
//			if (Constants.CAMPO_NUMERACION_PERIODO_GENERAL.equals(numPeriodo) ){
//				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato)){
//					//VALIDO el numero
//					setDocumentoNumeracion(null,null,null,null,null,"");
//				} else if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato)){
//					//VALIDO la LETRA, ESTABLECIMIENTO y el NUMERO
//					setDocumentoNumeracion("","",null,null,null,"");
//				}
//			} else 	if (Constants.CAMPO_NUMERACION_PERIODO_ENTIDAD.equals(numPeriodo) ){
//				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato) ){
//					//VALIDO el NUMERO , el tipo de Entidad y la entidad
//					setDocumentoNumeracion(null,null,null,null,null,"");
//				} else 	if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato) ){
//					//VALIDO la LETRA, ESTABLECIMIENTO, el NUMERO  , el tipo de Entidad y la entidad
//					setDocumentoNumeracion("","",null,null,null,"");
//	
//				}
//			}
//		}
		
		
//	}

}