package com.contable.common.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
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
	  	    createLabel(excelSheet,camposDet.split(","));
	  	    //Crea el contenido
	  	    getListadoDetalle(excelSheet,documento);

	  	  int tab = 1;  
	  	  /*  IMPUTACIONES   */
	  	    if (documento.getImputaciones() != null && ! documento.getImputaciones().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Concepto,Cuenta,Tipo Entidad, Entidad, Referencia, Descripción,Cotizacion, Moneda, Importe";
	    	    /*IMPUTACIONES*/
	    	    workbook.createSheet("Imputaciones", tab);
	    	    WritableSheet excelSheetTab = workbook.getSheet(tab);
	    	    //Crea los Titulos
	    	    createLabel(excelSheetTab,campos.split(","));
	    	    //Crea el contenido
	    	    getListadoImputaciones(excelSheetTab,documento.getImputaciones());
	    	    //Sumo 1 para el siguiente tab.
	    	    tab ++;
	  	    }
	  	  /*  APLICACIONES   */
	  	    if (documento.getAplicaciones() != null && ! documento.getAplicaciones().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Documento Aplicado,Numero Documento,Numero, Moneda,Importe";
	    	    /*IMPUTACIONES*/
	    	    workbook.createSheet("Aplicaciones", tab);
	    	    WritableSheet excelSheetTab = workbook.getSheet(tab);
	    	    //Crea los Titulos
	    	    createLabel(excelSheetTab,campos.split(","));
	    	    //Crea el contenido
	    	    getListadoAplicaciones(excelSheetTab,documento.getAplicaciones());
	    	    //Sumo 1 para el siguiente tab.
	    	    tab ++;
	  	    }
	  	  /*  INGRESO DE VALORES   */
	  	    if (documento.getValoresEgreTerce() != null && ! documento.getValoresEgreTerce().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Banco,Numero,Emisor,Moneda,Importe";
	    	    /*IMPUTACIONES*/
	    	    workbook.createSheet("Egreso Valores", tab);
	    	    WritableSheet excelSheetTab = workbook.getSheet(tab);
	    	    //Crea los Titulos
	    	    createLabel(excelSheetTab,campos.split(","));
	    	    //Crea el contenido
	    	    getListadoEgresoValores(excelSheetTab,documento.getValoresEgreTerce());

	    	    
	    	    //Sumo 1 para el siguiente tab.
	    	    tab ++;
	    	}
	  	  /*  EGRESO DE VALORES   */
	  	    if (documento.getValoresIngreTerce() != null && ! documento.getValoresIngreTerce().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Concepto,Cuenta,Tipo de Entidad,Entidad,Descripcion,Cotizacion,Moneda,Importe,Banco,Numero, Fecha Vto";
	    	    /*IMPUTACIONES*/
	    	    workbook.createSheet("Ingreso Valores", tab);
	    	    WritableSheet excelSheetTab = workbook.getSheet(tab);
	    	    //Crea los Titulos
	    	    createLabel(excelSheetTab,campos.split(","));
	    	    //Crea el contenido
	    	    getListadoIngresoValores(excelSheetTab,documento.getValoresIngreTerce());
	    	    //Sumo 1 para el siguiente tab.
	    	    tab ++;
	    	}
	  	  /*   VALORES PROPIOS		*/
	  	    if (documento.getValoresPropio() != null && ! documento.getValoresPropio().isEmpty()){
	  		  	//Deben estar separados por coma (",")
	  	    	String campos  = "Concepto,Cuenta,Tipo de Entidad,Entidad,Descripcion,Cotizacion,Moneda,Importe,Numero, Beneficiario,Fecha Vto";
	    	    /*IMPUTACIONES*/
	    	    workbook.createSheet("Valores Propios", tab);
	    	    WritableSheet excelSheetTab = workbook.getSheet(tab);
	    	    //Crea los Titulos
	    	    createLabel(excelSheetTab,campos.split(","));
	    	    //Crea el contenido
	    	    getListadoValoresPropios(excelSheetTab,documento.getValoresPropio());
	    	    //Sumo 1 para el siguiente tab.
	    	    tab ++;
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

  	protected void getListadoImputaciones(WritableSheet sheet, List<DocumentoMovimientoForm> imputaciones) {
	  	try {
		  int row = 1;
		  for (DocumentoMovimientoForm imputacion : imputaciones) {
			  addLabel(sheet, 0, row, imputacion.getConceptoNombre());
			  addLabel(sheet, 1, row, imputacion.getCuentaNombre());
			  addLabel(sheet, 2, row, imputacion.getTipoEntidadNombre());
			  addLabel(sheet, 3, row, imputacion.getEntidadNombre());
			  addLabel(sheet, 4, row, imputacion.getReferencia());
			  addLabel(sheet, 5, row, imputacion.getDescripcion());
			  addNumber(sheet,6, row, imputacion.getCotizacion());
			  addLabel(sheet, 7, row, imputacion.getMonedaCodigo());
			  addLabel(sheet, 8, row, imputacion.getImporte());
			  //Incremento la fila
			  row++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
  	}

  	protected void getListadoAplicaciones(WritableSheet sheet, List<DocumentoAplicacionForm> aplicaciones) {
	  	try {
		  int row = 1;
		  
		  for (DocumentoAplicacionForm aplicacion : aplicaciones) {
			  addLabel(sheet, 0, row, aplicacion.getTipoDocumentoAplicaNombre());
			  addLabel(sheet, 1, row, aplicacion.getNumeroAplicaText());
			  addNumber(sheet, 2, row, aplicacion.getNumero());
			  addLabel(sheet, 3, row, aplicacion.getMonedaCodigo());
			  addLabel(sheet, 4, row, FormatUtil.format2DecimalsStr(aplicacion.getImporteAplicado()));
			  //Incremento la fila
			  row++;
		  }

		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
  	}

  	protected void getListadoEgresoValores(WritableSheet sheet, List<DocumentoMovimientoValorTerceForm> egresos) {
	  	try {
		  int row = 1;
		  for (DocumentoMovimientoValorTerceForm valor : egresos) {
			  addLabel(sheet, 0, row, valor.getValorTerce().getBancoNombre());
			  addNumber(sheet, 1, row, valor.getValorTerce().getNumero());
			  addLabel(sheet, 2, row, valor.getValorTerce().getEmisor());
			  addLabel(sheet, 3, row, valor.getValorTerce().getMonedaCodigo());
			  addNumber(sheet, 4, row, valor.getValorTerce().getImporte());
			  //Incremento la fila
			  row++;
		  }
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
  	}
  	
  	protected void getListadoIngresoValores(WritableSheet sheet, List<DocumentoMovimientoValorTerceForm> ingresos) {
	  	try {
		  int row = 1;
		  for (DocumentoMovimientoValorTerceForm valor : ingresos) {
			  addLabel(sheet, 0, row, valor.getConceptoNombre());
			  addLabel(sheet, 1, row, valor.getCuentaNombre());
			  addLabel(sheet, 2, row, valor.getTipoEntidadNombre());
			  addLabel(sheet, 3, row, valor.getEntidadNombre());
			  addLabel(sheet, 4, row, valor.getDescripcion());
			  addNumber(sheet, 5, row, valor.getCotizacion());
			  addLabel(sheet, 6, row, valor.getMonedaCodigo());
			  addLabel(sheet, 7, row, valor.getImporte());
			  addLabel(sheet, 8, row, valor.getValorTerce().getBancoNombre());
			  addNumber(sheet, 9, row, valor.getValorTerce().getNumero());
			  addLabel(sheet, 10, row, valor.getValorTerce().getFechaVencimiento());
			  
			  //Incremento la fila
			  row++;
		  }
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
  	}
    
  	protected void getListadoValoresPropios(WritableSheet sheet, List<DocumentoMovimientoValorPropioForm> valoresPropios) {
	  	try {
		  int row = 1;
	
		  	for (DocumentoMovimientoValorPropioForm valor : valoresPropios) {
			  addLabel(sheet, 0, row, valor.getConceptoNombre());
			  addLabel(sheet, 1, row, valor.getCuentaNombre());
			  addLabel(sheet, 2, row, valor.getTipoEntidadNombre());
			  addLabel(sheet, 3, row, valor.getEntidadNombre());
			  addLabel(sheet, 4, row, valor.getDescripcion());
			  addNumber(sheet,5, row, valor.getCotizacion());
			  addLabel(sheet, 6, row, valor.getMonedaCodigo());
			  addLabel(sheet, 7, row, valor.getImporte());
			  addNumber(sheet,8, row, valor.getValorPropio().getNumero());
			  addLabel(sheet, 9, row, valor.getValorPropio().getBeneficiario());
			  addLabel(sheet,10, row, valor.getValorPropio().getFechaVencimiento());
			  
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