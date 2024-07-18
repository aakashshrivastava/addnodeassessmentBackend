package com.altassianassessment.backend.repositories;



import com.altassianassessment.backend.models.Configurations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {
}

