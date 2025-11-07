package com.fatih.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class VerticalLaser extends BaseObstacle{
    public VerticalLaser(Vector2 startPosition, float length) {
        super(startPosition, length);
    }

    @Override
    public void updateCollider() {

    }

    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {

    }

    @Override
    public float getRenderWidth(float width, float height) {
        return WIDTH;
    }
}
