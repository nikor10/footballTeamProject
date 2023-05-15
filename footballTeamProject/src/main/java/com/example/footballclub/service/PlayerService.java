package com.example.footballclub.service;

// PlayerService.java

import com.example.footballclub.model.Player;

import java.util.List;

public interface PlayerService {
    Player getPlayerById(Long id);
    List<Player> getAllPlayers();
    Player savePlayer(Player player);
    void deletePlayer(Long id);
}
