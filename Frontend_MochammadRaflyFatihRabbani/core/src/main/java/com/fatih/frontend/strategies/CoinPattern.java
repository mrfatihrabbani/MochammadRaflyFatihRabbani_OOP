package com.fatih.frontend.strategies;

import com.fatih.frontend.Coin;
import com.fatih.frontend.factories.CoinFactory;

import java.util.List;

public interface CoinPattern {
    public List<Coin> spawn(CoinFactory factory, float groundTopY, float spawnX, float screenHeight);
    public String getName();
}
