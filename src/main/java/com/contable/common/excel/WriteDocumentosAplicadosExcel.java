package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.beans.FiltroDocAplicacionBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.DocumentoAplicacionMovimientoForm;

@Resource
public class WriteDocumentosAplicadosExcel extends WriteExcel{
  
	private List<DocumentoAplicacionMovimientoForm> lista = new ArrayList<DocumentoAplicacionMovimientoForm>();
	private FiltroDocAplicacionBean busqueda;
	private boolean mostrarMonedaEn= false;

  	public void write(List<DocumentoAplicacionMovimientoForm> documentos,FiltroDocAplicacionBean busqueda) {
	  	try {
	  		//Seteo la busqueda
  			this.busqueda = busqueda;
	  		//Valido si tengo moneda para mostrar 
	  		if (this.busqueda.getMonedaMuestraId() != null 
	  				&& this.busqueda.getMonedaMuestraId() > 0){
	  			mostrarMonedaEn = true;
	  		}
	  			
			  //Seteo la lista que voy exportar
			  this.setLista(documentos);
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
	    int fila = 0;
	  	try {
	  		
	  		//BUSQUEDA
	  		fila = 1;
	  		addCaption(sheet, 0, fila, "Fecha",getEncabezadoTitulo());
	  		addCaption(sheet, 1, fila, "Desde",getEncabezadoTitulo());
	  		addCaption(sheet, 2, fila, busqueda.getDocAplicadoFechaDesde());
	  		addCaption(sheet, 3, fila, "Hasta",getEncabezadoTitulo());
	  		addCaption(sheet, 4, fila, busqueda.getDocAplicadoFechaHasta());

	  		//ENCABEZADO DE LA TABLA
	  		fila = 3;
	  		addCaption(sheet, 0, fila, "Id Doc",6);
	  		addCaption(sheet, 1, fila, "Ingreso",8);
	  		addCaption(sheet, 2, fila, "Tipo Documento",18);
	  		addCaption(sheet, 3, fila, "Numero",15);
	  		addCaption(sheet, 4, fila, "Descripcion",15);
	  		addCaption(sheet, 5, fila, "Cuenta",20);
	  		addCaption(sheet, 6, fila, "Entidad",20);
	  		addCaption(sheet, 7, fila, "Moneda",5);
	  		addCaption(sheet, 8, fila, "Importe",9);
	  		addCaption(sheet, 9, fila, "Cotizacion",6);
	  		addCaption(sheet, 10, fila, "Tipo documento Aplicado",20);
	  		addCaption(sheet, 11, fila, "Numero",15);
	  		addCaption(sheet, 12, fila, "Descripcion",20);
	  		addCaption(sheet, 13, fila, "Moneda",5);
	  		addCaption(sheet, 14, fila, "Importe",9);
	  		addCaption(sheet, 15, fila, "Cotizacion",6);
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
//		  boolean entrelineado = true;
		  for (DocumentoAplicacionMovimientoForm formRow : getLista()) {
				setTexto(Colour.BLACK,Colour.WHITE);
				addNumber(sheet, 0, row, formRow.getDocAplicaId());
				addLabel(sheet, 1, row, formRow.getFechaIngreso());
				addLabel(sheet, 2, row, formRow.getTipoDocumentoNombre());
				addLabel(sheet, 3, row, formRow.getNumeroFormateado());
				addLabel(sheet, 4, row, formRow.getDescripcion());
				addLabel(sheet, 5, row, formRow.getDocAplicaCuentaNombre());
				addLabel(sheet, 6, row, formRow.getDocAplicaEntidadNombre());
				addLabel(sheet, 7, row, formRow.getMovMonedaCodigo());
				addNumber(sheet, 8, row, ConvertionUtil.DouValueOf(formRow.getImporteTotal()));
				addNumber(sheet, 9, row, ConvertionUtil.DouValueOf(formRow.getCotizacion()));
				addLabel(sheet, 10, row, formRow.getDocAplicaTipoDocumentoNombre());
				addLabel(sheet, 11, row, formRow.getDocAplicaNumeroFormateado());
				addLabel(sheet, 12, row, formRow.getDocAplicaDescripcion());
				addLabel(sheet, 13, row, formRow.getMovMonedaCodigo());
				addNumber(sheet, 14, row, ConvertionUtil.DouValueOf(formRow.getMovImporte()));
				addNumber(sheet, 15, row, ConvertionUtil.DouValueOf(formRow.getMovCotizacion()));				
			  //Incremento la fila
			  row++;
      		
		  }


		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

  	}
  

	public List<DocumentoAplicacionMovimientoForm> getLista() {
		return lista;
	}
	
	public void setLista(List<DocumentoAplicacionMovimientoForm> lista) {
		this.lista = lista;
	}

	public FiltroDocAplicacionBean getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(FiltroDocAplicacionBean busqueda) {
		this.busqueda = busqueda;
	}
	
	  
} 