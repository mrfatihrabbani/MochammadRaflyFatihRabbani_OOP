package com.mochammadrafly.demo.Repository;

import com.mochammadrafly.demo.Model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {
    // ISI Kodenya disini
    List<Score> findByPlayerId(UUID playerId);
    List<Score> findByPlayerIdOrderByValueDesc(UUID playerId);
    List<Score> findByValueGreaterThan(int minValue);
    List<Score> findAllByOrderByCreatedAtDesc();

    @Query("SELECT s FROM Score s ORDER BY s.value DESC")
    List<Score> findTopScores(int limit);

    @Query("SELECT s FROM Score s WHERE s.playerId = :playerId ORDER BY s.value DESC")
    List<Score> findHighestScoreByPlayerId(@Param("playerId") UUID playerId);

    @Query("SELECT SUM(s.coinsCollected) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalCoinsByPlayerId(@Param("playerId") UUID playerId);

    @Query("SELECT SUM(s.distanceTravelled) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalDistanceByPlayerId(@Param("playerId") UUID playerId);
}

