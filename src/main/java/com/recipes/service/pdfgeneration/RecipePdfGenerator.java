package com.recipes.service.pdfgeneration;

import com.recipes.entity.Recipe;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RecipePdfGenerator {
    @Value(value = "${recipePdfGenerator.fontPath}")
    private String fontPath;
    @Value(value = "${recipePdfGenerator.logoPath}")
    private String logoPath;
    @Value(value = "${recipePdfGenerator.logoHeight}")
    private float logoHeight;
    @Value(value = "${recipePdfGenerator.logoWidth}")
    private float logoWidth;
    @Value(value = "${recipePdfGenerator.link}")
    private String link;
    @Value(value = "${recipePdfGenerator.startPositionFooterBlock1}")
    private float startPositionFooterBlock1;
    @Value(value = "${recipePdfGenerator.startPositionFooterBlock2}")
    private float startPositionFooterBlock2;
    @Value(value = "${recipePdfGenerator.startPositionFooterBlock3}")
    private float startPositionFooterBlock3;

    private float startPositionX = 20f;
    //таке число не випадкове, воно вирахуване з співвідношення сторін
//    зображення, яке вставляється і використовується лише в одному методі.
    private float startPositionXForImage = 73f;
    //зробити значення в проперті файлі
    private float imageWidth = 450;
    private float imageHeight = 200;
    private int fontSizeSmall = 10;
    private int fontSizeText = 14;
    private int footerFontSize = 20;
    private int tabulation = 10;
    private float verticalOffsetForText = 15;


    public void generateRecipes(List<Recipe> recipes) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(PDRectangle.A4);
            PDType0Font font = PDType0Font.load(document, new File(fontPath));
            PDImageXObject imageLogo = PDImageXObject.createFromFile(logoPath, document);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            float pageHeight = page.getMediaBox().getHeight();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private float adLogo(PDPageContentStream contentStream, PDImageXObject imageLogo, float pageHeight) throws IOException {
        pageHeight -= 41;
        contentStream.drawImage(imageLogo, startPositionX, pageHeight, logoWidth, logoHeight);
        contentStream.close();
        return pageHeight;
    }

    //що краще зробити метод, який додає все окремо ссилку, опис і тд, чи краще зробити
//    універсальний метод, який додає текст і в нього відповідно передавати параметри, які потрібні?
//    чи краще зробити щоб усі позиції всіх вкладень - мали б свої місця за константами?
    private void addLink(PDPageContentStream contentStream, PDType0Font font, float pageHeight) throws IOException {
        contentStream.setFont(font, fontSizeSmall);
        contentStream.beginText();
        float linkPosition = startPositionX + logoWidth + tabulation;
        contentStream.newLineAtOffset(linkPosition, pageHeight);
        contentStream.showText(link);
        contentStream.endText();
    }

    private void setRecipeImage(PDPageContentStream contentStream, PDImageXObject recipeImage, float pageHeight) throws IOException {
        pageHeight -= 0;
        //тут мало бути б 500 пікселів третій аргумент - в пробному файлі - вирахував оптимальне положення
        contentStream.drawImage(recipeImage, startPositionXForImage, pageHeight, imageWidth, imageHeight);
        contentStream.close();
    }

    //додає 1 строку в файл
    private void addStringText(PDPageContentStream contentStream, PDType0Font font, String text, float pageHeight) throws IOException {
        contentStream.setFont(font, fontSizeText);
        contentStream.beginText();
        contentStream.newLineAtOffset(startPositionX, pageHeight);
        contentStream.showText(text);
        contentStream.endText();
        contentStream.close();
        pageHeight-= verticalOffsetForText;
    }

    private void addFooter(PDPageContentStream contentStream, PDType0Font font, String text, float pageHeight) throws IOException {
        contentStream.setFont(font, footerFontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(startPositionFooterBlock1, pageHeight);
    }
    //зробити метод, який вираховуватиме позицію елемента по у
    private void calculateYPosition(float elementsHeight){
//зробити перевірку, чи нова позиція не вийде за межі верхньої точки футера + 1 відступ (напр 20 футер і 15 відступ)
// то точка не може бути нижчою ніж 35, якщо виходить нижче, то перенести на нову сторінку і наша пісня гарна нова починаймо її знову
    }
}
