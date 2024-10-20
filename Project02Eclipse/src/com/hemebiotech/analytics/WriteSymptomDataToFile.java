package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

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
