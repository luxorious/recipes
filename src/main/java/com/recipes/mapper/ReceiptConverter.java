package com.recipes.mapper;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.ReceiptDTO;
import com.recipes.entity.Recipe;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public record ReceiptConverter(ModelMapper mapper) {
    public ReceiptDTO receiptToDTO(Recipe recipe) {
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

    public Recipe receiptToDTO(CreateReceiptDTO dto) {
        return mapper.map(dto, Recipe.class);
    }

    public List<ReceiptDTO> listReceiptsToDTO(List<Recipe> recipes){
        return recipes.stream()
                .map(recipe -> mapper.map(recipe, ReceiptDTO.class))
                .collect(Collectors.toList());
    }
}
