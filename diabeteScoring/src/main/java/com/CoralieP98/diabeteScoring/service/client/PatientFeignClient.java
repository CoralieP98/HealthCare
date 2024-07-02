package com.CoralieP98.diabeteScoring.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("patient")
public interface PatientFeignClient {
}
