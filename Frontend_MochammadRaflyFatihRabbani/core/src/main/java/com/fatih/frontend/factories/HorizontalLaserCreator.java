package com.fatih.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool;
import com.fatih.frontend.obstacles.BaseObstacle;
import com.fatih.frontend.obstacles.HorizontalLaser;
import com.fatih.frontend.pools.HorizontalLaserPool;

import java.util.List;
import java.util.Random;

public class HorizontalLaserCreator implements ObstacleFactory.ObstacleCreator {
    private HorizontalLaserPool pool = new HorizontalLaserPool();

    public static final float MIN_LENGTH = 100f;
    public static final float MAX_LENGTH = 300f;

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float size = MIN_LENGTH + rng.nextFloat() * (MAX_LENGTH - MIN_LENGTH);

        float minY = groundTopY + playerHeight;
        float maxY = Gdx.graphics.getHeight() - playerHeight;
        float randomY = minY + rng.nextFloat() * (maxY - minY);

        Vector2 position = new Vector2(spawnX, randomY);

        pool.obtain().initialize(position, (int)size);
        pool.obtain().setActive(true);
        return pool.obtain();
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if(supports(obstacle)){
            pool.release((HorizontalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HorizontalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof HorizontalLaser;
    }

    @Override
    public String getName() {
        return "HorizontalLaser";
    }
}
