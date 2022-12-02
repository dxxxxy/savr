package studio.dreamys.savr;

import studio.dreamys.savr.object.World;

public class Main {
    public static void main(String[] args) {
        //create test world
        World world = new World();

        //save world (print)
        Savr.save(world);
    }
}
