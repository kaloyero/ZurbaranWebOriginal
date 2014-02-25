package com.contable.common;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;

public abstract class AbstractManagerImpl<E,F> implements AbstractManager<E,F> { 

	/**
	 * Obtener el servicio
	 * @return
	 */
	protected abstract List<Property> getFilterFields() ;
	
	/**
	 * Obtener el servicio
	 * @return
	 */
	protected abstract AbstractService<E> getRelatedService() ;

	/**
	 * Obtener el mapper
	 * @return
	 */
	protected abstract Mapper<E,F> getMapper() ;

	public List<F> getLista() {
		
		List<F> list = (List<F>) getMapper().getFormList(getRelatedService().listAll());
		return list;
	}
	
	public List<F> getListaDataTable(int pagina,int cantRegistros, String filterText, String filterBy, boolean orderAsc) {
		
		List<F> list = (List<F>) getMapper().getFormList(getRelatedService().
				listPaginByFilter(pagina, cantRegistros, getFilterFields(), filterText, filterBy, orderAsc));
		return list;
	}

	@Transactional
	public void guardarNuevo(F form){
		getRelatedService().save(getMapper().getEntidad(form));
	}

}
