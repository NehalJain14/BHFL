package com.example.api;

import java.util.List;

public class ApiResponse {

    private boolean isSuccess;
    private String userId;
    private String email;
    private String rollNumber;
    private List<String> numbers;
    private List<String> alphabets;
    private String highestLowercaseAlphabet;
    private boolean isPrimeFound;
    private FileInfo file;

    public ApiResponse(boolean isSuccess, String userId, String email, String rollNumber,
                       List<String> numbers, List<String> alphabets, String highestLowercaseAlphabet,
                       boolean isPrimeFound, FileInfo file) {
        this.isSuccess = isSuccess;
        this.userId = userId;
        this.email = email;
        this.rollNumber = rollNumber;
        this.numbers = numbers;
        this.alphabets = alphabets;
        this.highestLowercaseAlphabet = highestLowercaseAlphabet;
        this.isPrimeFound = isPrimeFound;
        this.file = file;
    }

    // Getters and Setters
    // ...
}

class FileInfo {
    private boolean fileValid;
    private String fileMimeType;
    private long fileSizeKB;

    public FileInfo(boolean fileValid, String fileMimeType, long fileSizeKB) {
        this.fileValid = fileValid;
        this.fileMimeType = fileMimeType;
        this.fileSizeKB = fileSizeKB;
    }

    // Getters and Setters
    // ...
}
