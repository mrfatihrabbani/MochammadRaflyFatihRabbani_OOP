package com.fatih.frontend;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Player {
    //position
    private Vector2 position;
    //velocity
    private Vector2 velocity;

    float gravity = 2000f;
    float force = 4500f;
    float maxVerticalSpeed = 700f;
    Rectangle collider;
    float width = 64f;
    float height = 64f;

    //speed system
    float baseSpeed = 300f;
    float distanceTraveled = 0f;

    public Player(Vector2 position, Vector2 velocity, Rectangle collider){
        this.position = position;
        this.velocity = velocity;
        this.collider = collider;

        Vector2 startPosition;

    }

    private void update(float delta, boolean isFlying){

    }
    private void updateDistanceAndSpeed(float delta){

    }
    private void updatePosition(float delta){

    }
    private void  applyGravity(float delta){

    }
}
