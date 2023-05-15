package com.example.footballclub.service;

// MatchService.java

import com.example.footballclub.model.Match;

import java.util.List;

public interface MatchService {
    Match getMatchById(Long id);
    List<Match> getAllMatches();
    Match saveMatch(Match match);
    void deleteMatch(Long id);
}

