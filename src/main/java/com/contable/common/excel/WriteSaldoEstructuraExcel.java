package com.contable.common.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.beans.FiltroSaldoEstructura;
import com.contable.common.utils.ConvertionUtil;
import com.contable.form.EstructuraSaldoForm;

@Resource
public class WriteSaldoEstructuraExcel extends WriteExcel{
  
	private List<EstructuraSaldoForm> lista = new ArrayList<EstructuraSaldoForm>();
	private FiltroSaldoEstructura busqueda;
	private boolean mostrarMonedaEn= false;
	private String administracion;
	private String estructura;
	private String monedaEn;

  	public void write(List<EstructuraSaldoForm> lista,FiltroSaldoEstructura busqueda,String administracion,String estructura,String monedaEn) {
	  	try {
	  		//Seteo la busqueda
  			this.busqueda = busqueda;
	  		//Valido si tengo moneda para mostrar 
	  		if (this.busqueda.getMonedaMostrarId() != null 
	  				&& this.busqueda.getMonedaMostrarId() > 0){
	  			mostrarMonedaEn = true;
	  		}
	  		this.administracion = administracion;
	  		this.estructura = estructura;
	  		this.monedaEn = monedaEn;
	  		
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
	  		addCaption(sheet, 0, 1, "Saldos Por Estructura",getEncabezadoTitulo());
	  		addCaption(sheet, 0, 3, "Administracion",getEncabezadoTitulo());
	  		addCaption(sheet, 1, 3, administracion);
	  		addCaption(sheet, 0, 4, "Estructura",getEncabezadoTitulo());
	  		addCaption(sheet, 1, 4, estructura);
	  		addCaption(sheet, 0, 5, "Fecha",getEncabezadoTitulo());
	  		addCaption(sheet, 1, 5, busqueda.getFecha(),getEncabezado());
	  		if (mostrarMonedaEn){
		  		addCaption(sheet, 0, 6, "Moneda",getEncabezadoTitulo());
		  		addCaption(sheet, 1, 6, monedaEn);
	  		}

	  		
	  		//ENCABEZADO DE LA TABLA
	  		fila = 8;
	  		addCaption(sheet, 0, fila, "Contenido",20);
	  		addCaption(sheet, 1, fila, "Cuenta",20);
	  		addCaption(sheet, 2, fila, "Entidad",20);
	  		addCaption(sheet, 3, fila, "Moneda",5);
	  		addCaption(sheet, 4, fila, "Saldo",9);
	  		if (mostrarMonedaEn){
		  		addCaption(sheet, 5, fila, "Moneda",5);
		    	addCaption(sheet, 6, fila, "Saldo",9);
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
		  int row = 9;
//		  boolean entrelineado = true;
		  for (EstructuraSaldoForm formRow : getLista()) {
			  
				setTexto(Colour.BLACK,Colour.WHITE);
				addLabel(sheet, 0, row, formRow.getContenidoNombre());
				addLabel(sheet, 1, row, formRow.getCuentaNombre());
				addLabel(sheet, 2, row, formRow.getEntidadNombre());
				addLabel(sheet, 3, row, formRow.getMonedaCodigo());
				addNumber(sheet, 4, row, ConvertionUtil.DouValueOf(formRow.getSaldo()));
				if (mostrarMonedaEn){
		    		addLabel(sheet, 5, row, formRow.getMonedaCodigoMuestra());
			  		addNumber(sheet, 6, row, ConvertionUtil.DouValueOf(formRow.getSaldoMuestra()));
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