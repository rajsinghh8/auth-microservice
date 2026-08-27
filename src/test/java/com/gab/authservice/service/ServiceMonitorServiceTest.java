package com.gab.authservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceMonitorServiceTest {

    @Mock
    private HealthEndpoint healthEndpoint;

    @InjectMocks
    private ServiceMonitorService serviceMonitorService;

    @Test
    void currentServiceStatus_returnsCurrentHealthStatus() {
        when(healthEndpoint.health()).thenReturn(Health.up().build());

        assertEquals("UP", serviceMonitorService.currentServiceStatus());
    }
}
