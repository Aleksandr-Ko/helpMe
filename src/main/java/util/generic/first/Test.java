package util.generic.first;

//https://annimon.com/article/2637

public class Test {
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.set(new Car("Aston Martin"));
        Car car = (Car) garage.get();
        System.out.println(car.getName()); // Aston Martin

        Garage garage2 = new Garage();
        garage2.set(new Motorcycle("Honda CBR500R"));
//        Motorcycle motorcycle = (Motorcycle) garage2.get();
        Motorcycle motorcycle = (Motorcycle) garage.get();          //ошибка в адресе обращения garage -> garage2
        System.out.println(motorcycle.getName());

    }
}
