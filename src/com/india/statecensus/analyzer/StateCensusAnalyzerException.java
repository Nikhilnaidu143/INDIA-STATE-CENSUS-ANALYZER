package com.india.statecensus.analyzer;

public class StateCensusAnalyzerException extends Exception{
	
	public enum exception_type {
		NO_SUCH_FILE;
	}
	
	public StateCensusAnalyzerException(String message) {
		super(message);
	}
}
