package poi.word.table;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MergingXWPFDocument {
    public static void main(String[] args) throws IOException {
        try (XWPFDocument wordDoc = new XWPFDocument()) {
            XWPFTable table = wordDoc.createTable(3, 4);

            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText("Стоимость ремонтных воздействий");

            XWPFTableRow tableRowTwo = table.getRow(1);
            tableRowTwo.getCell(0).setText("Наименование");
            tableRowTwo.getCell(1).setText("Цена");
            tableRowTwo.getCell(2).setText("Нормо-час");
            tableRowTwo.getCell(3).setText("Сумма");

            XWPFTableRow tableRowThree = table.getRow(2);
            table.setWidth(9640);
            tableRowThree.getCell(0).setText("");

            mergeCellHorizontally(table, 0, 0, 2);
            mergeCellHorizontally(table, 2, 0, 3);

            try (OutputStream os = new FileOutputStream(new File("C:\\Users\\kopylov\\Desktop\\Project\\work\\poi\\src\\main\\resources\\test\\mergingtable.docx"))) {
                wordDoc.write(os);
            }
        }
    }

    static void mergeCellHorizontally(XWPFTable table, int row, int fromCol, int toCol) {
        for (int colIndex = fromCol; colIndex <= toCol; colIndex++) {
            CTHMerge hmerge = CTHMerge.Factory.newInstance();
            if (colIndex == fromCol) {
                hmerge.setVal(STMerge.RESTART);
            } else {
                hmerge.setVal(STMerge.CONTINUE);
            }
            XWPFTableCell cell = table.getRow(row).getCell(colIndex);
            CTTcPr tcPr = cell.getCTTc().getTcPr();
            if (tcPr != null) {
                tcPr.setHMerge(hmerge);
            } else {
                tcPr = CTTcPr.Factory.newInstance();
                tcPr.setHMerge(hmerge);
                cell.getCTTc().setTcPr(tcPr);
            }
        }
    }
}
