package dev.eder.padilla.cursogdgunam.recyclerview;

import io.realm.RealmObject;

public class PowerLevel extends RealmObject{

    public String maxPowerLevel;

    public String minPowerLevel;

    public String getMaxPowerLevel() {
        return maxPowerLevel;
    }

    public String getMinPowerLevel() {
        return minPowerLevel;
    }

    public PowerLevel() {
    }

    public PowerLevel(String maxPowerLevel, String minPowerLevel) {
        this.maxPowerLevel = maxPowerLevel;
        this.minPowerLevel = minPowerLevel;
    }

    @Override
    public String toString() {
        return "PowerLevel{" +
                "maxPowerLevel=" + maxPowerLevel +
                ", minPowerLevel=" + minPowerLevel +
                '}';
    }
}
