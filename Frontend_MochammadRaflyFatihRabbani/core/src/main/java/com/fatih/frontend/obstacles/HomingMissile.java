package com.fatih.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.Player;

public class HomingMissile extends BaseObstacle{
    private Player target;
    private Vector2 velocity;
    private float speed = 200f;
    private float width = 40f;
    private float height = 20f;

    public HomingMissile(Vector2 startPosition, float length){
        super(startPosition,length);
        this.velocity = new Vector2();
    }

    public void initialize(Vector2 startPosition, int length){
        super.initialize(startPosition,length);
        velocity.set(0,0);
    }


    public void setTarget(Player target){
        this.target = target;
    }

    public boolean isTargetingPlayer(){
        if(target == null){
            return false;
        }
        return target.getPosition().x > position.x;
    }

    public void update(float delta){
        Vector2 targetPosition = target.getPosition();
        velocity.set(targetPosition).sub(position).nor().scl(speed);

        updateCollider();
    }

    @Override
    public void updateCollider() {
        collider = new Rectangle(position.x, position.y, width, height);
    }

    @Override
    public void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    @Override
    public float getRenderWidth() {
        return width;
    }
}
