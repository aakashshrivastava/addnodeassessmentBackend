package com.altassianassessment.backend.dataloader;

import com.altassianassessment.backend.models.Configuration;
import com.altassianassessment.backend.models.JiraField;
import com.altassianassessment.backend.repositories.ConfigurationsRepository;
import com.altassianassessment.backend.repositories.JiraFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ConfigurationsRepository configurationsRepository;
    @Autowired
    private JiraFieldRepository jiraFieldRepository;

    @Override
    public void run(String... args) throws Exception {

        JiraField jiraField1 = JiraField.builder().id(1L).jiraField("jiraField1").build();
        JiraField jiraField2 = JiraField.builder().id(2L).jiraField("jiraField2").build();
        JiraField jiraField3 = JiraField.builder().id(3L).jiraField("jiraField3").build();

        jiraFieldRepository.save(jiraField1);
        jiraFieldRepository.save(jiraField2);
        jiraFieldRepository.save(jiraField3);

        Configuration configuration1 = Configuration.builder().id(1L).customField("customField1").jiraField(jiraField1).build();
        Configuration configuration2 = Configuration.builder().id(2L).customField("customField2").jiraField(jiraField2).build();
        Configuration configuration3 = Configuration.builder().id(3L).customField("customField3").jiraField(jiraField3).build();

        configurationsRepository.save(configuration1);
        configurationsRepository.save(configuration2);
        configurationsRepository.save(configuration3);
    }
}
