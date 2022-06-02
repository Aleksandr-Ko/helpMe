package poi.word.image;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Добавьте изображение
public class AddImage {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        String imgFile = "c:\\test\\yandex.png";

        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph p = doc.createParagraph();
        XWPFRun r = p.createRun();
        r.setText(imgFile);                            // ссылка на фото
        r.addBreak();


        // add png image - добавить png изображение
        try (FileInputStream is = new FileInputStream(imgFile)) {
            r.addPicture(is,
                    Document.PICTURE_TYPE_PNG,         // png file - png файл
                    imgFile,
                    Units.toEMU(482),
                    Units.toEMU(482));           // 482x482 pixels
        }


        //вывод в файл
        try (FileOutputStream out = new FileOutputStream("c:\\test\\images.docx")) {
            doc.write(out);
        }


    }
}
