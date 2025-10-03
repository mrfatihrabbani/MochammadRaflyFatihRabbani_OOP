package com.mochammadrafly.demo;
import java.util.*;
import com.mochammadrafly.demo.Model.Player;
import com.mochammadrafly.demo.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        if (playerRepository.existsByUsername(player.getUsername())){
            throw new RuntimeException("Username already exists: " + player.getUsername());
        }

        return playerRepository.save(player);
    }


    public Optional<Player> getPlayerById(UUID playerId) {
        return playerRepository.findById(playerId);
    }


    public Optional<Player> getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username);
    }


    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }


    public Player updatePlayer(UUID playerId, Player updatedPlayer) {
        Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + playerId));

        // Update username jika berbeda dan tersedia
        if (updatedPlayer.getUsername() != null &&
                !updatedPlayer.getUsername().equals(existingPlayer.getUsername())) {

            if (existsByUsername(updatedPlayer.getUsername())) {
                throw new RuntimeException("Username already exists: " + updatedPlayer.getUsername());
            }
            existingPlayer.setUsername(updatedPlayer.getUsername());
        }

        if (updatedPlayer.getHighScore() != null) {
            existingPlayer.setHighScore(updatedPlayer.getHighScore());
        }

        if (updatedPlayer.getTotalCoins() != null) {
            existingPlayer.setTotalCoins(updatedPlayer.getTotalCoins());
        }

        if (updatedPlayer.getTotalDistance() != null) {
            existingPlayer.setTotalDistance(updatedPlayer.getTotalDistance());
        }

        playerRepository.save(existingPlayer);
        return existingPlayer;
    }

    public void deletePlayer(UUID playerId) {
        if(!playerRepository.existsById(playerId)){
           throw new RuntimeException("Player not found with ID: " + playerId);
        }
        playerRepository.deleteById(playerId);
    }

    public void deletePlayerByUsername(String username) {
        Player player = playerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Player not found with username: " + username));
        playerRepository.delete(player);
    }

    public Player updatePlayerStats(UUID playerId, Integer scoreValue, Integer coinsCollected, Integer distanceTravelled) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + playerId));

        // Update high score if this score is higher
        player.updateHighScore(scoreValue);

        // Add coins and distance to totals
        player.addCoins(coinsCollected);
        player.addDistance(distanceTravelled);

        playerRepository.save(player);
        return player;
    }

    public List<Player> getLeaderboardByHighScore(int limit) {
        return playerRepository.findTopPlayersByHighScore(limit);
    }
    public List<Player> getLeaderboardByTotalCoins() {
        return playerRepository.findAllByOrderByTotalCoinsDesc();
    }


    public List<Player> getLeaderboardByTotalDistance() {
        return playerRepository.findAllByOrderByTotalDistanceTravelledDesc();
    }


    public boolean isUsernameExists(String username) {
        return playerRepository.findByUsername(username).isPresent();
    }

}
