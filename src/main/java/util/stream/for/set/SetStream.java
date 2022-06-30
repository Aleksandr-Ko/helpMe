package util.stream.foreach.set;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetStream {

    @Data
    public static class Employee {
        private String name;
        private double workedHours;
        private double dedicationScore;


        public Employee(String name, double workedHours) {
            this.name = name;
            this.workedHours = workedHours;
        }

        // Constructor, Getters and Setters
        public void calculateDedication() {
            dedicationScore = workedHours*1.5;
        }

        public void receiveReward() {
            System.out.println(String
                    .format("%s только что получил награду за то, что был преданным работником!", name));
        }
    }

    static void forEach(){

        Set<Employee> employees = new HashSet<>();

        employees.add(new Employee("Vladimir", 60));
        employees.add(new Employee("John", 25));
        employees.add(new Employee("David", 40));
        employees.add(new Employee("Darinka", 60));

        // посчитаем балл преданности каждого сотрудника:
        employees.stream().forEach(Employee::calculateDedication);

        //  удалим тех, у кого слишком низкий балл:
        Set<Employee> regular = employees.stream()
                .filter(employee -> employee.getDedicationScore() <= 60)
                .collect(Collectors.toSet());
        employees.removeAll(regular);

        // вознаградим сотрудников за их тяжелую работу:
        employees.stream().forEach(employee -> employee.receiveReward());

        // И для наглядности выведем имена счастливчиков
        System.out.println("Награжденные сотрудники:");
        employees.stream().map(employee -> employee.getName()).forEach(employee -> System.out.println(employee));
    }

    public static void main(String[] args) {

        forEach();
    }

}
