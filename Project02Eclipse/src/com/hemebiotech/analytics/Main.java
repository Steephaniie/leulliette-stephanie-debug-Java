package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args)  {

		// Instantiation of reader and writer objects
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		// Instantiation of the AnalyticsCounter object
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		// 1. Read symptoms from the file
		List<String> symptoms = analyticsCounter.getSymptoms();

		// 2. Count the occurrences of symptoms
		Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);

		// 3. Sort symptoms in alphabetical order
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

		// 4. Write the results to the output file
		analyticsCounter.writeSymptoms(sortedSymptoms);

		// Display success message
		System.out.println("Symptoms processing is complete.");
	}
}

	
	
	

