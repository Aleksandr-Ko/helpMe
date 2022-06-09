package util.generic.alishev;

public class Animal {
    String nameAnimal;

    public Animal (){}
    public Animal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    @Override
    public String toString() {

        return nameAnimal;
    }
}
