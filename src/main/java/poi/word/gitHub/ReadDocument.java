package poi.word.gitHub;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;

public class ReadDocument {

    public static void main(String[] args) throws Exception {

        try {
            // нахождение файла и вывод всего его содержимого в консоль
            XWPFDocument docx = new XWPFDocument(new FileInputStream("Word Testing.docx"));
            XWPFWordExtractor we = new XWPFWordExtractor(docx);
            System.out.println(we.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
