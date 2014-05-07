package com.contable.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataTable implements Serializable {


	private static final long serialVersionUID = 1L;

	private List <List> aaData =new ArrayList<List>();;

	public static final String PARAM_S_SEARCH = "sSearch";
	
	public static final String PARAM_I_DISPLAY_START = "iDisplayStart";
	
	public static final String PARAM_I_DISPLAY_LENGTH = "iDisplayLength";

	private String sEcho;
	private String iTotalRecords ;
	private String iTotalDisplayRecords ;


	
	public void setTotals(int total,int totalDisplay,int echo){
        this.sEcho =ConvertionUtil.StrValueOf(echo);
        this.iTotalDisplayRecords =ConvertionUtil.StrValueOf(totalDisplay);
        this.iTotalRecords =ConvertionUtil.StrValueOf(total);
	}
	
	
	public List<List> getAaData() {
		return aaData;
	}

	public void setAaData(List<List> aaData) {
		this.aaData = aaData;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(String iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public String getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(String iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	
	
}
