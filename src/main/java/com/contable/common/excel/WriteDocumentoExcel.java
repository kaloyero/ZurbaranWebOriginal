package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.form.DocumentoForm;


public class WriteDocumentoExcel extends WriteExcel{
  
  private List<DocumentoForm> lista = new ArrayList<DocumentoForm>();
  
  	public void write(List<DocumentoForm> lista) {
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
	    	addCaption(sheet, 0, 0, "Administracion");
	    	addCaption(sheet, 1, 0, "Tipo Documento");
	    	addCaption(sheet, 2, 0, "Documento");
		    addCaption(sheet, 3, 0, "Fecha Ingreso");
		    addCaption(sheet, 4, 0, "Fecha Vencimiento");
		    addCaption(sheet, 5, 0, "Moneda");
		    addCaption(sheet, 6, 0, "Total");
		    addCaption(sheet, 7, 0, "Descripción");
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
		  for (DocumentoForm form : getLista()) {
			  
			  addLabel(sheet, 0, row, form.getAdministracionNombre());
			  addLabel(sheet, 1, row, form.getTipoDocumentoNombre());
			  addLabel(sheet, 2, row, form.getNumeroFormateado());
			  addLabel(sheet, 3, row, form.getFechaIngreso());
			  addLabel(sheet, 4, row, form.getFechaVencimiento());
			  addLabel(sheet, 5, row, form.getMonedaNombre());
			  addNumber(sheet,6, row, form.getImporteTotal());
			  addLabel(sheet, 7, row, form.getDescripcion());
				
			  //Incremento la fila
			  row++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

  	}
  
	public List<DocumentoForm> getLista() {
		return lista;
	}
	
	public void setLista(List<DocumentoForm> lista) {
		this.lista = lista;
	}
	
	  
} 