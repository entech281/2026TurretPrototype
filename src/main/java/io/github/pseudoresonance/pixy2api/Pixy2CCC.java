package io.github.pseudoresonance.pixy2api;

import java.util.ArrayList;
import java.util.List;

public class Pixy2CCC {
    public static class Block {
        public int getX(){ return 0; }
        public int getY(){ return 0; }
        public int getWidth(){ return 0; }
        public int getHeight(){ return 0; }
        public int getAngle(){ return 0; }
        public int getIndex(){ return 0; }
    }

    public void getBlocks() {}

    public List<Block> getBlockCache(){ return new ArrayList<>(); }
}
