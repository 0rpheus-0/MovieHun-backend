package com.vitek.javalabs.controller;

import com.vitek.javalabs.Inform;
import com.vitek.javalabs.service.InformService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class FirstController {
    private final InformService informService;

    public FirstController(InformService informService) {
        this.informService = informService;
    }

    @GetMapping(value = "/movie/{name}", produces = "application/json")
    public Inform movieName(@PathVariable(name = "name") String name) {
        return informService.informName(name);
    }

    @GetMapping(value = "/movie", produces = "application/json")
    public Inform movieEmpty() {
        return informService.informEmpty();
    }
}
