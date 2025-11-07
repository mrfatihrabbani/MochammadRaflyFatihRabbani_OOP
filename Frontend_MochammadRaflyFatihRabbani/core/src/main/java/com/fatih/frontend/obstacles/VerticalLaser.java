package com.fatih.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class VerticalLaser extends BaseObstacle{
    public VerticalLaser(Vector2 startPosition, float length) {
        super(startPosition, length);
    }

    public void initialize(Vector2 startPosition, int length){
        super.initialize(startPosition,length);
    }

    @Override
    public void updateCollider() {
        collider = new Rectangle(position.x, position.y, WIDTH, length);
    }

    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, WIDTH, length);
    }

    @Override
    public float getRenderWidth() {
        return WIDTH;
    }
}
