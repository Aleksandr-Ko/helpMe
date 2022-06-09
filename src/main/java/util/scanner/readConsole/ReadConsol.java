package util.scanner.readConsole;

import java.util.Scanner;

public class ReadConsol {
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = console.nextLine();
        
        System.out.println("Введите возраст");
        int age = console.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
