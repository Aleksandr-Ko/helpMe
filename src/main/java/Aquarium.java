import java.util.ArrayList;
import java.util.Arrays;


class Aquarium {
    private ArrayList<Fish> fish;

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        System.out.println(aquarium.getFish());
        // fish has already been initialized
        System.out.println(aquarium.getFish()); // line n1
    }

    public ArrayList<Fish> getFish() {
        if (fish == null) initFish();
        return fish;
    }

    private void initFish() {
        fish = new ArrayList<>(Arrays.asList(
                new Fish("Bubbles"),
                new Fish("Calypso"),
                new Fish("Dory")
        ));
    }
}
