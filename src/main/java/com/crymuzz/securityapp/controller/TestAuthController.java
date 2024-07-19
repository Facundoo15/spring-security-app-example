package com.crymuzz.securityapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class TestAuthController {


    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("GET request received successfully!");
    }

    @PostMapping("/postMessage")
    public ResponseEntity<String> postMessage() {
        return ResponseEntity.ok("POST request received successfully!");
    }

    @PutMapping("/putMessage")
    public ResponseEntity<String> putMessage() {
        return ResponseEntity.ok("PUT request received successfully!");
    }

    @DeleteMapping("/deleteMessage")
    public ResponseEntity<String> deleteMessage() {
        return ResponseEntity.ok("DELETE request received successfully!");
    }

}
