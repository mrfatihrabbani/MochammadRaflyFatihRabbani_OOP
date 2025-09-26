package Service;
import java.util.*;
import Model.Player;
import Repository.PlayerRepository;

import javax.swing.text.html.Option;

public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public boolean existByUsername(String username){
        return playerRepository.existByUsername(username);
    }

    public void createPlayer(Player player){
        playerRepository.save(player);
    }

    public Optional<Player> getPlayerById(UUID playerId){
        return playerRepository.findById(playerId);
    }

    public Optional<Player> getPlayerByUsername(String username){
        return playerRepository.findByUsername(username);
    }

    public void deletePlayer(UUID playerId){
        playerRepository.deleteById(playerId);
    }

    public Player updatePlayerStats(UUID playerId, int scoreValue, int coinsCollected, int distanceTravelled) {

    }

    public void getAllPlayers(){

    }

    public void updatePlayer(UUID playerId, Player updatedPlayer){
        if(getPlayerById(playerId).isEmpty()){
            throw new RuntimeException("Played does not exists");
        }

        if(existByUsername(updatedPlayer.getUsername())){
            throw new RuntimeException("Player already exists");
        }

        //Optional<Player>
    }

    public List<Player> getLeaderboardByHighScore(int limit){
        return playerRepository.findTopPlayersByHighScore(limit);
    }

    public List<Player> getLeaderboardByTotalCoins(){
        return playerRepository.findAllByOrderByTotalCoinsDesc();
    }

    public List<Player> getLeaderboardByTotalDistance(){
        return playerRepository.findAllByOrderByTotalDistanceTravelledDesc();
    }

    /*

    public void deletePlayerByUsername(String username){
        playerRepository.deleteById(username);
    }


     */



}
