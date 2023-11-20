package com.recipes.converter;

public interface ConverterService<Entity, Dto1, Dto2> {

    Dto1 toDto(Entity e);

    Entity toEntity(Dto2 dto);

}
