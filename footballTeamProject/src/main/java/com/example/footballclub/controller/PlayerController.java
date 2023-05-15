package com.example.footballclub.controller;

// PlayerController.java

import com.example.footballclub.model.Player;
import com.example.footballclub.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Long id) {
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.savePlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
