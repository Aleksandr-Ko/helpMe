package poi.word.table;


import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;

import java.io.FileOutputStream;

// Создаем таблицу в файле документа Word

public class CreateTable {

    public static void main(String[] args) throws Exception {

        try (XWPFDocument document = new XWPFDocument()) {      // создаем документ

            XWPFTable table1 = document.createTable();          // создаем таблицу в документе
            table1.setWidth(9640);                              // ширина таблицы 17см (9640) или по ширине окна("100%")
//            table1.setCellMargins(300,300,300,300);           // задать точный размер ячейки

            XWPFTableRow tableRowOne = table1.getRow(0);
            XWPFRun runt1 = tableRowOne.getCell(0).addParagraph().createRun();
            XWPFTableCell cell1 = tableRowOne.getCell(0);

            runt1.setFontFamily("Times New Roman");
            runt1.setFontSize(12);
            runt1.setText("Номер");
            runt1.addBreak();
            runt1.setText("точки");
            tableRowOne.getCell(0).setWidth("800");
            tableRowOne.getCell(0).removeParagraph(0);

            CTTcPr tcpr = cell1.getCTTc().addNewTcPr(); // создаем точку слияния
            CTVMerge vMerge = tcpr.addNewVMerge();      // добавить нов слияние

            XWPFRun runt2 = tableRowOne.addNewTableCell().addParagraph().createRun();
            runt2.setFontFamily("Times New Roman");
            runt2.setFontSize(12);
            runt2.addTab();
            runt2.setText("Географические координаты точек");
            tableRowOne.getCell(1).setWidth("8040");
            tableRowOne.getCell(1).removeParagraph(0);





            // save to .docx file - сохранить в файл .docx
            try (FileOutputStream out = new FileOutputStream("C:\\Users\\kopylov\\IdeaProjects\\poi\\src\\main\\resources\\test\\CreateTable.docx")) {
                document.write(out);
            }
        }

    }

}
