package com.recipes.converter;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.ReceiptDTO;
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

    public ReceiptDTO toDTO(Recipe recipe) {
        return mapper.typeMap(Recipe.class, ReceiptDTO.class)
                .addMapping(source -> source.getUser().getFirstName(),
                        ReceiptDTO::setFirstName)
                .addMapping(source -> source.getUser().getLastName(),
                        ReceiptDTO::setLastName)
                .addMapping(source -> source.getCategory().getCategoryName(),
                        ReceiptDTO::setCategoryName)
                .addMapping(source -> source.getCountry().getCountry(),
                        ReceiptDTO::setCountry)
                .addMapping(source -> source.getQuantity().getValue(),
                        ReceiptDTO::setValue)
                .map(recipe);
    }

    public Recipe toEntity(CreateReceiptDTO dto) {
        return mapper.map(dto, Recipe.class);
    }

    public List<ReceiptDTO> toListDTO(List<Recipe> recipes) {
        return recipes.stream()
                .map(recipe -> mapper.map(recipe, ReceiptDTO.class))
                .collect(Collectors.toList());
    }
}
