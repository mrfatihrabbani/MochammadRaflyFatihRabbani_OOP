package com.fatih.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Ground {
    private float GROUND_HEIGHT = 50f;
    private Rectangle collider;

    public Ground(){
        collider = new Rectangle(0f,0f,Gdx.graphics.getWidth()*2,GROUND_HEIGHT);
    }

    public void update(float cameraX){
        float xAxis = cameraX - Gdx.graphics.getWidth() / 2f - 500;
        collider.setPosition(xAxis,0);
        collider.setWidth(Gdx.graphics.getWidth()*2);

    }

    public boolean isColliding(Rectangle playerCollider){
       return playerCollider.overlaps(collider);
    }

    public float getTopY(){
        return GROUND_HEIGHT;
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shapeRenderer.rect(collider.x, collider.y, collider.width, collider.height);
    }



}
