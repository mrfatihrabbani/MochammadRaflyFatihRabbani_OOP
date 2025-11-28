package com.fatih.frontend.factories;

import com.fatih.frontend.Coin;
import com.fatih.frontend.pools.CoinPool;

import java.util.List;
import java.util.Random;

public class CoinFactory {
    private CoinPool coinPool;
    private Random random;

    public void createCoinPattern(float spawnX, float groundTopY){
        if(random.nextFloat(1) < 0.3){
            for(int i = 0; i<= 3; i++){
                coinPool.obtain(spawnX + 40, groundTopY);
            }
        }
    }

    public void getActiveCoins(Coin coin){
        coinPool.release(coin);
    }

}
