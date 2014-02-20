package com.contable.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	/**
	 * Recibe un String y devuelve un date  formateado
	 * 
	 * @param d
	 * @return
	 */
	public static Date convertStringToDate (String d){
		
		Date returnDate = null;

		try {
			if (d != null){
				returnDate = formatter.parse(d);	
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("ERROR (DateFormater.java) Error en el parseo de formato ");
		}

		return returnDate;
		
	}
	
	
	/**
	 * Recibe un date y devuelve un String formateado
	 * 
	 * @param d
	 * @return
	 */
	public static String convertDateToString (Date d){
		
		String resultDate = null; 
		if (d != null){
			resultDate = formatter.format(d);
		}

		return resultDate;
		
	}
	
	/**
	 * Recibe un date y devuelve un String formateado con minutos
	 * 
	 * @param d
	 * @return
	 */
	public static String convertDateToStringWithMinutes (Date d){
		
		String resultDate = null; 
		if (d != null){
			resultDate = formatterHour.format(d);
		}

		return resultDate;
		
	}

	/**
	 * Devuelve en formato String la fecha actual
	 * 
	 * @return
	 */
	public static String getStringToday (){
		Date fecha = new Date();
		String resultDate = convertDateToString(fecha);

		return resultDate;
		
	}
	
	
	/**
	 * Toma la fecha actual
	 * 
	 * @return
	 */
	public static Date getDateToday (){
		Date fecha = new Date();
		return fecha;
	}

	public static Date getDateTodayDmyFormat (){
		return  convertStringToDate(getStringToday());	
	}
	
    /**
     * Suma X minutos a una fecha especifica
     * 
     * @param fch
     * @param horas
     * @return
     */
    public static Date sumarMinutos(Date fch, int minutos) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MINUTE, minutos);

        return new Date(cal.getTimeInMillis());
    }
	
    /**
     * Suma X horas a una fecha especifica
     * 
     * @param fch
     * @param horas
     * @return
     */
    public static Date sumarHoras(Date fch, int horas) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.HOUR, horas);

        return new Date(cal.getTimeInMillis());
    }

    /**
     * Suma X dias a una fecha especifica
     * 
     * @param fch
     * @param dias
     * @return
     */
    public static Date sumarDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);

        return new Date(cal.getTimeInMillis());
    }

    
    /**
     * Devuelve el dia de la semana
     * 
     * @param fch
     * @return
     */
    public static int getDiaDeLaSemana(Date fch) {
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTime(fch);
    	return cal.get(Calendar.DAY_OF_WEEK) -1;
    }
    public static String getDiaDeLaSemanaName(Date fch) {
    	 SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated  
    	   return simpleDateformat.format(fch);
    }
 
    public static int getHora(Date fch) {
    	DateFormat hourFormat = new SimpleDateFormat("HH");
    	return Integer.parseInt(hourFormat.format(fch));
    	
    	
    }
    
    
    public static int getMinutes(int hour, int minutes) {
    	return (hour * 60) + minutes;
    }
    
    public static int setHourInfForm(int minutes) {

    	if (minutes == 0){
    		return 0;
    	} else {
    		return minutes / 60;	
    	}
    	
    }
    
    public static int setMinutesInfForm(int minutes) {
    	if (minutes == 0){
    		return 0;
    	} else {
        	return minutes % 60;	
    	}
    }
}
