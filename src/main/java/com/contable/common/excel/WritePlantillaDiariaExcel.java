package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;

import com.contable.common.beans.FiltroSaldoEstructura;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.EstructuraSaldoForm;


public class WritePlantillaDiariaExcel extends WriteExcel{
  
	private List<EstructuraSaldoForm> lista = new ArrayList<EstructuraSaldoForm>();
	private FiltroSaldoEstructura busqueda;
  
  	public void write(List<EstructuraSaldoForm> lista,FiltroSaldoEstructura busqueda) {
	  	try {
	  		  //Seteo la busqueda
	  			this.busqueda = busqueda;
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
	    int fila = 0;
	  	try {
	  		
	  		//BUSQUEDA
	  		fila = 1;
	  		addCaption(sheet, 0, fila, "Fecha",getEncabezadoTitulo());
	  		addCaption(sheet, 1, fila, "Desde:",getEncabezadoTitulo());
	  		addCaption(sheet, 2, fila, busqueda.getFechaDesde(),getEncabezado());
	  		addCaption(sheet, 3, fila, "Hasta:",getEncabezadoTitulo());
	  		addCaption(sheet, 4, fila, busqueda.getFecha(),getEncabezado());
	  		
	  		
	  		//ENCABEZADO DE LA TABLA
	  		fila = 3;
	  		addCaption(sheet, 0, fila, "Doc Id",6);
	    	addCaption(sheet, 1, fila, "Contenido",20);
	    	addCaption(sheet, 2, fila, "Cuenta",25);
	    	addCaption(sheet, 3, fila, "Entidad",17);
		    addCaption(sheet, 4, fila, "Fecha",10);
		    addCaption(sheet, 5, fila, "",5);
		    addCaption(sheet, 6, fila, "Debito",11);
		    addCaption(sheet, 7, fila, "Credito",11);
		    addCaption(sheet, 8, fila, "Saldo",11);
		    addCaption(sheet, 9, fila, "",5);
		    addCaption(sheet, 10, fila, "Importe",11);
		    addCaption(sheet, 11, fila, "Saldo",11);
		    addCaption(sheet, 12, fila, "Documento",50);
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
		  boolean grey25 = true;
		  for (EstructuraSaldoForm formRow : getLista()) {
			  //ELIJO EL COLOR QUE VA TENER LA FILA
	      		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	      			if (grey25){
	      				setTexto(Colour.BLACK,Colour.GREY_25_PERCENT);
	      				grey25 = false;
	      			} else {
	      				setTexto(Colour.BLACK,Colour.GREY_40_PERCENT);
	      				grey25 = true;
	      			}
				  
	      		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
	  			  setTexto(Colour.BLACK,Colour.LIGHT_BLUE);
	  			  grey25 = true;
	      		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
      			  setTexto(Colour.BLACK,Colour.AQUA);
	      		}

      		//DOcumento Id
      		if (formRow.getDocumentoId() != null && formRow.getDocumentoId() > 0){
      			addNumber(sheet, 0, row, formRow.getDocumentoId());
      		} else {
      			addLabel(sheet, 0, row, "");
      		}
      		//
      		//Codigo
      		if ( Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
      			addLabel(sheet, 1, row, "");
      			addLabel(sheet, 2, row, formRow.getCuentaNombre());
      		} else {
      			addLabel(sheet, 1, row, formRow.getContenidoNombre());
      			if (StringUtils.isBlank(formRow.getCuentaNombre() )){
      				addLabel(sheet, 2, row, formRow.getMonedaCodigo());
      			} else {
      				addLabel(sheet, 2, row, formRow.getCuentaNombre() + " ( " + formRow.getMonedaCodigo() + " ) ");
      			}
      		}
      		//Entidad
      		addLabel(sheet, 3, row, formRow.getEntidadNombre());
      		
      		//fecha / Si es saldo INI o saldo FIN. Muestro las fechas de búsqueda
      		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
          		addLabel(sheet, 4, row, formRow.getFecha());
      		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
      			addLabel(sheet, 4, row, busqueda.getFechaDesde());
      		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
      			addLabel(sheet, 4, row, busqueda.getFecha());
      		}
      		
      		// MONEDA DEL MOVIMIENTO
      		//moneda
      		addLabel(sheet, 5, row, formRow.getMonedaCodigo());
      		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
      			if (Constants.ZERO.equals(formRow.getDebito())){
	        			//debito
	      				addLabel(sheet, 6, row, " - ");
	        		} else {
	        			//debito
	        			addNumber(sheet, 6, row, ConvertionUtil.DouValueOf(formRow.getDebito()) );
	        		}
	        		if (Constants.ZERO.equals(formRow.getCredito())){
	        			//credito
	        			addLabel(sheet, 7, row, " - ");
	        		} else {
	        			//credito
	        			addNumber(sheet, 7, row, ConvertionUtil.DouValueOf(formRow.getCredito()) );
	        		}
      		} else {
    			addLabel(sheet, 6, row, "");
    			addLabel(sheet, 7, row, "");
      		}
      		// SALDO - Averigua si es menor a ZERO
      		addNumber(sheet, 8, row, ConvertionUtil.DouValueOf(formRow.getSaldo()) );
      		//EXPRESION EN MONEDA
  			//moneda
      		if (StringUtils.isBlank(formRow.getMonedaCodigoMuestra())){
      			addLabel(sheet, 9, row, "");
      			addLabel(sheet, 10, row, "");
      			addLabel(sheet, 11, row, "");
      		} else {
      				addLabel(sheet, 9, row, formRow.getMonedaCodigoMuestra());
	        		//IMPORTE
	        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			if (Constants.ZERO.equals(formRow.getDebitoMuestra())){
		        			//debito
	        				//row.add("-");
		        		} else {
		        			//debito
		        			addNumber(sheet, 10, row, ConvertionUtil.DouValueOf(formRow.getDebitoMuestra()) );
		        		}
		        		if (Constants.ZERO.equals(formRow.getCreditoMuestra())){
		        			//credito
		        			//row.add("-");
		        		} else {
		        			//credito
		        			addNumber(sheet, 10, row, ConvertionUtil.DouValueOf(formRow.getCreditoMuestra()) );
	
		        		}
	        		} else {
	        			addLabel(sheet, 10, row, "");
	        		}
	        		// SALDO - Averigua si es menor a ZERO
	        		addNumber(sheet, 11, row, ConvertionUtil.DouValueOf(formRow.getSaldoMuestra()) );

      		}
      		
      		//Documento o Saldo
      		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
      			addLabel(sheet, 12, row, formRow.getDocumento() + " " + formRow.getTipoDocumentoNombre() +  " - " + formRow.getDocumentoDescripcion());
      		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
      			addLabel(sheet, 12, row, "Saldo Inicial");
      		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
      			addLabel(sheet, 12, row, "Saldo Final");
      		}

			  //Incremento la fila
			  row++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

  	}
  
	public List<EstructuraSaldoForm> getLista() {
		return lista;
	}
	
	public void setLista(List<EstructuraSaldoForm> lista) {
		this.lista = lista;
	}

	public FiltroSaldoEstructura getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(FiltroSaldoEstructura busqueda) {
		this.busqueda = busqueda;
	}
	
	  
} 