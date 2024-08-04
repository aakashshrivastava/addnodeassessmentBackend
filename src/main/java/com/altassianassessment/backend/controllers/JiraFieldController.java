package com.altassianassessment.backend.controllers;

import com.altassianassessment.backend.models.Configuration;
import com.altassianassessment.backend.models.JiraField;
import com.altassianassessment.backend.services.ConfigurationsService;
import com.altassianassessment.backend.services.JiraFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/jiraField")
public class JiraFieldController {

    @Autowired
    private JiraFieldService jiraFieldService;

    @GetMapping
    public ResponseEntity<List<JiraField>> getAllJiraFields() {
        return new ResponseEntity<>(jiraFieldService.getAllDistinctJiraFields(),HttpStatus.OK) ;
    }
}
