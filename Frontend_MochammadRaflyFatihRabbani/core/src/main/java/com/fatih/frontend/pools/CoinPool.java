package com.fatih.frontend.pools;

import com.badlogic.gdx.math.Vector2;
import com.fatih.frontend.Coin;

public class CoinPool extends ObjectPool<Coin>{
    @Override
    protected Coin createObject() {
        return new Coin(new Vector2(0,0));
    }

    @Override
    protected void resetObject(Coin object) {
        object.setActive(false);
    }

    public Coin obtain(float x, float y){
        Coin coin = super.obtain();
        coin.getPosition().set(x,y);
        coin.setActive(true);
        return coin;
    }

}
