package com.contable.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contable.common.ConfigurationControllerImpl;
import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ControllerUtil;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.ConceptoForm;
import com.contable.hibernate.model.Concepto;
import com.contable.manager.AdministracionManager;
import com.contable.manager.ConceptoManager;
import com.contable.manager.CuentaManager;
import com.contable.manager.EntidadManager;
import com.contable.manager.MonedaManager;
import com.contable.manager.TipoEntidadManager;
import org.springframework.expression.ParseException;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/concepto")
public class ConceptoController  extends ConfigurationControllerImpl<Concepto, ConceptoForm>{

	@Autowired
	private ConceptoManager conceptoManager;
	@Autowired
	private TipoEntidadManager tipoEntidadManager;
	@Autowired
	private AdministracionManager adminManager;
	@Autowired
	private MonedaManager monedaManager;
	@Autowired
	private EntidadManager entidadManager;
	@Autowired
	private CuentaManager cuentaManager;

	@Override
	protected ConfigurationManager<Concepto, ConceptoForm> getRelatedManager() {
		return conceptoManager;
	}

	@Override
	protected List<String> getRowDataList(ConceptoForm formRow) {
		List <String> row =new ArrayList<String>();
		row.add(ConvertionUtil.StrValueOf(formRow.getId()));
		row.add(ControllerUtil.getAdministracionDescripcion(formRow.getAdministracion().getNombre()));
		row.add(formRow.getNombre());
		row.add(formRow.getCodigo());

		row.add(formRow.getCuenta().getNombre());
		if (formRow.getEntidad().getTipo()!=null){
			row.add(formRow.getEntidad().getTipo().getNombre());
		}else{
			row.add("");
		}		
		row.add(formRow.getEntidad().getNombre());	
		
		row.add(formRow.getMoneda().getNombre());
		
		row.add(ControllerUtil.getEstadoDescripcion(formRow.getEstado()));

		row.add(BOTON_LISTADO_CAMBIARESTADO +
				BOTON_LISTADO_EDITAR +
				BOTON_LISTADO_ELIMINAR);
		return row;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)	
	public  String  showInit(Locale locale, Model model, HttpServletRequest request) {
		List<ConfigBean> listadoTipoEntidades =tipoEntidadManager.getConfigNameList();
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);
		List<ConfigBean> listadoEntidades =entidadManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameListByAdm(-1);
		
		model.addAttribute("Concepto", new ConceptoForm());
		model.addAttribute("tipoEntidades", listadoTipoEntidades);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("entidades", listadoEntidades);
		model.addAttribute("cuentas", listadoCuentas);

		

	   return "configuraciones/concepto";
	}

	@RequestMapping(value = "/getEntidadById/{id}", method = RequestMethod.GET)
	public String get(Locale locale, Model model,@PathVariable int id, HttpServletRequest request) throws ParseException{
		ConceptoForm concepto =conceptoManager.findById(id);
		
		List<ConfigBean> listadoAdministraciones =adminManager.getConfigNameList(AdministracionManager.CAMPO_TODAS);
		List<ConfigBean> listadoMonedas =monedaManager.getConfigNameList(Constants.CAMPO_EXTRA_TODAS);
		List<ConfigBean> listadoCuentas =cuentaManager.getConfigNameListByAdm(concepto.getAdministracion().getId());
		List<ConfigBean> listadoEntidades =entidadManager.getConfigEntidadesListByTipoEntidad(concepto.getCuenta().getTipoEntidad().getId(),Constants.CAMPO_EXTRA_TODAS);

		
		model.addAttribute("Concepto", concepto);
		model.addAttribute("administraciones", listadoAdministraciones);
		model.addAttribute("monedas", listadoMonedas);
		model.addAttribute("cuentas", listadoCuentas);
		model.addAttribute("entidades", listadoEntidades);

	
		return "configuraciones/editConcepto";
	}

	
}
