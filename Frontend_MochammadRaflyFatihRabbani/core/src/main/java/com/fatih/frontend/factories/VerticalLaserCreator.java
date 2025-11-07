package com.fatih.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.obstacles.BaseObstacle;
import com.fatih.frontend.obstacles.HorizontalLaser;
import com.fatih.frontend.obstacles.VerticalLaser;
import com.fatih.frontend.pools.VerticalLaserPool;

import java.util.List;
import java.util.Random;

public class VerticalLaserCreator implements ObstacleFactory.ObstacleCreator {
    private VerticalLaserPool pool = new VerticalLaserPool();

    public static final float MIN_HEIGHT = 100f;
    public static final float MAX_HEIGHT = 300f;

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float size = MIN_HEIGHT + rng.nextFloat() * (MAX_HEIGHT - MIN_HEIGHT);

        Vector2 position = new Vector2(spawnX, groundTopY);

        pool.obtain().initialize(position, (int)size);
        pool.obtain().setActive(true);
        return pool.obtain();
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if(supports(obstacle)){
            pool.release((VerticalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<? extends BaseObstacle> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof VerticalLaser;
    }

    @Override
    public String getName() {
        return "VerticalLaser";
    }
}
