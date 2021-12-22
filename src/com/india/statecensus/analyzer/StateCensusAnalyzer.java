package com.india.statecensus.analyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class StateCensusAnalyzer {
	
	List<CSVStateCensus> csvStateCensus = new ArrayList<>();
	
	public void readingFromCSV(String path_for_file) throws StateCensusAnalyzerException, IOException {
		CSVReader csvReader;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path_for_file));
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				String[] data = line.split(",");
				csvStateCensus.add(new CSVStateCensus(data[0],data[1],data[2],data[3]));
			}
			
		} catch (FileNotFoundException e) {
			throw new StateCensusAnalyzerException(StateCensusAnalyzerException.exception_type.NO_SUCH_FILE + " OOPS! File not found.");
		} 
	}
	
	/*** Checking Number of records matching. **/
	public boolean checkingNumOfRecords() {
		if(csvStateCensus.size() == 30) {
			return true;
		}
		else {
			return false;		
		}
	}
}