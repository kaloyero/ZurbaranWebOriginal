package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.DocumentoUtil;
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
	/*  Cuenta Nombre   */
	private String cuentaNombre;
	/*  Entidad Nombre   */
	private String entidadNombre;
	
  	public void write(List<CuentaBusquedaForm> lista, FiltroCuentaBean busqueda, Double saldoInicial, Double saldoInicialMostrarEn,String cuentaNombre,String entidadNombre) {
	  	try {
			  //Inicializo el saldo acumulado
	  		  this.saldoAcumulado = saldoInicial.doubleValue();
	  		  this.saldoAcumuladoMonedaEn = saldoInicialMostrarEn.doubleValue();
	  		  //Fecha inicial
	  		  this.fechaIni = busqueda.getFechaDesde(); 
	  		  //Fecha Final
	  		  this.fechaFin = busqueda.getFechaHasta();
	  		  //Cuenta Nombre
	  		  this.cuentaNombre = cuentaNombre;
	  		  //Entudad Nombre
	  		  this.entidadNombre = entidadNombre;

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
  	    		moneda = getLista().get(0).getMonedaCodigo() ;
  	    		monedaMostrar = getLista().get(0).getMonedaMostrarCodigo() ;
  	    	}
  	    	
  	    	addLabel(sheet, 0, 0, "Resumen");
  	    	addLabel(sheet, 1, 0, "de Cuenta");

  	    	addLabel(sheet, 0, 2, "Cuenta");
	    	if (StringUtils.isNotBlank(cuentaNombre)){
	    		addLabel(sheet, 1, 2, cuentaNombre);
	    	} else {
	    		addLabel(sheet, 1, 2, "Varias");
	    	}
	    	addLabel(sheet, 2, 2, entidadNombre);
	    	
  			addLabel(sheet, 0, 3, "Fecha Inicial");
  			addLabel(sheet, 1, 3, this.fechaIni);
  			addLabel(sheet, 2, 3, "Fecha Final");
  			addLabel(sheet, 3, 3, this.fechaFin);
  			addLabel(sheet, 0, 4, "Moneda");
  			addLabel(sheet, 1, 4, moneda);  			
  			addLabel(sheet, 0, 5, "Saldo Inicial");
  			addLabel(sheet, 1, 5, FormatUtil.format2DecimalsStr(this.saldoAcumulado));
  			addLabel(sheet, 0, 6, "Saldo Final");
			if (mostrarEnMoneda){
				addLabel(sheet, 2, 4, monedaMostrar);
				addLabel(sheet, 2, 5, FormatUtil.format2DecimalsStr(this.saldoAcumuladoMonedaEn));
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
	    	
			addCaption(sheet, 0, initRow, "Fecha Ingreso",9);
			addCaption(sheet, 1, initRow, "Tipo Documento",12);
	    	addCaption(sheet, 2, initRow, "Numero",10);
	    	addCaption(sheet, 3, initRow, "Descripción",12);
	    	addCaption(sheet, 4, initRow, "Referencia",15);
	    	addCaption(sheet, 5, initRow, "Cuenta",12);
	    	addCaption(sheet, 6, initRow, "Tipo Entidad",8);
	    	addCaption(sheet, 7, initRow, "Entidad",10);
	    	addCaption(sheet, 8, initRow, "Estado",8);
	    	addCaption(sheet, 9, initRow, "",4);
	    	addCaption(sheet, 10, initRow, "Importe",10);
		    addCaption(sheet, 11,initRow, "Saldo",10);
    		/* SALDO Mostrar En Moneda*/
    		if (mostrarEnMoneda){
    	    	addCaption(sheet, 12, initRow, "",4);
    	    	addCaption(sheet, 13, initRow, "Cotizacion",8);
    	    	addCaption(sheet, 14, initRow, "Importe",8);
    		    addCaption(sheet, 15,initRow, "Saldo",8);
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
	  		
	  		//Tipo de Letra
	  		setTexto(Colour.BLACK,Colour.WHITE,8);
	  		
		  for (CuentaBusquedaForm form : getLista()) {
			  
			  addLabel(sheet, 0, initRow, form.getFechaIngreso());
			  addLabel(sheet, 1, initRow, form.getTipodocumentoNombre());
			  addLabel(sheet, 2, initRow, form.getNumeroFormateado());
			  addLabel(sheet, 3, initRow, form.getDocDescripcion());
			  
			  addLabel(sheet, 4, initRow, form.getReferencia());
			  addLabel(sheet, 5, initRow, form.getCuentaNombre());
			  addLabel(sheet, 6, initRow, form.getTipoEntidadNombre());
			  addLabel(sheet, 7, initRow, form.getEntidadNombre());
	    		//Devuelvo el estado
			  addLabel(sheet, 8, initRow, DocumentoUtil.getResumenCuentaEstado(form.getEstado(), form.getDocumentoAnuladoPorId(), form.getDocumentoAnulaaId()));
			  addLabel(sheet, 9, initRow, form.getMonedaCodigo());
			  
			  addNumber(sheet, 10, initRow, SaldosUtil.getImporteExcel(form.getDebito(), form.getCredito()));
			  //saldo acumulado
	    	  saldoAcumulado = SaldosUtil.sumar(saldoAcumulado, form.getDebito(), form.getCredito());
			  addNumber(sheet, 11, initRow, saldoAcumulado);
			  
	    		if (mostrarEnMoneda){
		    		/* SALDO Mostrar En Moneda*/
				    addLabel(sheet, 12, initRow, form.getMonedaMostrarCodigo());
		    		/* Cotizacion*/
				    addLabel(sheet, 13, initRow, form.getCotizacion());
				    //Debito - credito
	        		addNumber(sheet, 14, initRow, SaldosUtil.getImporteExcel(form.getDebitoMostrar(),form.getCreditoMostrar()));
	        		//saldo acumulado
	        		saldoAcumuladoMonedaEn = SaldosUtil.sumar(saldoAcumuladoMonedaEn, form.getDebitoMostrar(), form.getCreditoMostrar());
	        		addNumber(sheet, 15, initRow, saldoAcumuladoMonedaEn);
	    		}
			  
			  
			  //Incremento la fila
			  initRow++;
		  }
		  
		  setTexto(Colour.BLACK,Colour.WHITE,8, Border.NONE,BorderLineStyle.NONE);
		  /* Saldo Final*/
		  addLabel(sheet, 1, 6,FormatUtil.format2DecimalsStr(this.saldoAcumulado));
		  if (mostrarEnMoneda){
			  addLabel(sheet, 2, 6,FormatUtil.format2DecimalsStr(this.saldoAcumuladoMonedaEn));
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