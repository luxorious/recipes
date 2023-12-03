package com.recipes.service.crud.implementation;

import com.recipes.converter.interfaces.IngredientDtoConverter;
import com.recipes.dto.ingredient.IngredientDTO;
import com.recipes.entity.Ingredient;
import com.recipes.repository.IngredientRepository;
import com.recipes.service.crud.interfaces.IngredientService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;
    private final IngredientDtoConverter converter;

    @Override
    public IngredientDTO create(IngredientDTO dto) {
        Ingredient ingredient = converter.toEntity(dto);
        return converter.toDto(ingredient);
    }

    @Override
    public List<IngredientDTO> findAllIngredients() {
        List<Ingredient> ingredients = repository.findAllIngredients();
        return converter.toListDTO(ingredients);
    }

    @Override
    public boolean deleteIngredientById(Long id) {
        return repository.deleteIngredientById(id);
    }
}
