package com.recipes.dbfiller;

import com.recipes.entity.*;
import com.recipes.repository.*;
import jakarta.annotation.PostConstruct;
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

    private final UserRepository userService;
    private final AuthenticationRepository authenticationService;
    private final RecipeRepository recipeService;
    private final QuantityRepository quantityService;
    private final DishCategoryRepository dishCategoryService;
    private final IngredientRepository ingredientService;
    private final MeasureUnitRepository measureUnitService;
    private final CountryRepository countryService;

    private int limit = 2;
    private int limit2 = 2;

    //User
    @Value(value = "${dbFiller.firstNamesPath}")
    private String firstNamesPath;
    @Value(value = "${dbFiller.lastNamePath}")
    private String lastNamePath;
    @Value(value = "${dbFiller.eMailsPath}")
    private String eMailsPath;
    @Value(value = "${dbFiller.aboutMePath}")
    private String aboutMePath;
    @Value(value = "${dbFiller.skillsPath}")
    private String skillsPath;
    @Value(value = "${dbFiller.linkPath}")
    private String linkPath;

    //Authentication
    @Value(value = "${dbFiller.rolePath}")
    private String rolePath;
    @Value(value = "${dbFiller.loginPath}")
    private String loginPath;
    @Value(value = "${dbFiller.passwordPath}")
    private String passwordPath;

    //Recipe
    @Value(value = "${dbFiller.recipeNamePath}")
    private String recipeNamePath;
    @Value(value = "${dbFiller.descriptionPath}")
    private String descriptionPath;
    @Value(value = "${dbFiller.instructionPath}")
    private String instructionPath;
    @Value(value = "${dbFiller.dishTypePath}")
    private String dishTypePath;
    @Value(value = "${dbFiller.imageLinkPath}")
    private String imageLinkPath;

    //Quantity
    @Value(value = "${dbFiller.valuePath}")
    private String valuePath;

    //DishCategory
    @Value(value = "${dbFiller.categoryNamePath}")
    private String categoryNamePath;

    //MeasureUnit
    @Value(value = "${dbFiller.unitPath}")
    private String unitPath;

    //Ingredient
    @Value(value = "${dbFiller.ingredientNamePath}")
    private String ingredientNamePath;

    //country
    @Value(value = "${dbFiller.countryPath}")
    private String countryPath;


    private Random random = new Random();

    @PostConstruct
    public void init(){
        fill();
    }

    public void fill(){
        for (int i = 0; i < limit; i++) {
            User user = userService.save( fillUser());
            Authentication authentication = authenticationService.save(fillAuthentication(user));
            DishCategory dishCategory = dishCategoryService.save(fillDishCategory());
            MeasureUnit measureUnit = measureUnitService.save(fillMeasureUnit());
            for (int j = 0; j < limit2; j++) {
                Country country = countryService.save(fillCountry());
                Recipe recipe = recipeService.save(fillRecipe(user, country, dishCategory));
                Quantity quantity = quantityService.save(fillQuantity(measureUnit, recipe));
                Ingredient ingredient = ingredientService.save(fillIngredient(quantity));
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
        generatedUser.setLink(randomChoice(linkPath));

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
        generatedCountry.setName(randomChoice(countryPath));
        return generatedCountry;
    }

    private Recipe fillRecipe(User user, Country country, DishCategory category){
        double min = 1.0;
        double max = 5.0;
        Double rating = Math.round((Math.random() * (max - min) + min) * 10.0) / 10.0;

        Recipe generatedRecipe = new Recipe();
        generatedRecipe.setImageName(randomChoice(linkPath));
        generatedRecipe.setName("r");
        generatedRecipe.setDescription(randomChoice(descriptionPath));
        generatedRecipe.setInstruction(randomChoice(instructionPath));
        generatedRecipe.setCookingTime(random.nextInt(1, 251));
        generatedRecipe.setRating(rating);
        generatedRecipe.setImageName(randomChoice(imageLinkPath));
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
        int choice = new Random().nextInt(0, list.size());
        return list.get(choice);
    }
}
