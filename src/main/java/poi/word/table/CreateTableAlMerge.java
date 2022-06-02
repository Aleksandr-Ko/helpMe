package poi.word.table;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateTableAlMerge {
    public static void main(String[] args) throws IOException {

        XWPFDocument docX2 = new XWPFDocument();    //создаем документс doc
        XWPFTable table1 = docX2.createTable();     //в нем создаем таблицу
        table1.setWidth(9640);                      //размер 17см

        XWPFTableRow row1 = table1.getRow(0);   //создаем ряд таблицы
        XWPFTableCell cell1 = row1.getCell(0);  //создаем ячейку

        // 1 ячейка
        cell1.setText("00");                        // присваиваем текст первой ячейки

        CTTcPr tcpr = cell1.getCTTc().addNewTcPr(); // создаем точку слияния
        CTVMerge vMerge = tcpr.addNewVMerge();      // добавить нов вертикальное слияние
                 vMerge.setVal(STMerge.RESTART);    // маяк для слияни restart-оставить при слиянии

        cell1 = row1.createCell();                  // создали вторую ячейку
        cell1.setText("01");                        // присваиваем текст

        tcpr = cell1.getCTTc().addNewTcPr();        // создаем точку слияния
        vMerge = tcpr.addNewVMerge();
        vMerge.setVal(STMerge.RESTART);

        cell1 = row1.createCell();
        cell1.setText("02");

        tcpr = cell1.getCTTc().addNewTcPr();
        vMerge = tcpr.addNewVMerge();
        vMerge.setVal(STMerge.RESTART);

        row1 = table1.createRow();                  // создание нового ряда

        cell1 = row1.getCell(0);
        cell1.setText("10");

        tcpr = cell1.getCTTc().addNewTcPr();
        vMerge = tcpr.addNewVMerge();
        vMerge.setVal(STMerge.CONTINUE);

        cell1 = row1.getCell(1);
        cell1.setText("11");

        tcpr = cell1.getCTTc().addNewTcPr();           // (берем ячейку cell1)-(получаем доступ к св-в getCTTc)-(присваиваем новые св-в)
        vMerge = tcpr.addNewVMerge();
        vMerge.setVal(STMerge.RESTART);

        cell1 = row1.getCell(2);
        cell1.setText("12");

        tcpr = cell1.getCTTc().addNewTcPr();
        vMerge = tcpr.addNewVMerge();
        vMerge.setVal(STMerge.CONTINUE);


        try (FileOutputStream out = new FileOutputStream("C:\\Users\\kopylov\\Desktop\\Project\\poi\\src\\main\\resources\\test\\AlMerge.docx")) {
            docX2.write(out);
        }
    }
}
