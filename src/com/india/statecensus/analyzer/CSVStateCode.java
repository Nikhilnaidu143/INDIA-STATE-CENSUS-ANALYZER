package com.india.statecensus.analyzer;

public class CSVStateCode {
	/*** Instance Variables. ***/
	public int Sr_no;
	public String State_name;
	public int tin;
	public String StateCode;
	
	/*** Parameterized Constructor. ***/
	public CSVStateCode(int sr_no, String state_name, int tin, String stateCode) {
		this.Sr_no = sr_no;
		this.State_name = state_name;
		this.tin = tin;
		this.StateCode = stateCode;
	}
}
