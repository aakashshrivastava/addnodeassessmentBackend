package com.altassianassessment.backend.controllers;

import com.altassianassessment.backend.models.Configuration;
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
    public ResponseEntity<List<Configuration>> getAllConfigurations() {
        return new ResponseEntity<>(configurationsService.getAllConfigurations(),HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public Configuration getConfigurationById(@PathVariable Long id) {
        return configurationsService.getConfigurationById(id);
    }

    @PostMapping
    public ResponseEntity<Configuration> createConfiguration(@RequestBody Configuration configuration) {
        return new ResponseEntity<>(configurationsService.saveConfiguration(configuration),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Configuration updateConfiguration(@PathVariable Long id, @RequestBody Configuration configuration) {
        configuration.setId(id);
        return configurationsService.saveConfiguration(configuration);
    }

    @DeleteMapping("/{id}")
    public void deleteConfiguration(@PathVariable Long id) {
        configurationsService.deleteConfiguration(id);
    }
}
