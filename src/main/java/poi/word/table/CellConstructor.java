package poi.word.table;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

import java.io.FileOutputStream;
import java.io.IOException;

public class CellConstructor {
    public static void main(String[] args) throws IOException {

        XWPFDocument doc = new XWPFDocument();

        addTableHeader(doc);


        FileOutputStream out = new FileOutputStream("C:\\Users\\kopylov\\Desktop\\Project\\poi\\src\\main\\resources\\test\\CellCon.docx");
        doc.write(out);
        out.close();
        System.out.println("Готово :)");

    }

    static private void addTableHeader(XWPFDocument doc) {

        XWPFTable table1 = doc.createTable(3, 7);                             // в документе таблицу
        table1.setWidth(9640);                                                          // задали размер таблицы (17см)

        CTHMerge hMerge = CTHMerge.Factory.newInstance();                               // горизонтальное слияния
        hMerge.setVal(STMerge.RESTART);                                                 // ячейки, которые останутся restart
        table1.getRow(0).getCell(1).getCTTc().addNewTcPr().setHMerge(hMerge);
        table1.getRow(1).getCell(1).getCTTc().addNewTcPr().setHMerge(hMerge);
        table1.getRow(1).getCell(4).getCTTc().addNewTcPr().setHMerge(hMerge);
        // Ячейка строки будет объединена / «удалена»
        CTHMerge hMerge1 = CTHMerge.Factory.newInstance();
        hMerge1.setVal(STMerge.CONTINUE);
        table1.getRow(0).getCell(2).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(0).getCell(3).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(0).getCell(4).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(0).getCell(5).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(0).getCell(6).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(1).getCell(2).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(1).getCell(3).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(1).getCell(5).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table1.getRow(1).getCell(6).getCTTc().addNewTcPr().setHMerge(hMerge1);

        // First Row
        CTVMerge vMerge = CTVMerge.Factory.newInstance();
        vMerge.setVal(STMerge.RESTART);                                                     //назначаем ячейки которые останутся-restart
        table1.getRow(0).getCell(0).getCTTc().addNewTcPr().setVMerge(vMerge);
        table1.getRow(0).getCell(1).getCTTc().addNewTcPr().setVMerge(vMerge);
        //  Ячейка будет объединена
        CTVMerge vMerge1 = CTVMerge.Factory.newInstance();
        vMerge1.setVal(STMerge.CONTINUE);                                                   // назначаем ячейки которые уберем-continue
        table1.getRow(1).getCell(0).getCTTc().addNewTcPr().setVMerge(vMerge1);
        table1.getRow(2).getCell(0).getCTTc().addNewTcPr().setVMerge(vMerge1);

        // 1 - ряд (Номер точки-Географ коор. точ.)
        XWPFTableRow table1Row0 = table1.getRow(0);                                     // создаем в таблице ряд (0)
        table1Row0.setRepeatHeader(true);                                                    // для повторения на новой странице
        XWPFTableCell cell1 = table1Row0.getCell(0);                                     // создаем доступ к ячейке (0) ряда
        XWPFParagraph heading1 = cell1.addParagraph();                                      // создаем параграф в ячейке
        cell1.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);                     // выравнивание ячейки по вертикали
        heading1.setAlignment(ParagraphAlignment.CENTER);                                   // выравнивание ячейи по горизонтали
        XWPFRun runText1 = heading1.createRun();
        runText1.setFontFamily("Times New Roman");
        runText1.setFontSize(12);
        runText1.setText("Номер");
        runText1.addBreak();
        runText1.setText("точки");
        table1Row0.getCell(0).removeParagraph(0);

        cellStyle(table1Row0,1,"Географические координаты точек");
        // 2 - ряд (С.Ш.-В.Д.)
        XWPFTableRow table1Row1 = table1.getRow(1);
        table1Row1.setRepeatHeader(true);
        cellStyle(table1Row1, 1, "С.Ш.");
        cellStyle(table1Row1, 4, "В.Д.");
        // 3 - ряд (С.Ш.)(град.-мин.-сек.)
        XWPFTableRow table1Row2 = table1.getRow(2);
        table1Row2.setRepeatHeader(true);
        cellStyle(table1Row2, 1, "град.");
        cellStyle(table1Row2, 2, "мин.");
        cellStyle(table1Row2, 3, "сек.");
        cellStyle(table1Row2, 4, "град.");
        cellStyle(table1Row2, 5, "мин.");
        cellStyle(table1Row2, 6, "сек.");

    }

    static private void cellStyle(XWPFTableRow tableRow, int cell, String text) {     // конструктор единого стиля ячейки
//        PetBaseReportService.tabRowCellStyleParag(tableRow, cell, text);
        tableRow.getCell(cell).removeParagraph(0);
    }
}


