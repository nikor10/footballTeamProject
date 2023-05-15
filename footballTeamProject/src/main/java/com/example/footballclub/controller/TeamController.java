package com.example.footballclub.controller;

// TeamController.java

import com.example.footballclub.model.Team;
import com.example.footballclub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable("id") Long id) {
        Team team = teamService.getTeamById(id);
        return ResponseEntity.ok(team);
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team savedTeam = teamService.saveTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}

