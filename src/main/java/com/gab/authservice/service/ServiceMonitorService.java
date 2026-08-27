package com.gab.authservice.service;

import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.stereotype.Service;

@Service
public class ServiceMonitorService {
    private final HealthEndpoint healthEndpoint;

    public ServiceMonitorService(HealthEndpoint healthEndpoint) {
        this.healthEndpoint = healthEndpoint;
    }

    public String currentServiceStatus() {
        HealthComponent health = healthEndpoint.health();
        return health.getStatus().getCode();
    }
}
