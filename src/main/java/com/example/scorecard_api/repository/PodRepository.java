package com.example.scorecard_api.repository;

import com.example.scorecard_api.model.Pod;
import com.example.scorecard_api.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PodRepository extends JpaRepository<Pod, Long> {

    boolean existsByPodName(String podName);

    List<Pod> findAllByStack(Stack stack);

}

