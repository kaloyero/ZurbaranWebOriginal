package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.CuentaBusquedaForm;


public class WriteCuentaSaldoExcel extends WriteExcel{
  
  private List<CuentaBusquedaForm> lista = new ArrayList<CuentaBusquedaForm>();
  	private Double saldoIni;
  	private Double saldoFin;
	/*  Fecha Inicial   */
	private String fechaIni;
	/*  Fecha Final   */
	private String fechaFin;
  	
  
  	public void write(List<CuentaBusquedaForm> lista, FiltroCuentaBean busqueda,Double saldoIni, Double saldoFin) {
	  	try {
	  			this.saldoIni = saldoIni;
	  			this.saldoFin = saldoFin;
		  		  //Fecha inicial
		  		  this.fechaIni = busqueda.getFechaDesde(); 
		  		  //Fecha Final
		  		  this.fechaFin = busqueda.getFechaHasta(); 	  			
	  		
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

  @Override
  protected void getTitulos(WritableSheet sheet) {
	    try {
	    	addCaption(sheet, 0, 0, "Saldo al");
	    	addCaption(sheet, 1, 0, fechaIni);
	    	addNumber (sheet, 2, 0, saldoIni);
	    	addCaption(sheet, 0, 1, "Saldo al ");
	    	addCaption(sheet, 1, 1, fechaFin);
	    	addNumber (sheet, 2, 1, saldoFin);
	    	
	    	int rowIniti = 3;
	    	
	    	addCaption(sheet, 0, rowIniti, "Cuenta");
	    	addCaption(sheet, 1, rowIniti, "Tipo Entidad");
	    	addCaption(sheet, 2, rowIniti, "Entidad");
	    	addCaption(sheet, 3, rowIniti, "Moneda");
		    addCaption(sheet, 4, rowIniti, "Saldo");
		    addCaption(sheet, 5, rowIniti, "Calculado en ");
		    addCaption(sheet, 6, rowIniti, "Total");
	    } catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}


  }
  

  	@Override
  	protected void getListado(WritableSheet sheet) {
	  
	  	try {
		  int row = 4;
		  for (CuentaBusquedaForm form : getLista()) {
			  addLabel (sheet, 0, row, form.getCuentaNombre());
			  addLabel (sheet, 1, row, form.getEntidadNombre());
			  addLabel (sheet, 2, row, form.getTipoEntidadNombre());
			  addLabel (sheet, 3, row, form.getMonedaCodigo());
			  addNumber(sheet,4, row, ConvertionUtil.DouValueOf(form.getSaldo()));
			  addLabel (sheet, 5, row, form.getMonedaMostrarCodigo());
			  addNumber(sheet,6, row, ConvertionUtil.DouValueOf(form.getTotalMostrar()));

				
			  //Incremento la fila
			  row++;
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