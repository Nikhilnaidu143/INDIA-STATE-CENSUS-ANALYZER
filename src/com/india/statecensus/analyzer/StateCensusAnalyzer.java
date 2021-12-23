package com.india.statecensus.analyzer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class StateCensusAnalyzer {

	List<CSVStateCensus> csvStateCensus = new ArrayList<>();
	
	List<CSVStateCode> csvStateCode = new ArrayList<>();

	/*** Reading data from CSV file. ***/
	public void readingFromCSV(String path_for_file)
			throws StateCensusAnalyzerException, IOException, CsvValidationException {
		
		try {
			CSVReader csvReader = new CSVReader(new FileReader(path_for_file));
			if(path_for_file.contains("Census")) {
				String[] data;
				data = csvReader.readNext();
				if (checkingHeader(data) == false) {
					throw new StateCensusAnalyzerException(
							StateCensusAnalyzerException.exception_type.INVALID_HEADER + " OOPS! Header is not correct.");
				} 
				while ((data = csvReader.readNext()) != null) {
					if (data.length != 4) {
						throw new StateCensusAnalyzerException(
								StateCensusAnalyzerException.exception_type.DELIMITER_ISSUE
										+ " OOPS! Delimiter issue is there.");
					} else {
							csvStateCensus.add(new CSVStateCensus(data[0], Long.parseLong(data[1]),
									Integer.parseInt(data[2]), Double.parseDouble(data[3])));
					}
				}
			}
			else if (path_for_file.contains("Code")) {
				String[] record;
				record = csvReader.readNext();
				if (checkingHeaderForStateCode(record) == false) {
					throw new StateCensusAnalyzerException(
							StateCensusAnalyzerException.exception_type.INVALID_HEADER + " OOPS! Header is not correct.");
				} 
				while ((record = csvReader.readNext()) != null) {
					if (record.length != 4) {
						throw new StateCensusAnalyzerException(
								StateCensusAnalyzerException.exception_type.DELIMITER_ISSUE
										+ " OOPS! Delimiter issue is there.");
					} else {
							csvStateCode.add(new CSVStateCode(Integer.parseInt(record[0]), record[1],
									Integer.parseInt(record[2]), record[3]));
					}
				}
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			throw new StateCensusAnalyzerException(
					StateCensusAnalyzerException.exception_type.NO_SUCH_FILE + " OOPS! File not found.");
		} catch (NumberFormatException e) {
			throw new StateCensusAnalyzerException(
					StateCensusAnalyzerException.exception_type.INCORRECT_TYPE + " OOPS! type is not valid.");
		}
	}

	/*** Checking Number of records matching. **/
	public boolean checkingNumOfRecords() {
		if (csvStateCensus.size() == 29) {
			return true;
		} else {
			return false;
		}
	}

	/*** Checking Header is correct or not. ***/
	public boolean checkingHeader(String[] data) {
		if (data[0].compareTo("State") + data[1].compareTo("Population") + data[2].compareTo("AreaInSqKm")
				+ data[3].compareTo("DensityPerSqKm") == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/*** Checking Number of records matching for IndiaStateCode.csv ***/
	public boolean checkingNumOfRecordsForStateCodeCsv() {
		if(csvStateCode.size() == 37) {
			return true;
		} else {
			return false;
		}
	}
	
	/*** Checking Header for IndiaStateCode.csv is correct or not. ***/
	public boolean checkingHeaderForStateCode(String[] record) {
		if (record[0].compareTo("Sr.No") + record[1].compareTo("StateName") + record[2].compareTo("TIN")
				+ record[3].compareTo("StateCode") == 0) {
			return true;
		} else {
			return false;
		}
	}
}