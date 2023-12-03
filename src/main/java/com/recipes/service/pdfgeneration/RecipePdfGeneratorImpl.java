package com.recipes.service.pdfgeneration;

import com.recipes.entity.Recipe;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipePdfGeneratorImpl implements RecipePdfGenerator {

    @Value("${savingFiles.pathSavingPDfBook}")
    private String pathSavingPDfBook ="src/main/resources/save-recipes/book-";

    @Value("${savingFiles.pathSavingPDfPage}")
    private String pathSavingPDfPage ="src/main/resources/save-recipes/page-";

    @Value("${savingFiles.bookFormat}")
    private String bookFormat=".pdf";

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

    private PDDocument document;// = new PDDocument();
    private PDType0Font font;// = PDType0Font.load(document, new File(fontPath));
    private PDPage page;// = new PDPage(PDRectangle.A4);
    private PDPageContentStream contentStream;//;// = new PDPageContentStream(document, page);
    private float pageHeight ;//= page.getMediaBox().getHeight() - tabulation;
    private float pageHeightPoints;//;// = page.getMediaBox().getHeight();
    private float pageWidth ;//= page.getMediaBox().getWidth();
    private int pageNumber ;//= 1;


    public RecipePdfGeneratorImpl() throws IOException {
        init();
    }

    private void init()throws IOException{
        this.document = new PDDocument();
        this.font = PDType0Font.load(document, new File(fontPath));
        this.page = new PDPage(PDRectangle.A4);
        this.contentStream = new PDPageContentStream(document, page);
        this.pageHeight = page.getMediaBox().getHeight() - tabulation;
        this.pageHeightPoints = page.getMediaBox().getHeight();
        this.pageWidth = page.getMediaBox().getWidth();
        this.pageNumber = 1;
    }

    /**
     * Generates a PDF document containing a book of recipes from the provided list of Recipe objects.
     *
     * @param recipes A list of Recipe objects to include in the book.
     * @return The PDDocument representing the generated recipes book.
     * @throws IOException If an I/O exception occurs while generating the document.
     */
    @Override
    public String generateRecipesBook(List<Recipe> recipes) throws IOException {
        addBookCover();
        List<String> contents = new ArrayList<>();
        for (Recipe recipe : recipes) {
            generatePage(recipe);
            contents.add(recipe.getName());
            pageNumber++;
        }
        generateContents(contents);
        pageNumber = 1;
        contentStream.close();
        String path = pathSavingPDfBook + System.currentTimeMillis()+bookFormat;
        document.save(path);
        document.close();
        init();

        //зробити метод, який повинен автоматично видаляти документ + документ назвати пейдж-час.пдф
        return path;
    }

    /**
     * Generates a PDF document based on the provided recipe.
     * Adds recipe details, images, page numbers, and footer.
     *
     * @param recipe The recipe object containing details to be added to the PDF.
     * @return The generated PDF document.
     * @throws IOException If an I/O error occurs during PDF creation.
     */
    @Override
    public String generateRecipe(Recipe recipe) throws IOException {
        PDDocument doc = generatePage(recipe);
        contentStream.close();
        String path = pathSavingPDfPage + System.currentTimeMillis()+bookFormat;
        doc.save(path);
        doc.close();
        init();
        return path;
    }

    //after coll method - must use method doc.close()

    private PDDocument generatePage(Recipe recipe) throws IOException {
        addAdditionalPage();
        PDImageXObject logo = PDImageXObject.createFromFile(logoPath, document);
        PDImageXObject recipeImage = PDImageXObject.createFromFile(recipe.getImageName(), document);
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
        //add a recipe photo
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
        return document;
    }

    /**
     * Adds the book cover image to the current document on a new additional page.
     * The method creates an additional page, places the book cover image on it, and adjusts the page height accordingly.
     *
     * @throws IOException If an I/O error occurs while processing the book cover image.
     */
    private void addBookCover() throws IOException {
        addAdditionalPage();
        PDImageXObject cover = PDImageXObject.createFromFile(imgBookCover, document);
        float coverWidth = page.getMediaBox().getWidth();
        float coverHeight = page.getMediaBox().getHeight();
        float zeroPosition = 0;
        contentStream.drawImage(cover, zeroPosition, zeroPosition, coverWidth, coverHeight);
        pageHeight = coverHeight - tabulation;
        System.out.println("cover");
    }

    /**
     * Adds an image to the PDF document at specified coordinates and dimensions.
     *
     * @param image  The image to be added as a PDImageXObject.
     * @param x      The x-coordinate for the image placement.
     * @param width  The width of the image in points.
     * @param height The height of the image in points.
     * @throws IOException If there is an issue with adding the image to the document.
     */
    private void addImage(PDImageXObject image, float x, float width, float height) throws IOException {
        pageHeight = calculateYPosition(height);
        contentStream.drawImage(image, x, pageHeight, width, height);
        pageHeight = calculateYPosition(tabulation);
    }

    /**
     * Adds text to the PDF content stream with specified font size.
     *
     * @param text     The text content to be added.
     * @param fontSize The font size of the text.
     * @throws IOException If an input or output exception occurred.
     */
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

    /**
     * Adds text to the PDF document at the specified coordinates with the given font size.
     *
     * @param text     The text to be added to the document.
     * @param fontSize The size of the font to be used for the text.
     * @param x        The x-coordinate where the text should be placed.
     * @param y        The y-coordinate where the text should be placed.
     * @throws IOException If there's an issue while adding the text to the document.
     */
    private void addStringText(String text, int fontSize, float x, float y) throws IOException {
        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
        pageHeight = calculateYPosition(fontSize + textOffset);
    }

    /**
     * Creates a table of contents for the book based on the provided list of recipe names.
     * This method adds an extra page, calculates positions, and adds lines and numbering to the table of contents.
     *
     * @param contents List of strings representing the content to add.
     * @throws IOException If an I/O error occurs while creating the content.
     */
    private void generateContents(List<String> contents) throws IOException {
        addAdditionalPage();
        pageHeight -= startPositionY;
        float x = calculateMiddleXPosition(content, fontSizeRecipeName * 2);
        addStringText(content, footerFontSize, x, pageHeight);
        for (int i = 0; i < contents.size(); i++) {
            addStringText(getContentsString(contents.get(i), fontSizeRecipeName, i + 1),
                    fontSizeRecipeName, startPositionX, pageHeight);
        }
    }

    /**
     * Generates a content string based on provided parameters, ensuring the text fits within the specified page width.
     *
     * @param textString The initial text string to be considered.
     * @param fontSize   The font size used for the text.
     * @param pageNumber The current page number to be appended at the end of the content.
     * @return A formatted string that fits within the page width by potentially appending dots or the page number.
     * @throws IOException If an input/output exception occurs during font calculations.
     */
    private String getContentsString(String textString, int fontSize, int pageNumber) throws IOException {
        StringBuilder string = new StringBuilder();
        string.append(textString);
        while (true) {
            float length = font.getStringWidth(String.valueOf(string)) * fontSize / 1000f - 1;
            if (length < pageWidth - startPositionX * 2) {
                string.append(".");
            } else {
                string.append(pageNumber);
                return string.toString();
            }
        }
    }

    /**
     * Adds a footer to the PDF page with an image, text, and specified position.
     *
     * @param image The image to be added in the footer.
     * @param text  The text content to be displayed in the footer.
     * @param x     The x-coordinate position for the footer.
     * @throws IOException If an input or output exception occurs.
     */
    private void addFooter(PDImageXObject image, String text, float x) throws IOException {
        contentStream.drawImage(image, x, footerHeight, iconSize, iconSize);
        contentStream.setFont(font, footerFontSize);
        contentStream.beginText();
        float textPosition = x + iconSize + tabulation;
        contentStream.newLineAtOffset(textPosition, footerHeight + textOffset);
        contentStream.showText(text);
        contentStream.endText();
    }

    /**
     * Calculates the X-coordinate position to a center-align text horizontally on the page.
     *
     * @param text     The text for which the X-coordinate position needs to be calculated.
     * @param fontSize The font size of the text.
     * @return The X-coordinate position for center-aligning the text horizontally on the page.
     * @throws IOException If an IO exception occurs while fetching font metrics.
     */
    private float calculateMiddleXPosition(String text, int fontSize) throws IOException {
        float wordWidth = font.getStringWidth(String.valueOf(text)) * fontSize / 1000f;
        return (pageWidth / 2 - wordWidth / 2);
    }

    /**
     * Calculates the vertical position for elements based on their height on the page.
     * If the available space on the current page is insufficient for the element,
     * it adds a page and returns the vertical position on the new page.
     *
     * @param elementsHeight The height of the elements being placed on the page.
     * @return The calculated vertical position for the elements.
     * @throws IOException if an I/O exception occurs while adding a page.
     */
    private float calculateYPosition(float elementsHeight) throws IOException {
        if (pageHeight - elementsHeight <= footerHeight + footerHeight) {
            addAdditionalPage();
            return pageHeightPoints - 40;
        } else {
            return pageHeight - elementsHeight;
        }
    }

    /**
     * Adds a page to the document.
     * Closes the existing content stream, adds a new A4-sized page to the document,
     * updates the page height, and creates a new content stream for the added page.
     *
     * @throws IOException if an I/O error occurs while adding the page or creating the content stream
     */
    private void addAdditionalPage() throws IOException {
        PDPage newPage = new PDPage(PDRectangle.A4);
        contentStream.close();
        document.addPage(newPage);
        pageHeight = newPage.getMediaBox().getHeight();
        contentStream = new PDPageContentStream(document, newPage);
    }
}
