package com.fatih.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Player {
    //position
    private Vector2 position;
    //velocity
    private Vector2 velocity;

    private float gravity = 2000f;
    private float force = 4500f;
    private float maxVerticalSpeed = 700f;
    private Rectangle collider;
    private float width = 64f;
    private float height = 64f;

    //speed system
    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    private boolean isDead = false;
    private Vector2 startPosition;

    public Player(Vector2 startPosition){
        position = new Vector2(startPosition);
        velocity = new Vector2(0, 0);
        collider = new Rectangle(position.x, position.y, width, height);
        this.startPosition = new Vector2(startPosition);
    }

    public void update(float delta, boolean isFlying){
        if(!isDead){
            updateDistanceAndSpeed(delta);
            updatePosition(delta);
            applyGravity(delta);
            if(isFlying){
                fly(delta);
            }
            updateCollider();
        }
    }

    private void updateDistanceAndSpeed(float delta){
        distanceTraveled += velocity.x * delta;
    }
    private void updatePosition(float delta){
        position.x += velocity.x * delta;
        position.y += velocity.y * delta;
    }
    private void applyGravity(float delta){
        velocity.y -= gravity * delta;
        velocity.x = baseSpeed;
        if(velocity.x > maxVerticalSpeed){
            velocity.x = maxVerticalSpeed;
        }
        if(velocity.y > maxVerticalSpeed){
            velocity.y = maxVerticalSpeed;
        }
    }

    private void fly(float delta){
        velocity.y += force * delta;
    }

    private void updateCollider(){
        collider.setPosition(position.x, position.y);
    }

    public void checkBoundaries(Ground ground, float ceilingY){
        if(ground.isColliding(collider)){
            position.y = ground.getTopY();
            velocity.y = 0;
        }
        if(position.y + height > ceilingY){
            position.y = ceilingY;
            velocity.y = 0;
        }
    }
    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(1f, 0f,0f,0f);
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public float getDistanceTraveled() {
        return distanceTraveled / 10f;
    }

    public void die(){
        this.isDead = true;
        this.velocity.set(0,0);
    }

    public void reset(){
        this.isDead = false;
        this.position.set(startPosition);
        this.velocity.set(0,0);
        this.distanceTraveled = 0f;
    }

    public boolean isDead(){
        return isDead;
    }

}
