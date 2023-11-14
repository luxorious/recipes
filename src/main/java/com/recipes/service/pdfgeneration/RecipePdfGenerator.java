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
import java.util.ArrayList;
import java.util.List;

public class RecipePdfGenerator {
    @Value(value = "${recipePdfGenerator.fontPath}")
    private String fontPath = "src/main/resources/times.ttf";

    @Value(value = "${recipePdfGenerator.imgBookCover}")
    private String imgBookCover = "src/main/resources/pdf-resources/cover.jpg";

    @Value(value = "${recipePdfGenerator.logoPath}")
    private String logoPath = "src/main/resources/logo/logo.png";

    @Value(value = "${recipePdfGenerator.logoHeight}")
    private float logoHeight = 20;

    @Value(value = "${recipePdfGenerator.logoWidth}")
    private float logoWidth = 20;

    @Value(value = "${recipePdfGenerator.link}")
    private String link = "recipes.com";

    @Value(value = "${recipePdfGenerator.startPositionFooterBlock1}")
    private float startPositionFooterBlock1 = 20;

    @Value(value = "${recipePdfGenerator.imgPathDishType}")
    private String imgDishType = "src/main/resources/pdf-resources/dishType.png";

    @Value(value = "${recipePdfGenerator.startPositionFooterBlock2}")
    private float startPositionFooterBlock2 = 185;

    @Value(value = "${recipePdfGenerator.imgPathRating}")
    private String imgPathRating = "src/main/resources/pdf-resources/rating.png";

    @Value(value = "${recipePdfGenerator.startPositionFooterBlock3}")
    private float startPositionFooterBlock3 = 370;

    @Value(value = "${recipePdfGenerator.imgPathCockingTime}")
    private String imgCockingTime = "src/main/resources/pdf-resources/cockingTime.png";

    @Value(value = "${recipePdfGenerator.startPositionX}")
    private float startPositionX = 20f;

    @Value(value = "${recipePdfGenerator.startPositionXForRecipePhoto}")
    private float startPositionXForRecipePhoto = 73f;

    @Value(value = "${recipePdfGenerator.recipePhotoWidth}")
    private float recipePhotoWidth = 450;

    @Value(value = "${recipePdfGenerator.recipePhotoHeight}")
    private float recipePhotoHeight = 200;

    @Value(value = "${recipePdfGenerator.fontSizeLink}")
    private int fontSizeLink = 10;

    @Value(value = "${recipePdfGenerator.fontSizeAuthorName}")
    private int fontSizeAuthorName = 10;

    @Value(value = "${recipePdfGenerator.fontSizeText}")
    private int fontSizeText = 14;

    @Value(value = "${recipePdfGenerator.fontSizeRecipeName}")
    private int fontSizeRecipeName = 14;

    @Value(value = "${recipePdfGenerator.footerFontSize}")
    private int footerFontSize = 20;

    @Value(value = "${recipePdfGenerator.footerFontSize}")
    private int pageNumberFontSize = 10;

    @Value(value = "${recipePdfGenerator.tabulation}")
    private int tabulation = 10;

    @Value(value = "${recipePdfGenerator.footerHeight}")
    private float footerHeight = 25;

    @Value(value = "${recipePdfGenerator.iconSize}")
    private float iconSize = 20;

    @Value(value = "${recipePdfGenerator.textOffset}")
    private float textOffset = 3;

    @Value(value = "${recipePdfGenerator.content}")
    private String content = "Зміст";

    @Value(value = "${recipePdfGenerator.startPositionY}")
    private float startPositionY = 40;

    private PDDocument document = new PDDocument();
    private PDType0Font font = PDType0Font.load(document, new File(fontPath));
    private PDPage page = new PDPage(PDRectangle.A4);
    private PDPageContentStream contentStream = new PDPageContentStream(document, page);
    private float pageHeight = page.getMediaBox().getHeight() - tabulation;
    private final float pageHeightPoints = page.getMediaBox().getHeight();

    private final float pageWidth = page.getMediaBox().getWidth();

    private int pageNumber = 1;

    public RecipePdfGenerator() throws IOException {
        //empty constructor due to the fact that the variable "font" - can throw an error,
        // and it was necessary to initialize the no args constructor
    }

    public PDDocument generateRecipesBook(List<Recipe> recipes) throws IOException {
        addBookCover();
        List<String> contents = new ArrayList<>();
        for (Recipe recipe : recipes) {
            generateRecipe(recipe);
            contents.add(recipe.getName());
            pageNumber++;
        }
        generateContents(contents);
        pageNumber = 1;
        contentStream.close();
        document.save("doc.pdf");
        return document;
    }

    public void generateRecipe(Recipe recipe) throws IOException {
        addAdditionalPage();
        PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);
        PDImageXObject recipeImage = PDImageXObject.createFromFile(recipe.getImageLink(), document);
        //page number
        addStringText(String.valueOf(pageNumber), pageNumberFontSize, 570, 10);
        //add footer
        List<String> iconPaths = List.of(imgPathRating, imgCockingTime, imgDishType);
        List<String> footerData = List.of(String.valueOf(recipe.getRating()),
                String.valueOf(recipe.getCookingTime()),
                recipe.getDishType());
        List<Float> blockSizes = List.of(startPositionFooterBlock1, startPositionFooterBlock2, startPositionFooterBlock3);

        for (int i = 0; i < iconPaths.size(); i++) {
            PDImageXObject icon = PDImageXObject.createFromFile(iconPaths.get(i), document);
            addFooter(icon, footerData.get(i), blockSizes.get(i));
        }

        //add logo
        addImage(logo, startPositionX, logoWidth, logoHeight);
        //add link
        float linkXPosition = startPositionX + logoWidth + tabulation;
        addStringText(link, fontSizeLink, linkXPosition, pageHeight + logoHeight);
        //add recipe photo
        addImage(recipeImage, startPositionXForRecipePhoto, recipePhotoWidth, recipePhotoHeight);
        //add author
        String authorName = recipe.getUser().getFirstName() + " " + recipe.getUser().getLastName();
        float authorNameXPosition = calculateMiddleXPosition(authorName, fontSizeAuthorName);
        addStringText(authorName, fontSizeAuthorName, authorNameXPosition, pageHeight);
        pageHeight = calculateYPosition(tabulation);
        //add recipe`s name
        String recipeName = recipe.getName();
        float recipeNamePositionX = calculateMiddleXPosition(recipeName, fontSizeAuthorName);
        addStringText(recipeName, fontSizeRecipeName, recipeNamePositionX, pageHeight);
        //add description
        String description = recipe.getDescription();
        addText(description, fontSizeText);
        //add instructions
        pageHeight = calculateYPosition(tabulation);
        String instructions = recipe.getInstruction();
        addText(instructions, fontSizeText);
        pageHeight = page.getMediaBox().getHeight() - tabulation;
    }

    public void addBookCover() throws IOException {
        addAdditionalPage();
        PDImageXObject cover = PDImageXObject.createFromFile(imgBookCover, document);
        float coverWidth = page.getMediaBox().getWidth();
        float coverHeight = page.getMediaBox().getHeight();
        float zeroPosition = 0;
        contentStream.drawImage(cover, zeroPosition, zeroPosition, coverWidth, coverHeight);
        pageHeight = coverHeight - tabulation;
        System.out.println("cover");
    }

    public void addImage(PDImageXObject image, float x, float width, float height) throws IOException {
        pageHeight = calculateYPosition(height);
        contentStream.drawImage(image, x, pageHeight, width, height);
        pageHeight = calculateYPosition(tabulation);
    }

    private void addText(String text, int fontSize) throws IOException {
        String[] words = text.split("\\s+");
        StringBuilder currentLine = new StringBuilder();
        for (String word : words) {
            float stringWidth = font.getStringWidth(String.valueOf(currentLine)) * fontSize / 1000f;
            float wordWidth = font.getStringWidth(word) * fontSize / 1000f;
            if (stringWidth + wordWidth < pageWidth - startPositionX * 2) {
                currentLine.append(word).append(" ");
            } else {
                addStringText(currentLine.toString().trim(), fontSize, startPositionX, pageHeight);
                currentLine = new StringBuilder(word + " ");
            }
        }
        addStringText(currentLine.toString().trim(), fontSize, startPositionX, pageHeight);
        pageHeight = calculateYPosition(tabulation);
    }

    private void addStringText(String text, int fontSize, float x, float y) throws IOException {
        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
        pageHeight = calculateYPosition(fontSize + textOffset);
    }

    private void generateContents(List<String> contents) throws IOException {
        addAdditionalPage();
        pageHeight-=startPositionY;
        float x = calculateMiddleXPosition(content, fontSizeRecipeName*2);
        addStringText(content,footerFontSize, x, pageHeight);
        for (int i = 0; i < contents.size(); i++) {
            addStringText(getContentsString(contents.get(i), fontSizeRecipeName, i+1),
                    fontSizeRecipeName, startPositionX, pageHeight);
        }
    }

    private String getContentsString(String textString, int fontSize, int pageNumber) throws IOException {
        StringBuilder string = new StringBuilder();
        string.append(textString);
        while (true){
            float length = font.getStringWidth(String.valueOf(string)) * fontSize / 1000f - 1;
            if (length < pageWidth-startPositionX*2){
                string.append(".");
            } else {
                string.append(pageNumber);
                return string.toString();
            }
        }
    }

    private void addFooter(PDImageXObject image, String text, float x) throws IOException {
        contentStream.drawImage(image, x, footerHeight, iconSize, iconSize);
        contentStream.setFont(font, footerFontSize);
        contentStream.beginText();
        float textPosition = x + iconSize + tabulation;
        contentStream.newLineAtOffset(textPosition, footerHeight + textOffset);
        contentStream.showText(text);
        contentStream.endText();
    }

    private float calculateMiddleXPosition(String text, int fontSize) throws IOException {
        float wordWidth = font.getStringWidth(String.valueOf(text)) * fontSize / 1000f;
        return (pageWidth / 2 - wordWidth / 2);
    }

    private float calculateYPosition(float elementsHeight) throws IOException {
        if (pageHeight - elementsHeight <= footerHeight + footerHeight) {
            addAdditionalPage();
            return pageHeightPoints - 40;
        } else {
            return pageHeight - elementsHeight;
        }
    }

    private void addAdditionalPage() throws IOException {
        PDPage newPage = new PDPage(PDRectangle.A4);
        contentStream.close();
        document.addPage(newPage);
        pageHeight = newPage.getMediaBox().getHeight();
        contentStream = new PDPageContentStream(document, newPage);
    }
}
