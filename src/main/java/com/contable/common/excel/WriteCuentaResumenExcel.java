package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.FormatUtil;
import com.contable.common.utils.SaldosUtil;
import com.contable.form.CuentaBusquedaForm;


public class WriteCuentaResumenExcel extends WriteExcel{
  
  private List<CuentaBusquedaForm> lista = new ArrayList<CuentaBusquedaForm>();
  	/*  Saldo Inicial   */
	private Double saldoAcumulado;
	/*  Mostrar en moneda  */
	private boolean mostrarEnMoneda;
  	/*  Saldo Inicial Mostrar en moneda  */
	private Double saldoAcumuladoMonedaEn;
	/*  Fecha Inicial   */
	private String fechaIni;
	/*  Fecha Final   */
	private String fechaFin;
	
	
  	public void write(List<CuentaBusquedaForm> lista, FiltroCuentaBean busqueda, Double saldoInicial, Double saldoInicialMostrarEn) {
	  	try {
			  //Inicializo el saldo acumulado
	  		  this.saldoAcumulado = saldoInicial.doubleValue();
	  		  this.saldoAcumuladoMonedaEn = saldoInicialMostrarEn.doubleValue();
	  		  //Fecha inicial
	  		  this.fechaIni = busqueda.getFechaDesde(); 
	  		  //Fecha Final
	  		  this.fechaFin = busqueda.getFechaHasta();
	  		  //mostrarEnMoneda
	  		  if (busqueda.getMonedaMuestraId() == null){
	  			mostrarEnMoneda = false;
	  		  } else {
	  			mostrarEnMoneda = true;  
	  		  }
	  		  
			  //Seteo la lista que voy exportar
			  this.setLista(lista);
			  //Nombre de la hoja
			  this.write("Listado");

		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
  	}

    protected void getEncabezado(WritableSheet sheet) {
  	    try {
  	    	String moneda = "";
  	    	String monedaMostrar = "";
  	    	if (getLista() != null && getLista().size() >= 1){
  	    		moneda = getLista().get(0).getMonedaNombre() + " (" + getLista().get(0).getMonedaCodigo() + " )";
  	    		monedaMostrar = getLista().get(0).getMonedaNombre() + " (" + getLista().get(0).getMonedaMostrarCodigo() + " )";
  	    	}
  	    	

  			addCaption(sheet, 0, 1, "Fecha Inicial");
  			addCaption(sheet, 1, 1, this.fechaIni);
  			addCaption(sheet, 0, 2, "Fecha Final");
  			addCaption(sheet, 1, 2, this.fechaFin);
  			addCaption(sheet, 0, 3, "Moneda");
			addCaption(sheet, 1, 3, moneda);  			
  	    	addCaption(sheet, 0, 4, "Saldo Inicial");
  	    	addCaption(sheet, 1, 4, FormatUtil.format2DecimalsStr(this.saldoAcumulado));
  	    	addCaption(sheet, 0, 5, "Saldo Final");
			if (mostrarEnMoneda){
  				addCaption(sheet, 2, 3, monedaMostrar);
  	  	    	addCaption(sheet, 2, 4, FormatUtil.format2DecimalsStr(this.saldoAcumuladoMonedaEn));
  			}
  			
  	    	//Se completa despues
  	    } catch (RowsExceededException e) {
  			e.printStackTrace();
  		} catch (WriteException e) {
  			e.printStackTrace();
  		}
    }
  	
  	
  	
  @Override
  protected void getTitulos(WritableSheet sheet) {
	    try {
	    	//Encabezado
	    	getEncabezado(sheet);
	    	
	    	//Titulos de la tabla
	    	int initRow = 8; 
	    	
			addCaption(sheet, 0, initRow, "Fecha Ingreso");
			addCaption(sheet, 1, initRow, "Tipo Documento");
	    	addCaption(sheet, 2, initRow, "Numero");
	    	addCaption(sheet, 3, initRow, "Descripción");
	    	addCaption(sheet, 4, initRow, "Referencia");
	    	addCaption(sheet, 5, initRow, "Cuenta");
	    	addCaption(sheet, 6, initRow, "Tipo Entidad");
	    	addCaption(sheet, 7, initRow, "Entidad");
	    	addCaption(sheet, 8, initRow, "Moneda");
	    	addCaption(sheet, 9, initRow, "Importe");
		    addCaption(sheet, 10,initRow, "Saldo");
    		/* SALDO Mostrar En Moneda*/
    		if (mostrarEnMoneda){
    	    	addCaption(sheet, 11, initRow, "Moneda");
    	    	addCaption(sheet, 12, initRow, "Importe");
    		    addCaption(sheet, 13,initRow, "Saldo");
    		}
		    
	    } catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
  }
  

  	@Override
  	protected void getListado(WritableSheet sheet) {
	  
	  	try {
	  		int initRow = 9; 
		  for (CuentaBusquedaForm form : getLista()) {
			  
			  addLabel(sheet, 0, initRow, form.getFechaIngreso());
			  addLabel(sheet, 1, initRow, form.getTipodocumentoNombre());
			  addLabel(sheet, 2, initRow, form.getNumeroFormateado());
			  addLabel(sheet, 3, initRow, form.getDocDescripcion());
			  
			  addLabel(sheet, 4, initRow, form.getReferencia());
			  addLabel(sheet, 5, initRow, form.getCuentaNombre());
			  addLabel(sheet, 6, initRow, form.getTipoEntidadNombre());
			  addLabel(sheet, 7, initRow, form.getEntidadNombre());
			  addLabel(sheet, 8, initRow, form.getMonedaCodigo());
			  
			  addNumber(sheet, 9, initRow, SaldosUtil.getImporteExcel(form.getDebito(), form.getCredito()));
			  //saldo acumulado
	    	  saldoAcumulado = SaldosUtil.sumar(saldoAcumulado, form.getDebito(), form.getCredito());
			  addNumber(sheet, 10, initRow, saldoAcumulado);
			  
	    		if (mostrarEnMoneda){
		    		/* SALDO Mostrar En Moneda*/
				    addLabel(sheet, 11, initRow, form.getMonedaMostrarCodigo());
	        		//Debito - credito
	        		addNumber(sheet, 12, initRow, SaldosUtil.getImporteExcel(form.getDebitoMostrar(),form.getCreditoMostrar()));
	        		//saldo acumulado
	        		saldoAcumuladoMonedaEn = SaldosUtil.sumar(saldoAcumuladoMonedaEn, form.getDebitoMostrar(), form.getCreditoMostrar());
	        		addNumber(sheet, 13, initRow, saldoAcumuladoMonedaEn);
	    		}
			  
			  
			  //Incremento la fila
			  initRow++;
		  }
		  
		  /* Saldo Final*/
		  addCaption(sheet, 1, 5,FormatUtil.format2DecimalsStr(this.saldoAcumulado));
		  if (mostrarEnMoneda){
			  addCaption(sheet, 2, 5,FormatUtil.format2DecimalsStr(this.saldoAcumuladoMonedaEn));
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

  	}
  
	public List<CuentaBusquedaForm> getLista() {
		return lista;
	}
	
	public void setLista(List<CuentaBusquedaForm> lista) {
		this.lista = lista;
	}
	
	  
} 