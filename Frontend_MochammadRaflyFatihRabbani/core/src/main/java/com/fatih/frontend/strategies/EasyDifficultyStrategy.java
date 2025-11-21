package com.fatih.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class EasyDifficultyStrategy implements DifficultyStrategy{
    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 1);
        map.put("HorizontalLaser", 1);
        return map;
    }

    @Override
    public float getSpawnInterval() {
        return 1.5f;
    }

    @Override
    public float getDensity() {
        return 1.5f;
    }

    @Override
    public float getMinGap() {
        return 1.5f;
    }

}
