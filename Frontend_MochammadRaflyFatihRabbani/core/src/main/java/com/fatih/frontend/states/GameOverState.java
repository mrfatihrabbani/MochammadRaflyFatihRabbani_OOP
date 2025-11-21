package com.fatih.frontend.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState {
    private GameStateManager gsm;
    private BitmapFont font;

    public GameOverState(){
        this.gsm = new GameStateManager();
        this.font = new BitmapFont();
    }

    public void update(float delta){
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gsm.set(new PlayingState(gsm));
        }
    }

    public void render(SpriteBatch batch){
        batch.begin();
        font.draw(batch, "GAME OVER!",Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        font.draw(batch, "Press SPACE to restart",Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch.end();
    }

    public void dispose(){
        font.dispose();
    }

}
