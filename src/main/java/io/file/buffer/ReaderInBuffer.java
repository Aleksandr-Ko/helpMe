package io.file.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderInBuffer {

        public static void main(String[] args) {
            String outputFileName = "file.txt";
            String[] array = { "one", "two", "three", "four" };

            try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
                for (String value : array) {
                    writter.write(value + "\n");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


}
