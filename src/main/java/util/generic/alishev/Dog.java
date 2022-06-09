package util.generic.alishev;

public class Dog extends Animal{

    String breed;

    public Dog (String bread){
        this.breed=bread;
    }

    @Override
    public String toString() {
        return breed;
    }
}
