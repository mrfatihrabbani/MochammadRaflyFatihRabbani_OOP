package Repository;

import java.util.*;
import java.util.stream.Collectors;

import Model.Score;

public class ScoreRepository extends BaseRepository <Score, UUID>{

    @Override
    public void save(Score score) {
        UUID id = getId(score);
        dataMap.put(id, score);
        dataList.add(score);
    }

    @Override
    public UUID getId(Score entity) {
        return entity.getScoreId();
    }

    public List<Score> findByPlayerID(UUID playerId){
        return dataList.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .collect(Collectors.toList());
    }

    public List<Score> findByPlayerIdOrderByValueDesc(UUID playerId) {
        return dataList.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .collect(Collectors.toList());
    }

    public List<Score> findTopScores(int limit) {
        return dataList.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Optional<Score> findHighestScoreByPlayerId(UUID playerId) {
        return dataList.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .max((s1, s2) -> Integer.compare(s1.getValue(), s2.getValue()));
    }

    public List<Score> findByValueGreaterThan(Integer minValue) {
        return dataList.stream()
                .filter(score -> score.getValue() > minValue)
                .collect(Collectors.toList());
    }

    public List<Score> findAllByOrderByCreatedAtDesc() {
        return dataList.stream()
                .sorted((s1, s2) -> s2.getCreatedAt().compareTo(s1.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        return dataList.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        return dataList.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getDistance)
                .sum();
    }

}
