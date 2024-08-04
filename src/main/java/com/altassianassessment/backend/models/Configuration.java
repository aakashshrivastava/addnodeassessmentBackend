package com.altassianassessment.backend.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customField;

    @ManyToOne
    @JoinColumn(name = "jira_field_id", referencedColumnName = "id")
    private JiraField jiraField;
}
