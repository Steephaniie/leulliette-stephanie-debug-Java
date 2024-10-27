package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data to an output source.
 * 
 * Any implementation of this interface is responsible for writing symptoms and
 * their respective counts to a specified output, such as a file. The data is provided
 * as a Map, where each key is a symptom (String), and each value is the occurrence count (Integer).
 * 
 */

public interface ISymptomWriter {

	/**
     * Writes symptoms and their respective counts to an output.
     *
     * @param symptoms a Map containing symptoms as keys and their occurrence counts as values;
     *                 each entry represents a unique symptom and the number of times it occurs
     */

	public void writeSymptoms(Map<String, Integer> symptoms);
}
