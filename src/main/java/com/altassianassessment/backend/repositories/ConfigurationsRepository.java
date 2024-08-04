package com.altassianassessment.backend.repositories;



import com.altassianassessment.backend.models.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationsRepository extends JpaRepository<Configuration, Long> {
}

