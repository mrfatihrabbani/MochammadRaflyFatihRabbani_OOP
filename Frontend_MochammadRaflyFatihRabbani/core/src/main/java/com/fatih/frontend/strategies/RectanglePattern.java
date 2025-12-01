package com.fatih.frontend.strategies;

import com.fatih.frontend.Coin;
import com.fatih.frontend.factories.CoinFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RectanglePattern implements CoinPattern{
    private static final float SPACING_X = 40f;
    private static final float SPACING_Y = 40f;
    private Random random;

    public RectanglePattern(){
        this.random = new Random();
    }
    @Override
    public List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight) {
        List<Coin> coins = new ArrayList<>();

        int rows = 3 + random.nextInt(2);
        int cols = 2 + random.nextInt(2);

        float minY = groundTopY + 50f;
        float maxY = screenHeight - 100f;
        float startY = minY + random.nextFloat() * (maxY - minY);

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                float posX = spawnX + (col * SPACING_X);
                float posY = startY + (row * SPACING_Y);
                Coin coin = factory.coinPool.obtain(posX,posY);
                coins.add(coin);
            }
        }
        return coins;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
