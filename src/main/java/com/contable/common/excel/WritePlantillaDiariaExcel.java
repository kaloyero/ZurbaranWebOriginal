package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;

import com.contable.common.beans.FiltroSaldoEstructura;
import com.contable.common.constants.Constants;
import com.contable.common.utils.ConvertionUtil;
import com.contable.common.utils.DateUtil;
import com.contable.form.EstructuraSaldoForm;
import com.contable.hibernate.model.DocumentoAplicaciones_V;

@Resource
public class WritePlantillaDiariaExcel extends WriteExcel{
  
	private List<EstructuraSaldoForm> lista = new ArrayList<EstructuraSaldoForm>();
	private FiltroSaldoEstructura busqueda;
	private Map<Integer,List<DocumentoAplicaciones_V>> listadoAplicaciones;
	private boolean mostrarMonedaEn= false;

  	public void write(List<EstructuraSaldoForm> lista,FiltroSaldoEstructura busqueda,Map<Integer,List<DocumentoAplicaciones_V>> listadoAplicaciones) {
	  	try {
	  		//Seteo el listado de aplicaciones;
	  		this.listadoAplicaciones= listadoAplicaciones; 
	  		//Seteo la busqueda
  			this.busqueda = busqueda;
	  		//Valido si tengo moneda para mostrar 
	  		if (this.busqueda.getMonedaMostrarId() != null 
	  				&& this.busqueda.getMonedaMostrarId() > 0){
	  			mostrarMonedaEn = true;
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
	  		addCaption(sheet, 0, fila, "Doc Id",5);
	  		if (mostrarMonedaEn){
		  		addCaption(sheet, 1, fila, "Contenido",15);
		    	addCaption(sheet, 2, fila, "Cuenta",18);
		    	addCaption(sheet, 3, fila, "Entidad",15);
	  		} else {
		  		addCaption(sheet, 1, fila, "Contenido",18);
		    	addCaption(sheet, 2, fila, "Cuenta",19);
		    	addCaption(sheet, 3, fila, "Entidad",19);
	  		}
		    addCaption(sheet, 4, fila, "Fecha",9);
		    addCaption(sheet, 5, fila, "",4);
		    addCaption(sheet, 6, fila, "Importe",8);
		    addCaption(sheet, 7, fila, "Saldo",8);
		    if (mostrarMonedaEn){
		    	addCaption(sheet, 8, fila, "",4);
			    addCaption(sheet, 9, fila, "Importe",8);
			    addCaption(sheet, 10, fila, "Saldo",8);
			    addCaption(sheet, 11, fila, "Documento",15);
			    addCaption(sheet, 12, fila, "Referencia",15);
		    } else {
		    	addCaption(sheet, 8, fila, "Documento",20);	
		    	addCaption(sheet, 9, fila, "Descripción",20);
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
		  int row = 4;
//		  boolean entrelineado = true;
		  for (EstructuraSaldoForm formRow : getLista()) {
			  //ELIJO EL COLOR QUE VA TENER LA FILA
	      		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
//	      			if (entrelineado){
	      				setTexto(Colour.BLACK,Colour.WHITE);
//	      				entrelineado = false;
//	      			} else {
//	      				setTexto(Colour.BLACK,Colour.GREY_40_PERCENT);
//	      				entrelineado = true;
//	      			}
				  
	      		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
	  			  setTexto(Colour.BLACK,Colour.GREY_25_PERCENT);
//	  			  entrelineado = true;
	      		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
      			  setTexto(Colour.BLACK,Colour.GREY_40_PERCENT,Border.BOTTOM,BorderLineStyle.DOUBLE);
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
//      				addLabel(sheet, 2, row, formRow.getMonedaCodigo());
      				addLabel(sheet, 2, row, "");
      			} else {
//      				addLabel(sheet, 2, row, formRow.getCuentaNombre() + " ( " + formRow.getMonedaCodigo() + " ) ");
      				addLabel(sheet, 2, row, formRow.getCuentaNombre() );
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
      				Double importe = 0.0; 
      				if ( ! Constants.ZERO.equals(formRow.getDebito())){
	        			//debito
      					importe = ConvertionUtil.DouValueOf(formRow.getDebito()) ;
	        		}
	        		if ( ! Constants.ZERO.equals(formRow.getCredito())){
	        			//credito (lo multiplico por -1 para que sea negativo)
	        			importe = (ConvertionUtil.DouValueOf(formRow.getCredito()) * -1) ;
	        		}
	        		//AGREGO IMPORTE
	        		addNumber(sheet, 6, row, importe );
      		} else {
    			addLabel(sheet, 6, row, "");
      		}
      		// SALDO - Averigua si es menor a ZERO
      		addNumber(sheet, 7, row, ConvertionUtil.DouValueOf(formRow.getSaldo()) );
      		//EXPRESION EN MONEDA
  			//moneda
      		if (mostrarMonedaEn){
      				addLabel(sheet, 8, row, formRow.getMonedaCodigoMuestra());
	        		//IMPORTE
	        		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
	        			Double importe = 0.0; 
	        			if (Constants.ZERO.equals(formRow.getDebitoMuestra())){
		        			//debito
	        				//row.add("-");
		        		} else {
		        			//debito
		        			importe = ConvertionUtil.DouValueOf(formRow.getDebitoMuestra()) ;
		        		}
		        		if (Constants.ZERO.equals(formRow.getCreditoMuestra())){
		        			//credito
		        			//row.add("-");
		        		} else {
		        			//credito (lo multiplico por -1 para que sea negativo)
		        			importe = ConvertionUtil.DouValueOf("-"+formRow.getCreditoMuestra()) ;
		        		}
		        		//AGREGO IMPORTE
		        		addNumber(sheet, 9, row, importe );
	        		} else {
	        			addLabel(sheet, 9, row, "");
	        		}
	        		// SALDO - Averigua si es menor a ZERO
	        		addNumber(sheet, 10, row, ConvertionUtil.DouValueOf(formRow.getSaldoMuestra()) );

	        		//CAMPO DESCRIPCION
	        		agregarDescripcion(sheet, 11, row, formRow);
	        		//CAMPO REFERENCIA
	        		agregarReferencia(sheet, 12, row, formRow);
      		} else {
      			//CAMPO DESCRIPCION
      			agregarDescripcion(sheet, 8, row, formRow);
      			//CAMPO REFERENCIA
      			agregarReferencia(sheet, 9, row, formRow);
      		}

		  //Incremento la fila
		  row++;
      		
			/* AGREGA REGISTRO PARA DOCUMENTOS APLICADOS */
			if (formRow.isAplicacionesEnDocumento()){
				List<DocumentoAplicaciones_V> documentosAplicados= listadoAplicaciones.get(formRow.getDocumentoId()) ;
				for (DocumentoAplicaciones_V docApl : documentosAplicados) {
					addNumber(sheet, 0, row, docApl.getDocumentoAplicaId());
					addLabel(sheet, 1, row, "");
					addLabel(sheet, 2, row, "");
					addLabel(sheet, 3, row, "");
					addLabel(sheet, 4, row, "");
					addLabel(sheet, 5, row, "");
					addLabel(sheet, 6, row, "");
					addLabel(sheet, 7, row, "");
					if (mostrarMonedaEn){
						addLabel(sheet, 8, row, "");
						addLabel(sheet, 9, row, "");
						addLabel(sheet, 10, row, "");
						addLabel(sheet, 11, row, docApl.getTipoDocumentoAplicadoNombre() + " " +docApl.getNumeroFormateadoAplicacion());
						addLabel(sheet, 12, row, DateUtil.convertDateToString(docApl.getFechaIngresoDocumentoAplicado()) +" " + docApl.getDocumentoAplicaDescripcion());
					} else {
						addLabel(sheet, 8, row, docApl.getTipoDocumentoAplicadoNombre() + " " +docApl.getNumeroFormateadoAplicacion());
						addLabel(sheet, 9, row, DateUtil.convertDateToString(docApl.getFechaIngresoDocumentoAplicado()) +" " + docApl.getDocumentoAplicaDescripcion());
					}

					//Incremento la fila
					  row++;

					
				}
			}
      		
		  }

	//	  testColours(sheet);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

  	}
  
  	private void agregarDescripcion(WritableSheet sheet,int column, int row,EstructuraSaldoForm formRow) throws RowsExceededException, WriteException{
  		//Documento o Saldo
  		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
  			addLabel(sheet, column, row, formRow.getTipoDocumentoNombre()+ " " + formRow.getDocumento() );
  		} else if (Constants.ESTRUCTURA_MOV_SALDO_INICIAL.equals(formRow.getCodigo())){
  			addLabel(sheet, column, row, "Saldo Inicial");
  		} else if (Constants.ESTRUCTURA_MOV_SALDO_FINAL.equals(formRow.getCodigo())){
  			addLabel(sheet, column, row, "Saldo Final");
  		}
  	}
 
 	private void agregarReferencia(WritableSheet sheet,int column, int row,EstructuraSaldoForm formRow) throws RowsExceededException, WriteException{
  		//REFERENCIA
  		if (Constants.ESTRUCTURA_MOV_SALDO_MOVIMINETO.equals(formRow.getCodigo())){
  			String campo = "";
  			if (StringUtils.isBlank(formRow.getDocumentoDescripcion())){
  				campo = formRow.getReferencia();
  			} else{
  	  			if (StringUtils.isBlank(formRow.getReferencia())){
  	  				campo = formRow.getDocumentoDescripcion();
  	  			} else {
  	  				campo = formRow.getDocumentoDescripcion() + " / " + formRow.getReferencia();
  	  			}
  				
  			}
  			
  			addLabel(sheet, column, row, campo);
  		} else {
  			addLabel(sheet, column, row, "");
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