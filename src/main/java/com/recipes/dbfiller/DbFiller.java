package com.recipes.dbfiller;

import com.recipes.entity.Authentication;
import com.recipes.entity.Country;
import com.recipes.entity.DishCategory;
import com.recipes.entity.Ingredient;
import com.recipes.entity.MeasureUnit;
import com.recipes.entity.Quantity;
import com.recipes.entity.Recipe;
import com.recipes.entity.User;
import com.recipes.service.interfaces.AuthenticationService;
import com.recipes.service.interfaces.CountryService;
import com.recipes.service.interfaces.DishCategoryService;
import com.recipes.service.interfaces.IngredientService;
import com.recipes.service.interfaces.MeasureUnitService;
import com.recipes.service.interfaces.QuantityService;
import com.recipes.service.interfaces.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Data
@Component
@RequiredArgsConstructor
@Slf4j
public class DbFiller {

    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final RecipeService recipeService;
    private final QuantityService quantityService;
    private final DishCategoryService dishCategoryService;
    private final IngredientService ingredientService;
    private final MeasureUnitService measureUnitService;
    private final CountryService countryService;

    private int limit = 10;
    private int limit2 = 10;

    //User
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/firstNamesPath.txt}")
    private String firstNamesPath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/eMailsPath.txt}")
    private String lastNamePath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/firstNamesPath.txt}")
    private String eMailsPath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/aboutMePath.txt}")
    private String aboutMePath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/skillsPath.txt}")
    private String skillsPath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/linkPath.txt}")
    private String linkPath;

    //Authentication
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/rolePath.txt}")
    private String rolePath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/loginPath.txt}")
    private String loginPath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/passwordPath.txt}")
    private String passwordPath;

    //Recipe
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/recipeNamePath.txt}")
    private String recipeNamePath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/descriptionPath.txt}")
    private String descriptionPath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/instructionPath.txt}")
    private String instructionPath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/dishTypePath.txt}")
    private String dishTypePath;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/imageLinkPath.txt}")
    private String imageLinkPath;

    //Quantity
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/valuePath.txt}")
    private String valuePath;

    //DishCategory
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/categoryNamePath.txt\n}")
    private String categoryNamePath;

    //MeasureUnit
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/unitPath.txt}")
    private String unitPath;

    //Ingredient
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/ingredientNamePath.txt}")
    private String ingredientNamePath;

    //country;
    @Value(value = "${dbFiller.firstNamesPath=src/main/resources/databasefiller/countryPath.txt}")
    private String countryPath;


    private Random random = new Random();

    public void fill(){
        for (int i = 0; i < limit; i++) {
            User user = fillUser();
            Authentication authentication = fillAuthentication(user);
            DishCategory dishCategory = fillDishCategory();
            MeasureUnit measureUnit = fillMeasureUnit();
            for (int j = 0; j < limit2; j++) {
                Country country = fillCountry();
                Recipe recipe = fillRecipe(user, country, dishCategory);
                Quantity quantity = fillQuantity(measureUnit, recipe);
                Ingredient ingredient = fillIngredient(quantity);
            }
        }
    }

    private User fillUser(){
        User generatedUser = new User();
        generatedUser.setFirstName(randomChoice(firstNamesPath));
        generatedUser.setLastName(randomChoice(lastNamePath));
        generatedUser.setEMail(randomChoice(eMailsPath));
        generatedUser.setAboutMe(randomChoice(aboutMePath));
        generatedUser.setSkills(randomChoice(skillsPath));
        generatedUser.setLinks(randomChoice(linkPath));

        return generatedUser;
    }

    private Quantity fillQuantity(MeasureUnit unit, Recipe recipe){
        Quantity generatedQuantity = new Quantity();
        generatedQuantity.setValue(randomChoice(valuePath));

        generatedQuantity.setRecipe(recipe);
        generatedQuantity.setMeasureUnit(unit);
        return generatedQuantity;
    }

    private MeasureUnit fillMeasureUnit(){
        MeasureUnit generatedMeasureUnit = new MeasureUnit();
        generatedMeasureUnit.setUnit(randomChoice(unitPath));

        return generatedMeasureUnit;
    }

    private Ingredient fillIngredient(Quantity quantity){
        Ingredient generatedIngredient = new Ingredient();
        generatedIngredient.setName(randomChoice(ingredientNamePath));
        generatedIngredient.setQuantity(quantity);

        return generatedIngredient;
    }

    private DishCategory fillDishCategory(){
        DishCategory category = new DishCategory();
        category.setCategoryName(randomChoice(categoryNamePath));

        return category;
    }
    private Authentication fillAuthentication(User user){
        Authentication generatedAuthentication = new Authentication();
        generatedAuthentication.setRole(randomChoice(rolePath));
        generatedAuthentication.setLogin(randomChoice(loginPath));
        generatedAuthentication.setPassword(randomChoice(passwordPath));

        generatedAuthentication.setUser(user);
        return generatedAuthentication;
    }

    private Country fillCountry(){
        Country generatedCountry = new Country();
        generatedCountry.setCountry(randomChoice(countryPath));
        return generatedCountry;
    }
    private Recipe fillRecipe(User user, Country country, DishCategory category){
        Recipe generatedRecipe = new Recipe();

        generatedRecipe.setImageLink(randomChoice(linkPath));
        generatedRecipe.setName(randomChoice(recipeNamePath));
        generatedRecipe.setDescription(randomChoice(descriptionPath));
        generatedRecipe.setInstruction(randomChoice(instructionPath));
        generatedRecipe.setCookingTime(random.nextInt(30,250));
        generatedRecipe.setRating(random.nextDouble(1, 6));
        generatedRecipe.setImageLink(imageLinkPath);
        generatedRecipe.setUser(user);
        generatedRecipe.setDishType(randomChoice(dishTypePath));
        generatedRecipe.setCategory(category);
        generatedRecipe.setCountry(country);

        return generatedRecipe;
    }

    private List<String> writeFromFileToList(String filePath) {
        File file = new File(filePath);
        List<String> stringsFromFile;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            stringsFromFile = bufferedReader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringsFromFile;
    }

    /**
     * Randomly selects a string from the file located at the given path.
     *
     * @param path The file path to read strings from.
     * @return The randomly chosen string from the file.
     */
    private String randomChoice(String path) {
        List<String> list = writeFromFileToList(path);
        return randomChoice(list);
    }

    /**
     * Randomly selects an element from the given list.
     *
     * @param list The list of elements to choose from.
     * @param <T>  The type of elements in the list.
     * @return The randomly chosen element.
     */
    private <T> T randomChoice(List<T> list) {
        int choice = new Random().nextInt(list.size());
        return list.get(choice);
    }
}
