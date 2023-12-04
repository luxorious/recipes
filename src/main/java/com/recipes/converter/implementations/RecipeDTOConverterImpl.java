package com.recipes.converter.implementations;

import com.recipes.converter.interfaces.RecipeDTOConverter;
import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Country;
import com.recipes.entity.DishCategory;
import com.recipes.entity.Recipe;
import com.recipes.entity.User;
import com.recipes.service.crud.interfaces.CountryService;
import com.recipes.service.crud.interfaces.DishCategoryService;
import com.recipes.service.crud.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RecipeDTOConverterImpl implements RecipeDTOConverter {

    private final ModelMapper mapper;
    private final UserService userService;
    private final DishCategoryService categoryService;
    private final CountryService countryService;

    @Value("${savingFiles.pathSavingImages}")
    private String pathSavingImages;

    @Override
    public RecipeDTO toDto(Recipe recipe) {
        RecipeDTO dto = mapper.map(recipe, RecipeDTO.class);

        dto.setLastName(recipe.getUser().getLastName());
        dto.setFirstName(recipe.getUser().getFirstName());
        dto.setCountryName(recipe.getCountry().getName());
        dto.setCategoryName(recipe.getCategory().getCategoryName());

        return dto;
    }

    @Override
    public Recipe toEntity(CreateReceiptDTO dto, String imageName) {
        User user = userService.findByIdEntity(dto.getUserId());
        DishCategory category = categoryService.findById(dto.getCategoryId());
        Country country = countryService.findById(dto.getCountryId());

        Recipe recipe = mapper.map(dto, Recipe.class);

        recipe.setImageName(pathSavingImages + imageName);
        recipe.setUser(user);
        recipe.setCountry(country);
        recipe.setCategory(category);

        return recipe;
    }

    @Override
    public List<RecipeDTO> toListDto(List<Recipe> recipes) {
        List<RecipeDTO> listDto = new ArrayList<>();
        for (Recipe recipe : recipes) {
            RecipeDTO dto = toDto(recipe);
            listDto.add(dto);
        }
        return listDto;
    }
}
