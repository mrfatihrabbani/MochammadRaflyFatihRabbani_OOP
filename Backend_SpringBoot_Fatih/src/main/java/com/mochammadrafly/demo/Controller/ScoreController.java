package com.mochammadrafly.demo.Controller;

import com.mochammadrafly.demo.Model.Score;
import com.mochammadrafly.demo.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<?> createScore(@RequestBody Score score){
        try{
            Score create = scoreService.createScore(score);
            return ResponseEntity.status(HttpStatus.CREATED).body(create);
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllScores(){
        List<Score> score = scoreService.getAllScores();
        return ResponseEntity.ok(score);
    }

    @GetMapping({"/{scoreId}"})
    public ResponseEntity<?> getScoreById(@PathVariable UUID scoreId){
        Optional<Score> score = scoreService.getScoreById(scoreId);

        if(score.isPresent()){
            return ResponseEntity.ok(score.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Score not found for ID " + scoreId);
        }

    }

    @PutMapping("/{scoreId}")
    public ResponseEntity<?> updateScore(@PathVariable UUID scoreId, @RequestBody Score score){
        try {
            Score updated = scoreService.updatedScore(scoreId, score);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{scoreId}")
    public ResponseEntity<?> deleteScore(@PathVariable UUID scoreId){
        try{
            scoreService.deleteScore(scoreId);
            return  ResponseEntity.ok("Score deleted successfully");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<?> getScoreByPlayerId(@PathVariable UUID playerId){
        List<Score> score = scoreService.getScoresByPlayerId(playerId);
        return ResponseEntity.ok(score);
    }

    @GetMapping("/player/{playerId}/ordered")
    public ResponseEntity<List<Score>> getScoresByPlayerIdOrdered(@PathVariable UUID playerId){
        List<Score> score =  scoreService.getScoresByPlayerIdOrderByValue(playerId);
        return ResponseEntity.ok(score);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<Score>> getLeaderboard(@RequestParam(defaultValue = "10") int limit){
        List<Score> leaderboard = scoreService.getLeaderboard(limit);
        return ResponseEntity.ok(leaderboard);
    }

    @GetMapping("/player/{playerId}/highest")
    public ResponseEntity<?> getHighestScoreByPlayerId( @PathVariable UUID playerId){
        Optional<Score> highestScore = scoreService.getHighestScoreByPlayerId(playerId);
        if (highestScore.isPresent()){
            return ResponseEntity.ok(highestScore.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No scores found for Player ID " + playerId);
        }
    }

    @GetMapping("/above/{minValue}")
    public ResponseEntity<List<Score>> getScoresAboveValue(@PathVariable Integer minValue){
        List<Score> score = scoreService.getScoresAboveValue(minValue);
        return ResponseEntity.ok(score);
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Score>> getRecentScore(){
        List<Score> recentScore = scoreService.getRecentScores();
        return ResponseEntity.ok(recentScore);
    }

    @GetMapping("/player/{playerId}/total-coins")
    public ResponseEntity<?> getTotalCoinsByPlayerId(@PathVariable UUID playerId) {
        Integer totalCoins = scoreService.getTotalCoinsByPlayerId(playerId);
        return ResponseEntity.ok().body(Map.of("totalCoins", totalCoins));
    }

    @GetMapping("/player/{playerId}/total-distance")
    public ResponseEntity<?> getTotalDistanceByPlayerId(@PathVariable UUID playerId){
        Integer totalDistance = scoreService.getTotalDistanceByPlayerId(playerId);
        return ResponseEntity.ok().body(Map.of("totalDistance", totalDistance));
    }

    @DeleteMapping("/player/{playerId}")
    public ResponseEntity<?> deleteScoresByPlayerId(@PathVariable UUID playerId){
        scoreService.deleteScoresByPlayerId(playerId);
        return ResponseEntity.ok("Score deleted successfully");
    }
}
