package com.contable.manager;

import java.util.List;

import com.contable.common.ConfigurationManager;
import com.contable.common.beans.ConfigBean;
import com.contable.form.CuentaForm;
import com.contable.form.MonedaForm;
import com.contable.hibernate.model.Cuenta;

public interface CuentaManager extends ConfigurationManager<Cuenta,CuentaForm>{

	List<MonedaForm> getMonedasByCuenta(Integer cuentaId, boolean cotizacion);
	
	List<ConfigBean> getMonedasConfigByCuenta(Integer cuentaId);
}
