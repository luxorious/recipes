package com.recipes.mapper;

import com.recipes.DTO.CreateReceiptDTO;
import com.recipes.DTO.ReceiptDTO;
import com.recipes.entity.Receipt;
import com.recipes.entity.User;
import com.recipes.entity.enumerations.Categories;
import com.recipes.entity.enumerations.Countries;
import com.recipes.entity.enumerations.DishType;
import com.recipes.repository.UserRepository;
import com.recipes.service.component.interfaces.Converter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link ReceiptMapper} interface for mapping between
 * {@link Receipt} entity and {@link ReceiptDTO} DTO.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ReceiptMapperImpl implements ReceiptMapper {

    private final Converter<Categories> converter;

    /**
     * Converts a {@link Receipt} entity to a {@link ReceiptDTO} DTO.
     *
     * @param receipt The {@link Receipt} entity to be converted.
     * @return The corresponding {@link ReceiptDTO} DTO.
     */
    @Override
    public ReceiptDTO toDto(Receipt receipt) {
        ReceiptDTO dto = new ReceiptDTO();
        String authorName = receipt.getUser().getFirstName() + " " + receipt.getUser().getLastName();

        dto.setName(receipt.getName());
        dto.setDescription(receipt.getDescription());
        dto.setInstruction(receipt.getInstruction());
        dto.setIngredients(receipt.getIngredients());
        dto.setCookingTime(String.valueOf(receipt.getCookingTime()));
        dto.setRating(String.valueOf(receipt.getRating()));
        dto.setCountry(String.valueOf(receipt.getCountry()));
        dto.setDishType(String.valueOf(receipt.getDishType()));
        dto.setCategories(converter.convertEnumToStringList(receipt.getCategories()));
        dto.setImageLink(receipt.getImageLink());

        dto.setAuthorName(authorName);
        return dto;
    }

    /**
     * Converts a {@link ReceiptDTO} DTO to a {@link Receipt} entity.
     *
     * @param dto The {@link ReceiptDTO} DTO to be converted.
     * @return The corresponding {@link Receipt} entity.
     */

    @Override
    public Receipt toEntity(ReceiptDTO dto) {
        Receipt receipt = new Receipt();
        receipt.setName(dto.getName());
        receipt.setDescription(dto.getDescription());
        receipt.setInstruction(dto.getInstruction());
        receipt.setIngredients(dto.getIngredients());
        receipt.setCookingTime(Long.valueOf(dto.getCookingTime()));
        receipt.setRating(Double.valueOf(dto.getCookingTime()));
        receipt.setCountry(Countries.valueOf(dto.getCountry()));
        receipt.setDishType(DishType.valueOf(dto.getDishType()));
        receipt.setCategories(converter.convertStringListToEnumList(dto.getCategories()));
        receipt.setImageLink(dto.getImageLink());
        return receipt;
    }

//на той випадок, якщо варіант з анотацією не спрацює...
//    @Override
//    public Receipt toEntity(ReceiptDTO dto) {
//        Receipt receipt = new Receipt();
//        receipt.setName(dto.getName());
//        receipt.setDescription(dto.getDescription());
//        receipt.setInstruction(dto.getInstruction());
//        receipt.setIngredients(dto.getIngredients());
//        receipt.setCookingTime(validator.checkLong(dto.getCookingTime()));
//        receipt.setRating(validator.checkDouble(dto.getRating()));
//        receipt.setCountry(validator.checkCountries(dto.getCountry()));
//        receipt.setDishType(validator.checkDishType(dto.getDishType()));
//        receipt.setCategories(converter.convertStringListToEnumList(dto.getCategories()));
//        receipt.setImageLink(dto.getImageLink());
//        return receipt;
//    }

    private final UserRepository repository;
    @Override
    public Receipt createDtoToEntity(CreateReceiptDTO dto) {
        Receipt receipt = new Receipt();

        receipt.setName(dto.getName());
        receipt.setCategories(converter.convertStringListToEnumList(dto.getCategories()));
        receipt.setDescription(dto.getDescription());
        receipt.setInstruction(dto.getInstruction());
        receipt.setIngredients(dto.getIngredients());
        receipt.setCookingTime(Long.valueOf(dto.getCookingTime()));
        receipt.setRating(Double.valueOf(dto.getRating()));
        receipt.setCountry(Countries.valueOf(dto.getCountry()));
        receipt.setDishType(DishType.valueOf(dto.getDishType()));
        receipt.setImageLink(dto.getImageLink());

        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Bibo");
        repository.save(user);
        receipt.setUser(user);

        return receipt;
    }
}