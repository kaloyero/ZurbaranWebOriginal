package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.utils.ConvertionUtil;
import com.contable.form.CuentaBusquedaForm;


public class WritePlantillaDiariaExcel extends WriteExcel{
  
  private List<CuentaBusquedaForm> lista = new ArrayList<CuentaBusquedaForm>();
  
  	public void write(List<CuentaBusquedaForm> lista) {
	  	try {
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
	    	addCaption(sheet, 0, 0, "Documento");
	    	addCaption(sheet, 1, 0, "Fecha Ingreso");
	    	addCaption(sheet, 2, 0, "Moneda");
	    	addCaption(sheet, 3, 0, "Debito");
		    addCaption(sheet, 4, 0, "Credito");
	    } catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}


  }
  

  	@Override
  	protected void getListado(WritableSheet sheet) {
	  
	  	try {
		  int row = 1;
		  for (CuentaBusquedaForm form : getLista()) {
			  addLabel(sheet, 0, row, form.getNumeroFormateado());
			  addLabel(sheet, 1, row, form.getFechaIngreso());
			  addLabel(sheet, 2, row, form.getMonedaCodigo());
			  addNumber(sheet,3, row, ConvertionUtil.DouValueOf(form.getDebito()));
			  addNumber(sheet,4, row, ConvertionUtil.DouValueOf(form.getCredito()));
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