package com.recipes.converter;

public interface ConverterService<Entity, Dto1, Dto2> {
    Entity toEntity(Dto1 dto);

    Dto2 toDto(Entity e);

}
