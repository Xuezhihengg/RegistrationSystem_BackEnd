package com.example.utils;

import java.io.File;

public class FileUtils {

    // Clean and sanitize file name
    public static String cleanFileName(String fileName) {
        if (fileName == null) {
            return null;
        }

        // Remove path elements and invalid characters
        String cleanedFileName = fileName
                .replaceAll("[/\\\\]", "")  // Remove path separators
                .replaceAll("[*\"?:<>|]", "_"); // Replace invalid characters with underscore

        // Trim and remove leading/trailing dots and spaces
        cleanedFileName = cleanedFileName.trim().replaceAll("^\\.*", "").replaceAll("\\.+$", "");

        // Ensure file name is not empty or only dots
        if (cleanedFileName.isEmpty()) {
            cleanedFileName = "unnamed_file";
        }

        return cleanedFileName;
    }
}

