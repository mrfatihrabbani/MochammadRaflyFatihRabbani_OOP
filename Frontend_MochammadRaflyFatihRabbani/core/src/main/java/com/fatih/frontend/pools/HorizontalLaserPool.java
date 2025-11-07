package com.fatih.frontend.pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.obstacles.HorizontalLaser;

public class HorizontalLaserPool extends ObjectPool<HorizontalLaser> {
    @Override
    protected HorizontalLaser createObject() {
        return new HorizontalLaser(new Vector2(), 100);
    }

    @Override
    protected void resetObject(HorizontalLaser object) {
        object.setPosition(Gdx.graphics.getWidth(),0);
        object.setActive(false);
    }

    public HorizontalLaser obtain(Vector2 position, int length){
        super.obtain().initialize(position,length);
        super.obtain().setActive(true);
        return super.obtain();
    }
}
