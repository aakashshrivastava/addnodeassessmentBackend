package com.altassianassessment.backend.services;

import com.altassianassessment.backend.models.Configurations;
import com.altassianassessment.backend.repositories.ConfigurationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationsService {

    @Autowired
    private ConfigurationsRepository configurationsRepository;

    public List<Configurations> getAllConfigurations() {
        return configurationsRepository.findAll();
    }

    public Configurations getConfigurationById(Long id) {
        return configurationsRepository.findById(id).orElse(null);
    }

    public Configurations saveConfiguration(Configurations configurations) {
        return configurationsRepository.save(configurations);
    }

    public void deleteConfiguration(Long id) {
        configurationsRepository.deleteById(id);
    }
}
