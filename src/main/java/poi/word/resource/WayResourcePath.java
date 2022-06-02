package poi.word.resource;

import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Iterator;

public class WayResourcePath {
    public static void main(String[] args) throws IOException {

        ClassPathResource f = new ClassPathResource("templateWord/NeedsOPI.docx");
        XWPFDocument doc = new XWPFDocument(f.getInputStream());
        Iterator<IBodyElement> pa = doc.getBodyElementsIterator();
    }
}
