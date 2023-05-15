package com.example.footballclub.service.impl;

// TeamServiceImpl.java

import com.example.footballclub.model.Team;
import com.example.footballclub.repository.TeamRepository;
import com.example.footballclub.service.TeamService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team not found with id: " + id));
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
