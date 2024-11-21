package com.example.api;


import org.springframework.stereotype.Service;
import org.apache.tika.Tika;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ApiService {

    // Prime number check
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Find the highest lowercase alphabet from the array
    public String highestLowercaseAlphabet(List<String> alphabets) {
        return alphabets.stream()
                .filter(c -> c.length() == 1 && Character.isLowerCase(c.charAt(0)))
                .max(String::compareTo)
                .orElse("");
    }

    // Base64 decoding of file and validate it
    public FileInfo decodeAndValidateFile(String fileB64) {
        if (fileB64 == null || fileB64.isEmpty()) {
            return new FileInfo(false, "", 0);
        }

        // Here we would decode the Base64 string and analyze the file
        byte[] decodedFile = Base64.getDecoder().decode(fileB64);

        // For simplicity, let's assume the file is an image (add MIME and file size logic here)
        String mimeType = new Tika().detect(decodedFile);
        long fileSizeKB = decodedFile.length / 1024;

        boolean isValid = mimeType.startsWith("image"); // Check for valid image MIME type

        return new FileInfo(isValid, mimeType, fileSizeKB);
    }

    // Process POST request
    public ApiResponse processPostRequest(List<String> data, String fileB64) {

        // Extract numbers and alphabets
        List<String> numbers = data.stream()
                .filter(s -> s.matches("\\d+"))
                .collect(Collectors.toList());

        List<String> alphabets = data.stream()
                .filter(s -> s.matches("[a-zA-Z]"))
                .collect(Collectors.toList());

        // Check if there is any prime number
        boolean isPrimeFound = numbers.stream()
                .map(Integer::parseInt)
                .anyMatch(this::isPrime);

        // Get highest lowercase alphabet
        String highestLowercase = highestLowercaseAlphabet(alphabets);

        // Decode and validate file from Base64 string
        FileInfo fileInfo = decodeAndValidateFile(fileB64);

        // User id (hardcoded)
        String userId = "john_doe_17091999";

        // Build response object
        return new ApiResponse(
                true, userId, "john@xyz.com", "ABCD123",
                numbers, alphabets, highestLowercase, isPrimeFound,
                fileInfo);
    }
}
