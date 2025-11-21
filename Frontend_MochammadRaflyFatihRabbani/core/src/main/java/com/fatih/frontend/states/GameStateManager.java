package com.fatih.frontend.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    private final Stack<GameState> states;

    public GameStateManager(){
        this.states = new Stack<>();
    }

    public void push(GameState state){
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(GameState state){
        pop();
        push(state);
    }

    public void update(float delta){
        update(delta);
        states.peek();
    }

    public void render(SpriteBatch batch){
        render(batch);
    }
}
