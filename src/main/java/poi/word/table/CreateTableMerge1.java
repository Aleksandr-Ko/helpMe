package poi.word.table;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileOutputStream;
import java.math.BigInteger;

public class CreateTableMerge1 {
    public static void main(String[] args) throws Exception {

        try (XWPFDocument doc = new XWPFDocument()) {

            XWPFTable table1 = doc.createTable(3,7); // This is your row 1  (1.1)
            table1.setWidth(9640);
//            XWPFTable table2 = doc.createTable(1,7); // This is your row 2  (1.3)
//            table2.setWidth(9640);

// Теперь пришло время охватить каждый столбец table1 и table2 диапазоном по вашему выбору.
// скажем, 6 - это требуемый общий диапазон, если есть некоторая строка с 6 столбцами.
                                        // не рабочие конструкции
            spanCellsAcrossRow(table1, 0, 0, 2);
            spanCellsAcrossRow(table1, 1, 1, 2);
            spanCellsAcrossRow(table1, 2, 2, 2);
//            spanCellsAcrossRow(table2, 0, 1, 2);
//            spanCellsAcrossRow(table2, 0, 2, 2);


            try (FileOutputStream out = new FileOutputStream("C:\\Users\\kopylov\\Desktop\\Project\\poi\\src\\main\\resources\\test\\Merge1.docx")) {
                doc.write(out);
            }
            System.out.println("Merge1 Готово");
        }
    }

    // диапазон ячеек по строке
    static private void spanCellsAcrossRow(XWPFTable table, int rowNum, int colNum, int span) {
        XWPFTableRow tableRow = table.getRow(rowNum);
        XWPFTableCell cell = tableRow.getCell(colNum);

        cell.getCTTc().addNewTcPr().addNewGridSpan();
//        cell.getCTTc().getTcPr().addNewGridSpan();
        cell.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf((long) span));
    }
}
// удаление из xml
//    cellRow = table3.getRow(0).getCell(2);
//    cellRow.getCTTc().newCursor().removeXml();
//    cellRow = table3.getRow(0).getCell(1);
//    cellRow.getCTTc().newCursor().removeXml();




