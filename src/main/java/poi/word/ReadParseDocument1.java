package poi.word;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


//извлечения и чтения текста из документов
public class ReadParseDocument1 {

    public static void main(String[] args) throws IOException {

        String fileName = "c:\\test\\simple.docx";

        XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(fileName)));

            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            String docText = xwpfWordExtractor.getText();
            System.out.println(docText);

            // find number of words in the document - найти количество слов в документе
            long count = Arrays.stream(docText.split("\\s+")).count();
            System.out.println("Total words: " + count);
    }

}
