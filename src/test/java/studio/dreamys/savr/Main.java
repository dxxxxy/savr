package studio.dreamys.savr;

import studio.dreamys.savr.object.World;
import studio.dreamys.savr.util.FileUtils;

public class Main {
    public static void main(String[] args) {
        //create test world
        World world = new World();

        //save world (print)
        Savr.save(world);

        //load world (print)
        System.out.println(FileUtils.loadUncompressed());
    }
}
