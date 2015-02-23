package com.contable.hibernate.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.utils.DateUtil;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.dao.EstructuraDao;
import com.contable.hibernate.model.Estructura;

@Repository("estructuraDao")
public class EstructuraDaoImpl extends GenericDaoImpl<Estructura, Integer> implements EstructuraDao{

	@Override
	protected Class<Estructura> getEntityClass() {
		return Estructura.class;
	}

	@Override
	@Transactional
	public List<EstructuraSaldoForm> getEstructuraSaldos(int idEstructura,
			int idAdministracion, String fecha, Integer monedaMostrarId) {

		List<EstructuraSaldoForm> lista  = null; 
		boolean mostrarMonedaEn = false;
		
		//Valido los parametros recibidos
		//Si la estructura es null o < a 1 devuevo la lista en null
		//Si la administracion es null o < a 1 devuevo la lista en null
		//Si la fecha es nula devuelvo la lista en null
		if ( (idEstructura < 1 ) || 
			(idAdministracion < 1) || 
			(StringUtils.isBlank(fecha)) ){
			return lista;
		}		
		
		//Si la moneda MostrarEn es vacia ejecuto uno u otro query
		if (monedaMostrarId != null && monedaMostrarId >0 ){
			mostrarMonedaEn = true;
		}
		
		String queryStr = "";
		if (mostrarMonedaEn){
			queryStr = getQueryEstructuraSaldosMostrarMoneda(idEstructura, idAdministracion, monedaMostrarId);
		} else {
			queryStr = getQueryEstructuraSaldos(idEstructura, idAdministracion);
		}
		
		lista = excecuteQueryEstructuraSaldos(queryStr,fecha);
				
		return lista;
	}

	private String getQueryEstructuraSaldosMostrarMoneda(int idEstructura,
			int idAdministracion, Integer monedaMostrarId){
		StringBuilder queryStr = new StringBuilder();
		
		queryStr.append("SELECT CodigoContenido contenidoNombre, ");
		queryStr.append("NombreCuenta cuentaNombre, ");
		queryStr.append("NombreEntidad entidadNombre, ");
		queryStr.append("CodigoMoneda monedaCodigo, ");
		queryStr.append("sum(ImporteMovimiento) saldo, ");
		queryStr.append("	  sum(round(em.ImporteMovimiento * ");
		queryStr.append("em.cotizacion	/ ");
		queryStr.append("(case ");
		queryStr.append("	    when em.IdMoneda = " + monedaMostrarId + " then "); 
		queryStr.append("em.cotizacion ");
		queryStr.append("else ");
		queryStr.append("dc.Cotizacion ");
		queryStr.append("end ");
		queryStr.append(") ");
		queryStr.append(",2) ");
		queryStr.append(") saldoMuestra ");
		queryStr.append("from estructuramovimientos_v em ");
		queryStr.append("join documentocotizaciones dc on dc.Fecha = em.FechaMovimiento ");
		queryStr.append(" AND dc.IdMoneda =  " + monedaMostrarId + "  ");
		queryStr.append("where IdEstructura =  " + idEstructura + "  ");
		queryStr.append("and FechaMovimiento <= :fecha ");
		queryStr.append("group by ");
		queryStr.append("CodigoContenido, ");
		queryStr.append("NombreCuenta, ");
		queryStr.append("NombreEntidad, ");
		queryStr.append("CodigoMoneda ; ");
		
		
		return queryStr.toString();
	}

	private String getQueryEstructuraSaldos(int idEstructura,
			int idAdministracion){
		
		StringBuilder queryStr = new StringBuilder();
		
		queryStr.append("SELECT CodigoContenido contenidoNombre, ");
		queryStr.append("NombreCuenta cuentaNombre, ");
		queryStr.append("NombreEntidad entidadNombre, ");
		queryStr.append("CodigoMoneda monedaCodigo, ");
		queryStr.append("SUM(ImporteMovimiento) saldo, ");
		queryStr.append(" '' as saldoMuestra  ");
		queryStr.append("FROM estructuramovimientos_v ");
		queryStr.append("WHERE IdEstructura =  " + idEstructura + "  ");
		queryStr.append("and FechaMovimiento <=  :fecha ");
		queryStr.append("group by ");
		queryStr.append("CodigoContenido, ");
		queryStr.append("NombreCuenta, ");
		queryStr.append("NombreEntidad, ");
		queryStr.append("CodigoMoneda ; ");
		
		
		return queryStr.toString();
		
	}

	@SuppressWarnings("unchecked")
	private List<EstructuraSaldoForm>  excecuteQueryEstructuraSaldos(String queryStr, String fecha){
		Query query = getSession().createSQLQuery(queryStr.toString())
				.addScalar("contenidoNombre")
				.addScalar("cuentaNombre")
				.addScalar("entidadNombre")
				.addScalar("monedaCodigo")
				.addScalar("saldo",Hibernate.STRING)
				.addScalar("saldoMuestra",Hibernate.STRING)
				.setResultTransformer( Transformers.aliasToBean(EstructuraSaldoForm.class));
				
		if (StringUtils.isNotBlank(fecha))		
			query.setDate("fecha", DateUtil.convertStringToDate(fecha));


		List<EstructuraSaldoForm> result = query.list();
		
		return result;
	}
	
}
