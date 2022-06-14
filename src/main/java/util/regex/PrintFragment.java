package util.regex;

public class PrintFragment {
    public static void main(String[] args) {

        String line = "Лукин Иван Петрович";
        String[] word = line.split(" ");
        String newLine = "";
        // вывод выводит имя и отчество
        for (int i = 0; i < word.length; i++) {
            if(i != 0){
                newLine += word[i]+" ";
                System.out.println(word[i]);
            }
        }

        System.out.println(newLine);

        for (String str : word) {
//            System.out.println(str);
        }

    }
}
