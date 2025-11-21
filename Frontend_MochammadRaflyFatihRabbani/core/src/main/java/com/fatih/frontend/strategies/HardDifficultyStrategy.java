package com.fatih.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy{
    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> map = new HashMap<>();
        map.put("VerticalLaser", 4);
        map.put("HorizontalLaser", 4);
        map.put("HomingMissile", 4);
        return map;
    }

    @Override
    public float getSpawnInterval() {
        return 4.5f;
    }

    @Override
    public float getDensity() {
        return 4.5f;
    }

    @Override
    public float getMinGap() {
        return 4.5f;
    }


}
