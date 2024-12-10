package com.github.romankh3.maventemplaterepository;

import java.util.List;

public class LawnOwnerParsedData {

    private final int maxX;
    private final int maxY;
    private final List<MowerConfig> mowerConfigs;

    public LawnOwnerParsedData(int maxX, int maxY, List<MowerConfig> mowerConfigs) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.mowerConfigs = mowerConfigs;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public List<MowerConfig> getMowerConfigs() {
        return mowerConfigs;
    }

    public static class MowerConfig {
        private final int initialX;
        private final int initialY;
        private final char orientation;
        private final String instructions;

        public MowerConfig(int initialX, int initialY, char orientation, String instructions) {
            this.initialX = initialX;
            this.initialY = initialY;
            this.orientation = orientation;
            this.instructions = instructions;
        }

        public int getInitialX() {
            return initialX;
        }

        public int getInitialY() {
            return initialY;
        }

        public char getOrientation() {
            return orientation;
        }

        public String getInstructions() {
            return instructions;
        }
    }

}
