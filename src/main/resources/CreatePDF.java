package org.example.pdfcreating;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;


public class CreatePDF {
    public static void main(String[] args) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

//            PDFont font = new PDType1Font(TIMES_ITALIC);
            PDType0Font font = PDType0Font.load(document, new File("src/main/resources/times.ttf"));

            PDImageXObject image = PDImageXObject.createFromFile("src/main/resources/img2.jpeg", document);
            PDImageXObject logo = PDImageXObject.createFromFile("src/main/resources/logo.png", document);
            //------------------------------------------------------------
            PDRectangle mediaBox = page.getMediaBox();

            float pageWidth = mediaBox.getWidth();
            float pageHeight = mediaBox.getHeight();
            //Ширина сторінки: 595.276
            //Висота сторінки: 841.890
            System.out.println("Ширина сторінки: " + pageWidth);
            System.out.println("Висота сторінки: " + pageHeight);
            //------------------------------------------------------------
            ()
            String lol = "Помилка \"Nested beginText() calls are not allowed\" вказує на те, що ви спробували викликати beginText() під час уже активного текстового блоку. У Apache PDFBox може бути лише один активний текстовий блок одночасно, тому вам потрібно викликати endText() перед початком нового текстового блоку.";
            StringBuilder form = new StringBuilder();

            System.out.println(form);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            //works
            contentStream.drawImage(logo, 20, 800, 20, 20);

            contentStream.setFont(font, 10);
            contentStream.beginText();
            contentStream.newLineAtOffset(45, 800);
            contentStream.showText("link");
            contentStream.endText();

            contentStream.drawImage(image, 73, 580, 450, 200);
            //works

            int line = 0;
///////////////////////////////////
            String[] words = lol.split("\\s+");  // Розділити вхідний текст на слова за пробілами
            StringBuilder currentLine = new StringBuilder();

            contentStream.drawImage(logo, 20, 800, 20, 20);
            contentStream.setFont(font, 14);//шрифт заголовку

            for (String word : words) {
                if (currentLine.length() + word.length() <= 80) {
                    currentLine.append(word).append(" ");
                } else {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(20, 550 - line);
                    contentStream.showText(currentLine.toString().trim());
                    line += 15;
                    System.out.println(currentLine);
                    contentStream.endText();
                    currentLine = new StringBuilder(word + " ");
                }
            }

// Запис останнього рядка (якщо є)
            contentStream.beginText();
            contentStream.newLineAtOffset(20, 550 - line);
            contentStream.showText(currentLine.toString().trim());
            contentStream.endText();
            contentStream.close();

///////////////////////////////////

            contentStream.close();

            document.save("example.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
