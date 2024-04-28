package com.vitek.javalabs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitek.javalabs.service.RequestCounterService;

@RestController
@RequestMapping("/stats")
public class RequestStatsController {

    private RequestCounterService requestCounterService;

    public RequestStatsController(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @GetMapping
    public ResponseEntity<Integer> getRequestStats() {
        return ResponseEntity.ok(requestCounterService.getCount());
    }
}
