package exeption.mastering;

public class NewMes {
    public static void main(String[] args){

        try{
            int result = Factorial.getFactorial(3);
            System.out.println(result);
        }
        catch(FactorialException ex){

            System.out.println(ex.getMessage());
            System.out.println(ex.getNumber());
        }
    }
}
