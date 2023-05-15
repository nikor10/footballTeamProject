package com.example.footballclub.repository;

// PlayerRepository.java

import com.example.footballclub.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}

