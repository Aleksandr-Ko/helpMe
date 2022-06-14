package util.regex.my;

public class MyTest3 {
    public static void main(String[] args) {

        String text = "197229, город Санкт-Петербург, Лахтинский пр-кт, д. 2 к. 3 стр. 1";
        String text2 = "197229, г. Санкт-Петербург, Лахтинский пр-кт, д. 2 к. 3 стр. 1";

        System.out.println(getCity(text));
        System.out.println(getCity(text2));
    }

    public static String getCity(String text){

        String[] split = text.split(" ");
        String result = "";

        for (int i = 0; i < split.length; i++) {
            if(split[i].equals("город")){
                result = split[i+1];
            } else if (split[i].equals("г.")) {
                result = split[i+1];
            }
        }

        return result;
    }
}
