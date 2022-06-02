package poi.word.image;


public class ImageAl {

      /*

     * @param imageFile - файл картинки
     * @param параграф в вставить файл
     * @param customProperties
*/

    /*
    public static void addImagesToWordParagraph(File imageFile, XWPFParagraph paragraph, CustomProperties customProperties) {
        try {
            List<XWPFRun> runs = paragraph.getRuns();
            for (int i = 0; i < runs.size(); ) {
                paragraph.removeRun(i);
            }
            if (imageFile == null) {
                return;
            }

            BufferedImage bimg1 = ImageIO.read(imageFile);
            int width = bimg1.getWidth();
            int height = bimg1.getHeight();
            double multiplier = getMultiplier(width, height,
                    getDocumentWidth(paragraph.getDocument(), customProperties),
                    getDocumentHeight(paragraph.getDocument(), customProperties)
            );

            String imgFile = imageFile.getName();

            int imgFormat = getImageFormat(imgFile);
            XWPFRun run = paragraph.createRun();

            XWPFPicture picture = run.addPicture(new FileInputStream(imageFile), imgFormat, imgFile, Units.toEMU(width * multiplier), Units.toEMU(height * multiplier));


            //Добавление рамки для картинок + чтобы отображались верхняя и нижняя рамка - меняю размер (костыль)
            picture.getCTPicture().getSpPr().addNewLn().setW(Units.toEMU(0.25));
            picture.getCTPicture().getSpPr().getLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, 0});
            run.getCTR().getDrawingList().get(0).getInlineArray(0).getExtent().setCy(Units.toEMU(height * multiplier) - 1);
        } catch (IOException | InvalidFormatException ex) {
            LOG.warn(ex.getMessage());
        }
    }
*/

}
