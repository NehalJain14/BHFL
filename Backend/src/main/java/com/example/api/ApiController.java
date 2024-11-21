package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @Autowired
    private ApiService apiService;

    // POST method to handle input and file
    @PostMapping
    public ResponseEntity<ApiResponse> handlePostRequest(
            @RequestParam List<String> data,
            @RequestParam String fileB64) {
        
        ApiResponse response = apiService.processPostRequest(data, fileB64);
        return ResponseEntity.ok(response);
    }

    // GET method to return the operation code
    @GetMapping
    public ResponseEntity<String> handleGetRequest() {
        return ResponseEntity.ok("{\"operation_code\":1}");
    }
}
