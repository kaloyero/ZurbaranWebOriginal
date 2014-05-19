package com.contable.common.excel;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;


public abstract class WriteExcel {

  protected WritableCellFormat timesBoldUnderline;
  protected WritableCellFormat times;
  protected String inputFile;
  
  
  protected abstract void getTitulos(WritableSheet sheet);
  
  protected abstract void getListado(WritableSheet sheet);
  
  public void setOutputFile(String nom) {
	  String ruta = "c:/temp/";
	  String extension = ".xls";
	  
	  String nombre = getNombre(ruta, nom, extension);

	  this.inputFile = ruta + nombre + extension;
  }

  protected void write(String nombreSheet) throws IOException, WriteException {
    File file = new File(inputFile);
    WorkbookSettings wbSettings = new WorkbookSettings();

    wbSettings.setLocale(new Locale("en", "EN"));

    WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
    workbook.createSheet(nombreSheet, 0);
    WritableSheet excelSheet = workbook.getSheet(0);
    //Crea los Titulos
    createLabel(excelSheet);
    //Crea el contenido
    getListado(excelSheet);

    workbook.write();
    workbook.close();
  }

  private void createLabel(WritableSheet sheet)
      throws WriteException {
    // Lets create a times font
    WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
    // Define the cell format
    times = new WritableCellFormat(times10pt);
    // Lets automatically wrap the cells
    times.setWrap(true);

    // create create a bold font with unterlines
    WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, false,
        UnderlineStyle.NO_UNDERLINE);
    timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
   // Lets automatically wrap the cells
    timesBoldUnderline.setWrap(true);

    CellView cv = new CellView();
    cv.setFormat(times);
    cv.setFormat(timesBoldUnderline);
    cv.setAutosize(true);

    // Escribe los titulos
    getTitulos(sheet);

  }

//  private void createContent(WritableSheet sheet) throws WriteException,
//      RowsExceededException {
//    // Write a few number
//    for (int i = 1; i < 10; i++) {
//      // First column
//      addNumber(sheet, 0, i, i + 10);
//      // Second column
//      addNumber(sheet, 1, i, i * i);
//    }
//    // Lets calculate the sum of it
//    StringBuffer buf = new StringBuffer();
//    buf.append("SUM(A2:A10)");
//    Formula f = new Formula(0, 10, buf.toString());
//    sheet.addCell(f);
//    buf = new StringBuffer();
//    buf.append("SUM(B2:B10)");
//    f = new Formula(1, 10, buf.toString());
//    sheet.addCell(f);
//
//    // now a bit of text
//    for (int i = 12; i < 20; i++) {
//      // First column
//      addLabel(sheet, 0, i, "Boring text " + i);
//      // Second column
//      addLabel(sheet, 1, i, "Another text");
//    }
//  }

  protected void addCaption(WritableSheet sheet, int column, int row, String s)
      throws RowsExceededException, WriteException {
    Label label;
    label = new Label(column, row, s, timesBoldUnderline);
    sheet.addCell(label);
  }

  protected void addNumber(WritableSheet sheet, int column, int row,
      Double decimal) throws WriteException, RowsExceededException {

	  if (decimal == null ){
		  decimal = new Double(0.0);
	  }
	  
	  // Lets create a times font
	  WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
	    
	  NumberFormat nf=new NumberFormat("0.00");                   // this format constraints the number upto 3 decimal points
	  WritableCellFormat cf2obj=new WritableCellFormat(nf);
	  cf2obj.setFont(times10pt);
	  
	  Number number;
	  
	  number = new Number(column, row, decimal, cf2obj);
	  sheet.addCell(number);
  }

  protected void addNumber(WritableSheet sheet, int column, int row,
	      Integer integer) throws WriteException, RowsExceededException {
	    Number number;
	    number = new Number(column, row, integer, times);
	    sheet.addCell(number);
  }

  protected void addLabel(WritableSheet sheet, int column, int row, String s)
      throws WriteException, RowsExceededException {
  
	 if (StringUtils.isBlank(s)){
		 s= "";
	 }
	  
	Label label;
    label = new Label(column, row, s, times);
    sheet.addCell(label);
  }

  private String getNombre(String path,String nombre,String extension){
	  
	  String nom = nombre;
	  boolean nombreValido = false;
	  int contador = 1;
	  
	  
	  while (nombreValido == false) {
		  String rutaArchivo = path + nom + extension;
		  File fichero = new File(rutaArchivo);
		  if (fichero.exists()){
			nom = nombre + " ("+ contador +")"; 
		  	contador ++;
		  } else {
			  nombreValido = true;
		  }
	  }
	  
	  return nom;
  }
  
} 