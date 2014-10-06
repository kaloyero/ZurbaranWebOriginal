package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.beans.FiltroCuentaBean;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.CuentaBusquedaForm;


public class WriteCuentaSaldoExcel extends WriteExcel{
  
  private List<CuentaBusquedaForm> lista = new ArrayList<CuentaBusquedaForm>();
	/*  Fecha Final   */
	private String fechaFin;
	/*  Cuenta Nombre   */
	private String cuentaNombre;  	
	/*  Mostrar en moneda  */
	private boolean mostrarEnMoneda;	
	/*  Filtro por moneda  */
	private boolean filtroMoneda;	

	
  	public void write(List<CuentaBusquedaForm> lista, FiltroCuentaBean busqueda,String cuentaNombre) {
	  	try {
		  		  //Fecha Final
		  		  this.fechaFin = busqueda.getFechaDesde(); 	  			
		  		this.cuentaNombre = cuentaNombre;
		  		  //mostrarEnMoneda
		  		  if (busqueda.getMonedaMuestraId() == null){
		  			mostrarEnMoneda = false;
		  		  } else {
		  			mostrarEnMoneda = true;  
		  		  }
		  		  //Filtro por moneda
		  		  if (busqueda.getMonedaId() == null){
		  			filtroMoneda = false;
		  		  } else {
		  			filtroMoneda = true;  
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
	    try {
	    	getEncabezado(sheet);
	    	
	    	int rowIniti = 6;
	    	
	    	addCaption(sheet, 0, rowIniti, "Cuenta",26);
	    	addCaption(sheet, 1, rowIniti, "Tipo Entidad",26);
	    	addCaption(sheet, 2, rowIniti, "Entidad",26);
	    	addCaption(sheet, 3, rowIniti, "",6);
		    addCaption(sheet, 4, rowIniti, "Saldo",14);
		    if (mostrarEnMoneda){
			    addCaption(sheet, 5, rowIniti, "",6);
			    addCaption(sheet, 6, rowIniti, "Saldo",14);
		    }
	    } catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}


  }
  
  private void getEncabezado(WritableSheet sheet) throws RowsExceededException,WriteException{
  	    	String moneda = "";
  	    	String monedaMostrar = "";
  	    	if (getLista() != null && getLista().size() >= 1){
  	    		moneda = getLista().get(0).getMonedaCodigo() ;
  	    		monedaMostrar = getLista().get(0).getMonedaMostrarCodigo() ;
  	    	}
	    	
	    	addLabel(sheet, 0, 0, "Saldos de Cuenta");

	    	addLabel(sheet, 0, 2, "Cuenta");
	    	if (StringUtils.isNotBlank(cuentaNombre)){
	    		addLabel(sheet, 1, 2, cuentaNombre);
	    	} else {
	    		addLabel(sheet, 1, 2, "Varias");
	    	}
	    	
	    	addLabel(sheet, 0, 3, "Saldos al ");
	    	addLabel(sheet, 1, 3, fechaFin);
	    	if (filtroMoneda){
		    	addLabel(sheet, 0, 4, "Moneda");
		    	addLabel(sheet, 1, 4, moneda);
		    	if (mostrarEnMoneda){
		    		addLabel (sheet, 2, 4, monedaMostrar);
		    	}
	    	} else {
	    		if (mostrarEnMoneda){
			    	addLabel(sheet, 0, 4, "Mostrar en");
			    	addLabel (sheet, 1, 4, monedaMostrar);
	    		}
	    	}
  }
  
  	@Override
  	protected void getListado(WritableSheet sheet) {
	  
	  	try {
		  int row = 7;
		  for (CuentaBusquedaForm form : getLista()) {
			  addLabel (sheet, 0, row, form.getCuentaNombre());
			  addLabel (sheet, 1, row, form.getEntidadNombre());
			  addLabel (sheet, 2, row, form.getTipoEntidadNombre());
			  addLabel (sheet, 3, row, form.getMonedaCodigo());
			  addNumber(sheet,4, row, ConvertionUtil.DouValueOf(form.getSaldo()));
			  if (mostrarEnMoneda){
			  	addLabel (sheet, 5, row, form.getMonedaMostrarCodigo());
			  	addNumber(sheet,6, row, ConvertionUtil.DouValueOf(form.getTotalMostrar()));
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
  
	public List<CuentaBusquedaForm> getLista() {
		return lista;
	}
	
	public void setLista(List<CuentaBusquedaForm> lista) {
		this.lista = lista;
	}
	
	  
} 