package com.contable.common.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.contable.common.utils.FormatUtil;
import com.contable.form.DocumentoAplicacionForm;
import com.contable.form.DocumentoForm;
import com.contable.form.DocumentoMovimientoForm;
import com.contable.form.DocumentoMovimientoValorPropioForm;
import com.contable.form.DocumentoMovimientoValorTerceForm;


public class WriteDetalleDocumentoExcel extends WriteExcel{
  
  private List<DocumentoForm> lista = new ArrayList<DocumentoForm>();
  
  	public void write(DocumentoForm documento) {

  		
	  	try {

	  		File file = new File(inputFile);
	  	    WorkbookSettings wbSettings = new WorkbookSettings();

	  	    wbSettings.setLocale(new Locale("en", "EN"));

	  	    WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
	  	    /*   DETALLE  */
		  	//Deben estar separados por coma (",")
	  	    String camposDet  = "Administracion,Fecha,Fecha Ingreso,Fecha Vto,Tipo Documento, Numero,Descripción, Tipo Entidad, Entidad, Moneda, Cotizacion, Total Imputaciones,Total Aplicaciones,Total Egreso Valor, Total Ingreso Valor,Total Valor Propio,Total";
	  	    workbook.createSheet("Detalle", 0);
	  	    WritableSheet excelSheet = workbook.getSheet(0);

	  	    //Crea los Titulos
	  	    getTitulos(excelSheet,camposDet.split(","),0);
	  	    //Crea el contenido
			setTexto(Colour.BLACK,Colour.WHITE);
	  	    getListadoDetalle(excelSheet,documento);

	  	  int rowInit = 3;  
	  	  /*  IMPUTACIONES   */
	  	    if (documento.getImputaciones() != null && ! documento.getImputaciones().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Concepto,Cuenta,Tipo Entidad, Entidad, Referencia, Descripción,Cotizacion, Moneda, Importe";
	    	    /*IMPUTACIONES*/
//	    	    workbook.createSheet("Imputaciones", tab);
//	    	    WritableSheet excelSheetTab = workbook.getSheet(tab);
	    	    //Crea los Titulos
	    	    addLabel(excelSheet,1,rowInit,"IMPUTACIONES");
	    	    rowInit++;
	    	    getTitulos(excelSheet,campos.split(","),rowInit);
	    	    rowInit++;
	    	    //Crea el contenido
	    	    rowInit = getListadoImputaciones(excelSheet,documento.getImputaciones(),rowInit);
	    	    //Sumo 1 para siguiente
	    	    rowInit++;
	  	    }
	  	  /*  APLICACIONES   */
	  	    if (documento.getAplicaciones() != null && ! documento.getAplicaciones().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Documento Aplicado,Numero Documento,Numero, Moneda,Importe";
	    	    //Crea los Titulos
	    	    addLabel(excelSheet,1,rowInit,"APLICACIONES");
	    	    rowInit++;
	    	    getTitulos(excelSheet,campos.split(","),rowInit);
	    	    //Crea el contenido
	    	    rowInit = getListadoAplicaciones(excelSheet,documento.getAplicaciones(),rowInit);
	    	    //Sumo 1 para el siguiente.
	    	    rowInit++;
	  	    }
	  	  /*  INGRESO DE VALORES   */
	  	    if (documento.getValoresEgreTerce() != null && ! documento.getValoresEgreTerce().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Banco,Numero,Emisor,Moneda,Importe";

	  	    	//Crea los Titulos
	    	    addLabel(excelSheet,1,rowInit,"INGRESO DE VALORES");
	    	    rowInit++;
	    	    getTitulos(excelSheet,campos.split(","),rowInit);
	    	    //Crea el contenido
	    	    rowInit = getListadoIngresoValores(excelSheet,documento.getValoresIngreTerce(),rowInit);
	    	    //Sumo 1 para el siguiente.
	    	    rowInit++;
	    	}
	  	  /*  EGRESO DE VALORES   */
	  	    if (documento.getValoresIngreTerce() != null && ! documento.getValoresIngreTerce().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Concepto,Cuenta,Tipo de Entidad,Entidad,Descripcion,Cotizacion,Moneda,Importe,Banco,Numero, Fecha Vto";
	    	    
	  	    	//Crea los Titulos
	    	    addLabel(excelSheet,1,rowInit,"EGRESO DE VALORES");
	    	    rowInit++;
	    	    getTitulos(excelSheet,campos.split(","),rowInit);
	    	    //Crea el contenido
	    	    rowInit = getListadoEgresoValores(excelSheet,documento.getValoresEgreTerce(),rowInit);
	    	    //Sumo 1 para el siguiente.
	    	    rowInit++;	    	    
	    	}
	  	  /*   VALORES PROPIOS		*/
	  	    if (documento.getValoresPropio() != null && ! documento.getValoresPropio().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Concepto,Cuenta,Tipo de Entidad,Entidad,Descripcion,Cotizacion,Moneda,Importe,Numero, Beneficiario,Fecha Vto";
	  	    	//Crea los Titulos
	    	    addLabel(excelSheet,1,rowInit,"VALORES PROPIOS");
	    	    rowInit++;
	    	    getTitulos(excelSheet,campos.split(","),rowInit);
	    	    //Crea el contenido
	    	    rowInit = getListadoValoresPropios(excelSheet,documento.getValoresPropio(),rowInit);
	    	    //Sumo 1 para el siguiente.
	    	    rowInit++;	    	    
	  	    }

	  	    workbook.write();
	  	    workbook.close();

	  	
	  	} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

  		
  	}



  @Override
  protected void getTitulos(WritableSheet sheet) {
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

  	protected void getListadoDetalle(WritableSheet sheet, DocumentoForm form ) {
	  	try {
		  addLabel(sheet, 0, 1, form.getAdministracionNombre());
		  addLabel(sheet, 1, 1, form.getFechaReal());
		  addLabel(sheet, 2, 1, form.getFechaIngreso());
		  addLabel(sheet, 3, 1, form.getFechaVencimiento());
		  addLabel(sheet, 4, 1, form.getTipoDocumentoNombre());
		  addLabel(sheet, 5, 1, form.getNumeroFormateado());
		  addLabel(sheet,6, 1, form.getDescripcion());
		  addLabel(sheet, 7, 1, form.getTipoEntidadNombre());
		  addLabel(sheet, 8, 1, form.getEntidadNombre());
		  addLabel(sheet, 9, 1, form.getMonedaCodigo());
		  addNumber(sheet, 10, 1, form.getCotizacion());
		  addLabel(sheet, 11, 1, form.getTotalImputacion());
		  addLabel(sheet, 12, 1, form.getTotalCancelaciones());
		  addLabel(sheet, 13, 1, form.getTotalEgresoValor());
		  addLabel(sheet, 14, 1, form.getTotalIngresoValor());
		  addLabel(sheet, 15, 1, form.getTotalValorPropio());
		  addLabel(sheet, 16, 1, form.getTotalHeader());
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
  	}

  	protected int getListadoImputaciones(WritableSheet sheet, List<DocumentoMovimientoForm> imputaciones,int rowInit) {
	  	try {
		  for (DocumentoMovimientoForm imputacion : imputaciones) {
			  addLabel(sheet, 0, rowInit, imputacion.getConceptoNombre());
			  addLabel(sheet, 1, rowInit, imputacion.getCuentaNombre());
			  addLabel(sheet, 2, rowInit, imputacion.getTipoEntidadNombre());
			  addLabel(sheet, 3, rowInit, imputacion.getEntidadNombre());
			  addLabel(sheet, 4, rowInit, imputacion.getReferencia());
			  addLabel(sheet, 5, rowInit, imputacion.getDescripcion());
			  addNumber(sheet,6, rowInit, imputacion.getCotizacion());
			  addLabel(sheet, 7, rowInit, imputacion.getMonedaCodigo());
			  addLabel(sheet, 8, rowInit, imputacion.getImporte());
			  //Incremento la fila
			  rowInit++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	  	
	  	return rowInit;
  	}

  	protected int getListadoAplicaciones(WritableSheet sheet, List<DocumentoAplicacionForm> aplicaciones,int rowInit) {
	  	try {
		  for (DocumentoAplicacionForm aplicacion : aplicaciones) {
			  addLabel(sheet, 0, rowInit, aplicacion.getTipoDocumentoAplicaNombre());
			  addLabel(sheet, 1, rowInit, aplicacion.getNumeroAplicaText());
			  addNumber(sheet, 2, rowInit, aplicacion.getNumero());
			  addLabel(sheet, 3, rowInit, aplicacion.getMonedaCodigo());
			  addLabel(sheet, 4, rowInit, FormatUtil.format2DecimalsStr(aplicacion.getImporteAplicado()));
			  //Incremento la fila
			  rowInit++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	  	
	  	return rowInit;
  	}

  	protected int getListadoEgresoValores(WritableSheet sheet, List<DocumentoMovimientoValorTerceForm> egresos,int rowInit) {
	  	try {
		  for (DocumentoMovimientoValorTerceForm valor : egresos) {
			  addLabel(sheet, 0, rowInit, valor.getValorTerce().getBancoNombre());
			  addNumber(sheet, 1, rowInit, valor.getValorTerce().getNumero());
			  addLabel(sheet, 2, rowInit, valor.getValorTerce().getEmisor());
			  addLabel(sheet, 3, rowInit, valor.getValorTerce().getMonedaCodigo());
			  addNumber(sheet, 4, rowInit, valor.getValorTerce().getImporte());
			  //Incremento la fila
			  rowInit++;
		  }
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	  	
	  	return rowInit;
  	}
  	
  	protected int getListadoIngresoValores(WritableSheet sheet, List<DocumentoMovimientoValorTerceForm> ingresos,int rowInit) {
	  	try {
		  for (DocumentoMovimientoValorTerceForm valor : ingresos) {
			  addLabel(sheet, 0, rowInit, valor.getConceptoNombre());
			  addLabel(sheet, 1, rowInit, valor.getCuentaNombre());
			  addLabel(sheet, 2, rowInit, valor.getTipoEntidadNombre());
			  addLabel(sheet, 3, rowInit, valor.getEntidadNombre());
			  addLabel(sheet, 4, rowInit, valor.getDescripcion());
			  addNumber(sheet, 5, rowInit, valor.getCotizacion());
			  addLabel(sheet, 6, rowInit, valor.getMonedaCodigo());
			  addLabel(sheet, 7, rowInit, valor.getImporte());
			  addLabel(sheet, 8, rowInit, valor.getValorTerce().getBancoNombre());
			  addNumber(sheet, 9, rowInit, valor.getValorTerce().getNumero());
			  addLabel(sheet, 10, rowInit, valor.getValorTerce().getFechaVencimiento());
			  
			  //Incremento la fila
			  rowInit++;
		  }
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	  	
	  	return rowInit;
  	}
    
  	protected int getListadoValoresPropios(WritableSheet sheet, List<DocumentoMovimientoValorPropioForm> valoresPropios,int rowInit) {
	  	try {
	
		  	for (DocumentoMovimientoValorPropioForm valor : valoresPropios) {
			  addLabel(sheet, 0, rowInit, valor.getConceptoNombre());
			  addLabel(sheet, 1, rowInit, valor.getCuentaNombre());
			  addLabel(sheet, 2, rowInit, valor.getTipoEntidadNombre());
			  addLabel(sheet, 3, rowInit, valor.getEntidadNombre());
			  addLabel(sheet, 4, rowInit, valor.getDescripcion());
			  addNumber(sheet,5, rowInit, valor.getCotizacion());
			  addLabel(sheet, 6, rowInit, valor.getMonedaCodigo());
			  addLabel(sheet, 7, rowInit, valor.getImporte());
			  addNumber(sheet,8, rowInit, valor.getValorPropio().getNumero());
			  addLabel(sheet, 9, rowInit, valor.getValorPropio().getBeneficiario());
			  addLabel(sheet,10, rowInit, valor.getValorPropio().getFechaVencimiento());
			  
			  //Incremento la fila
			  rowInit++;
		  	}
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	  	
	  	return rowInit;
  	}
  	
	public List<DocumentoForm> getLista() {
		return lista;
	}
	
	public void setLista(List<DocumentoForm> lista) {
		this.lista = lista;
	}
	
	  
} 