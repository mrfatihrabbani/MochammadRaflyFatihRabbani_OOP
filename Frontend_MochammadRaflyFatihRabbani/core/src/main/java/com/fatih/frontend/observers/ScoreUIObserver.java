package com.fatih.frontend.observers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer{
    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver(){
        font = new BitmapFont();
        batch = new SpriteBatch();
        font.setColor(Color.WHITE);
    }

    @Override
    public void update(int score) {
        System.out.println(score);
    }

    public void render(int score, int coins){
        batch.begin();
        batch.draw(font.getRegion(),0, Gdx.graphics.getHeight());
        font.draw(batch,"Score :" + score, 0,Gdx.graphics.getHeight());
        font.draw(batch,"Coins :" + coins, 0,Gdx.graphics.getHeight() - 30);
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        font.dispose();
    }
}
