package com.altassianassessment.backend.repositories;

import com.altassianassessment.backend.models.JiraField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JiraFieldRepository extends JpaRepository<JiraField, Long> {
    Optional<JiraField> findByJiraField(String jiraField);
}
