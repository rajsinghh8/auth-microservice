package com.gab.authservice.controller;

import com.gab.authservice.service.ServiceMonitorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/monitor")
public class ServiceMonitorController {
    private final ServiceMonitorService serviceMonitorService;

    public ServiceMonitorController(ServiceMonitorService serviceMonitorService) {
        this.serviceMonitorService = serviceMonitorService;
    }

    @GetMapping("/services")
    public ResponseEntity<Map<String, String>> monitorServices() {
        return ResponseEntity.ok(Map.of("status", serviceMonitorService.currentServiceStatus()));
    }
}
