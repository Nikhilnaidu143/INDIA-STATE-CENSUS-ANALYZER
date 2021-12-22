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

		stateCensusAnalyzer.readingFromCSV("IndiaStateCensusData.csv");
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
			stateCensusAnalyzer.readingFromCSV("IndiaStateCensus.csv");
		} catch(StateCensusAnalyzerException ex) {
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
			stateCensusAnalyzer.readingFromCSV("IndiaStateCensusWrongData.csv");
		} catch (StateCensusAnalyzerException | IOException e) {
			e.printStackTrace();
		}
	}
}