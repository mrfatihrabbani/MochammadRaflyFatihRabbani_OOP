package com.fatih.frontend.commands;

import com.badlogic.gdx.Gdx;
import com.fatih.frontend.Player;

public class JetpackCommand implements Command{
    private Player player;
    public JetpackCommand(Player player){
        this.player = player;
    }


    @Override
    public void execute() {
        float delta = Gdx.graphics.getDeltaTime();
        if(!player.isDead()){
            player.fly(delta);
        }
    }
}
