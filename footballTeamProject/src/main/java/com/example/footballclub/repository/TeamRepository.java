package com.example.footballclub.repository;

// TeamRepository.java

import com.example.footballclub.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}

