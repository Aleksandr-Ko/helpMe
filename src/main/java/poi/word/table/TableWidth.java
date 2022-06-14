package poi.word.table;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.math.BigInteger;

public class TableWidth {
    public static void main(String[] args) {

        XWPFDocument document = new XWPFDocument();

        XWPFTable poiTable = document.createTable();

        CTTbl table = poiTable.getCTTbl();

        CTTblPr pr = table.getTblPr();

        CTTblWidth tblW = pr.getTblW();
        tblW.setW(BigInteger.valueOf(5000));
        tblW.setType(STTblWidth.PCT);

        pr.setTblW(tblW);

        table.setTblPr(pr);
    }

}
