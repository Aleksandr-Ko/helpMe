package util.stream.foreach.list;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Show {

    @Data
    
    static class Car {
        private String name;
        private int year;

        public Car(String model, int age) {
            this.name = model;
            this.year = age;
        }
        public Car(String model) {
            this.name = model;
        }

        // getters and setters
        @Override
        public String toString() {
            return "name='" + name + "'";
        }
    }



    public static void main(String[] args) {
        List<String> models = Arrays.asList("BMW", "Audi", "Peugeot", "Fiat");

        //Традиционный подход заключается в переборе списка с помощью расширенного цикла for:
        old(models);

        // более современный подход заключается в использовании Stream для сопоставления:
        modern(models);

        // Сбор с потоком
        mutate(models);

        // Сопоставление с потоком (mapping -> Сопоставление)
        // Классическая задача — классифицировать объекты по определенным критериям.
        // Мы можем сделать это, сопоставив необходимую информацию с информацией об объекте и проверив, что это то, что нам нужно:
        mapping();
    }




    private static void old(List<String> models) {
        for (String car : models) {
            if (!car.equals("Fiat")) {
                Car model = new Car(car);
                System.out.println(model);
            }
        }

    }

    private static void modern(List<String> models) {
        models.stream()
                .filter(model -> !model.equals("Fiat"))
//      .map(Car::new)                 // Эталонный подход к методу
//      .map(model -> new Car(model))  // Лямбда-подход
                .forEach(System.out::println);
    }

    private static void mutate(List<String> models) {

        List<Car> carList = models.stream()
                .filter(model -> !model.equals("Fiat"))
                .map(Car::new)
                .collect(Collectors.toList());
        carList.forEach(System.out::println);
    }

    static void mapping() {

        List<Car> models = Arrays.asList(new Car("BMW", 2011), new Car("Audi", 2018), new Car("Peugeot", 2015));

        boolean all = models.stream().allMatch(model -> model.getYear() > 2010);
        System.out.println("Все модели новее 2010 г.: " + all);

        boolean any = models.stream().anyMatch(model -> model.getYear() > 2016);
        System.out.println("Есть ли модели новее 2016 года? : " + any);

        boolean none = models.stream().noneMatch(model -> model.getYear() < 2010);
        System.out.println("Есть машина старше 2010 года? : " + none);
    }
}


