package com.example.footballclub.controller;
// MatchController.java

import com.example.footballclub.model.Match;
import com.example.footballclub.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {
    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable("id") Long id) {
        Match match = matchService.getMatchById(id);
        return ResponseEntity.ok(match);
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        List<Match> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match savedMatch = matchService.saveMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
