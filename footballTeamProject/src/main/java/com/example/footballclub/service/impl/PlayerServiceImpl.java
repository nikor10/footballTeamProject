package com.example.footballclub.service.impl;

// PlayerServiceImpl.java

import com.example.footballclub.exception.NotFoundException;
import com.example.footballclub.model.Player;
import com.example.footballclub.repository.PlayerRepository;
import com.example.footballclub.service.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id: " + id));
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
