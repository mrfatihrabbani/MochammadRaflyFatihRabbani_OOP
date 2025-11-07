package com.fatih.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HorizontalLaser extends BaseObstacle{
    private Vector2 startPosition;
    private int length;

    public HorizontalLaser(Vector2 startPosition, float length) {
        super(startPosition, length);
    }

    @Override
    public void updateCollider() {
        collider = new Rectangle(position.x, position.y, length, WIDTH);
    }

    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, length, WIDTH);
    }

    @Override
    public float getRenderWidth(float width, float height) {
        return length;
    }
}
