package com.CoralieP98.Service.Client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("patient")
public interface PatientFeignClient {
}
