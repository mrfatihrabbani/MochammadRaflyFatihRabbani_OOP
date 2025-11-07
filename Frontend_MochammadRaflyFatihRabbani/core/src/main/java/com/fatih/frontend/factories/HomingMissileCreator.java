package com.fatih.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.obstacles.BaseObstacle;
import com.fatih.frontend.obstacles.HomingMissile;
import com.fatih.frontend.obstacles.HorizontalLaser;
import com.fatih.frontend.pools.HomingMissilePool;

import java.util.List;
import java.util.Random;
import java.util.Vector;

public class HomingMissileCreator implements ObstacleFactory.ObstacleCreator {
    private HomingMissilePool pool = new HomingMissilePool();

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float randomY = groundTopY + rng.nextFloat() * (Gdx.graphics.getHeight() - groundTopY);

        Vector2 position = new Vector2(spawnX, randomY);

        pool.obtain().initialize(position, 1);
        pool.obtain().setActive(true);
        return pool.obtain();
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if(supports(obstacle)){
            pool.release((HomingMissile) obstacle);
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
        return obstacle instanceof HomingMissile;
    }

    @Override
    public String getName() {
        return "HomingMissile";
    }
}
