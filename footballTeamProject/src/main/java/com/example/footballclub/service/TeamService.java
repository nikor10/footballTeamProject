package com.example.footballclub.service;

// TeamService.java

import com.example.footballclub.model.Team;

import java.util.List;

public interface TeamService {
    Team getTeamById(Long id);
    List<Team> getAllTeams();
    Team saveTeam(Team team);
    void deleteTeam(Long id);
}

