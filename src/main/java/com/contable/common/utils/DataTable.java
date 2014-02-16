package com.contable.common.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataTable implements Serializable {


	
	private List <List> aaData =new ArrayList<List>();;
	private String sEcho ;
	private String iTotalRecords ;
	private String iTotalDisplayRecords ;


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
