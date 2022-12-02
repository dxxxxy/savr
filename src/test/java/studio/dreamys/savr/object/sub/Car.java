package studio.dreamys.savr.object.sub;

//basic car class
public class Car {
    public String name;
    public int speed;
    public int acceleration;
    public Human owner;

    public Car(String name, int speed, int acceleration, Human owner) {
        this.name = name;
        this.speed = speed;
        this.acceleration = acceleration;
        this.owner = owner;
    }
}
