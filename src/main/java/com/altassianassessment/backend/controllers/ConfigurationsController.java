package com.altassianassessment.backend.controllers;

import com.altassianassessment.backend.models.Configurations;
import com.altassianassessment.backend.services.ConfigurationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/configurations")
public class ConfigurationsController {

    @Autowired
    private ConfigurationsService configurationsService;

    @GetMapping
    public ResponseEntity<List<Configurations>> getAllConfigurations() {
        return new ResponseEntity<>(configurationsService.getAllConfigurations(),HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public Configurations getConfigurationById(@PathVariable Long id) {
        return configurationsService.getConfigurationById(id);
    }

    @PostMapping
    public ResponseEntity<Configurations> createConfiguration(@RequestBody Configurations configurations) {
        return new ResponseEntity<>(configurationsService.saveConfiguration(configurations),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Configurations updateConfiguration(@PathVariable Long id, @RequestBody Configurations configurations) {
        configurations.setId(id);
        return configurationsService.saveConfiguration(configurations);
    }

    @DeleteMapping("/{id}")
    public void deleteConfiguration(@PathVariable Long id) {
        configurationsService.deleteConfiguration(id);
    }
}
