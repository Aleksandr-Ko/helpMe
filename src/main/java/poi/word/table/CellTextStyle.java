package poi.word.table;


import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class CellTextStyle {
    public static void main(String[] args) throws IOException {

        try (XWPFDocument doc = new XWPFDocument()) {                            // создаем документ
            XWPFTable table = doc.createTable();                                 // в документе таблицу
            table.setWidth(9640);                                                // задаем общий размер таблицы

            XWPFTableRow tableRow = table.getRow(0);                        // создаем доступ к таблице рядя
            XWPFTableCell cell = tableRow.getCell(0);                       // создаем доступ к ряду в ячейке
            XWPFParagraph heading = cell.addParagraph();                        // создаем в ячейке параграф

            cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);      // вертикальное выравнивание в ячейке(нужно при слиянии ячеек)
            heading.setAlignment(ParagraphAlignment.CENTER);                    // горизонтальное выравнивание параграфа

            XWPFRun run = heading.createRun();                                 // вывод текста внутри параграфа
            run.setText("Привет");                                             // текст
            tableRow.getCell(0).removeParagraph(0);                   // возвращает курсор в положение - (0)


            try (FileOutputStream out = new FileOutputStream("C:\\Users\\kopylov\\Desktop\\Project\\poi\\src\\main\\resources\\test\\Test.docx")) {
                doc.write(out);

                System.out.println("Готово!");
            }
        }
    }

}


