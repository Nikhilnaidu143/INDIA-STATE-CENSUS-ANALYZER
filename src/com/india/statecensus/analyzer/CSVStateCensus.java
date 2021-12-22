package com.india.statecensus.analyzer;

public class CSVStateCensus {
	
	/** Instance variables. **/
	public String stateName;
	public long population;
	public int areaInSKM;
	public double densityPSKM;

	/** Parameterized constructor. **/
	public CSVStateCensus(String stateName, long population, int areaInSKM, double densityPSKM) {
		this.stateName = stateName;
		this.population = population;
		this.areaInSKM = areaInSKM;
		this.densityPSKM = densityPSKM;
	}
}
