package com.india.statecensus.analyzer;

public class CSVStateCensus {

	/** Private variables. **/
	private String stateName;
	private String population;
	private String areaInSKM;
	private String densityPSKM;

	/** Parameterized constructor. **/
	public CSVStateCensus(String stateName, String population, String areaInSKM, String densityPSKM) {
		super();
		this.stateName = stateName;
		this.population = population;
		this.areaInSKM = areaInSKM;
		this.densityPSKM = densityPSKM;
	}
}
