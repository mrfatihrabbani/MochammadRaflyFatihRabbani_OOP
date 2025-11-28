package com.fatih.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;

    private float bobOffset;
    private float bobSpeed;

    public Coin(Vector2 startPosition){
        this.position = startPosition;
        collider = new Rectangle();
    }

    public void update(float delta){
        bobOffset = bobSpeed * delta;
        collider.setPosition(0, bobOffset);
    }

    public void renderShape(ShapeRenderer shapeRenderer){
        if(!active){
            return;
        }

        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x, drawY, radius);
    }

    public boolean isColliding(Rectangle playerCollider){
        return active && collider.overlaps(playerCollider);
    }

    public void setActive(boolean b) {
        this.active = b;
    }
}
