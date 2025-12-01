package com.fatih.frontend.factories;

import com.fatih.frontend.Coin;
import com.fatih.frontend.pools.CoinPool;

import java.util.List;
import java.util.Random;

public class CoinFactory {
    public final CoinPool coinPool;

    public CoinFactory(){
        this.coinPool = new CoinPool();
    }

    public List<Coin> getActiveCoins(){
        return coinPool.getInUse();
    }

    public void releaseCoin(Coin coin){
        coinPool.release(coin);
    }

    public void releaseAll() {
        coinPool.releaseAll();
    }
}
