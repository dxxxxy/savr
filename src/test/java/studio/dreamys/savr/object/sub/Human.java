package studio.dreamys.savr.object.sub;

//basic human class
public class Human {
    public String name;
    public int age;
    public int height;
    public int weight;
    public Tree personalTree;

    public Human(String name, int age, int height, int weight, Tree personalTree) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.personalTree = personalTree;
    }
}
