package com.contable.manager;

import java.util.List;
import java.util.Map;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.FiltroSaldoEstructura;
import com.contable.form.EstructuraForm;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.DocumentoAplicaciones_V;
import com.contable.hibernate.model.Estructura;

public interface EstructuraManager extends ConfigurationManager<Estructura,EstructuraForm>{

	public List<EstructuraSaldoForm> getEstructuraSaldos (int idEstructura, int idAdministracion,String fecha, Integer monedaMostrarId);
	
	public List<EstructuraSaldoForm> getEstructuraMovimientosSaldos (int idEstructura, int idAdministracion,String fechaInicial,String fechaFinal, Integer monedaMostrarId);
	
	public void exportPlanillaDiariExcel(List<EstructuraSaldoForm> listado,FiltroSaldoEstructura busqueda);
	public void exportSaldoEstructuraExcel(List<EstructuraSaldoForm> listado,FiltroSaldoEstructura busqueda);
	
	/**
	 * Devuelve en un map IdDocumento => listado de documentos q aplica ese documento.
	 * Itera la lista, obtiene los idDocumento que tienen documentos aplicados y obtiene la lista de aplicaciones
	 * 
	 * @param lista
	 * @return
	 */
	public Map<Integer, List<DocumentoAplicaciones_V>> getDocumentosAplicadosByEstructuras(List<EstructuraSaldoForm> lista);
	
}
