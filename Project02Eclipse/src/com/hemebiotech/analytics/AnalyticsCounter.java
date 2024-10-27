package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor an AnalyticsCounter with a specified symptom reader and writer.
	 * 
	 * @param reader the symptom reader used to retrieve symptoms
	 * @param writer the symptom writer used to output symptom data
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	/**
	 * Retrieves the list of symptoms from the input source.
	 * 
	 * @return a List of symptoms as Strings
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts occurrences of each symptom from a list of symptoms.
	 * 
	 * @param symptoms a List of symptom strings to be counted
	 * @return a Map with each symptom as a key and its occurrence count as the
	 *         value
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountMap = new HashMap<>();

		for (String symptom : symptoms) {

			// If the list does not contain the symptom
			if (!symptomCountMap.containsKey(symptom)) {
				// add the symptom to the list with a value of 1
				symptomCountMap.put(symptom, 1);

			} else {

				// if the symptom is already in the list, icrement its count
				Integer symptonCount = symptomCountMap.get(symptom);
				symptonCount++;
				symptomCountMap.put(symptom, symptonCount);
			}
		}

		return symptomCountMap;
	}

	/**
	 * Sorts the list of symptoms and their occurrences in alphabetical order.
	 * 
	 * @param symptoms a Map of symptoms and their occurrence counts
	 * @returna Map sorted alphabetically by symptom names
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		// TreeMap sorts keys in alphabetical order by default
		Map<String, Integer> sortedMap = new TreeMap<>(symptoms);
		return sortedMap;
	}

	/**
	 * Writes the sorted list of symptoms and their counts to an output source
	 * 
	 * @param symptoms a Map of symptoms and their occurrence counts
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
