package poi.word;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

//Создайте текстовый документ
public class ParagraphStyle {
    public static void main(String[] args) throws IOException {

        String fileName = "c:\\test\\hello.docx";
        XWPFDocument doc = new XWPFDocument();
        // create a paragraph - создать абзац
        XWPFParagraph para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.CENTER);   // текст выравнивание
        para.setSpacingAfterLines(10);                  // Указывает интервал, после последней строки (между словами
        // set font - установить шрифт текста
        XWPFRun runText = para.createRun();
        runText.setBold(true);                           // текст полужирный
        runText.setItalic(true);                         // текст курсив
        runText.setFontSize(22);                         // текст размер
        runText.setFontFamily("New Roman");              // текст шрифт
        runText.setText("I am first paragraph.");        // надпись при создании


        // save it to .docx file - сохранить его в файл .docx
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            doc.write(out);
        }

    }

}

