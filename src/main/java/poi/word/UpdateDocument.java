package poi.word;


/*
В этом примере мы будем использовать предварительно заполненный файл шаблона template.docx.
Файл шаблона содержит следующий текст Hello ${name}, Congratulations, you are learning something new!.
И мы заменим строку ${name}предопределенным вводом и создадим новый файл output.docxс обновленным содержимым.
 */

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UpdateDocument {

    public static void main(String[] args) throws IOException {

        UpdateDocument obj = new UpdateDocument();

        obj.updateDocument(
                "c:\\test\\template.docx",
                "c:\\test\\output.docx",
                "kopylov");
    }

    private void updateDocument(String input, String output, String name)throws IOException {

        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(input)))) {

            List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
            // Iterate over paragraph list and check for the replaceable text in each paragraph -
            // Перебрать список абзацев и проверить наличие заменяемого текста в каждом абзаце.
            for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
                for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                    String docText = xwpfRun.getText(0);
                    //replacement and setting position - замена и настройка положения
                    docText = docText.replace("${name}", name);
                    xwpfRun.setText(docText, 0);
                }
            }

            // save the docs - сохранить документы
            try (FileOutputStream out = new FileOutputStream(output)) {
                doc.write(out);

            }

        }

    }

}
