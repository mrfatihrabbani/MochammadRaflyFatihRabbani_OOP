package com.fatih.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.obstacles.HomingMissile;

public class HomingMissilePool extends ObjectPool<HomingMissile>{

    @Override
    protected HomingMissile createObject() {
        return new HomingMissile(new Vector2(),0);
    }

    @Override
    protected void resetObject(HomingMissile object) {
        object.setPosition(0,0);
        object.setTarget(null);
    }

    public HomingMissile obtain(Vector2 position){
        super.obtain().initialize(position,0);
        super.obtain().setActive(true);
        return super.obtain();
    }
}
