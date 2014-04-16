package com.contable.common;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.contable.common.beans.Mapper;
import com.contable.common.beans.Property;

public abstract class AbstractManagerImpl<E,F> implements AbstractManager<E,F> { 

	/**
	 * Obtener los campos por los que se va filtrar
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
	
	public List<F> getListaDataTable(int pagina,int cantRegistros, String filterText, String orderBy, boolean orderAsc) {
		return getMapper().getFormList(getRelatedService().listPaginByFilter(pagina, cantRegistros, getFilterFields(), filterText, orderBy, orderAsc));
	}

	public Map<String,Integer> getListaDateTableTotales(String filterText) {
		return getRelatedService().listPaginTotalesByFilter( getFilterFields(), filterText);
	}

	@Transactional
	public void guardarNuevo(F form){
		getRelatedService().save(getMapper().getEntidad(form));
	}

	@Transactional
	public void update(F form){
		getRelatedService().update(getMapper().getEntidad(form));
	}

	@Transactional
	public void delete(F form){
		getRelatedService().delete(getMapper().getEntidad(form));
	}

	@Transactional
	public F findById(Integer id){
		return getMapper().getForm(getRelatedService().findById(id) );
	}
}
