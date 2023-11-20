package com.recipes.converter;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.RecipeDTO;
import com.recipes.entity.Recipe;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RecipeDTOConverter {

    private final ModelMapper mapper;

    public RecipeDTO toDto(Recipe recipe) {
        return mapper.typeMap(Recipe.class, RecipeDTO.class)
                .addMapping(src->src.getCategory().getCategoryName(),
                        (dest, name)-> dest.setCategoryName((String) name))
                .addMapping(src->src.getUser().getFirstName() + src.getUser().getLastName(),
                        (dest, fullName)->dest.setFirstName((String) fullName))
                .addMapping(src->src.getCountry().getName(),
                        (dest, countryName)->dest.setCountry((String) countryName))
                .map(recipe);
    }

    public Recipe toEntity(CreateReceiptDTO dto) {
        return mapper.typeMap(CreateReceiptDTO.class, Recipe.class)
                .addMapping(CreateReceiptDTO::getCategoryId,
                        (dest, id) -> dest.getCategory().setId((Long) id))
                .addMapping(CreateReceiptDTO::getUserId,
                        (dest, id)->dest.getUser().setId((Long) id))
//                .addMapping(srs->srs.getQuantityId(),
//                        (dest, id)->dest.getQuantity().setId((Long) id))
                .addMapping(CreateReceiptDTO::getCountryId,
                        (dest, id)->dest.getCountry().setId((Long) id))
                .map(dto);
    }

    public List<RecipeDTO> toListDto(List<Recipe> recipes) {
        return recipes.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
