package com.altassianassessment.backend.services;

import com.altassianassessment.backend.models.Configuration;
import com.altassianassessment.backend.models.JiraField;
import com.altassianassessment.backend.repositories.ConfigurationsRepository;
import com.altassianassessment.backend.repositories.JiraFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JiraFieldService {

    @Autowired
    private JiraFieldRepository jiraFieldRepository;

    public List<JiraField> getAllDistinctJiraFields() {
        return jiraFieldRepository.findAll();
    }
}
