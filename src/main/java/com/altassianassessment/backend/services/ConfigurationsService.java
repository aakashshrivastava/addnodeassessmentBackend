package com.altassianassessment.backend.services;

import com.altassianassessment.backend.models.Configuration;
import com.altassianassessment.backend.models.JiraField;
import com.altassianassessment.backend.repositories.ConfigurationsRepository;
import com.altassianassessment.backend.repositories.JiraFieldRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigurationsService {

    @Autowired
    private ConfigurationsRepository configurationsRepository;

    @Autowired
    private JiraFieldRepository jiraFieldRepository;

    public List<Configuration> getAllConfigurations() {
        return configurationsRepository.findAll();
    }

    public Configuration getConfigurationById(Long id) {
        return configurationsRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackOn = Exception.class)
    public Configuration saveConfiguration(Configuration configuration) {
        try {
            Optional<JiraField> jiraFieldOptional = jiraFieldRepository.findByJiraField(configuration.getJiraField().getJiraField());
            if (jiraFieldOptional.isPresent()) {
                configuration.setJiraField(jiraFieldOptional.get());
            } else {
                JiraField jiraField1 = jiraFieldRepository.save(JiraField.builder().jiraField(configuration.getJiraField().getJiraField()).build());
                configuration.setJiraField(jiraField1);
            }
            return configurationsRepository.save(configuration);
        }
        catch(Exception e){
            // Log the exception (optional)
            System.err.println("Exception occurred: " + e.getMessage());
            // Rethrow the exception to trigger rollback
            throw e;
        }
    }

    @Transactional
    public void deleteConfiguration(Long id) {
        configurationsRepository.deleteById(id);
    }
}
