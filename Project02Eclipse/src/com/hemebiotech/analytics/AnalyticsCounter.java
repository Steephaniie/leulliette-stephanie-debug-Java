package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor
	 * 
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	/**
	 * Returns the list of symptoms contained in the file
	 * 
	 * @return
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Counts the occurrences of each existing symptom
	 * 
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> map = new HashMap<>();

		for (String symptom : symptoms) {

			// If the list does not contain the symptom
			if (!map.containsKey(symptom)) {

				// add the symptom to the list with a value of 1
				map.put(symptom, 1);

			} else {

				// if the symptom is already in the list.
				// find how many times the symptom has already been found
				Integer nombreSymptonDejaTrouve = map.get(symptom);
				// increment its value
				nombreSymptonDejaTrouve++;
				// update the list
				map.put(symptom, nombreSymptonDejaTrouve);
			}
		}

		return map;
	}

	/**
	 * Sorts the list of symptoms and occurrences in alphabetical order
	 * 
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		// Use a TreeMap to sort the map in alphabetical order of keys
		Map<String, Integer> sortedMap = new TreeMap<>(symptoms);

		return sortedMap;
	}

	/**
	 * Writes the result to the output file
	 * 
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
