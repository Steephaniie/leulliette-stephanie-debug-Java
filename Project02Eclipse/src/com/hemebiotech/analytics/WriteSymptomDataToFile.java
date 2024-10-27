package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter that writes symptom data to a specified
 * file.
 * 
 * This class writes each symptom along with its occurrence count to the file
 * provided in the constructor, with one symptom per line in the format:
 * "symptom: count".
 * 
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filepath;

	/**
	 * Constructs a WriteSymptomDataToFile with the specified file path.
	 *
	 * @param filepath the full or partial path to the file where symptom data will
	 *                 be written
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Writes each symptom and its count to the specified file.
	 *
	 * @param symptoms a Map of symptoms and their occurrence counts; each entry is
	 *                 written to the file in the format "symptom: count"
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		// Check if filepath and symptoms map are not null
		if (filepath != null && symptoms != null) {
			// Use FileWriter to write symptoms to the file
			try (FileWriter writer = new FileWriter(filepath)) {
				for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
					writer.write(entry.getKey() + ": " + entry.getValue() + "\n"); // Write each symptom with its count
				}
			} catch (IOException e) {
				e.printStackTrace(); // Handle the IOException if any
			}
		}
	}

}
