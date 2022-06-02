package poi.word.table;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

import java.io.FileOutputStream;

public class CreateTableMerge {
    public static void main(String[] args) throws Exception {

        XWPFDocument doc = new XWPFDocument();
        XWPFTable table = doc.createTable();
        table.setWidth(9640);

        XWPFTableRow row1 = table.getRow(0);
//        XWPFTableCell cell = row1.getCell(0);
//        XWPFParagraph para = cell.addParagraph();
//        para.setAlignment(ParagraphAlignment.CENTER);
        row1.getCell(0).setText("10");
        row1.addNewTableCell().setText("11");
        row1.addNewTableCell().setText("12");
        row1.addNewTableCell().setText("13");
        row1.addNewTableCell().setText("14");
        row1.addNewTableCell().setText("15");
        row1.addNewTableCell().setText("16");


        //Creating second Row - Создание второго ряда
        XWPFTableRow row2 = table.createRow();
        row2.getCell(0).setText("20");
        row2.getCell(1).setText("21");
        row2.getCell(2).setText("22");
        row2.getCell(3).setText("23");
        row2.getCell(4).setText("24");
        row2.getCell(5).setText("25");
        row2.getCell(6).setText("26");


        XWPFTableRow row3 = table.createRow();
        row3.getCell(0).setText("30");
        row3.getCell(1).setText("31");
        row3.getCell(2).setText("32");
        row3.getCell(3).setText("33");
        row3.getCell(4).setText("34");
        row3.getCell(5).setText("35");
        row3.getCell(6).setText("36");

//        XWPFTableCell cell = table.getRow(0).getCell(0);
//        cell.getCTTc().newCursor().removeXml();

//First Row
        CTHMerge hMerge = CTHMerge.Factory.newInstance();
        hMerge.setVal(STMerge.RESTART);
        table.getRow(0).getCell(1).getCTTc().addNewTcPr().setHMerge(hMerge);
        table.getRow(1).getCell(1).getCTTc().addNewTcPr().setHMerge(hMerge);
        table.getRow(1).getCell(4).getCTTc().addNewTcPr().setHMerge(hMerge);

// Secound Row cell will be merged/"deleted" - Ячейка второй строки будет объединена / «удалена»
        CTHMerge hMerge1 = CTHMerge.Factory.newInstance();
        hMerge1.setVal(STMerge.CONTINUE);
        table.getRow(0).getCell(2).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(0).getCell(3).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(0).getCell(4).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(0).getCell(5).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(0).getCell(6).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(1).getCell(2).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(1).getCell(3).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(1).getCell(5).getCTTc().addNewTcPr().setHMerge(hMerge1);
        table.getRow(1).getCell(6).getCTTc().addNewTcPr().setHMerge(hMerge1);

// First Row
        CTVMerge vmerge = CTVMerge.Factory.newInstance();
        vmerge.setVal(STMerge.RESTART);                                                     //назначаем ячейки которые остануться
        table.getRow(0).getCell(0).getCTTc().addNewTcPr().setVMerge(vmerge);
        table.getRow(0).getCell(1).getCTTc().addNewTcPr().setVMerge(vmerge);
// Secound Row cell will be merged - Ячейка второй строки будет объединена
        CTVMerge vmerge1 = CTVMerge.Factory.newInstance();
        vmerge1.setVal(STMerge.CONTINUE);                                                   // назначаем ячейки которые уберем
        table.getRow(1).getCell(0).getCTTc().addNewTcPr().setVMerge(vmerge1);
        table.getRow(2).getCell(0).getCTTc().addNewTcPr().setVMerge(vmerge1);



        try (FileOutputStream out = new FileOutputStream("C:\\Users\\kopylov\\Desktop\\Project\\poi\\src\\main\\resources\\test\\Merge.docx")) {
            doc.write(out);
            System.out.println("Merge Готово!");
        }
    }
}
