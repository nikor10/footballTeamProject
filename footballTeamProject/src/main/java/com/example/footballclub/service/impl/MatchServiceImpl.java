package com.example.footballclub.service.impl;

// MatchServiceImpl.java

import com.example.footballclub.model.Match;
import com.example.footballclub.repository.MatchRepository;
import com.example.footballclub.service.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with id: " + id));
    }

    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
