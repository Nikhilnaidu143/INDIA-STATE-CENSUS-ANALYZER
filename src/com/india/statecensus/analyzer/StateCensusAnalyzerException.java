package com.india.statecensus.analyzer;

public class StateCensusAnalyzerException extends Exception{
	
	/*** enum ***/
	public enum exception_type {
		NO_SUCH_FILE,
		INCORRECT_TYPE,
		DELIMITER_ISSUE,
		INVALID_HEADER;
	}
	
	public StateCensusAnalyzerException(String message) {
		super(message);
	}
}
