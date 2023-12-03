package com.example.demoLogs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@Slf4j
public class MyController {

    @GetMapping("/info")
    public ResponseEntity<?> logInfo() {
        log.info("Esto es un log tipo info.");
        return ResponseEntity.ok("Esto es un log tipo info.");
    }

    @GetMapping("/error")
    public ResponseEntity<?> logError() {
        log.error("Esto es un log tipo error.");
        return ResponseEntity.ok("Esto es un log tipo error.");
    }

    @GetMapping("/debug")
    public ResponseEntity<?> logDebug() {
        log.debug("Esto es un log tipo debug.");
        return ResponseEntity.ok("Esto es un log tipo debug.");
    }
}
