package studio.dreamys.savr.object;

import studio.dreamys.savr.annotation.SavrList;
import studio.dreamys.savr.annotation.SavrWrld;
import studio.dreamys.savr.object.sub.Car;
import studio.dreamys.savr.object.sub.Human;
import studio.dreamys.savr.object.sub.Tree;

import java.util.ArrayList;
import java.util.Arrays;

@SavrWrld
public class World {

    @SavrList
    public ArrayList<Car> cars;

    @SavrList
    public ArrayList<Human> humans;

    @SavrList
    public ArrayList<Tree> trees;

    public World() {
        cars = new ArrayList<>(Arrays.asList(
                new Car("Ferrari", 200, 10, new Human("John", 20, 180, 70, new Tree("Oak", 100, 10, 10))),
                new Car("Lamborghini", 250, 15, new Human("Bob", 30, 170, 60, new Tree("Pine", 50, 5, 5))),
                new Car("Porsche", 300, 20, new Human("Alice", 40, 160, 50, new Tree("Birch", 150, 15, 15)))
        ));

        humans = new ArrayList<>(Arrays.asList(
                new Human("John", 20, 180, 70, new Tree("Oak", 100, 10, 10)),
                new Human("Jane", 25, 170, 60, new Tree("Birch", 50, 5, 5)),
                new Human("Jack", 30, 190, 80, new Tree("Pine", 150, 15, 15))
        ));

        trees = new ArrayList<>(Arrays.asList(
                new Tree("Oak", 100, 10, 10),
                new Tree("Pine", 200, 20, 20),
                new Tree("Birch", 300, 30, 30)
        ));
    }
}
