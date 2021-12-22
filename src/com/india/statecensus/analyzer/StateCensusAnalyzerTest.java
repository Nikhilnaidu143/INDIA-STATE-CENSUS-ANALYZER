package com.india.statecensus.analyzer;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	public void givenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue()
			throws CsvValidationException, IOException, StateCensusAnalyzerException {

		stateCensusAnalyzer.readingFromCSV("IndiaStateCensusData.csv");
		assertEquals(true, stateCensusAnalyzer.checkingNumOfRecords());
	}

	/***
	 * T.C-1.2 :- Given the State Census CSV File if incorrect Returns a custom
	 * Exception.
	 * @throws IOException 
	 ***/
	@Test
	public void givenCsvFile_IfDoesntExist_ShouldThrowStateCensusAnalyserException() throws IOException {
		try {
			stateCensusAnalyzer.readingFromCSV("IndiaStateCensus.csv");
		} catch(StateCensusAnalyzerException ex) {
			ex.printStackTrace();
		}
	}
}