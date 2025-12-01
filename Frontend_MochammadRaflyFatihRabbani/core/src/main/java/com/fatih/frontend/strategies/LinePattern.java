package com.fatih.frontend.strategies;

import com.fatih.frontend.Coin;
import com.fatih.frontend.factories.CoinFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePattern implements CoinPattern{
    private static final float SPACING = 40f;
    private Random random;

    public LinePattern(){
        this.random = new Random();
    }

    @Override
    public List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight) {
        List<Coin> coins = new ArrayList<>();

        int coinCount = random.nextInt(3,5);
        float minY = groundTopY + 50;
        float maxY = screenHeight - 100;
        float startY = minY + random.nextFloat() * (maxY - minY);
        for(int i = 0; i < coinCount; i++){
            float coinX = spawnX + i * SPACING;
                Coin coin = factory.coinPool.obtain(coinX, startY);
                coins.add(coin);
        }
        return coins;
    }

    @Override
    public String getName() {
        return "Line";
    }
}
