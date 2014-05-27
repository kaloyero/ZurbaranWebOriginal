package com.contable.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.contable.common.GenericDaoImpl;
import com.contable.common.beans.ConfigBean;
import com.contable.common.beans.Property;
import com.contable.common.constants.Constants;
import com.contable.hibernate.dao.TipoDocumentoConceptoDao;
import com.contable.hibernate.model.Concepto;
import com.contable.hibernate.model.TipoDocumentoConcepto;

@Repository("documentoTipoConceptoDao")
public class TipoDocumentoConceptoDaoImpl extends GenericDaoImpl<TipoDocumentoConcepto, Integer> implements TipoDocumentoConceptoDao{

	@Override
	protected Class<TipoDocumentoConcepto> getEntityClass() {
		return TipoDocumentoConcepto.class;
	}

	@Transactional
	public void update(Collection<Integer> idsConceptos,int idTipoDocumento) {
		Collection<TipoDocumentoConcepto> conceptosTipoDoc= this.findAllByProperty("idTipoDocumento", idTipoDocumento,false);
	
		//Controla que los conceptos ya no esten y los ELIMINA
		for (TipoDocumentoConcepto ctoTipoDoc : conceptosTipoDoc) {
			boolean deleteMoneda = true;
			
			for (Integer idConcepto : idsConceptos) {
				if (idConcepto.equals(ctoTipoDoc.getConcepto().getId())){
					deleteMoneda = false;
				}
			}
			
			if (deleteMoneda){
				//elimina el concepto
				this.delete(ctoTipoDoc);
			}
		}
		
		//AGREGA CONCEPTOS
		for (Integer idConcepto : idsConceptos) {
			boolean insert = true;
			for (TipoDocumentoConcepto ctoTipoDoc : conceptosTipoDoc) {
				if (idConcepto.equals(ctoTipoDoc.getConcepto().getId())){
					insert =false;
				}
			}
			if (insert){
				TipoDocumentoConcepto tipoDocCto = new TipoDocumentoConcepto();
				Concepto cto = new Concepto(); 
				cto.setId(idConcepto);
				tipoDocCto.setIdTipoDocumento(idTipoDocumento);
				tipoDocCto.setConcepto(cto);

				this.save(tipoDocCto);
			}
			
		}

	}

	public List<TipoDocumentoConcepto> getConceptosByIdTipodocumento(int idTipoDocumento){
		List<TipoDocumentoConcepto> lista = this.findAllByProperty("idTipoDocumento" ,idTipoDocumento,false);
		return lista;
	}

	public List<ConfigBean> getConceptosConfigByIdTipodocumento(int idTipoDocumento){
		List<Property> filtros = new ArrayList<Property>();
		
		filtros.add(new Property(Restrictions.eq("idTipoDocumento", idTipoDocumento), Property.OPERATOR_AND));

		List<ConfigBean> list = this.findComboListByFilters(Constants.FIELD_REFERENCIA,Constants.FIELD_NAME,Constants.BD_ACTIVO,filtros,"concepto.nombre,concepto.codigo",true,"concepto");		
		
		return list;
	}

}
