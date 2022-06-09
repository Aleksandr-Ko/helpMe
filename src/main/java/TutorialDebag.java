public class TutorialDebag {

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();

        System.out.println(aquarium.getFish());
        // fish has already been initialized
        System.out.println(aquarium.getFish()); // line n1
    }




}
