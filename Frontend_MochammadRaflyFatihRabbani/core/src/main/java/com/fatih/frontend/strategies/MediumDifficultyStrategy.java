package com.fatih.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class MediumDifficultyStrategy implements DifficultyStrategy{
    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 2);
        map.put("HorizontalLaser", 3);
        map.put("HomingMissile", 1);
        return map;
    }

    @Override
    public float getSpawnInterval() {
        return 2.5f;
    }

    @Override
    public float getDensity() {
        return 3.5f;
    }

    @Override
    public float getMinGap() {
        return 3.5f;
    }

}
