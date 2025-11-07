package com.fatih.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.Player;

public class HomingMissile extends BaseObstacle{
    private Player target;
    private Vector2 velocity;
    private float speed = 200f;
    private float width = 40f;
    private float height = 20f;

    public HomingMissile(Vector2 startPosition, float length, Vector2 velocity){
        super(startPosition,length);
        velocity = new Vector2(velocity);
    }

    void setTarget(Player target){

    }
    @Override
    public void updateCollider() {

    }

    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {

    }

    @Override
    public float getRenderWidth(float width, float height) {
        return 0;
    }
}
