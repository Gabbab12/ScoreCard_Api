package com.example.scorecard_api.repository;

import com.example.scorecard_api.model.StackTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StackTemplateRepository extends JpaRepository<StackTemplate,Long> {
    StackTemplate findByStackNameIgnoreCase(String stackName);
    boolean existsByStackName(String stackName);
}
