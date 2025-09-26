package Service;

import Repository.ScoreRepository;
import Repository.PlayerRepository;

public class ScoreService {
    private ScoreRepository scoreRepository;
    private PlayerRepository playerRepository;
    private PlayerService playerService;


    ScoreService(ScoreRepository scoreRepository, PlayerRepository playerRepository, PlayerService playerService){
        this.scoreRepository = scoreRepository;
        this.playerRepository = playerRepository;
        this.playerService = playerService;


    }
}
