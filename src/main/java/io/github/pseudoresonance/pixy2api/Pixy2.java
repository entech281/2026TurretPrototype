package io.github.pseudoresonance.pixy2api;

import java.util.List;
import java.util.ArrayList;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;
import io.github.pseudoresonance.pixy2api.links.Link;

public class Pixy2 {
    public Pixy2() {}

    public static Pixy2 createInstance(Link link){ return new Pixy2(); }

    public void init() {}

    public Pixy2CCC getCCC(){
        return new Pixy2CCC();
    }

}
