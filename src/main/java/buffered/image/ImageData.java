package buffered.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;


// https://coderlessons.com/tutorials/akademicheskii/tsifrovaia-obrabotka-izobrazhenii-s-ispolzovaniem-java/klass-java-bufferedimage
public class ImageData {
    public static void main(String[] args) throws IOException {

        String data = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPAAAADwCAYAAAA+VemSAAAgAEl...==";

        String base64Image = data.split(",")[1];

        // с потоком байтов можно делать все что хочешь
        byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);

        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));

    }
}
