package com.recipes.mapper;

import com.recipes.dto.receipt.CreateReceiptDTO;
import com.recipes.dto.receipt.ReceiptDTO;
import com.recipes.entity.DishCategory;
import com.recipes.entity.Recipe;
import com.recipes.entity.User;
import com.recipes.entity.enumerations.Categories;
import com.recipes.repository.UserRepository;
import com.recipes.service.component.interfaces.Converter;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

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
     * Converts a {@link Recipe} entity to a {@link ReceiptDTO} DTO.
     *
     * @param receipt The {@link Recipe} entity to be converted.
     * @return The corresponding {@link ReceiptDTO} DTO.
     */
    @Override
    public ReceiptDTO toDto(Recipe receipt) {
        ReceiptDTO dto = new ReceiptDTO();
        String authorName = receipt.getUser().getFirstName() + " " + receipt.getUser().getLastName();

        dto.setName(receipt.getName());
        dto.setDescription(receipt.getDescription());
        dto.setInstruction(receipt.getInstruction());
        dto.setCookingTime(String.valueOf(receipt.getCookingTime()));
        dto.setRating(String.valueOf(receipt.getRating()));
        dto.setCountry(String.valueOf(receipt.getCountry()));
        dto.setDishType(String.valueOf(receipt.getDishType()));
        dto.setImageLink(receipt.getImageLink());

        dto.setAuthorName(authorName);
        return dto;
    }

    /**
     * Converts a {@link ReceiptDTO} DTO to a {@link Recipe} entity.
     *
     * @param dto The {@link ReceiptDTO} DTO to be converted.
     * @return The corresponding {@link Recipe} entity.
     */

    @Override
    public Recipe toEntity(ReceiptDTO dto) {
        Recipe receipt = new Recipe();
        receipt.setName(dto.getName());
        receipt.setDescription(dto.getDescription());
        receipt.setInstruction(dto.getInstruction());
        receipt.setRating(Double.valueOf(dto.getCookingTime()));
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
    public Recipe createDtoToEntity(CreateReceiptDTO dto) {
        Recipe receipt = new Recipe();

        receipt.setName(dto.getName());
//        receipt.setCategories(converter.convertStringListToEnumList(dto.getCategories()));
        receipt.setDescription(dto.getDescription());
        receipt.setInstruction(dto.getInstruction());
//        receipt.setIngredients(dto.getIngredients());
//        receipt.setCookingTime(Long.valueOf(dto.getCookingTime()));
        receipt.setRating(Double.valueOf(dto.getRating()));
//        receipt.setCountry(Country.valueOf(dto.getCountry()));
//        receipt.setDishType(DishType.valueOf(dto.getDishType()));
        receipt.setImageLink(dto.getImageLink());

        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Bibo");
        repository.save(user);
        receipt.setUser(user);

        return receipt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String instruction;

    private Integer cookingTime;

    private Double rating;

    private String country;

    private String dishType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private DishCategory dishCategory;
    private String image;
    private Timestamp createdAt;

}