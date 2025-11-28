package com.fatih.frontend.factories;

import com.fatih.frontend.Coin;
import com.fatih.frontend.pools.CoinPool;

import java.util.List;
import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;

    public CoinFactory(){
        this.coinPool = new CoinPool();
        this.random = new Random();
    }
    public void createCoinPattern(float spawnX, float groundTopY){
        if(random.nextFloat(1) < 0.3f){
            for(int i = 0; i<= 3; i++){
                float coinSpawnX = spawnX + (i * 40);
                coinPool.obtain(coinSpawnX, groundTopY);
            }
        }
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
