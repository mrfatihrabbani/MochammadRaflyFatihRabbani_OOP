package com.mochammadrafly.demo.Service;


import com.mochammadrafly.demo.Model.Score;
import com.mochammadrafly.demo.Repository.PlayerRepository;
import com.mochammadrafly.demo.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore(Score score) {
        UUID playerId = score.getPlayerId();
        if (playerId == null || !playerRepository.existsById(playerId)) {
            throw new RuntimeException("player_not_found");
        }
        if (score.getCoinsCollected() == null) score.setCoinsCollected(0);
        if (score.getDistanceTravelled() == null) score.setDistanceTravelled(0);
        Score saved = scoreRepository.save(score);
        playerService.updatePlayerStats(saved.getPlayerId(), saved.getValue(), saved.getCoinsCollected(), saved.getDistanceTravelled());
        return saved;
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        List<Score> list = scoreRepository.findTopScores(limit);
        if (list == null) return Collections.emptyList();
        if (limit <= 0 || list.size() <= limit) return list;
        return list.subList(0, limit);
    }

    public Optional<Score> getHighestScoreByPlayerId(UUID playerId) {
        List<Score> list = scoreRepository.findHighestScoreByPlayerId(playerId);
        if(list.isEmpty()) {
            return Optional.empty();
        } else return Optional.of(list.get(0));

    }

    public List<Score> getScoresAboveValue(int minValue) {
        return scoreRepository.findByValueGreaterThan( minValue);
    }

    public List<Score> getRecentScores() {
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId){
        Integer total = scoreRepository.getTotalCoinsByPlayerId(playerId);
        if(total != null){
            return total;
        } else {
            return 0;
        }
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId){
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        if(total != null){
            return total;
        } else {
            return 0;
        }
    }

    public Score updatedScore(UUID scoreId, Score updatedScore){
        Score existingScore = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new RuntimeException("Score is not found " + scoreId));
        if (updatedScore.getValue() != null) {
            existingScore.setValue(updatedScore.getValue());
        }
        if (updatedScore.getCoinsCollected() != null) {
            existingScore.setCoinsCollected(updatedScore.getCoinsCollected());
        }
        if (updatedScore.getDistanceTravelled() != null) {
            existingScore.setDistanceTravelled(updatedScore.getDistanceTravelled());
        }

        return scoreRepository.save(existingScore);
    }

    public void deleteScore(UUID scoreId){
        if(!scoreRepository.existsById(scoreId)){
            throw new RuntimeException("Score not found for Score ID " + scoreId);
        }
        scoreRepository.deleteById(scoreId);
    }

    public void deleteScoresByPlayerId(UUID playerId){
        List<Score> playerScores = scoreRepository.findByPlayerId(playerId);

        scoreRepository.deleteAll(playerScores);
    }



}
