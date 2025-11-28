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

    public void obtain(float x, float y){
        super.obtain();
        //Create a public method obtain(float x, float y): Call super.obtain(), initialize the coin position, then return the coin.
    }

}
