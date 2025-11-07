package com.fatih.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    protected Vector2 position;
    protected Rectangle collider;
    protected float length;
    protected final float WIDTH = 10f;
    protected boolean active = false;

    public BaseObstacle(Vector2 startPosition, float length){
        position = new Vector2(startPosition);
        this.length = length;
        updateCollider();
    }

    void render(ShapeRenderer shapeRenderer){
        if(!active){
            //collide with player
        }
    }

    public boolean isActive() {
        return active;
    }

    public boolean isOffScreenCamera(float cameraLeftEdge){
        //skipped
    }

    public abstract void updateCollider();
    public abstract void drawShape(ShapeRenderer shapeRenderer);

    public abstract float getRenderWidth(float width, float height);

    public void setActive(boolean active){

    }

    public void setPosition(float x, float y){
        collider.setPosition(x,y);
    }

    public Vector2 getPosition(){
        return position;
    }




}
