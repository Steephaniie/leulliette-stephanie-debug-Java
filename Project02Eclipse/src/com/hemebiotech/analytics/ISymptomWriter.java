package com.hemebiotech.analytics;

import java.util.Map;


public interface ISymptomWriter {

	/**
	 * writes symptoms and their quantities to a file
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
