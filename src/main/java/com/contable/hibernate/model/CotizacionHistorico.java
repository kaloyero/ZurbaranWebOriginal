package com.contable.hibernate.model;

import java.io.Serializable;
import java.util.Date;

public class CotizacionHistorico implements Serializable {

	/** Serial Version UID */
	private static final long serialVersionUID = 1L;

	private Date fecha;
	
	private double cotizacion;

    private  int idMoneda;

    
    public CotizacionHistorico() {
		super();
	}    
	public CotizacionHistorico(Date fecha, double cotizacion, int idMoneda) {
		super();
		this.fecha = fecha;
		this.cotizacion = cotizacion;
		this.idMoneda = idMoneda;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}


}
