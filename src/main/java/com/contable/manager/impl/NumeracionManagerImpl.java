package com.contable.manager.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contable.common.AbstractService;
import com.contable.common.ConfigurationManagerImpl;
import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
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

	public String getLastDocNumeration(int idTipoDocumento,String numTipo, String numPeriodo, String numFormato) {
		String numeroLetra = "";
		String numeroEstablecimiento = "";
		String numeroAnio = "";
		String numeroMes = "";
		String numeroDia = "";
		String numero= "";
		

		
		
//		Para Obtener la numeracion
//
//		filtro por Tipo de Documento y Administracion
//
//		Si Tipo = automatica
//			si es historico
//				- filtro por numero
//			si es Anual
//				- filtro por anio
//			si es Mensual
//				- filtro por Mensual
//			si es diario
//				- filtro por diario
//				
//		si Tipo = Manual


		if (Constants.CAMPO_NUMERACION_TIPO_MANUAL.equals(numTipo) ){
			if (Constants.CAMPO_NUMERACION_PERIODO_GENERAL.equals(numPeriodo) ){
				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato)){
					//Se debe INGRESAR el NUMERO
					setDocumentoNumeracion(null,null,null,null,null,"");
				} else if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato)){
					//Se debe INGRESAR la LETRA, ESTABLECIMIENTO y el NUMERO
					setDocumentoNumeracion("","",null,null,null,"");
				}
			} else 	if (Constants.CAMPO_NUMERACION_PERIODO_ENTIDAD.equals(numPeriodo) ){
				if (Constants.CAMPO_NUMERACION_FORMATO_NORMAL.equals(numFormato) ){
					//Se debe INGRESAR el NUMERO
					setDocumentoNumeracion(null,null,null,null,null,"");
				} else 	if (Constants.CAMPO_NUMERACION_FORMATO_LETRA.equals(numFormato) ){
					//Se debe INGRESAR la LETRA, ESTABLECIMIENTO y el NUMERO
					setDocumentoNumeracion("","",null,null,null,"");

				}
			}
		} else if (Constants.CAMPO_NUMERACION_TIPO_AUTOMATICA.equals(numTipo) ){
		//TIPO de NUMERACION es AUTOMATICA ("A")
			Calendar fecha = Calendar.getInstance();
			String dia = Integer.toString(fecha.get(Calendar.DATE));
			String mes = Integer.toString(fecha.get(Calendar.MONTH));
			String anio = Integer.toString(fecha.get(Calendar.YEAR));
			String nextNum = "1"; //TODO trear el ultimo segun el tipo de documento
				if (Constants.CAMPO_NUMERACION_PERIODO_HISTORICO.equals(numPeriodo) ){
					//Trae el ultimo numero para el Tipo de Documento
					setDocumentoNumeracion(null,null,null,null,null,nextNum);
				} else if (Constants.CAMPO_NUMERACION_PERIODO_ANUAL.equals(numPeriodo) ){
					//Trae el ultimo numero para el Tipo de Documento y el anio
					setDocumentoNumeracion(null,null,anio,null,null,nextNum);
				} else if (Constants.CAMPO_NUMERACION_PERIODO_MENSUAL.equals(numPeriodo) ){
					//Trae el ultimo numero para el Tipo de Documento y el mes 
					setDocumentoNumeracion(null,null,null,mes,null,nextNum);
				} else if (Constants.CAMPO_NUMERACION_PERIODO_DIARIO.equals(numPeriodo) ){
					//Trae el ultimo numero para el Tipo de Documento y el dia
					setDocumentoNumeracion(null,null,null,null,dia,nextNum);
				}
		}
		
		return "";
	}

	private String setDocumentoNumeracion(String numLetra, String numEstablecimiento, String numAnio, String numMes, String numDia, String num){
		String numeroLetra = numLetra;
		String numeroEstablecimiento = numEstablecimiento;
		String numeroAnio = numAnio;
		String numeroMes = numMes;
		String numeroDia = numDia;
		String numero= num;
		
		return "";
	}
	
}
