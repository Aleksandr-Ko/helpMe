import java.util.ArrayList;
import java.util.Arrays;


class Aquarium {
    private ArrayList<Fish> fish;


    public ArrayList<Fish> getFish() {
        if (fish == null) {
            initFish();
        }
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
