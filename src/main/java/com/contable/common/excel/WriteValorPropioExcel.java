package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.utils.ConvertionUtil;
import com.contable.form.ValorPropioForm;


public class WriteValorPropioExcel extends WriteExcel{
  
  private List<ValorPropioForm> lista = new ArrayList<ValorPropioForm>();
  
  	public void write(List<ValorPropioForm> lista) {
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
	    	addCaption(sheet, 0, 0, "Numero");
	    	addCaption(sheet, 1, 0, "Cuenta");
	    	addCaption(sheet, 2, 0, "Tipo Entidad");
		    addCaption(sheet, 3, 0, "Entidad");
		    addCaption(sheet, 4, 0, "Fecha Vencimiento");
		    addCaption(sheet, 5, 0, "Moneda");
		    addCaption(sheet, 6, 0, "Importe");

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
		  for (ValorPropioForm form : getLista()) {
			  addLabel(sheet, 0, row, ConvertionUtil.StrValueOf(form.getNumero()));
			  addLabel(sheet, 1, row, form.getCuentaNombre());
			  addLabel(sheet, 2, row, form.getTipoEntidadNombre());
			  addLabel(sheet, 3, row, form.getEntidadNombre());
			  addLabel(sheet, 4, row, form.getFechaVencimiento());
			  addLabel(sheet, 5, row, form.getMonedaCodigo());
			  addNumber(sheet,6, row, form.getImporteValor());
			
			  //Incremento la fila
			  row++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

  	}
  
	public List<ValorPropioForm> getLista() {
		return lista;
	}
	
	public void setLista(List<ValorPropioForm> lista) {
		this.lista = lista;
	}
	
	  
} 