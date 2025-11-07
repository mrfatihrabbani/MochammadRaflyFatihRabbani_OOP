package com.fatih.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.obstacles.HorizontalLaser;
import com.fatih.frontend.obstacles.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser>{

    @Override
    protected VerticalLaser createObject() {
        return new VerticalLaser(new Vector2(), 100);
    }

    @Override
    protected void resetObject(VerticalLaser object) {
        object.setPosition(Gdx.graphics.getWidth(),0);
        object.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length){
        super.obtain().initialize(position,length);
        super.obtain().setActive(true);
        return super.obtain();
    }
}
