
package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.AbstractManagerImpl;
import com.contable.common.AbstractService;
import com.contable.common.beans.ErrorRespuestaBean;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.NumeroBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.form.NumeracionForm;
import com.contable.hibernate.model.Numeracion;
import com.contable.hibernate.model.TipoDocumento;
import com.contable.manager.NumeracionManager;
import com.contable.mappers.NumeracionMapper;
import com.contable.services.DocumentoService;
import com.contable.services.NumeracionService;
import com.contable.services.TipoDocumentoService;

@Service("numeracionManager")
public class NumeracionManagerImpl extends AbstractManagerImpl<Numeracion,NumeracionForm> implements NumeracionManager{

	@Autowired
	NumeracionService numeracionService;

	@Autowired
	TipoDocumentoService tipoDocumentoService;

	@Autowired
	DocumentoService documentoService;

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

	@Transactional
	public NumeroBean getLastDocNumeration(int idAdministracion, int idTipoDocumento, String fechaIngreso, String letra, Integer establecimiento) {
		NumeroBean numero = new NumeroBean();
		
		/* En el caso de que la ADMINISTRACION no sea enviada devolvera todos los campos en NULL*/
		/* En el caso de que el TIPO DE DOCUMENTO no sea enviado devolvera todos los campos en NULL */
		if (idAdministracion < 1){
			return setDocumentoNumeracion(null,null,null,null,null,null);
		}else if (idTipoDocumento < 1){
			return setDocumentoNumeracion(null,null,null,null,null,null);
		} 
		
		//averiguar estos datos por el tipoDeDocumento
		TipoDocumento tipoDoc = tipoDocumentoService.findById(idTipoDocumento);

		String numTipo = tipoDoc.getNumeracionTipo();
		
		
		if (Constants.CAMPO_NUMERACION_TIPO_MANUAL.equals(numTipo) ){
		/*TIPO de NUMERACION es MANUAL ("M")
		 * (*) En el caso de que el TIPO del Documento sea MANUAL devueve el siguiente Formato:
	     * 		- NULL para los campos que no deben aparecer
	     * 		- "" para los campos que se deben completar.
		 * */
			numero = getLastDocNumerationManual(tipoDoc);
		} else if (Constants.CAMPO_NUMERACION_TIPO_AUTOMATICA.equals(numTipo) ){
		/*TIPO de NUMERACION es AUTOMATICA ("A")
	     * 		- NULL para los campos que no deben aparecer
	     * 		- "" para los campos que se deben completar.
	     * 		- XXX para los campos que tienen algún valor
	     * 		- En el caso de que no se envíe la fecha devolvera todos los campos en NULL
		 *		- En el caso de que el FORMATO requiera Letra + Establecimiento y estos no se envién devolvera los campos Letra y Establecimiento "" y "" respectivamente, dejando el resto de los campos en NULL.
		 *		- En el caso de que el PERIODO requiera la fecha y esta no se envié devolvera todos los campos en NULL. 
		 */
			//Verifica si tiene Letra + Establesimiento.
			String numFormato = tipoDoc.getNumeracionFormato();
			if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato) ){
				//VAlida que se haya ingresado la Letra y el Establecimiento
				if (StringUtils.isNotBlank(letra) && establecimiento != null ){
					//si tiene Letra y Establecimiento y son enviados. Devuelve el ULTIMO NUMERO
					numero = getLastDocNumerationAutomatico(idAdministracion,tipoDoc, fechaIngreso,letra,establecimiento);
				} else {
					//si tiene Letra y Establecimiento y NO son enviados. Devuelve el numero vacio
					numero = setDocumentoNumeracion("","",null,null,null,null);
				}
			} else {
				// Si no tiene letra obtiene el ultio numero
				numero = getLastDocNumerationAutomatico(idAdministracion,tipoDoc, fechaIngreso,null,null);
			}
		}
		return numero;
	}
	
private NumeroBean getLastDocNumerationAutomatico(int idAdministracion, TipoDocumento tipoDoc, String fechaIngreso,String letra,Integer establecimiento){
	NumeroBean numero = new NumeroBean();
	//Obtengo el periodo del tipo de Documento
	String numPeriodo = tipoDoc.getNumeracionPeriodo();
	
	//Si el periodo es HISTORICO
	if (Constants.CAMPO_NUMERACION_PERIODO_HISTORICO.equals(numPeriodo) ){
		/* Busco en la tabla NUMERACION
		 * filtro por idAdministracion y idTipoDocumento
		 * Devuelvo ultimo numero + 1
		 */
		int ultimoNumero =  numeracionService.getUltimoNumero(idAdministracion,tipoDoc.getId(),letra,establecimiento,null,null,null) + 1;
		numero = setDocumentoNumeracion(letra,ConvertionUtil.StrValueOf(establecimiento),null,null,null,ConvertionUtil.StrValueOf(ultimoNumero));
	} else {
		//Valido que se haya ingresado una FECHA
		if (fechaIngreso == null){
			//Si no se ingreso una fecha valida devuelvo un numero vacío
			numero = setDocumentoNumeracion(null,null,null,null,null,null);
		} else {
			// Si hay una fecha valida:
			
			Date fecha = DateUtil.convertStringToDate(fechaIngreso);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(fecha);
			String dia = Integer.toString(calendar.get(Calendar.DATE));
			//(le sumo uno al mes poruqe va del 0 al 11)
			String mes = Integer.toString(calendar.get(Calendar.MONTH) + 1);
			String anio = Integer.toString(calendar.get(Calendar.YEAR));
			
			if (Constants.CAMPO_NUMERACION_PERIODO_ANUAL.equals(numPeriodo) ){
				/* Busco en la tabla NUMERACION
				 * filtro por idAdministracion ,idTipoDocumento, ano
				 * Devuelvo ultimo numero + 1
				 */
				//Obtengo el ultimo numero y le sumo 1
				int ultimoNumero =  numeracionService.getUltimoNumero(idAdministracion,tipoDoc.getId(),letra,establecimiento,ConvertionUtil.IntValueOf(anio),null,null) + 1;
				numero = setDocumentoNumeracion(letra,ConvertionUtil.StrValueOf(establecimiento),anio,null,null,ConvertionUtil.StrValueOf(ultimoNumero));
			} else if (Constants.CAMPO_NUMERACION_PERIODO_MENSUAL.equals(numPeriodo) ){
				/* Busco en la tabla NUMERACION
				 * filtro por idAdministracion ,idTipoDocumento, ano , mes
				 * Devuelvo ultimo numero + 1
				 */
				int ultimoNumero =  numeracionService.getUltimoNumero(idAdministracion,tipoDoc.getId(),letra,establecimiento,ConvertionUtil.IntValueOf(anio),ConvertionUtil.IntValueOf(mes),null) + 1;
				numero = setDocumentoNumeracion(letra,ConvertionUtil.StrValueOf(establecimiento),anio,mes,null,ConvertionUtil.StrValueOf(ultimoNumero));
			} else if (Constants.CAMPO_NUMERACION_PERIODO_DIARIO.equals(numPeriodo) ){
				/* Busco en la tabla NUMERACION
				 * filtro por idAdministracion ,idTipoDocumento, ano , mes y dia
				 * Devuelvo ultimo numero + 1
				 */
				int ultimoNumero =  numeracionService.getUltimoNumero(idAdministracion,tipoDoc.getId(),letra,establecimiento,ConvertionUtil.IntValueOf(anio),ConvertionUtil.IntValueOf(mes), ConvertionUtil.IntValueOf(dia)) + 1;
				numero = setDocumentoNumeracion(letra,ConvertionUtil.StrValueOf(establecimiento),anio,mes,dia,ConvertionUtil.StrValueOf(ultimoNumero));
			}
		}
	}
	
	return numero;
}

private NumeroBean getLastDocNumerationManual(TipoDocumento tipoDoc){
	NumeroBean numero = new NumeroBean();
	
	String numPeriodo = tipoDoc.getNumeracionPeriodo();
	String numFormato = tipoDoc.getNumeracionFormato();

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

	@Transactional
	public ErrorRespuestaBean validarNumeroNoRepetido(Integer idAdministracion, Integer idTipoDocumento,Integer idTipoEntidad,Integer idEntidad, String numero, String letra, String establesimiento) {
		return validarNumeroNoRepetido(idAdministracion, idTipoDocumento,idTipoEntidad, idEntidad, new NumeroBean(letra,establesimiento,numero));
	}

	@Transactional
	public ErrorRespuestaBean validarNumeroNoRepetido(Integer idAdministracion,
			Integer idTipoDocumento,Integer idTipoEntidad, Integer idEntidad, NumeroBean num) {

		ErrorRespuestaBean res = new ErrorRespuestaBean();

		//averiguar estos datos por el tipoDeDocumento
		TipoDocumento tipoDoc = tipoDocumentoService.findById(idTipoDocumento);

		String numTipo = tipoDoc.getNumeracionTipo();
		String numPeriodo = tipoDoc.getNumeracionPeriodo();
		String numFormato = tipoDoc.getNumeracionFormato();

		
		NumeroBean numValidar = null;
		boolean filtroEntidad = false;
		Integer idEntidadValidar = null;
		Integer idTipoEntidadValidar = null;
		//VOY A SETEAR LOS VALORES QUE QUIERO VERIFICAR
		if (Constants.CAMPO_NUMERACION_TIPO_MANUAL.equals(numTipo) ){
			if (Constants.CAMPO_NUMERACION_PERIODO_GENERAL.equals(numPeriodo) ){
			if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato)){
				//VALIDO el numero
				numValidar = setDocumentoNumeracion(null,null,null,null,null,num.getNumero());
			} else if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato)){
				//VALIDO la LETRA, ESTABLECIMIENTO y el NUMERO
				numValidar = setDocumentoNumeracion(num.getNumeroLetra(),num.getNumeroEstablecimiento(),null,null,null,num.getNumero());
			}
		} else 	if (Constants.CAMPO_NUMERACION_PERIODO_ENTIDAD.equals(numPeriodo) ){
			//SETEO LA ENTIDAD Y EL TIPO ENTIDAD
			filtroEntidad = true;
			idEntidadValidar = idTipoDocumento;
			idTipoEntidadValidar = idEntidad;
			if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato) ){
				//VALIDO el NUMERO , el tipo de Entidad y la entidad
				numValidar = setDocumentoNumeracion(null,null,null,null,null,num.getNumero());
			} else 	if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato) ){
				//VALIDO la LETRA, ESTABLECIMIENTO, el NUMERO  , el tipo de Entidad y la entidad
				numValidar = setDocumentoNumeracion(num.getNumeroLetra(),num.getNumeroEstablecimiento(),null,null,null,num.getNumero());
				
			}
		}
		res = documentoService.verificarExisteDocumento(idAdministracion, idTipoDocumento,filtroEntidad,idTipoEntidadValidar, idEntidadValidar, numValidar);	
		}
		
		res.setValido(true);
		
		return res;
	}

	@Transactional
	public void actualizarNumeracion(Integer idAdministracion,
			Integer idTipoDocumento, NumeroBean num) {

		numeracionService.actualizarNumeracion(idAdministracion, idTipoDocumento, num);	
		
	}

}
