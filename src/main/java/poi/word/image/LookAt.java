package poi.word.image;

public class LookAt {

}

//    XWPFDocument doc = new XWPFDocument();
//
//    XWPFParagraph title = doc.createParagraph();
//    XWPFRun run = title.createRun();
//    run.setText("Fig.1 A Natural Scene");
//    run.setBold(true);
//    title.setAlignment(ParagraphAlignment.CENTER);
//
//    String imgFile = "encabezado.jpg";
//    FileInputStream is = new FileInputStream(imgFile);
//    run.addBreak();
//    run.addPicture(is,
//    XWPFDocument.PICTURE_TYPE_JPEG, imgFile,
//            Units.toEMU(200),
//            Units.toEMU(200));
//    is.close();
//
//    FileOutputStream fos = new FileOutputStream("test4.docx");
//    doc.write(fos);
//    fos.close();
//}


//
//        	HSSFSheet sheet = workbook.createSheet ("Test"); // Создать рабочий лист (Sheet)
//        	FileInputStream stream=newFileInputStream("d:\\POI\\Apache.gif");
//
//        	byte[] bytes=new byte[(int)stream.getChannel().size()];
//        	stream.read (bytes); // Чтение изображения в двоичный массив
//
//        	int pictureIdx = workbook.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG);
//        	HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//        	HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short)0, 0, (short)5, 5);
//        	HSSFPicture pict = patriarch.createPicture(anchor,pictureIdx);
//        	//pict.resize();// Авто регулировка размера изображения, информация о положении изображения может быть потеряна
