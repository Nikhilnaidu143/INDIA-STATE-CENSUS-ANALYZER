package com.india.statecensus.analyzer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.opencsv.exceptions.CsvValidationException;

public class StateCensusAnalyzerTest {

	StateCensusAnalyzer stateCensusAnalyzer;

	@Before
	public void intialize() {
		stateCensusAnalyzer = new StateCensusAnalyzer();
	}

	/***
	 * T.C-1.1 :- Given the States Census CSV file, Check to ensure the Number of
	 * Record matches
	 * 
	 * @throws StateCensusAnalyzerException
	 ***/
	@Test
	public void givenCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue()
			throws CsvValidationException, IOException, StateCensusAnalyzerException {

		stateCensusAnalyzer.readingFromCSV("StateCensusFiles/IndiaStateCensusData.csv");
		assertEquals(true, stateCensusAnalyzer.checkingNumOfRecords());
	}

	/***
	 * T.C-1.2 :- Given the State Census CSV File if incorrect Returns a custom
	 * Exception.
	 * 
	 * @throws IOException
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenCsvFile_IfDoesntExist_ShouldThrowCustomException() throws IOException, CsvValidationException {
		try {
			stateCensusAnalyzer.readingFromCSV("StateCensusFiles/IndiaStateCensus.csv");
		} catch (StateCensusAnalyzerException ex) {
			ex.printStackTrace();
		}
	}

	/***
	 * T.C-1.3 :- Given the State Census CSV File when correct but type incorrect
	 * Returns a custom Exception.
	 * 
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenCsvFile_IfIncorrectType_ShouldThrowCustomException() throws CsvValidationException {
		try {
			stateCensusAnalyzer.readingFromCSV("StateCensusFiles/IndiaStateCensusWrongData.csv");
		} catch (StateCensusAnalyzerException | IOException e) {
			e.printStackTrace();
		}
	}

	/***
	 * T.C-1.4 :- Given the State Census CSV File when correct but delimiter
	 * incorrect Returns a custom Exception.
	 * 
	 * @throws IOException
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenCsvFile_IfThereISDelimiterIssue_ShouldThrowCustomException()
			throws CsvValidationException, IOException {
		
		try {
			stateCensusAnalyzer.readingFromCSV("StateCensusFiles/IndiaStateCensusDataWrongDelimiter.csv");
		} catch (StateCensusAnalyzerException e) {
			e.printStackTrace();
		}
	}

	/***
	 * T.C-1.5 :- Given the State Census CSV File when correct but csv header
	 * incorrect Returns a custom Exception.
	 * 
	 * @throws IOException
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenCsvFile_IfHeaderIsNotCorrect_ShouldThrowCustomException()
			throws CsvValidationException, IOException {
		
		try {
			stateCensusAnalyzer.readingFromCSV("StateCensusFiles/IndiaStateCensusDataWrongHeader.csv");
		} catch (StateCensusAnalyzerException e) {
			e.printStackTrace();
		}
	}
	
	
	/****---------------------------UC-2----------------------------------****/
	
	/***
	 * T.C-2.1 :- Given the States Census CSV file, Check to ensure the Number of
	 * Record matches.
	 * @throws IOException 
	 * @throws StateCensusAnalyzerException 
	 * @throws CsvValidationException 
	 ***/
	@Test
	public void givenStateCodeCsvFile_IfHasCorrectNumOfRecords_ShouldReturnTrue()
			throws CsvValidationException, StateCensusAnalyzerException, IOException {
		
		stateCensusAnalyzer.readingFromCSV("StateCodeFiles/IndiaStateCode.csv");
		assertEquals(true , stateCensusAnalyzer.checkingNumOfRecordsForStateCodeCsv());
	}
	
	/***
	 * T.C-2.2 :- Given the State Census CSV File if incorrect Returns a custom
	 * Exception.
	 * 
	 * @throws IOException
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenStateCodeCsvFile_IfDoesntExist_ShouldThrowCustomException() throws IOException, CsvValidationException {
		try {
			stateCensusAnalyzer.readingFromCSV("StateCodeFiles/IndiaStateCodeData.csv");
		} catch (StateCensusAnalyzerException ex) {
			ex.printStackTrace();
		}
	}
	
	/***
	 * T.C-2.3 :- Given the State Census CSV File when correct but type incorrect
	 * Returns a custom Exception.
	 * 
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenStateCodeCsvFile_IfIncorrectType_ShouldThrowCustomException() throws CsvValidationException {
		try {
			stateCensusAnalyzer.readingFromCSV("StateCodeFiles/IndiaStateCodeWrongData.csv");
		} catch (StateCensusAnalyzerException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * T.C-2.4 :- Given the State Census CSV File when correct but delimiter
	 * incorrect Returns a custom Exception.
	 * 
	 * @throws IOException
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenStateCodeCsvFile_IfThereISDelimiterIssue_ShouldThrowCustomException()
			throws CsvValidationException, IOException {
		
		try {
			stateCensusAnalyzer.readingFromCSV("StateCodeFiles/IndiaStateCodeWrongDelimiter.csv");
		} catch (StateCensusAnalyzerException e) {
			e.printStackTrace();
		}
	}

	/***
	 * T.C-2.5 :- Given the State Census CSV File when correct but csv header
	 * incorrect Returns a custom Exception.
	 * 
	 * @throws IOException
	 * @throws CsvValidationException
	 ***/
	@Test
	public void givenStateCodeCsvFile_IfHeaderIsNotCorrect_ShouldThrowCustomException()
			throws CsvValidationException, IOException {
		
		try {
			stateCensusAnalyzer.readingFromCSV("StateCodeFiles/IndiaStateCodeWrongHeader.csv");
		} catch (StateCensusAnalyzerException e) {
			e.printStackTrace();
		}
	}
}
