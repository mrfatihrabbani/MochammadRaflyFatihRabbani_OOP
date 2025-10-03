package Repository;

import java.util.*;
import java.util.stream.Collectors;

import Model.Player;

public class PlayerRepository extends BaseRepository <Player, UUID>{

    @Override
    public void save(Player player) {
        UUID id = getId(player);
        dataMap.put(id, player);
        dataList.add(player);
    }

    @Override
    public UUID getId(Player entity) {
        return entity.getPlayerID();
    }


    public Optional<Player> findByUsername(String username){
        return dataList.stream()
                .filter(player -> player.getUsername()
                        .equals(username)).findFirst();
    }

    public List<Player> findTopPlayersByHighScore(int limit){
        return dataList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getHighScore(), p1.getHighScore()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Player> findByHighscoreGreaterThan(int minScore){
        return dataList.stream()
                .filter(player -> player.getHighScore() > minScore)
                .collect(Collectors.toList());

    }

    public List<Player> findAllByOrderByTotalCoinsDesc(){
        return dataList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTotalCoins(), p1.getTotalCoins()))
                .collect(Collectors.toList());
    }

    public List<Player> findAllByOrderByTotalDistanceTravelledDesc(){
        return dataList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTotalDistance(), p1.getTotalDistance()))
                .collect(Collectors.toList());
    }

    public boolean existByUsername(String username) {
        return dataList.stream()
                .anyMatch(player -> player.getUsername().equals(username));
    }


}
