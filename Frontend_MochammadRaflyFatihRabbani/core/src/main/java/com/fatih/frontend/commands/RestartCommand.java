package com.fatih.frontend.commands;

import com.badlogic.gdx.Game;
import com.fatih.frontend.GameManager;
import com.fatih.frontend.Player;

public class RestartCommand implements Commands{
    private Player player;
    private GameManager gameManager;

    public RestartCommand(Player player, GameManager gameManager){
        this.player = player;
        this.gameManager = gameManager;
    }


    @Override
    public void execute() {
        player.reset();
        gameManager.setScore(0);
    }
}
