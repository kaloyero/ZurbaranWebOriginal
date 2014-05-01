
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
import com.contable.common.beans.NumeroBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.DateUtil;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.manager.NumeracionManager;
import com.contable.mappers.NumeracionMapper;
import com.contable.services.NumeracionService;
import com.contable.services.TipoDocumentoService;

@Service("numeracionManager")
public class NumeracionManagerImpl extends ConfigurationManagerImpl<Numeracion,NumeracionForm> implements NumeracionManager{

	@Autowired
	NumeracionService numeracionService;

	@Autowired
	TipoDocumentoService tipoDocumentoService;

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

	public NumeroBean getLastDocNumeration(int idAdministracion, int idTipoDocumento, String fechaIngreso) {
		NumeroBean numero = new NumeroBean();
		
		//averiguar estos datos por el tipoDeDocumento
		TipoDocumento tipoDoc = tipoDocumentoService.findById(idTipoDocumento);

		String numTipo = tipoDoc.getNumeracionTipo();
		String numPeriodo = tipoDoc.getNumeracionPeriodo();
		String numFormato = tipoDoc.getNumeracionFormato();
		
		Date fecha = DateUtil.convertStringToDate(fechaIngreso);
		
		if (Constants.CAMPO_NUMERACION_TIPO_MANUAL.equals(numTipo) ){
			if (Constants.CAMPO_NUMERACION_PERIODO_GENERAL.equals(numPeriodo) ){
				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato)){
					//Se debe INGRESAR el NUMERO
					numero = setDocumentoNumeracion(null,null,null,null,null,"");
				} else if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato)){
					//Se debe INGRESAR la LETRA, ESTABLECIMIENTO y el NUMERO
					numero = setDocumentoNumeracion("","",null,null,null,"");
				}
			} else 	if (Constants.CAMPO_NUMERACION_PERIODO_ENTIDAD.equals(numPeriodo) ){
				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato) ){
					//Se debe INGRESAR el NUMERO
					numero = setDocumentoNumeracion(null,null,null,null,null,"");
				} else 	if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato) ){
					//Se debe INGRESAR la LETRA, ESTABLECIMIENTO y el NUMERO
					numero = setDocumentoNumeracion("","",null,null,null,"");

				}
			}
		} else if (Constants.CAMPO_NUMERACION_TIPO_AUTOMATICA.equals(numTipo) ){
		//TIPO de NUMERACION es AUTOMATICA ("A")
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			String dia = Integer.toString(calendar.get(Calendar.DATE));
			String mes = Integer.toString(calendar.get(Calendar.MONTH));
			String anio = Integer.toString(calendar.get(Calendar.YEAR));
				if (Constants.CAMPO_NUMERACION_PERIODO_HISTORICO.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion y idTipoDocumento
					 * Devuelvo ultimo numero + 1
					 */
					int ultimoNumero = numeracionService.getUltimoNumero(idAdministracion,idTipoDocumento, null, null, null);
					numero = setDocumentoNumeracion("","",null,null,null,String.valueOf(ultimoNumero));
				} else if (Constants.CAMPO_NUMERACION_PERIODO_ANUAL.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion ,idTipoDocumento, ano
					 * Devuelvo ultimo numero + 1
					 */
					int ultimoNumero = numeracionService.getUltimoNumero(idAdministracion,idTipoDocumento, Integer.valueOf(anio), null, null);
					numero = setDocumentoNumeracion(null,null,anio,null,null,String.valueOf(ultimoNumero));
				} else if (Constants.CAMPO_NUMERACION_PERIODO_MENSUAL.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion ,idTipoDocumento, ano , mes
					 * Devuelvo ultimo numero + 1
					 */
					int ultimoNumero = numeracionService.getUltimoNumero(idAdministracion,idTipoDocumento, Integer.valueOf(anio), Integer.valueOf(mes), null); 
					numero = setDocumentoNumeracion(null,null,anio,mes,null,String.valueOf(ultimoNumero));
				} else if (Constants.CAMPO_NUMERACION_PERIODO_DIARIO.equals(numPeriodo) ){
					/* Busco en la tabla NUMERACION
					 * filtro por idAdministracion ,idTipoDocumento, ano , mes y dia
					 * Devuelvo ultimo numero + 1
					 */
					int ultimoNumero = numeracionService.getUltimoNumero(idAdministracion,idTipoDocumento, Integer.valueOf(anio), Integer.valueOf(mes), Integer.valueOf(dia));
					numero = setDocumentoNumeracion(null,null,anio,mes,dia,String.valueOf(ultimoNumero));

				}
		}
		return numero;
	}

	private NumeroBean setDocumentoNumeracion(String numLetra, String numEstablecimiento, String numAnio, String numMes, String numDia, String num){
		NumeroBean res = new NumeroBean();
		res.setNumeroLetra(numLetra);
		res.setNumeroEstablecimiento(numEstablecimiento);
		res.setNumeroAnio(numAnio);
		res.setNumeroMes(numMes);
		res.setNumeroDia(numDia);
		res.setNumero(num);
		
		return res;
	}


	public ErrorRespuestaBean validarNumeroNoRepetido(Integer idAdministracion, Integer idTipoDocumento,Integer idEntidad, String numero, String letra, String establesimiento) {
		ErrorRespuestaBean res = new ErrorRespuestaBean();
		
		
		res.setValido(true);
		
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
		
		return res;
	}

}
